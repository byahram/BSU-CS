
public class DiceMaster {

	public static void main(String[] args) {
		
		//TODO: Review Die class
		//TODO: Discuss static methods / variables
		//TODO: Discuss pass by reference
		//TODO: Discuss equals() method
		//TODO: Discuss Comparable interface
		
		Die die1 = new Die(20);
		Die die2 = new Die(21);
		
		die1.roll();
		die2.roll();
		
		System.out.println("Die1: " + die1);
		System.out.println("Die2: " + die2);
		
		
		if (die1.compareTo(die2) > 0) {
			System.out.println("Die1 Wins!");
		} else if (die1.compareTo(die2) < 0) {
			System.out.println("Die2 Wins!");
		} else {
			System.out.println("Tie Game");
		}

	}
}
