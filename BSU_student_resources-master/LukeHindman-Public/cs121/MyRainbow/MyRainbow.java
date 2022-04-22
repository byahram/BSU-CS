import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * In class example of how to create and work with an Array List
 * @author Luke Hindman
 *
 */
public class MyRainbow {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//TODO: Declare and instantiate an ArrayList of Color objects
		ArrayList<Color> rainbow = new ArrayList<Color>();
		
		//TODO: Add ORANGE, YELLOW, and PINK
		rainbow.add(Color.ORANGE);
		rainbow.add(Color.YELLOW);
		rainbow.add(Color.PINK);
		
		//TODO: Display the number of items
		System.out.println("The rainbow contains " + rainbow.size() + " colors");
		
		//TODO: Display the contents using toString() 
		System.out.println(rainbow.toString());
		
		//TODO: Remove the first item
		rainbow.remove(0);
		
		//TODO: Display the number of items
		System.out.println("The rainbow contains " + rainbow.size() + " colors");
		
		//TODO: Display the contents using toString() 
		System.out.println(rainbow.toString());
		
		//TODO: Remove a specific item
		rainbow.remove(Color.YELLOW);
		
		//TODO: Display the number of items
		System.out.println("The rainbow contains " + rainbow.size() + " colors");
		
		//TODO: Display the contents using toString() 
		System.out.println(rainbow.toString());
		
		//TODO: Remove all items
		rainbow.clear();
		
		//TODO: Display the number of items
		System.out.println("The rainbow contains " + rainbow.size() + " colors");
		
		
		/*
		 * Working with loops
		 */
		
		//TODO:  Use a for loop with a random number generator to add 100 items
		Random generator = new Random();
		
		for (int i = 0; i < 100; i++) {
			int r,g,b;
			r = generator.nextInt(256);
			g = generator.nextInt(256);
			b = generator.nextInt(256);
			Color randColor = new Color(r,g,b);
			rainbow.add(randColor);
		}
		
		//TODO: Use a for loop to display the contents
		for (int i = 0; i < rainbow.size(); i++) {
			System.out.println(rainbow.get(i));;
		}
		
		//TODO: Use a for-each loop to display the contents
		for (Color c: rainbow) {
			System.out.println(c);
		}
		
		//TODO: Use a while loop and Iterator to display the contents
		Iterator<Color> it = rainbow.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
		
	}

}
