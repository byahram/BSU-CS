<?php

include_once 'Dao.php';
include_once 'UserDO.php';

class UserDao
{
    private $conn;
    
	public function __construct() {
		try {
			$this->conn = Dao::getConnection();
		} catch (PDOException $e) {
			echo "Database connection failed.";
			echo $e->getMessage();
			die;
		}
    } 
    
	/**
	 * Executes the statement and returns an array of users.
	 */
	protected function executeQuery($stmt)
	{
		if($stmt->execute()) {
            $results = $stmt->fetchAll();
            
			foreach($results as $result) {
				$users[] = new UserDO($result);
			}
		} 
		return $users;
    }
    
	protected function getUsers()
	{
		$stmt = $this->conn->query("SELECT * FROM users");
		return $this->executeQuery($stmt);
    }
    
	protected function getUsersByKey($key, $value)
	{
		$stmt = $this->conn->prepare("SELECT * FROM users WHERE $key = :value");
		$stmt->bindParam(':value', $value);
		return $this->executeQuery($stmt);
    }
    
	/**
	 * Returns all rows in the users table.
	 */
	public function getUserById($value)
	{
		return $this->getUsersByKey('id', $value);
    }
    
	/**
	 *
	 */
	public function userExists($email)
	{
		$result = $this -> getUsersByKey('email', $email);
		if(!empty($result)) {
			return true;
		} else {
			return false;
		}
    }
    
	/**
	 * Adds the user to the user table with the given .
	 * $user: A UserDO object.
	 */
	public function addUser($user)
	{
		$stmt = $this -> $conn -> prepare("INSERT INTO users (email, fullName, pw) VALUES (:email, :fullName, :pw)");
		$email = $user -> getEmail();
		$pw = $user -> getPw();  
		$name = $user -> getfullName();
		
		$stmt -> bindParam(':email', $email);
		$stmt -> bindParam(':fullName', $fullName);
		$stmt -> bindParam(':pw', $pw);
		
		$stmt -> execute();
	}
}