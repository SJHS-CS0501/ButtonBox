import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import javax.swing.*;
import java.io.*;
import sun.audio.*;
import java.applet.*;
import java.net.*;
import java.util.*;
/**
 * 
 */



/**
 * @author SJHSStudent
 *
 */
public class ButtonBox extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1;
	private JLabel myLabel; // variable for label
	private GridBagLayout layout; // variable for the gridbag layout
	private ArrayList<String> buttonPressed;
	private ArrayList<Long> delayTime;
	/**
	 * @param args
	 */

	public ButtonBox() {
		super("ButtonBox");
		JButton sound1; // button for sound one, DING
		JButton sound2; // button for sound two, WAPANG
		JButton sound3; // button for sound three, RECYCLE
		JButton sound4; // button for sound four, RING TONE
		JButton playBack; // button for playing back the sounds
		JButton clearSounds;
		buttonPressed = new ArrayList<String>();
		delayTime = new ArrayList<Long>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// sets it to close as default
		layout = new GridBagLayout(); // creates a new GridBagLayout
		setLayout(layout); // sets the layout of myFrame according to GridBagLayout
		GridBagConstraints c = new GridBagConstraints(); // creates a new GridBagRestraint
		// general constraints
		c.fill = GridBagConstraints.BOTH; // sets c to resize components BOTH vertically and horizontally

		// label constraints
		c.weightx = 1.5; // changes weight of label to receive less space
		c.gridwidth = GridBagConstraints.REMAINDER; // sets the label to be in the second to last column
		myLabel = new JLabel("Press a button to play a sound!"); // creates new label
		myLabel.setForeground(Color.BLACK); // sets text color
		myLabel.setFont(new Font("TimesRoman", Font.BOLD, 24)); // sets font, makes font bold, and text size
		layout.setConstraints(myLabel, c); // sets restraints of the label
		add(myLabel); // adds label to frame

		c.gridwidth = GridBagConstraints.REMAINDER; // button constraints
		sound1 = new JButton("DING"); // sound for DING
		sound2 = new JButton("WAPANG"); // sound for WAPANG
		sound3 = new JButton("RECYCLE"); // sound for RECYCLE
		sound4 = new JButton("RING TONE"); // sound for RING TONE
		clearSounds = new JButton("Clear Sounds");
		playBack = new JButton("PLAYBACK"); // creates the button for playing for play back sounds
		sound1.setFont(new Font("TimesRoman", Font.ITALIC, 12)); // sets font, makes font italicized and font size
		sound2.setFont(new Font("TimesRoman", Font.ITALIC, 12)); // sets font, makes font italicized and font size
		sound3.setFont(new Font("TimesRoman", Font.ITALIC, 12)); // sets font, makes font italicized and font size
		sound4.setFont(new Font("TimesRoman", Font.ITALIC, 12)); // sets font, makes font italicized and font size
		playBack.setFont(new Font("TimesRoman", Font.ITALIC, 12));
		clearSounds.setFont(new Font("TimesRoman", Font.ITALIC, 12)); // sets font, makes font italicized and font size
		sound1.addActionListener(this); // adds ActionListener to button to roll dice
		sound2.addActionListener(this);// adds ActionListener to button to stop rolling dice
		sound4.addActionListener(this); // adds ActionListener to button to roll dice
		sound3.addActionListener(this);// adds ActionListener to button to stop rolling dice
		playBack.addActionListener(this);
		clearSounds.addActionListener(this);
		sound1.setActionCommand("Sound One");
		sound2.setActionCommand("Sound Two");
		sound3.setActionCommand("Sound Three");
		sound4.setActionCommand("Sound Four");
		playBack.setActionCommand("Play Back");
		clearSounds.setActionCommand("Clear Sounds");
		layout.setConstraints(sound1, c); // more button constraints
		layout.setConstraints(sound2, c); // more button constraints
		layout.setConstraints(sound3, c); // more button constraints
		layout.setConstraints(sound4, c); // more button constraints
		
		add(sound1); // adds button to frame
		add(sound2); // adds button to frame
		add(sound3); // adds button to frame
		add(sound4); // adds button to frame
		add(playBack);  
		add(clearSounds);
		setResizable(false); // makes the frame unresizable 
		 setSize( getPreferredSize() ); // sets the frame to the preferred size 
		 pack(); // 
		 setVisible(true); // makes the frame visible
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ButtonBox(); // creates a new instance of button box, which opens the window for the program
	}

