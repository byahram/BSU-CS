import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * Top-level panel for FancyCombinationLock example
 * @author lhindman
 *
 */
@SuppressWarnings("serial")
public class FancyCombinationLockPanel extends JPanel {
	
	/* Instance variables */
	private final int maxValue = 10;
	
	/* CodePanel instance variables */	
	private JPanel codePanel;
	private int code0,code1,code2;
	private JTextField codeField0, codeField1, codeField2;
	private JButton setCodeButton;
	private JButton testCodeButton;
	
	/* TumberPanel instance variables */
	private TumblerPanel tumbler;
	private JLabel lockStatusLabel;
	
	public FancyCombinationLockPanel() {
		
		/* Setup the code panel */
		this.codePanel = new JPanel();
		this.codeField0 = new JTextField();
		this.codeField1 = new JTextField();
		this.codeField2 = new JTextField();
		
		Random rand = new Random();

		/* Randomly set the initial value of each text field */
		codeField0.setText(Integer.toString(rand.nextInt(maxValue + 1)));
		codeField1.setText(Integer.toString(rand.nextInt(maxValue + 1)));
		codeField2.setText(Integer.toString(rand.nextInt(maxValue + 1)));
		
		/* Create the set and test buttons and bind to associated Listener */
		setCodeButton = new JButton("Set Code");
		setCodeButton.addActionListener(new SetCodeButtonListener());
		
		testCodeButton = new JButton("Test Code");
		testCodeButton.addActionListener(new TestCodeButtonListener());
		
		/* Add components to codePanel */
		codePanel.add(codeField0);
		codePanel.add(codeField1);
		codePanel.add(codeField2);
		codePanel.add(setCodeButton);
		codePanel.add(testCodeButton);
		
		/* Setup the TumblerPanel */
		tumbler = new TumblerPanel(maxValue);
		
		/* Setup the status label */
		lockStatusLabel = new JLabel("Status: Unlocked");

		/* Setup the layout of this panel and add GUI components */
		this.setLayout(new BorderLayout());
		this.add(codePanel, BorderLayout.NORTH);
		this.add(tumbler,BorderLayout.CENTER);
		this.add(lockStatusLabel,BorderLayout.SOUTH);

	}
	
	/**
	 * This listener checks to see if the code set on the tumblers matches
	 *    the code that has been set. If so, it updates the lock status
	 *    label appropriately and enables the ability to set a new code.
	 * @author lhindman
	 *
	 */
	private class TestCodeButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			/* Check to see if the select tumbler values match the code */
			if (tumbler.getFirstValue() == code0 && 
				tumbler.getSecondValue() == code1 &&
				tumbler.getThirdValue() == code2) {
				
				/* Display code values in text fields and enable editing */
				codeField0.setText(Integer.toString(code0));
				codeField0.setEnabled(true);
				codeField1.setText(Integer.toString(code1));
				codeField1.setEnabled(true);
				codeField2.setText(Integer.toString(code2));
				codeField2.setEnabled(true);
				
				/* Enable the set button so a new code can be entered */
				setCodeButton.setEnabled(true);
				
				/* Change the status label to unlocked */
				lockStatusLabel.setText("Status: Unlocked");
			}
			
		}
		
	}
	
	/**
	 * This listener stores the code that is specified in the
	 *     text fields, hides the values and disable the fields
	 *     so the code cannot be changed until it is unlocked.
	 * @author lhindman
	 *
	 */
	private class SetCodeButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				/* Try to parse integer values from the textFields */
				code0 = Integer.parseInt(codeField0.getText());
				code1 = Integer.parseInt(codeField1.getText());
				code2 = Integer.parseInt(codeField2.getText());
				
				/* Check to see that the values are within the appropriate range */
				if (code0 < 0 || code0 > maxValue || 
					code1 < 0 || code1 > maxValue ||
					code2 < 0 || code2 > maxValue) {
					System.out.println("Unable to set lock: Please enter values in the range of 0 to " + maxValue );
				} else {
				
					/* Replace the text in the textFields to hide the data
					 * and disable the ability to edit the textFields.
					 */
					codeField0.setText("*");
					codeField0.setEnabled(false);
					codeField1.setText("*"); 
					codeField1.setEnabled(false);
					codeField2.setText("*");
					codeField2.setEnabled(false);
					
					/* Disable the set button */
					setCodeButton.setEnabled(false);
					
					/* Set the status to locked */
					lockStatusLabel.setText("Status: Locked");
				}
				
			} catch (Exception ex) {
				/* Handle the case where an unexpected value is
				 * entered in the text fields and display a message in the console.
				 */
				System.out.println("Invalid input in field, please enter Integer values");
			}

			
		}
		
	}
	
	
	
	

}
