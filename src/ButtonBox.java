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
	
	private ArrayList<String> lotsOfSounds = new ArrayList<String>(); //for recording
	private ArrayList<Long> timing = new ArrayList<Long>(); //for the breaks in between
	private long time; //used to find the amount of time in between in milliseconds
	private static final long serialVersionUID = 1;
	private AudioInputStream audioSound;
	private JPanel buttonPanel; //buttons that will make sounds
	private JPanel startStop; //start and stop buttons
	private JLabel label;
	private Boolean stop = false, timer = false; 
	//private DataLine.Info info; don't think I need
	private AudioFormat format;
	//private Clip clip = null; don't think I need
	//private String[] sounds; don't think I need
	private Clip audioClip;
	private File sound; //holds sounds
	
	//constructor
	public ButtonBox() {
		super("Button Box");
		
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		buttonPanel = new JPanel(); //creating panel with sound buttons
		startStop = new JPanel(); //creating panel with start/stop buttons
		JButton button;
		
		GridBagConstraints c = new GridBagConstraints();
		//makes components fill space both horizontally and vertically
		c.fill = GridBagConstraints.BOTH;
		
		c.weightx = 0.0; //resizing behavior
        c.gridwidth = GridBagConstraints.RELATIVE; //rows, last one in its row
        
        label = new JLabel("Click a button to make a sound!");
		
        /*
         * This is what the next bit of code is doing:
         * 
         * - Making button for [drum roll] sound (also, start and stop)
         * - Setting word that is recognized by switch statement (a.k.a ActionCommand)
         * - Adding ActionListener so it will listen for this button
         * 		[this] referring to the current button
         * - Adding button to the panel
         */
        
		button = new JButton( "Drum roll" );
		button.setActionCommand( "Drum" );
		button.addActionListener( this );
		buttonPanel.add(button);
		
		button = new JButton( "Cymbals" );
		button.setActionCommand( "Cymbal" );
		button.addActionListener( this );
		buttonPanel.add(button);
		
		button = new JButton( "Bicycle Bell" );
		button.setActionCommand( "Bell" );
		button.addActionListener( this );
		buttonPanel.add(button);
		
		button = new JButton( "Cuckoo Clock" );
		button.setActionCommand( "Clock" );
		button.addActionListener( this );
		buttonPanel.add(button);
		
		button = new JButton( "Dolphin" );
		button.setActionCommand( "Dolphin" );
		button.addActionListener( this );
		buttonPanel.add(button);
		
		button = new JButton( "Cow" );
		button.setActionCommand( "Cow" );
		button.addActionListener( this );
		buttonPanel.add(button);
		
		button = new JButton( "Play Back" );
		button.setActionCommand("Play Back");
		button.addActionListener( this );
		startStop.add(button);
		
		button = new JButton( "Stop" );
		button.setActionCommand("Stop");
		button.addActionListener( this );
		startStop.add(button);
		
		button = new JButton( "Record" );
		button.setActionCommand("Record");
		button.addActionListener( this );
		startStop.add(button);
		
		//putting label at the top of the JFrame
		add(label, BorderLayout.NORTH);
		//putting the sound buttons in the center of the JFrame
		add(buttonPanel, BorderLayout.CENTER);
		//putting the start/stop buttons at the bottom of the JFrame
		add(startStop, BorderLayout.SOUTH);
		
		//when resizing it resizes to the preferred size of each container
		setSize(getPreferredSize());
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
		
		switch ( e.getActionCommand() ) { //switching on ActionCommands
		case "Play Back":
			stop = false;
			for(int i = 0; i <= lotsOfSounds.size(); i++ ) {
				recPlay(lotsOfSounds.get(i));
			}
			break;
		case "Stop":
			stop = false;
			break;
		case "Record":
			stop = true;
			break;
		default:
			stop = false;
			play(e);
			break;
		}
		
	}
	
	/**
	 * Playing back recording of sounds
	 * @param t
	 */
	public void recPlay( String t ) { 
		switch( t ) { //switching on the ActionCommands (strings) from array
		//every time a new file is created
		case "Drum":
			sound = new File("drum_roll2.wav");
			break;
		case "Cymbal":
			sound = new File("cymbals.wav");
			break;
		case "Bell":
			sound = new File("bicycle_bell.wav");
			break;
		case "Clock":
			sound = new File("cuckoo_clock1_x.wav");
			break;
		case "Dolphin":
			sound = new File("dolphin.wav");
			break;
		case "Cow":
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
		
		//adding functionality to sounds
		DataLine.Info info = new DataLine.Info(Clip.class, format);
		
		try {
			//accessing file again after going through DataLine
			audioClip = (Clip) AudioSystem.getLine(info);
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
	 * Plays sound (regular, not from recording)
	 * @param File sound
	 */
	public void play( ActionEvent s ) { 
		
		switch( s.getActionCommand() ) { //switching on ActionCommands
		case "Drum":
			sound = new File("drum_roll2.wav");
			if ( stop ) { //if it's recording (Boolean stop is true)...comes here
				lotsOfSounds.add(s.getActionCommand()); //adding it the recording ArrayList
				System.out.print("Yes sound added to array");
				time = System.currentTimeMillis(); //getting first time
				if ( timer ) { //if true..for the second button clicked
					//time is the first saved time minus the current time to give time in
					//between clicks
					time = System.currentTimeMillis() - time;
					timing.add(time); //adding that time to the ArrayList for timing
				}
			}
			break;
		case "Cymbal":
			sound = new File("cymbals.wav");
			if ( stop ) {
				lotsOfSounds.add(s.getActionCommand());
				System.out.print("Yes sound added to array");
				time = System.currentTimeMillis();
				if ( timer ) {
					time = System.currentTimeMillis() - time;
					timing.add(time);
				}
			}
			break;
		case "Bell":
			sound = new File("bicycle_bell.wav");
			if ( stop ) {
				lotsOfSounds.add(s.getActionCommand());
				System.out.print("Yes sound added to array");
				time = System.currentTimeMillis();
				if ( timer ) {
					time = System.currentTimeMillis() - time;
					timing.add(time);
				}
			}
			break;
		case "Clock":
			sound = new File("cuckoo_clock1_x.wav");
			if ( stop ) {
				lotsOfSounds.add(s.getActionCommand());
				System.out.print("Yes sound added to array");
				time = System.currentTimeMillis();
				if ( timer ) {
					time = System.currentTimeMillis() - time;
					timing.add(time);
				}
			}
			break;
		case "Dolphin":
			sound = new File("dolphin.wav");
			if ( stop ) {
				lotsOfSounds.add(s.getActionCommand());
				System.out.print("Yes sound added to array");
				time = System.currentTimeMillis();
				if ( timer ) {
					time = System.currentTimeMillis() - time;
					timing.add(time);
				}
			}
			break;
		case "Cow":
			sound = new File("cow.wav");
			if ( stop ) {
				lotsOfSounds.add(s.getActionCommand());
				System.out.print("Yes sound added to array");
				time = System.currentTimeMillis();
				if ( timer ) {
					time = System.currentTimeMillis() - time;
					timing.add(time);
				}
			}
			break;
		default:
			System.exit(0);
		}
		
		timer = true;
		
		try {
			audioSound = AudioSystem.getAudioInputStream(sound); //accessing file
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		format = audioSound.getFormat();
		
		//adding functionality to sounds
		DataLine.Info info = new DataLine.Info(Clip.class, format);
		
		try {
			//accessing file again after going through DataLine
			audioClip = (Clip) AudioSystem.getLine(info);
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
	
}

//problem at 135..recPlay
