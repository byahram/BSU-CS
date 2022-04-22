import javax.swing.BoxLayout;
import javax.swing.JPanel;
/**
 * Define a TumblerPanel to manage the creation and layout of multiple CounterPanels
 * @author lhindman
 *
 */
@SuppressWarnings("serial")
public class TumblerPanel extends JPanel {
	
	/* Instance Variables */
	private CounterPanel tumblerCounter0, tumblerCounter1, tumblerCounter2;
	
	/* Constructor */
	public TumblerPanel(int maxValue) {
		/* Create three tumblers */
		tumblerCounter0 = new CounterPanel(maxValue);
		tumblerCounter1 = new CounterPanel(maxValue);
		tumblerCounter2 = new CounterPanel(maxValue);
		
		/* Setup the layout of the TumblerPanel and add GUI components */
		this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		this.add(tumblerCounter0);
		this.add(tumblerCounter1);
		this.add(tumblerCounter2);
		
	}
	
	/**
	 * Get the value of the first tumbler
	 * @return value of first tumbler
	 */
	public int getFirstValue() {
		return tumblerCounter0.getValue();
	}
	
	/**
	 * Get the value of the second tumbler
	 * @return value of second tumbler
	 */
	public int getSecondValue() {
		return tumblerCounter1.getValue();
	}
	
	/**
	 * Get the value of the third tumbler
	 * @return value of third tumbler
	 */
	public int getThirdValue() {
		return tumblerCounter2.getValue();
	}

}
