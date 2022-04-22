
public class Yahtzee {

	public static void main(String[] args) {
		CupOfDice myCup = new CupOfDice();
		//CupOfDice myCup = new CupOfDice(12,17);
		
		myCup.shake();
		
		System.out.println("My current score is: " + myCup.getScore() );
		
		System.out.println(myCup);

	}

}
