import java.awt.Color;

/**
  	Represents one n-sided die with faces showing values between 1 and n, 
  	where n is specified when the die is constructed.

  	@author amit
  	@author Luke Hindman
*/

public class Die implements Comparable<Die>
{
	private final int DEFAULT_FACES = 6;  // maximum face value
	private int numberOfSides; //number of faces on the die
	private int faceValue;  // current value showing on the die
	private Color dieColor;
	private Color pipColor;

	/**
	  Constructor: Sets the initial face value.
	*/
	public Die()
	{
	   numberOfSides = DEFAULT_FACES;
	   faceValue = 1;
	   dieColor = Color.WHITE;
	   pipColor = Color.BLACK;
	}

	/**
	  Constructor: Sets the number of sides and initial face value.
	*/
	public Die(int numberOfSides)
	{
	   this.numberOfSides = numberOfSides;
	   faceValue = 1;
	   dieColor = Color.WHITE;
	   pipColor = Color.BLACK;
	}

	/**
	  Rolls the die and returns the result.
	*/
	public int roll()
	{
	   faceValue = (int)(Math.random() * numberOfSides) + 1;

	   return faceValue;
	}

	/**
	  Number of sides value accessor.
	*/
	public int getNumberOfSides() 
	{ 
		return numberOfSides; 
	}

	/**
		 Face value mutator.
	*/
	public void setFaceValue (int value) 
	{ 
		faceValue = value; 
	}

	/**
	  Face value accessor.
	*/
	public int getFaceValue() 
	{ 
		return faceValue; 
	}
	
	/**
	 * @return the dieColor
	 */
	public Color getDieColor() {
		return dieColor;
	}

	/**
	 * @param dieColor the dieColor to set
	 */
	public void setDieColor(Color dieColor) {
		this.dieColor = dieColor;
	}

	/**
	 * @return the pipColor
	 */
	public Color getPipColor() {
		return pipColor;
	}

	/**
	 * @param pipColor the pipColor to set
	 */
	public void setPipColor(Color pipColor) {
		this.pipColor = pipColor;
	}

	/**
	  Returns a string representation of this die.
	*/
	public String toString()
	{
	   String result = "Die [numberOfSides = " + numberOfSides + ", faceValue = " + faceValue + "]";

	   return result;
	}
	
	public boolean equals(Die d) {
		boolean result = false;
		
		if (this.numberOfSides == d.getNumberOfSides() && this.dieColor.equals(d.getDieColor())) {
			result = true;
		}
		
		return result;
	}

	@Override
	public int compareTo(Die o) {
		// TODO Auto-generated method stub
		System.out.println(o.getFaceValue());
		return this.faceValue - o.getFaceValue();
	}
}
