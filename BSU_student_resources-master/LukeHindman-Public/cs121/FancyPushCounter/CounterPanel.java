import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * In class example of creating a reusable CounterPanel
 * @author lhindman
 *
 */
public class CounterPanel extends JPanel {
	
	/* Instance Variables */
	private JButton upButton, downButton;
	private JLabel displayLabel;
	private int count;
	
	/* Constructor */
	public CounterPanel() {
		this.count = 0;
		
		/* Create the shared listener for the up and down buttons */
		CounterButtonListener cbl = new CounterButtonListener();
		
		/* Create the GUI components and adjust the alignment */
		upButton = new JButton("Up");
		upButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		upButton.addActionListener(cbl);
		
		downButton = new JButton("Down");
		downButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		downButton.addActionListener(cbl);
		
		displayLabel = new JLabel( Integer.toString(count));
		displayLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		
		/* Change layout from FlowLayout to BoxLayout and add components */
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		/* Add the GUI components to this panel */
		this.add(upButton);
		this.add(displayLabel);
		this.add(downButton);
		
	}
	
	/**
	 * Internal button listener to update the click count 
	 *    and the text of the displayLabel
	 * @author lhindman
	 *
	 */
	private class CounterButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();
			
			if (b == upButton) {
				count++;
			} else {
				count--;
			}
			
			displayLabel.setText(Integer.toString(count));
			
		}
		
	}
	
	
	
	

}
