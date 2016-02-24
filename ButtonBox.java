import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
/**
 * 
 */

/**
 * @author SJHSStudent
 *
 */
public class ButtonBox extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1; 
	 JLabel myLabel; // variable for label 
	 ButtonGroup myButton; // variable for roll dice button
	 GridBagLayout layout; // variable for the gridbag layout

	/**
	 * @param args
	 */
	
	public ButtonBox() {
		super( "ButtonBox" );
		JFrame myFrame = new JFrame("Button Box Sound App"); // creates the frame to hold all components
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// sets it to close as default
		myFrame.setVisible(true); // makes the frame visible
		layout = new GridBagLayout(); // creates a new GridBagLayout
		myFrame.setLayout(layout); // sets the layout of myFrame according to GridBagLayout
		GridBagConstraints c = new GridBagConstraints(); // creates a new GridBagRestraint 
		// general constraints
		c.fill = GridBagConstraints.BOTH;

		// label constraints
		c.weightx = .5; // changes weight of label to receive less space
		c.gridwidth = GridBagConstraints.RELATIVE; // sets the label to be in the second to last column
		myLabel = new JLabel("Press a button to play a sound!"); // creates new label
		myLabel.setForeground(Color.BLACK); // sets text color
		myLabel.setFont(new Font("TimesRoman", Font.BOLD, 24)); // sets font, makes font bold, and text size
		layout.setConstraints(myLabel, c); // sets restraints of the label 
		myFrame.add(myLabel); // adds label to frame

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	

}
