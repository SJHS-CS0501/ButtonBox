import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import sun.audio.*;
import java.applet.*;
import java.net.*;
/**
 * 
 */



/**
 * @author SJHSStudent
 *
 */
public class ButtonBox extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1;
	JLabel myLabel; // variable for label
	GridBagLayout layout; // variable for the gridbag layout

	/**
	 * @param args
	 */

	public ButtonBox() {
		super("ButtonBox");
		JButton sound1;
		JButton sound2;
		JButton sound3;
		JButton sound4;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// sets it to close as default
		layout = new GridBagLayout(); // creates a new GridBagLayout
		setLayout(layout); // sets the layout of myFrame according to GridBagLayout
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
		add(myLabel); // adds label to frame

		c.gridwidth = GridBagConstraints.REMAINDER; // button constraints
		sound1 = new JButton("DING"); // sound for
		sound2 = new JButton(""); // sound for
		sound3 = new JButton(""); // sound for
		sound4 = new JButton(""); // sound for
		sound1.setFont(new Font("TimesRoman", Font.ITALIC, 12)); // sets font, makes font italicized and font size
		sound2.setFont(new Font("TimesRoman", Font.ITALIC, 12)); // sets font, makes font italicized and font size
		sound3.setFont(new Font("TimesRoman", Font.ITALIC, 12)); // sets font, makes font italicized and font size
		sound4.setFont(new Font("TimesRoman", Font.ITALIC, 12)); // sets font, makes font italicized and font size

		sound1.addActionListener(this); // adds ActionListener to button to roll dice
		sound2.addActionListener(this);// adds ActionListener to button to stop rolling dice
		sound4.addActionListener(this); // adds ActionListener to button to roll dice
		sound2.addActionListener(this);// adds ActionListener to button to stop rolling dice
		sound1.setActionCommand("Sound One");
		layout.setConstraints(sound1, c); // more button constraints
		layout.setConstraints(sound2, c); // more button constraints
		layout.setConstraints(sound3, c); // more button constraints
		layout.setConstraints(sound4, c); // more button constraints
		add(sound1); // adds button to frame
		add(sound2); // adds button to frame
		add(sound3); // adds button to frame
		add(sound4); // adds button to frame

		setResizable(false); // makes the frame unresizable 
		 setSize( getPreferredSize() ); // sets the frame to the preferred size 
		 pack(); // 
		 setVisible(true); // makes the frame visible
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ButtonBox();
	}

/*
 * (non-Javadoc)
 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)

 */

		public void actionPerformed(ActionEvent e) {
			JButton eventSource = (JButton) e.getSource();
			JButton button = (JButton) e.getSource();
			
			switch (button.getActionCommand()) {
			case "Sound One":
				
					try {
					File "ding.wav";
						java.applet.AudioClip clip = new ("ding.wav");
						clip.play();
						} catch (java.net.MalformedURLException murle) {
						System.out.println(murle);
						}
					
				break;
			case "Sound Two":
				try {
					java.applet.AudioClip clip = java.applet.Applet.newAudioClip(new (""));
					clip.play();
					} catch (java.net.MalformedURLException murle) {
					System.out.println(murle);
					}
				break;
			case "Sound Three":
				try {
					java.applet.AudioClip clip = java.applet.Applet.newAudioClip(new (""));
					clip.play();
					} catch (java.net.MalformedURLException murle) {
					System.out.println(murle);
					}
				break;
			case "Sound Four":
				try {
					java.applet.AudioClip clip = java.applet.Applet.newAudioClip(new (""));
					clip.play();
					} catch (java.net.MalformedURLException murle) {
					System.out.println(murle);
					}
				break;
			default:

				break;

			}
		}
	}

