import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.Timer;

/**
 * 
 */

/**
 * @author lhindman
 *
 */
public class LonelyButton extends JButton {
	
	/* Instance Variables */
	private final int DELAY = 1000;  // Time in ms
	private final Color[] CYCLE_COLORS = {Color.BLUE, Color.ORANGE};
	private final Color DEFAULT_COLOR = Color.GREEN;
	private int colorIndex;
	
	private Timer animationTimer;
	
	
	/* Constructor */
	public LonelyButton () {
		setBackground(DEFAULT_COLOR);
		setOpaque(true);
		setBorderPainted(true);
		
		this.colorIndex = 0;
		
		/* Create our new animation Timer */
		this.animationTimer = new Timer(DELAY, new TimerActionListener());
		
		
	}
	
	/* Public Methods */
	/**
	 * Check whether the button is currently animating
	 * @return true if animation is active, false if not
	 */
	public boolean isActive() {
		return this.animationTimer.isRunning();
	}
	
	/**
	 * Start or stop the button animation
	 * @param state True to start animation, False to stop
	 */
	public void setActive(boolean state) {
		if (state == true && ! this.animationTimer.isRunning()) {
			this.animationTimer.start();
		} else if (state == false) {
			this.animationTimer.stop();
		}
	}
	
	
	/* Private Helper Methods */
	private void nextColor() {
		this.setBackground(CYCLE_COLORS[colorIndex]);
		colorIndex = (colorIndex + 1) % CYCLE_COLORS.length;
		
	}
	
	/* Action Listener for Timer events */
	private class TimerActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			nextColor();
		}
		
	}

	
	
}
