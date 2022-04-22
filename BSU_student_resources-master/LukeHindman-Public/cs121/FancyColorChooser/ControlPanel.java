import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;
/**
 * Custom panel to manage CounterPanels for RGB values
 * @author lhindman
 *
 */
@SuppressWarnings("serial")
public class ControlPanel extends JPanel{
	
	/* Instance variables */
	CounterPanel redCounter, greenCounter, blueCounter;
	
	/* Constructor */
	public ControlPanel() {
		

		/* Create CounterPanels for each RGB Color component */
		redCounter = new CounterPanel(255);
		redCounter.setBorderColor(Color.red);
		redCounter.setValue(32);
		
		greenCounter = new CounterPanel(255);
		greenCounter.setBorderColor(Color.green);
		greenCounter.setValue(128);
		
		blueCounter = new CounterPanel(255);
		blueCounter.setBorderColor(Color.blue);
		blueCounter.setValue(192);
		
		/* Set the layout and background for this panel */
		this.setLayout(new GridLayout(1,3,3,3));
		this.setBackground(Color.orange);
		
		/* Add counters to panel ColorControlPanel */
		this.add(redCounter);
		this.add(greenCounter);
		this.add(blueCounter);
		
	}
	
	/**
	 * Create a new Color object based upon the values of the
	 *   red, green and blue CounterPanels.
	 * @return Custom Color object based upon counter values.
	 */
	public Color getColor() {
		return new Color(redCounter.getValue(),greenCounter.getValue(), blueCounter.getValue());
	}

}