/**
 * Action listener method for the buttons
 */
		public void actionPerformed(ActionEvent e) {
			switch(e.getActionCommand()){
			case "Play Back":
				playBack(buttonPressed, delayTime); // calls the playback method to play back the button presses pressed
				break;
			case "Clear Sounds":
				buttonPressed.clear(); // clears button pressed so the user can record new sounds
				delayTime.clear(); // clears the delay so that the user can also record new delays with the cutton presses
			default:
				PlaySound(e); // if not the playback button or clear sounds, 
			}
		}
		public void playBack(ArrayList<String> buttonPressed, ArrayList<Long> delayTime){
			long actualDelay = 0;
			try{
			for(int ctr = 0; buttonPressed.size() >= ctr; ctr++ ){
				try{
				buttonPressed.get(ctr);
				actualDelay = (delayTime.get(ctr + 1)- delayTime.get(ctr)) / 1000000;
				}
				catch ( IndexOutOfBoundsException e2){
					System.out.println("Ingnore and move on, nothing to see here");
				}
				
				if(buttonPressed.get(ctr).equals("Sound One")){
					File ding = new File("ding.wav"); // creates the file to reference for sound one
					AudioInputStream dingStream = AudioSystem.getAudioInputStream(ding); // creates a new audio input stream
					AudioFormat dingFormat = dingStream.getFormat(); // creates a new audio format
					DataLine.Info dingInfo = new DataLine.Info( Clip.class, dingFormat); // creates a variable for additional information about the file
					Clip dingClip = (Clip) AudioSystem.getLine(dingInfo); // creates the clip that will be played 
					Thread.sleep(actualDelay);
					dingClip.open(dingStream); // opens the clip so that it can be played
					dingClip.start(); // starts to play the clip
					} 
					if(buttonPressed.get(ctr).equals("Sound Two")){
						File wapang = new File("WindowsCriticalStop.wav"); // creates a new file to reference for sound two
						AudioInputStream wapangStream = AudioSystem.getAudioInputStream(wapang);  // creates a new audio input stream
						AudioFormat wapangFormat = wapangStream.getFormat(); // creates a new audio format
						DataLine.Info wapangInfo = new DataLine.Info( Clip.class, wapangFormat);  // creates a variable for additional information about the file
						Clip wapangClip = (Clip) AudioSystem.getLine(wapangInfo); // creates the clip that will be played 
						Thread.sleep(actualDelay);
						wapangClip.open(wapangStream); // opens the clip so that it can be played
						wapangClip.start(); // starts to play the clip;
						} 							
						if(buttonPressed.get(ctr).equals("Sound Three")){
							File recycle = new File("WindowsRecycle.wav");
							AudioInputStream recycleStream = AudioSystem.getAudioInputStream(recycle);  // creates a new audio input stream
							AudioFormat recycleFormat = recycleStream.getFormat(); // creates a new audio format
							DataLine.Info recycleInfo = new DataLine.Info( Clip.class, recycleFormat);  // creates a variable for additional information about the file
							Clip recycleClip = (Clip) AudioSystem.getLine(recycleInfo); // creates the clip that will be played 
							Thread.sleep(actualDelay);
							recycleClip.open(recycleStream); // opens the clip so that it can be played
							recycleClip.start(); // starts to play the clip
						} 
						if(buttonPressed.get(ctr).equals("Sound Four")){
							File ringTone = new File("WindowsRingin.wav");
							AudioInputStream ringToneStream = AudioSystem.getAudioInputStream(ringTone);  // creates a new audio input stream
							AudioFormat ringToneFormat = ringToneStream.getFormat(); // creates a new audio format
							DataLine.Info ringToneInfo = new DataLine.Info( Clip.class, ringToneFormat);  // creates a variable for additional information about the file
							Clip ringToneClip = (Clip) AudioSystem.getLine(ringToneInfo); // creates the clip that will be played 
							Thread.sleep(actualDelay);
							ringToneClip.open(ringToneStream); // opens the clip so that it can be played
							ringToneClip.start(); // starts to play the clip
							} 
				}
			} catch (Exception e1){
					System.out.println(e1); // if an exception is found, the exception is printed in console
					System.out.println("If this exception is an IndexOutOfBoundsException, ingnore it, you saw nothing");
				}
		}
		
		public void PlaySound ( ActionEvent e){
			
			JButton button = (JButton) e.getSource(); // button variable for swtitch statement
			buttonPressed.add(e.getActionCommand());
			delayTime.add(System.nanoTime());
			switch (button.getActionCommand()) {
			case "Sound One":
				
				try {
					File ding = new File("ding.wav"); // creates the file to reference for sound one
						AudioInputStream dingStream = AudioSystem.getAudioInputStream(ding); // creates a new audio input stream
						AudioFormat dingFormat = dingStream.getFormat(); // creates a new audio format
						DataLine.Info dingInfo = new DataLine.Info( Clip.class, dingFormat); // creates a variable for additional information about the file
						Clip dingClip = (Clip) AudioSystem.getLine(dingInfo); // creates the clip that will be played 
						dingClip.open(dingStream); // opens the clip so that it can be played
						dingClip.start(); // starts to play the clip
						//buttonPressed.add("Sound One");
						
						} catch (Exception e1) {
						System.out.println(e1); // if an exception is found, the exception is printed in console
						}
					
				break;
			case "Sound Two":
				
				try {
					File wapang = new File("WindowsCriticalStop.wav"); // creates a new file to reference for sound two
					AudioInputStream wapangStream = AudioSystem.getAudioInputStream(wapang);  // creates a new audio input stream
					AudioFormat wapangFormat = wapangStream.getFormat(); // creates a new audio format
					DataLine.Info wapangInfo = new DataLine.Info( Clip.class, wapangFormat);  // creates a variable for additional information about the file
					Clip wapangClip = (Clip) AudioSystem.getLine(wapangInfo); // creates the clip that will be played
					wapangClip.open(wapangStream); // opens the clip so that it can be played
					wapangClip.start(); // starts to play the clip
					//buttonPressed.add("Sound Two");
					} catch (Exception e1) {
					System.out.println(e1); // if an exception is found, the exception is printed in console
					}
					
				break;
			case "Sound Three":
				
				try {
					File recycle = new File("WindowsRecycle.wav");
					AudioInputStream recycleStream = AudioSystem.getAudioInputStream(recycle);  // creates a new audio input stream
					AudioFormat recycleFormat = recycleStream.getFormat(); // creates a new audio format
					DataLine.Info recycleInfo = new DataLine.Info( Clip.class, recycleFormat);  // creates a variable for additional information about the file
					Clip recycleClip = (Clip) AudioSystem.getLine(recycleInfo); // creates the clip that will be played 
					recycleClip.open(recycleStream); // opens the clip so that it can be played
					recycleClip.start(); // starts to play the clip
					//buttonPressed.add("Sound Three");
					} catch (Exception e1) {
					System.out.println(e1); // if an exception is found, the exception is printed in console
					}
					
					
				break;
			case "Sound Four":
				
				try {
					File ringTone = new File("WindowsRingin.wav");
					AudioInputStream ringToneStream = AudioSystem.getAudioInputStream(ringTone);  // creates a new audio input stream
					AudioFormat ringToneFormat = ringToneStream.getFormat(); // creates a new audio format
					DataLine.Info ringToneInfo = new DataLine.Info( Clip.class, ringToneFormat);  // creates a variable for additional information about the file
					Clip ringToneClip = (Clip) AudioSystem.getLine(ringToneInfo); // creates the clip that will be played 
					ringToneClip.open(ringToneStream); // opens the clip so that it can be played
					ringToneClip.start(); // starts to play the clip
					//buttonPressed.add("Sound Four");
					} catch (Exception e1) {
					System.out.println(e1); // if an exception is found, the exception is printed in console
					}
					
				break;
			case "Play Back":
				playBack(buttonPressed, delayTime);
					
				break;
			default:

				break;

			}
		}
	}

	
