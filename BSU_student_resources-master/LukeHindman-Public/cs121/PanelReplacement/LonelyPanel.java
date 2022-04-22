import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class LonelyPanel extends JPanel{

	// Instance Variables
	private JButton[][] familyButtons;
	
	// Grid Panel instance variable
	private JPanel gridPanel;
	
	private JButton refreshButton;
	private JTextField gridSizeField;
	
	// Constructor
	public LonelyPanel() {
		
		/* Instantiate a new grid panel with buttons
		 * with an initial grid size of 2. */
		Integer initialGridSize = 2;

		/* Create JButton */
		this.refreshButton = new JButton ("Refresh");
		this.refreshButton.addActionListener(new RefreshButtonListener());
		this.gridSizeField = new JTextField(3);
		this.gridSizeField.setText(initialGridSize.toString());

		
		/* Create refresh panel */
		JPanel refreshPanel = new JPanel();
		refreshPanel.add(refreshButton);
		refreshPanel.add(gridSizeField);
		
		/* Add Grid panel to this panel */
		this.setLayout(new BorderLayout());
		
		/* Add the refreshPanel to the LonelyPanel */
		this.add(refreshPanel, BorderLayout.SOUTH);
		
		/* Call buildGridPanel() to create the gridPanel
		 *   with the specified size and add it to the
		 *   LonelyPanel */
		buildGridPanel(initialGridSize);
	}
	
	/**
	 * This function instantiates a new gridPanel with buttons
	 * of the specified size
	 * @param gridSize The number of row and columns for the new grid of buttons
	 */
	private void buildGridPanel(int gridSize) {
		int numRows = gridSize;
		int numCols = gridSize;
		
		/* Instantiate new JPanel */
		if (this.gridPanel != null) {
			this.remove(this.gridPanel);
		}
		this.gridPanel = new JPanel();
		
		/* set the layout of this panel */
		gridPanel.setLayout(new GridLayout(numRows,numCols));
		
		/* Initialize JButton Array */
		familyButtons = new JButton[numRows][numCols];
		
		/* Load buttons into array */
		for (int i=0; i < familyButtons.length; i++) {
			for (int j = 0; j < familyButtons[i].length; j++) {
				familyButtons[i][j] = new JButton();
				gridPanel.add(familyButtons[i][j]);
			}
		}
		
		/* Add the gridPanel to the LonelyPanel */
		this.add(gridPanel, BorderLayout.CENTER);
		
		/* Call revalidate() on the LonelyPanel to force the GUI to update with the new gridPanel */
		this.revalidate();
	}
	
	
	/* Create Listeners */
	private class RefreshButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			/* Get updated size from gridSizeField */
			int newGridSize = Integer.parseInt(gridSizeField.getText());
			
			/* Call method to rebuild the gridPanel using the specified size */
			buildGridPanel(newGridSize);
			/* Debugging */
			System.out.println("Refreshing Panel");
			
		}
		
	}
	
	
	
}
