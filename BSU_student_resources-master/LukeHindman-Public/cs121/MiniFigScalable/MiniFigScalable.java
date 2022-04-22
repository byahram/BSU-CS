import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Color;

/**
 * A starting point for creating a new graphical program
 * @author Luke Hindman
 */
@SuppressWarnings("serial")
public class MiniFigScalable extends JPanel
{
	
	private final int INITIAL_HEIGHT = 450;
	private final int INITIAL_WIDTH = 300;
	/**
	 * Draws the picture in the panel. This is where all of your
	 * code will go.
	 * @param page Our graphics canvas.
	 */
	public void paintComponent (Graphics page)
	{
		/* Define colors for each of the MiniFigScalable components */
		Color backgroundColor = Color.WHITE;
		Color headColor = new Color(255,227,48);
		Color shirtColor = new Color(7,60,145);
		Color beltColor = new Color (104,3,33);
		Color legColor = Color.BLACK;
		Color footColor = Color.DARK_GRAY;
		Color armColor = new Color (14, 250, 20);
		Color handColor = new Color(255,227,48);
		Color handHoleColor = backgroundColor;
		
		/* Store the height and width of the panel at the time
		 * the paintComponent() method is called.
		 */
		int currentHeight = getHeight();
		int currentWidth = getWidth();
		
		/* This is the anchor point for the MiniFigScalable (x,y) -> (mid,top) */
		int mid = currentWidth / 2;
		int top = 50;
		
		/* This is the scaler that is used to calculate the dimensions (height / width) 
		 * of each of the MiniFigScalable components. It uses the Math.min() function to select
		 * the smaller of currentWidth/INITIAL_WIDTH and currentHeight/INITIAL_HEIGHT.
		 * This way all the components are scaled to fit within the smaller of the two 
		 * panel dimensions.
		 */
		double scaleFactor = Math.min(currentWidth/(double)INITIAL_WIDTH,currentHeight/(double)INITIAL_HEIGHT );
		
		/* Set the background color */
		page.setColor(backgroundColor);
		page.fillRect(0, 0, currentWidth, currentHeight);
		
		/* 
		 * Component: Head
		 */
		// Calculate scaled knob dimensions
		int knobWidth = (int) (40 * scaleFactor);
		int knobHeight = (int) (16 * scaleFactor);
		int knobHeightPadded = knobHeight + 2; // extend knob below head to hide curved border
		int knobCurve = Math.min(5, (int) (5 * scaleFactor));
		
		// Define (x,y) coordinates for knob anchor point and store to Point object 
		Point knobAnchor = new Point(mid - knobWidth / 2, top );

		// Draw the knob component on the canvas
		page.setColor(headColor);
		page.fillRoundRect(knobAnchor.x,knobAnchor.y,knobWidth,knobHeightPadded,knobCurve,knobCurve); //head knob
		page.setColor(Color.BLACK);
		page.drawRoundRect(knobAnchor.x,knobAnchor.y,knobWidth,knobHeightPadded,knobCurve,knobCurve); //head knob
		
		// Calculate scaled face dimensions
		int faceWidth = (int) (84 * scaleFactor);
		int faceHeight = (int) (75 * scaleFactor);
		int faceCurve = Math.min(28, (int) (28 * scaleFactor));
		int eyeSpacing = (int) (30 * scaleFactor);
		int eyeDiameter = (int) (10 * scaleFactor);
		int distFromTopOfHead = (int) (28 * scaleFactor); 
		int mouthOvalDiameter = (int) (40 * scaleFactor);
		int mountDistFromTopOfHead = (int) (18 * scaleFactor);
		
		// Define (x,y) coordinates for face anchor point and store to Point object 
		Point faceAnchor = new Point (mid - faceWidth / 2,top + knobHeight );
		
		// Calculate eye positions based upon scaled dimensions and anchor point
		int leftEyeXOffset = mid - (eyeSpacing / 2 + eyeDiameter / 2);
		int rightEyeXOffset = mid + (eyeSpacing / 2 - eyeDiameter / 2);
		int EyeYOffset = faceAnchor.y + distFromTopOfHead;
		
		// Calculate mouth positions based upon scaled dimensions and anchor point
		int mouthXOffset = mid - mouthOvalDiameter / 2;
		int mouthYOffset = faceAnchor.y + mountDistFromTopOfHead;
		
		// Draw the face components on the canvas
		page.setColor(headColor);
		page.fillRoundRect(faceAnchor.x,faceAnchor.y,faceWidth,faceHeight,faceCurve,faceCurve); //head
		page.setColor(Color.BLACK);
		page.drawRoundRect(faceAnchor.x,faceAnchor.y,faceWidth,faceHeight,faceCurve,faceCurve); //head

		page.fillOval(leftEyeXOffset, EyeYOffset, eyeDiameter, eyeDiameter); // right eye
		page.fillOval(rightEyeXOffset, EyeYOffset, eyeDiameter, eyeDiameter); // left eye
		
		page.drawArc(mouthXOffset,mouthYOffset,mouthOvalDiameter,mouthOvalDiameter,225,90); // mouth
		
		// Calculate scaled neck dimensions
		int neckWidth = (int) (54 * scaleFactor);
		int neckHeight = (int) (10 * scaleFactor);
		
		// Define (x,y) coordinates for neck anchor point and store to Point object 
		int neckXOffset = mid - neckWidth / 2;
		int neckYOffset = faceAnchor.y + faceHeight;
		
		// Draw the neck component on the canvas
		page.setColor(headColor);
		page.fillRect(neckXOffset,neckYOffset,neckWidth,neckHeight);
		page.setColor(Color.BLACK);
		page.drawRect(neckXOffset,neckYOffset,neckWidth,neckHeight);

		
		/* 
		 * Component: Torso 
		 */
		// Calculate scaled torso dimensions
		int torsoShoulderWidth = (int) (90 * scaleFactor);
		int torsoWaistWidth = (int) (130 * scaleFactor);
		int torsoHeight = (int) (114 * scaleFactor);
		
		// Calculate the Y axis position for shoulders and waist
		int torsoShoulderYOffset = neckYOffset + neckHeight;
		int torsoWaistYOffset = neckYOffset + neckHeight + torsoHeight;
		
		// Use the scaled dimensions to calculate x,y Points for torso
		Point rightShoulder = new Point(mid - torsoShoulderWidth / 2, torsoShoulderYOffset);
		Point leftShoulder = new Point(mid + torsoShoulderWidth / 2, torsoShoulderYOffset);
		Point leftWaist = new Point(mid + torsoWaistWidth / 2, torsoWaistYOffset);
		Point rightWaist = new Point(mid - torsoWaistWidth / 2, torsoWaistYOffset);
		
		// Create a new Polygon object for the torso using the above Points
		Polygon torso = new Polygon();
		torso.addPoint(rightShoulder.x, rightShoulder.y ); //right shoulder point
		torso.addPoint(leftShoulder.x, leftShoulder.y); //left shoulder point
		torso.addPoint(leftWaist.x, leftWaist.y ); //left waist point
		torso.addPoint(rightWaist.x, rightWaist.y ); //right waist point

		// The torso Polygon is drawn later to achieve proper layering
		
		/*
		 * Component: Belt
		 */
		// Calculate scaled belt dimensions
		int beltWidth = (int) (120 * scaleFactor);
		int beltHeight = (int) (20 * scaleFactor);
		
		// Define (x,y) coordinates for belt anchor point and store to Point object
		Point beltAnchor = new Point(mid - beltWidth/2, torsoWaistYOffset);

		// Draw the belt component on the canvas
		page.setColor(beltColor);
		page.fillRect(beltAnchor.x,beltAnchor.y, beltWidth, beltHeight); // belt
		

		/* 
		 * Component: Legs
		 */
		// Calculate scaled leg dimensions
		int lowerLegWidth = (int) (60 * scaleFactor);
		int legSpacing = (int) (10 * scaleFactor);
		int legLength = (int) (94 * scaleFactor);
		int footHeight = (int) (28 * scaleFactor);
		int footWidth = lowerLegWidth;
		int legDividerWidth = (int) (12 * scaleFactor);
		int legDividerHeight = (int) (54 * scaleFactor);
		
		// Calculate the Y axis positions for upper and lower leg
		int upperLegYOffset = beltAnchor.y + beltHeight;
		int lowerLegYOffset = upperLegYOffset + legLength;
		
		// Use the scaled dimensions to calculate x,y Points for right leg
		Point rightHip = new Point(mid - beltWidth/2, upperLegYOffset);
		Point rightInseam = new Point(mid - (legSpacing / 2), upperLegYOffset);
		Point rightInnerAnkle = new Point(mid - (legSpacing / 2), lowerLegYOffset);
		Point rightOuterAnkle = new Point(mid - (legSpacing / 2 + lowerLegWidth),lowerLegYOffset);
		
		// Create a new Polygon object for the right leg using the above Points
		Polygon rightLeg = new Polygon();
		rightLeg.addPoint(rightHip.x, rightHip.y);
		rightLeg.addPoint(rightInseam.x, rightInseam.y);
		rightLeg.addPoint(rightInnerAnkle.x, rightInnerAnkle.y);
		rightLeg.addPoint(rightOuterAnkle.x, rightOuterAnkle.y);
		
		// Draw the right leg components on the canvas
		page.setColor(legColor);	
		page.fillPolygon(rightLeg);  //right leg
		page.setColor(Color.BLACK);
		page.drawPolygon(rightLeg);  //right leg
		
		page.setColor(footColor);
		page.fillRect(rightOuterAnkle.x, rightOuterAnkle.y, footWidth, footHeight); // right foot
		page.setColor(Color.BLACK);
		page.drawRect(rightOuterAnkle.x, rightOuterAnkle.y, footWidth, footHeight); // right foot
		
		// Use the scaled dimensions to calculate x,y Points for left leg
		Point leftHip = new Point(mid + beltWidth/2, upperLegYOffset);
		Point leftInseam = new Point(mid + (legSpacing / 2), upperLegYOffset);
		Point leftInnerAnkle = new Point(mid + (legSpacing / 2), lowerLegYOffset);
		Point leftOuterAnkle= new Point(mid + (legSpacing / 2 + lowerLegWidth),lowerLegYOffset);
		
		// Create a new Polygon object for the left leg using the above Points
		Polygon leftLeg = new Polygon();
		leftLeg.addPoint(leftHip.x, leftHip.y);
		leftLeg.addPoint(leftInseam.x, leftInseam.y);
		leftLeg.addPoint(leftInnerAnkle.x, leftInnerAnkle.y);
		leftLeg.addPoint(leftOuterAnkle.x, leftOuterAnkle.y);
		
		// Draw the left leg components on the canvas
		page.setColor(legColor);	
		page.fillPolygon(leftLeg);  //left leg
		page.setColor(Color.BLACK);
		page.drawPolygon(leftLeg);  //left leg
		
		page.setColor(footColor);
		page.fillRect(leftInnerAnkle.x, leftInnerAnkle.y, footWidth, footHeight); // left foot
		page.setColor(Color.BLACK);
		page.drawRect(leftInnerAnkle.x, leftInnerAnkle.y, footWidth, footHeight); // left foot
		
		// Use the scaled dimensions to calculate anchor point for leg divider
		Point legDividerAnchor = new Point(mid - legDividerWidth / 2, beltAnchor.y + beltHeight);

		// Draw the leg divider components on the canvas
		page.setColor(footColor);
		page.fillRect(legDividerAnchor.x, legDividerAnchor.y, legDividerWidth, legDividerHeight);
		page.setColor(Color.BLACK);
		page.drawRect(legDividerAnchor.x, legDividerAnchor.y, legDividerWidth, legDividerHeight);
		
		/* 
		 * Component: Arms
		 */
		// Calculate scaled arm dimensions
		int armUpperWidth = (int) (31 * scaleFactor);
		int armUpperHeight = (int) (20 * scaleFactor); 
		int armCuffWidth = (int) (35 * scaleFactor);
		
		// Calculate the Y axis positions for left and right arms
		int armShoulderYOffset = torsoShoulderYOffset+ (int) (8 * scaleFactor);
		int armElbowYOffset = armShoulderYOffset + (int) (58 * scaleFactor);
		int armUpperCuffYOffset = armElbowYOffset + (int) (34 * scaleFactor);
		int armLowerCuffYOffset = armElbowYOffset + (int) (38 * scaleFactor);
		
		// Use the scaled dimensions to calculate x,y Points for right arm
		Point rightArmAnchor = new Point(mid - (torsoShoulderWidth / 2 + armUpperWidth ), armShoulderYOffset);
		Point rightArmSleeve = new Point(rightArmAnchor.x - (int) (2 * scaleFactor), rightArmAnchor.y + armUpperHeight - (int) (2 * scaleFactor));
		Point rightArmElbow = new Point(rightArmAnchor.x - (int) (18 * scaleFactor), armElbowYOffset);
		Point rightArmCuffOuter = new Point(rightArmAnchor.x - (int) (24 * scaleFactor), armUpperCuffYOffset);
		Point rightArmCuffInner = new Point(rightArmCuffOuter.x + armCuffWidth, armLowerCuffYOffset);
		Point rightArmPit = new Point(rightArmAnchor.x + armUpperWidth , rightArmAnchor.y);

		// Create a new Polygon object for the right arm using the above Points
		Polygon rightArm = new Polygon();
		rightArm.addPoint(rightArmSleeve.x, rightArmSleeve.y);
		rightArm.addPoint(rightArmElbow.x , rightArmElbow.y);
		rightArm.addPoint(rightArmCuffOuter.x, rightArmCuffOuter.y);
		rightArm.addPoint(rightArmCuffInner.x, rightArmCuffInner.y);
		rightArm.addPoint(rightArmPit.x, rightArmPit.y);
		
		// Draw the right arm components on the canvas
		page.setColor(armColor);
		page.fillPolygon(rightArm);
		page.setColor(Color.BLACK);
		page.drawPolygon(rightArm);
		page.setColor(armColor);
		page.fillArc(rightArmAnchor.x, rightArmAnchor.y, armUpperWidth * 2, armUpperHeight * 2,90,90);
		page.setColor(Color.BLACK);
		page.drawArc(rightArmAnchor.x, rightArmAnchor.y, armUpperWidth * 2, armUpperHeight * 2,90,80);

		// Use the scaled dimensions to calculate x,y Points for left arm
		Point leftArmAnchor = new Point(mid + (torsoShoulderWidth / 2 - armUpperWidth), armShoulderYOffset);
		Point leftArmSleeve = new Point(leftArmAnchor.x  + armUpperWidth * 2 + (int) (2 * scaleFactor), leftArmAnchor.y + armUpperHeight - (int) (2 * scaleFactor) );
		Point leftArmElbow = new Point(leftArmAnchor.x + armUpperWidth*2 + (int) (18 * scaleFactor), armElbowYOffset);
		Point leftArmCuffOuter = new Point(leftArmAnchor.x + armUpperWidth*2 + (int) (24 * scaleFactor), armUpperCuffYOffset);
		Point leftArmCuffInner = new Point(leftArmAnchor.x + armUpperWidth + (int) (20 * scaleFactor), armLowerCuffYOffset);
		Point leftArmPit = new Point(leftArmAnchor.x + armUpperWidth, leftArmAnchor.y);
		
		// Create a new Polygon object for the left arm using the above Points
		Polygon leftArm = new Polygon();
		leftArm.addPoint(leftArmSleeve.x, leftArmSleeve.y);
		leftArm.addPoint(leftArmElbow.x, leftArmElbow.y);
		leftArm.addPoint(leftArmCuffOuter.x, leftArmCuffOuter.y);
		leftArm.addPoint(leftArmCuffInner.x, leftArmCuffInner.y);
		leftArm.addPoint(leftArmPit.x,leftArmPit.y );
		
		// Draw the right arm components on the canvas
		page.setColor(armColor);
		page.fillPolygon(leftArm);
		page.setColor(Color.BLACK);
		page.drawPolygon(leftArm);
		page.setColor(armColor);
		page.fillArc(leftArmAnchor.x, leftArmAnchor.y, armUpperWidth * 2, armUpperHeight * 2,90,-90);
		page.setColor(Color.BLACK);
		page.drawArc(leftArmAnchor.x, leftArmAnchor.y, armUpperWidth * 2, armUpperHeight * 2,90,-80);

		// Draw the torso polygon over the top of the arms to make sure the shoulders look correct
		page.setColor(shirtColor);
		page.fillPolygon(torso);
		page.setColor(Color.BLACK);
		page.drawPolygon(torso);
		
		
		/* 
		 * Components: Wrists
		 */
		int wristLength = (int) (15 * scaleFactor);
		// Calculate width of cuff using Pythagorean Theorem */
		double cuffWidth = Math.sqrt( Math.pow(Math.abs(rightArmCuffOuter.x - rightArmCuffInner.x),2) +
				Math.pow(Math.abs(rightArmCuffOuter.y - rightArmCuffInner.y),2));
		
		// Right Wrist
		double rightCuffSlope = ((double) rightArmCuffOuter.y - rightArmCuffInner.y) / (rightArmCuffOuter.x - rightArmCuffInner.x);
		double rightCuffAngle = Math.atan(rightCuffSlope);

		// Distance from outer cuff edge to outer wrist edge (1/5 cuffWidth)
		double rightWristDist1 = cuffWidth / 5.0;
		// Distance from outer cuff edge to inner wrist edge (4/5 cuffWidth)
		double rightWristDist2 = 4 * cuffWidth / 5.0; 

		// Use trig functions to calculate x,y components of Points required to draw wrist perpendicular to cuff on arm
		Point rightWristCuffOuter = new Point();
		rightWristCuffOuter.x = (int) (rightArmCuffOuter.x - (rightWristDist1 * (rightArmCuffOuter.x - rightArmCuffInner.x)) / cuffWidth);
		rightWristCuffOuter.y = (int) (rightArmCuffOuter.y - (rightWristDist1 * (rightArmCuffOuter.y - rightArmCuffInner.y)) / cuffWidth);
		
		Point rightWristCuffInner = new Point();
		rightWristCuffInner.x = (int) (rightArmCuffOuter.x - (rightWristDist2 * (rightArmCuffOuter.x - rightArmCuffInner.x)) / cuffWidth);
		rightWristCuffInner.y = (int) (rightArmCuffOuter.y - (rightWristDist2 * (rightArmCuffOuter.y - rightArmCuffInner.y)) / cuffWidth);
		
		Point rightWristHandOuter = new Point();
		rightWristHandOuter.x = (int)(rightWristCuffOuter.x + wristLength * Math.cos(rightCuffAngle + Math.PI/2.0));
		rightWristHandOuter.y = (int)(rightWristCuffOuter.y + wristLength * Math.sin(rightCuffAngle + Math.PI/2.0));
		
		Point rightWristHandInner = new Point();
		rightWristHandInner.x = (int)(rightWristCuffInner.x + wristLength * Math.cos(rightCuffAngle + Math.PI/2.0));
		rightWristHandInner.y = (int)(rightWristCuffInner.y + wristLength * Math.sin(rightCuffAngle + Math.PI/2.0));
		
		// Create a new Polygon object for the right wrist using the above Points
		Polygon rightWrist = new Polygon();
		rightWrist.addPoint(rightWristCuffOuter.x, rightWristCuffOuter.y);
		rightWrist.addPoint(rightWristCuffInner.x, rightWristCuffInner.y);
		rightWrist.addPoint(rightWristHandInner.x, rightWristHandInner.y);
		rightWrist.addPoint(rightWristHandOuter.x, rightWristHandOuter.y);
		
		// Draw the right wrist components on the canvas
		page.setColor(handColor);
		page.fillPolygon(rightWrist);
		page.setColor(Color.BLACK);
		page.drawPolygon(rightWrist);
		

		// Left Wrist
		double leftCuffSlope = ((double)leftArmCuffOuter.y - leftArmCuffInner.y) / (leftArmCuffOuter.x - leftArmCuffInner.x);
		double leftCuffAngle = Math.atan(leftCuffSlope);

		/* Distance from outer cuff edge to outer wrist edge (1/5 cuffWidth) */
		double leftWristDist1 = cuffWidth / 5.0;
		/* Distance from outer cuff edge to inner wrist edge (4/5 cuffWidth) */
		double leftWristDist2 = 4 * cuffWidth / 5.0; 
		
		// Use trig functions to calculate x,y components of Points required to draw wrist perpendicular to cuff on arm
		Point leftWristCuffOuter = new Point();
		leftWristCuffOuter.x = (int) (leftArmCuffOuter.x - (leftWristDist1 * (leftArmCuffOuter.x - leftArmCuffInner.x)) / cuffWidth);
		leftWristCuffOuter.y = (int) (leftArmCuffOuter.y - (leftWristDist1 * (leftArmCuffOuter.y - leftArmCuffInner.y)) / cuffWidth);
		
		Point leftWristCuffInner = new Point();
		leftWristCuffInner.x = (int) (leftArmCuffOuter.x - (leftWristDist2 * (leftArmCuffOuter.x - leftArmCuffInner.x)) / cuffWidth);
		leftWristCuffInner.y = (int) (leftArmCuffOuter.y - (leftWristDist2 * (leftArmCuffOuter.y - leftArmCuffInner.y)) / cuffWidth);
		
		Point leftWristHandOuter = new Point();
		leftWristHandOuter.x = (int)(leftWristCuffOuter.x + wristLength * Math.cos(leftCuffAngle + Math.PI / 2.0  )) + 1;
		leftWristHandOuter.y = (int)(leftWristCuffOuter.y + wristLength * Math.sin(leftCuffAngle + Math.PI / 2.0 ));
		
		Point leftWristHandInner = new Point();
		leftWristHandInner.x = (int)(leftWristCuffInner.x + wristLength * Math.cos(leftCuffAngle + Math.PI / 2.0 )) + 1;
		leftWristHandInner.y = (int)(leftWristCuffInner.y + wristLength * Math.sin(leftCuffAngle + Math.PI / 2.0 ));
		
		// Create a new Polygon object for the left wrist using the above Points
		Polygon leftWrist = new Polygon();
		leftWrist.addPoint(leftWristCuffOuter.x, leftWristCuffOuter.y);
		leftWrist.addPoint(leftWristCuffInner.x, leftWristCuffInner.y);
		leftWrist.addPoint(leftWristHandInner.x, leftWristHandInner.y);
		leftWrist.addPoint(leftWristHandOuter.x, leftWristHandOuter.y);
		
		// Draw the left wrist components on the canvas
		page.setColor(handColor);
		page.fillPolygon(leftWrist);
		page.setColor(Color.BLACK);
		page.drawPolygon(leftWrist);
		
		/* 
		 * Component:  Hands
		 */
		// Calculate scaled hand dimensions and position offsets
		int handDiameter = (int) (45 * scaleFactor);
		int handHoleDiameter = (int) (30 * scaleFactor);
		int leftHandXShift = (int) (-30 * scaleFactor);
		int leftHandYShift = (int) (-1 * scaleFactor);
		int rightHandXShift = (int) (-16 * scaleFactor);
		int rightHandYShift = (int) (-1 * scaleFactor);
		
		// Draw the left hand components on the canvas
		page.setColor(handColor);
		page.fillArc(leftWristHandOuter.x + leftHandXShift, leftWristHandOuter.y + leftHandYShift, handDiameter, handDiameter,-45,290);
		page.setColor(Color.BLACK);
		page.drawArc(leftWristHandOuter.x + leftHandXShift, leftWristHandOuter.y + leftHandYShift, handDiameter, handDiameter,-45,290);
		page.setColor(handHoleColor);
		page.fillOval(leftWristHandOuter.x + leftHandXShift + ((handDiameter - handHoleDiameter) / 2), leftWristHandOuter.y + leftHandYShift + ((handDiameter - handHoleDiameter) / 2), handHoleDiameter, handHoleDiameter);
		page.setColor(Color.BLACK);
		page.drawArc(leftWristHandOuter.x + leftHandXShift + ((handDiameter - handHoleDiameter) / 2), leftWristHandOuter.y + leftHandYShift + ((handDiameter - handHoleDiameter) / 2), handHoleDiameter, handHoleDiameter,-45,290);
		
		// Draw the right hand components on the canvas
		page.setColor(handColor);
		page.fillArc(rightWristHandOuter.x +rightHandXShift, rightWristHandOuter.y + rightHandYShift, handDiameter, handDiameter,-60,290);
		page.setColor(Color.BLACK);
		page.drawArc(rightWristHandOuter.x +rightHandXShift , rightWristHandOuter.y + rightHandYShift, handDiameter, handDiameter,-60,290);
		page.setColor(handHoleColor);
		page.fillOval(rightWristHandOuter.x  +rightHandXShift  + ((handDiameter - handHoleDiameter) / 2), rightWristHandOuter.y + rightHandYShift + ((handDiameter - handHoleDiameter) / 2), handHoleDiameter, handHoleDiameter);
		page.setColor(Color.BLACK);
		page.drawArc(rightWristHandOuter.x +rightHandXShift + ((handDiameter - handHoleDiameter) / 2), rightWristHandOuter.y +  rightHandYShift + ((handDiameter - handHoleDiameter) / 2), handHoleDiameter, handHoleDiameter,-60,290);

	}


	/**
	 * Constructor (panel initialization)
	 */
	public MiniFigScalable()
	{
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(INITIAL_WIDTH, INITIAL_HEIGHT));
	}


	/**
	 * Sets up a JFrame and the BlankCanvas panel.
	 * @param args unused
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("MiniFigScalable");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new MiniFigScalable());
		frame.pack();
		frame.setVisible(true);
	}
}
