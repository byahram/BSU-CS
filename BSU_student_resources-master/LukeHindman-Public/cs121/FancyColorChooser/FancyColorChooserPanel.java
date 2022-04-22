import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
/**
 * Top-level panel for the FancyColorChooser example
 * @author lhindman
 *
 */
@SuppressWarnings("serial")
public class FancyColorChooserPanel extends JPanel {
	
	/* Instance variables */
	private ControlPanel colorSelector;
	private JPanel displayPanel;
	private JButton updateDisplayButton;
	
	/* Constructor */
	public FancyColorChooserPanel() {

		/* Create the GUI components */
		colorSelector = new ControlPanel();
		displayPanel = new JPanel();
		displayPanel.setPreferredSize(new Dimension(300,300));
		updateDisplayButton = new JButton("Update Color");
		updateDisplayButton.addActionListener(new DisplayUpdateActionListener());
		
		/* Change the default layout from FlowLayout to BorderLayout */
		this.setLayout(new BorderLayout());
		
		/* Add components to panel */
		this.add(colorSelector,BorderLayout.SOUTH);
		this.add(displayPanel,BorderLayout.CENTER);
		this.add(updateDisplayButton, BorderLayout.EAST);
		
	}
	
	/**
	 * Listener that updates the displayPanel to the custom color set
	 *    in the ControlPanel.
	 * @author lhindman
	 *
	 */
	private class DisplayUpdateActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			displayPanel.setBackground(colorSelector.getColor());
			
		}
		
	}

}
