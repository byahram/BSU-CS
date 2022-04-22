import javax.swing.JFrame;

public class FancyPushCounter {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Fancy Push Counter");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(new CounterPanel());
		
		frame.pack();
		frame.setVisible(true);

	}

}
