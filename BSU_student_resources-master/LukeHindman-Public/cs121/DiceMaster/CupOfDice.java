import java.util.ArrayList;

/**
 * @author lhindman
 * Create a cup of dice objects for gaming fun
 */
public class CupOfDice {

	/* Instance Variables */
	private ArrayList<Die> cup;
	
	/* Constructors: Both a default constructor and an initial value constructor */
	public CupOfDice() {
		cup = new ArrayList<Die>();
		cup.add(new Die());
		cup.add(new Die());
		cup.add(new Die());
		cup.add(new Die());
		cup.add(new Die());
	}
	public CupOfDice(int numDice, int numSides) {
		cup = new ArrayList<Die>();
		for(int i = 0; i < numDice; i++) {
			cup.add(new Die(numSides));
		}
	}
	
	/* methods */
	
	public void shake() {
		for(Die d: this.cup) {
			d.roll();
		}
	}
	
	public int getScore() {
		int total = 0;
		
		for (Die d: cup) {
			total += d.getFaceValue();
		}
		
		return total;
	}
	
	public String toString() {
		String output = "";
		output += "This is the contents of my cup..\n";
		output += "--------------------------------\n";
		for (Die d: this.cup) {
			output += d.toString() + "\n";
		}
		
		return output;
	}
	
	
}
