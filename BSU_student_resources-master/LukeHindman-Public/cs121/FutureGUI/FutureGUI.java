import javax.swing.JFrame;

public class FutureGUI {

	public static void main(String[] args) {
		JFrame frame = new JFrame ("Future");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(new FuturePanel());
		frame.pack();
		frame.setVisible(true);

	}

}
