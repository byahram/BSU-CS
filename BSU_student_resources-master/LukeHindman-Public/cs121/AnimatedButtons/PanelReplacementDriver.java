import javax.swing.JFrame;

/**
 * 
 */

/**
 * @author lhindman
 *
 */
public class PanelReplacementDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame ("Panel Replacement Project");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Add a panel to the frame
		frame.getContentPane().add(new LonelyPanel());
		
		frame.pack();
		frame.setVisible(true);

	}

}
