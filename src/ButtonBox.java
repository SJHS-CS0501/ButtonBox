import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.sound.sampled.*;

/**
 * This program will have buttons that make sounds.
 * @author Julianna Nichols
 */
public class ButtonBox extends JFrame implements ActionListener {
	
	ArrayList<String> lotsOfSounds = new ArrayList<String>();
	private static final long serialVersionUID = 1;
	AudioInputStream audioSound;
	private JPanel buttonPanel; //buttons that will make sounds
	private JPanel startStop; //start and stop buttons
	private JLabel label;
	Boolean stop = false;
	DataLine.Info info;
	AudioFormat format;
	PrintWriter writer;
	Clip clip = null;
	String[] sounds;
	Clip audioClip;
	File sound;
	
	//constructor
	public ButtonBox() {
		super("Button Box");
		
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		buttonPanel = new JPanel(); //creating panel with sound buttons
		startStop = new JPanel(); //creating panel with start/stop buttons
		JButton button;
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH; //makes components fill space both horizontally and vertically
		
		c.weightx = 0.0; //resizing behavior
        c.gridwidth = GridBagConstraints.RELATIVE; //rows, last one in its row
        
        label = new JLabel("Click a button to make a sound!");
		
        /*
         * This is what the next bit of code is doing:
         * 
         * - Making button for [drum roll] sound (also, start and stop)
         * - Setting word that is recognized by switch statement
         * - Adding ACtionListener so it will listen for this button
         * 		[this] referring to the current button
         * - Adding button to the panel
         */
        
		button = new JButton( "Drum roll" );
		button.setActionCommand( "One" );
		button.addActionListener( this );
		buttonPanel.add(button);
		
		button = new JButton( "Cymbals" );
		button.setActionCommand( "Two" );
		button.addActionListener( this );
		buttonPanel.add(button);
		
		button = new JButton( "Bicycle Bell" );
		button.setActionCommand( "Three" );
		button.addActionListener( this );
		buttonPanel.add(button);
		
		button = new JButton( "Cuckoo Clock" );
		button.setActionCommand( "Four" );
		button.addActionListener( this );
		buttonPanel.add(button);
		
		button = new JButton( "Dolphin" );
		button.setActionCommand( "Five" );
		button.addActionListener( this );
		buttonPanel.add(button);
		
		button = new JButton( "Cow" );
		button.setActionCommand( "Six" );
		button.addActionListener( this );
		buttonPanel.add(button);
		
		button = new JButton( "Play Back" );
		button.setActionCommand("Seven");
		button.addActionListener( this );
		startStop.add(button);
		
		button = new JButton( "Stop" );
		button.setActionCommand("Eight");
		button.addActionListener( this );
		startStop.add(button);
		
		button = new JButton( "Record" );
		button.setActionCommand("Nine");
		button.addActionListener( this );
		startStop.add(button);
		
		add(label, BorderLayout.NORTH); //putting label at the top of the JFrame
		add(buttonPanel, BorderLayout.CENTER); //putting the sound buttons in the center of the JFrame
		add(startStop, BorderLayout.SOUTH); //putting the start/stop buttons at the bottom of the JFrame
		
		setSize(getPreferredSize()); //when resizing it resizes to the preferred size of each container
		pack();
		setVisible(true); //setting frame visible
	}

	/**
	 * This is the main method for the ButtonBox program.
	 * @param args
	 */
	public static void main(String[] args) {
		new ButtonBox();
	}
	
	/**
	 * ActionListener, listens for button clicks
	 * @param ActionEvent e, button to be clicked
	 */
	public void actionPerformed( ActionEvent e ) {
		JButton button = (JButton)e.getSource();
		
		switch ( button.getActionCommand() ) {
		case "Seven":
			audioClip.start();
			break;
		case "Eight":
			audioClip.stop();
			break;
		case "Nine":
			stop = true;
			makeRecording(button, stop);
			break;
		default:
			play(sound,button);
			break;
		}
		
	}
	
	/**
	 * Plays sound
	 * @param File sound
	 */
	public void play( File sound, JButton button ) {
		
		switch( button.getActionCommand() ) {
		/*
		 * all cases are set up:
		 * 
		 * - New file created
		 * - Call on 'play' method to actually play the sound
		 * 
		 * - Start/stop have commands to start/stop the sound playing
		 * 
		 * - Default terminates the program
		 */
		case "One":
			sound = new File("drum_roll2.wav");
			break;
		case "Two":
			sound = new File("cymbals.wav");
			break;
		case "Three":
			sound = new File("bicycle_bell.wav");
			break;
		case "Four":
			sound = new File("cuckoo_clock1_x.wav");
			break;
		case "Five":
			sound = new File("dolphin.wav");
			break;
		case "Six":
			sound = new File("cow.wav");
			break;
		default:
			System.exit(0);
		}
		
		try {
			audioSound = AudioSystem.getAudioInputStream(sound); //accessing file
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		format = audioSound.getFormat();
		
		DataLine.Info info = new DataLine.Info(Clip.class, format); //adding functionality to sounds
		
		try {
			audioClip = (Clip) AudioSystem.getLine(info); //accessing file again after going through DataLine
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		
		try {
			audioClip.open(audioSound); //opening sound file
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		audioClip.start(); //playing sound file
	}
	
	/**
	 * Making array (recording)
	 * @param button
	 */
	public void makeRecording(JButton button, Boolean stop) {
		
			switch( button.getActionCommand() ) {
			case "One":
				break;
			case "Two":
				break;
			case "Three":
				break;
			case "Four":
				break;
			case "Five":
				break;
			case "Six":
				break;
			case "Eight":
				break;
			default:
				System.out.print("Bad thing");
			}
			
			if( button.getActionCommand()!=("Eight") ) {
				int c = 0;
				lotsOfSounds.add(c, button.getActionCommand());
				c++;
			} else {
				
				try {
					writer = new PrintWriter("soundFile.txt");
					
					for (int ctr = 0; ctr >= 0; ctr++ ) {
						sounds = lotsOfSounds.toArray(new String[lotsOfSounds.size()]);
						writer.println( sounds[ctr] );
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				
			}
			
	}
	
}
