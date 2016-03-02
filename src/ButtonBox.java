import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.*;

/**
 * 
 */

/**
 * @author Ryan Smith
 *
 */
public class ButtonBox extends JFrame implements ActionListener{
	
	//declaring JLabels, JPanels and GridLayout
	private static final long serialVersionUID = 1;
	static JLabel myLabel;
	private JPanel mainPanel;
	private JPanel buttonPanel;
	static JButton quitButton;
	static GridLayout layout;
	public ArrayList buttonList;
	
	/**
	 * Constructor
	 */
	public ButtonBox() {
		super("Button Box");//Called because this class extends another class
		JButton button;
		JLabel label;
		myLabel = new JLabel("Press a button to play a sound");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		//instantiating JPanels mainPanel and buttonPanel
		mainPanel = new JPanel();
		buttonPanel = new JPanel();
		
		buttonPanel.setLayout(new GridLayout(1, 3)); //setting the layout to 1 x 3
		
		//instantiating JButttons, setting the action commands, adding the listener, and adding the JButton to the JPanel
		button = new JButton("Play sound 1");
		button.setActionCommand("one");
		button.addActionListener(this);
		buttonPanel.add(button);
		
		button = new JButton("Play sound 2");
		button.setActionCommand("two");
		button.addActionListener(this);
		buttonPanel.add(button);
		
		button = new JButton("Play sound 3");
		button.setActionCommand("three");
		button.addActionListener(this);
		buttonPanel.add(button);
		
		button = new JButton("Play sound 4");
		button.setActionCommand("four");
		button.addActionListener(this);
		buttonPanel.add(button);
		
		button = new JButton("Play sound 5");
		button.setActionCommand("five");
		button.addActionListener(this);
		buttonPanel.add(button);
		
		add(buttonPanel, BorderLayout.SOUTH);
		
		button = new JButton("Play back");
		button.setActionCommand("six");
		button.addActionListener(this);
		buttonPanel.add(button);
		
		label = new JLabel("Press a button to play a sound: ");
		mainPanel.add(label);
		
		myLabel = new JLabel();
		mainPanel.add(myLabel);
		
		add(mainPanel, BorderLayout.CENTER);
		
		setSize(getPreferredSize());
		pack();
		setVisible(true);
	}
	
	/**
	 * This method is the listener that plays the sound when the JButton is pressed.
	 */
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();//reference for JButton
		buttonList = new ArrayList<Integer>(100);
		switch(button.getActionCommand()) {
		case "one":
			myLabel.setText("Playing sound 1...");
			try {
			File dingSound = new File("ding.wav");//creating sound file reference
				AudioInputStream ding = AudioSystem.getAudioInputStream(dingSound);//creating AudioInputStream for sound ding
				AudioFormat formatOne = ding.getFormat();//new audio format
				DataLine.Info dingInfo = new DataLine.Info(Clip.class, formatOne);
				Clip dingClip  = (Clip) AudioSystem.getLine(dingInfo);//creates clip to be played
				dingClip.open(ding);//opens the clip
				dingClip.start();//plays the clip
				buttonList.add(1);
				} catch(Exception e1) {
				System.out.println(e1);
				}
			break;
		case "two":
			myLabel.setText("Playing sound 2...");
			try {
			File soundTwo = new File("Speech_Off.wav");//creating sound file reference
				AudioInputStream soundTwoStream = AudioSystem.getAudioInputStream(soundTwo);//creating AudioInputStream for soundTwo
				AudioFormat formatTwo = soundTwoStream.getFormat();//new audio format
				DataLine.Info soundTwoInfo = new DataLine.Info(Clip.class, formatTwo);
				Clip soundTwoClip  = (Clip) AudioSystem.getLine(soundTwoInfo);//creates clip to be played
				soundTwoClip.open(soundTwoStream);//opens the clip
				soundTwoClip.start();//plays the clip
				} catch(Exception e2) {
				System.out.println(e2);
				}
			break;
		case "three":
			myLabel.setText("Playing sound 3...");
			try {
			File soundThree = new File("Windows_Logon_Sound.wav");//creating sound file reference
				AudioInputStream soundThreeStream = AudioSystem.getAudioInputStream(soundThree);//creating AudioInputStream for soundThree
				AudioFormat formatThree = soundThreeStream.getFormat();//new audio format
				DataLine.Info soundThreeInfo = new DataLine.Info(Clip.class, formatThree);
				Clip soundThreeClip  = (Clip) AudioSystem.getLine(soundThreeInfo);//creates clip to be played
				soundThreeClip.open(soundThreeStream);//opens the clip
				soundThreeClip.start();//plays the clip
				} catch(Exception e3) {
				System.out.println(e3);
				}
			break;
		case "four":
			myLabel.setText("Playing sound 4...");
			try {
				File soundFour = new File("Windows_Battery_Low.wav");//creating sound file reference
					AudioInputStream soundFourStream = AudioSystem.getAudioInputStream(soundFour);//creating AudioInputStream for soundFour
					AudioFormat formatFour = soundFourStream.getFormat();//new audio format
					DataLine.Info soundFourInfo = new DataLine.Info(Clip.class, formatFour);
					Clip soundFourClip  = (Clip) AudioSystem.getLine(soundFourInfo);//creates clip to be played
					soundFourClip.open(soundFourStream);//opens the clip
					soundFourClip.start();//plays the clip
					} catch(Exception e4) {
					System.out.println(e4);
					}
			break;
		case "five":
			myLabel.setText("Playing sound 5...");
			try {
				File soundFive = new File("Windows_Hardware_Remove.wav");//creating sound file reference
				AudioInputStream soundFiveStream = AudioSystem.getAudioInputStream(soundFive);//creating AudioInputStream for soundFive
				AudioFormat formatFive = soundFiveStream.getFormat();//new audio format
				DataLine.Info soundFiveInfo = new DataLine.Info(Clip.class, formatFive);
				Clip soundFiveClip  = (Clip) AudioSystem.getLine(soundFiveInfo);//creates clip to be played
				soundFiveClip.open(soundFiveStream);//opens the clip
				soundFiveClip.start();//plays the clip
				} catch(Exception e5) {
					System.out.println(e5);
				}
			break;
		case "six":
			myLabel.setText("Play that funky music!");
			
			break;
		default:
			JOptionPane.showMessageDialog(this, "Unknown button pressed");//Will never happen.
		}
		
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ButtonBox();

	}

}
