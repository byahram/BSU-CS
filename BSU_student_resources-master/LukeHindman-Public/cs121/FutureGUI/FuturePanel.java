
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * GUI interface to the Future game.
 * @author lhindman
 *
 */
@SuppressWarnings("serial")
public class FuturePanel extends JPanel{
	private final String INITIAL_NAME_VALUE="Name";
	private final String INITIAL_GENDER_VALUE="Gender of spouse";
	
	/* Instance Variables */
	private JTextField nameField;
	private JTextField genderField;
	private JButton goButton;
	private JTextArea futureTextArea;
	
	/* Constructor */
	public FuturePanel() {
		/* Initialize the two text fields with default values */
		nameField = new JTextField(INITIAL_NAME_VALUE);
		genderField = new JTextField(INITIAL_GENDER_VALUE);
		
		/* The text area inside a JTextField is a separate Document object.
		 * In order to monitor changes to the text field, the listener must
		 * be add to this Document object and not to the JTextField itself
		 */
		TextFieldDocumentListener docListener = new TextFieldDocumentListener();
		nameField.getDocument().addDocumentListener(docListener);
		genderField.getDocument().addDocumentListener(docListener);
		
		goButton = new JButton("Go!!!");
		goButton.setEnabled(false);
		goButton.addActionListener(new GoButtonListener());
		
		futureTextArea = new JTextArea("You future will appear here...", 10,40);
		futureTextArea.setLineWrap(true);
		futureTextArea.setWrapStyleWord(true);
		
		add(nameField);
		add(genderField);
		add(goButton);
		add(futureTextArea);
	}
	
	/**
	 * This class monitors the Go button and will use the values
	 *   from the name and gender fields to generate a future and display
	 *   it in the JTextArea.
	 * @author lhindman
	 *
	 */
	private class GoButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String name = nameField.getText();
			String gender = genderField.getText();
			
			Future myFuture = new Future(name,gender);
			futureTextArea.setText(myFuture.toString());
			
		}
		
	}
	/**
	 * This class monitors the name and gender text fields and enables
	 *   the "Go" button when the both have been modified from their
	 *   INITIAL values.
	 * 
	 * This Listener is added to the JTextField itself.  The JTextField "has-a"
	 *   Document object as part of its internal state (an instance variable) that
	 *   this DocumentListener is added to.
	 * @author lhindman
	 *
	 */
	private class TextFieldDocumentListener implements DocumentListener {

		@Override
		public void insertUpdate(DocumentEvent e) {
			System.out.println("changeUpdate detected");
			String name = nameField.getText();
			String gender = genderField.getText();
			
			if (! name.equals(INITIAL_NAME_VALUE) && ! gender.equals(INITIAL_GENDER_VALUE)) {
				goButton.setEnabled(true);
			}
			
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			System.out.println("removeUpdate detected");
			
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			
		}
		
	}
	
	
	

}
