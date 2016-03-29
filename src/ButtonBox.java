import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.sound.sampled.*;

/**
 * This program will have buttons that make sounds.
 * 
 * @author Julianna Nichols
 */
public class ButtonBox extends JFrame implements ActionListener {

	private ArrayList<String> lotsOfSounds = new ArrayList<String>(10); // for
																		// recording
	private ArrayList<Long> timing = new ArrayList<Long>(10); // for the breaks
																// in between
	private Boolean recording = false, timer = false;
	private static final long serialVersionUID = 1;
	private AudioInputStream audioSound;
	private AudioFormat format;
	private JPanel buttonPanel; // buttons that will make sounds
	private JPanel startStop; // start and stop buttons
	private Clip audioClip;
	private JLabel label;
	private File sound; // holds sounds
	private long time; // used to find the amount of time in between in
						// milliseconds

	// private DataLine.Info info; don't think I need
	// private Clip clip = null; don't think I need
	// private String[] sounds; don't think I need

	// constructor
	public ButtonBox() {
		super("Button Box");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		buttonPanel = new JPanel(); // creating panel with sound buttons
		startStop = new JPanel(); // creating panel with start/stop buttons
		JButton button;

		GridBagConstraints c = new GridBagConstraints();
		// makes components fill space both horizontally and vertically
		c.fill = GridBagConstraints.BOTH;

		c.weightx = 0.0; // resizing behavior
		c.gridwidth = GridBagConstraints.RELATIVE; // rows, last one in its row
		label = new JLabel("Click a button to make a sound!");

		/*
		 * This is what the next bit of code is doing:
		 *
		 * - Making button for [drum roll] sound (also play back and record) -
		 * Setting word that is recognized by switch statement (a.k.a
		 * ActionCommand) - Adding ActionListener so it will listen for this
		 * button [this] referring to the current button - Adding button to the
		 * panel
		 */
		button = new JButton("Drum roll");
		button.setActionCommand("Drum");
		button.addActionListener(this);
		buttonPanel.add(button);

		button = new JButton("Cymbals");
		button.setActionCommand("Cymbal");
		button.addActionListener(this);
		buttonPanel.add(button);

		button = new JButton("Bicycle Bell");
		button.setActionCommand("Bell");
		button.addActionListener(this);
		buttonPanel.add(button);

		button = new JButton("Cuckoo Clock");
		button.setActionCommand("Clock");
		button.addActionListener(this);
		buttonPanel.add(button);

		button = new JButton("Dolphin");
		button.setActionCommand("Dolphin");
		button.addActionListener(this);
		buttonPanel.add(button);

		button = new JButton("Cow");
		button.setActionCommand("Cow");
		button.addActionListener(this);
		buttonPanel.add(button);

		button = new JButton("Play Back");
		button.setActionCommand("Play Back");
		button.addActionListener(this);
		startStop.add(button);

		button = new JButton("Record");
		button.setActionCommand("Record");
		button.addActionListener(this);
		startStop.add(button);

		// putting label at the top of the JFrame
		add(label, BorderLayout.NORTH);
		// putting the sound buttons in the center of the JFrame
		add(buttonPanel, BorderLayout.CENTER);
		// putting the start/stop buttons at the bottom of the JFrame
		add(startStop, BorderLayout.SOUTH);

		// when resizing it resizes to the preferred size of each container
		setSize(getPreferredSize());
		pack();
		setVisible(true); // setting frame visible
	}

	/**
	 * This is the main method for the ButtonBox program.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new ButtonBox();
	}

	/**
	 * ActionListener, listens for button clicks
	 * 
	 * @param ActionEvent
	 *            e, button to be clicked
	 */
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) { // switching on ActionCommands
		case "Play Back":
			recording = false;
			for (int i = 0; i < lotsOfSounds.size(); i++) {
				// System.out.println("going through array"); //check
				// System.out.println("i = " + i); //check
				try {
					recPlay(lotsOfSounds.get(i));
				} catch (Exception c) {
					System.exit(0);
				}

				for (int q = 0; q < timing.size(); q++) {
					try {
						Thread.sleep(timing.get(q + 1) - timing.get(q));
					} catch (Exception d) {
						System.exit(0);
					}
				}
			}
			break;
		case "Record":
			recording = true;
			lotsOfSounds.clear();
			timing.clear();
			break;
		default:
			if (recording == true) { // checking if recording is already set to
										// true
				timer = true;
				play(e, recording, timer);
			}
			if (recording == false) {
				timer = false;
				play(e, recording, timer);
			}
			break;
		}
	}

	/**
	 * Playing back recording of sounds
	 * 
	 * @param t
	 */
	public void recPlay(String t) {
		switch (t) { // switching on the ActionCommands (strings) from array
		// every time a new file is created
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
			audioSound = AudioSystem.getAudioInputStream(sound); // accessing
																	// file
			format = audioSound.getFormat();
			// adding functionality to sounds
			DataLine.Info info = new DataLine.Info(Clip.class, format);
			// accessing file again after going through DataLine
			audioClip = (Clip) AudioSystem.getLine(info);
			audioClip.open(audioSound); // opening sound file

		} catch (Exception e) {
			System.out.print("ERROR");
		}

		audioClip.start(); // playing sound file
	}

	/**
	 * Plays sound/makes ArrayList for recording
	 * 
	 * @param File
	 *            sound
	 */
	public void play(ActionEvent s, Boolean recording, Boolean timer) {

		switch (s.getActionCommand()) { // switching on ActionCommands
		case "Drum":
			sound = new File("drum_roll2.wav");

			if (recording) { // if it's recording (Boolean recording is
								// true)...comes here
				lotsOfSounds.add(s.getActionCommand()); // adding it the
														// recording ArrayList
				// System.out.println("Yes sound added to array "); //just a
				// check

				time = System.currentTimeMillis(); // getting first time
				timing.add(time);
				/*
				 * if ( timer ) { //if true..for the second button clicked
				 * //time is the first saved time minus the current time to give
				 * time in //between clicks System.out.println(
				 * "Got to the timer"); time = System.currentTimeMillis() -
				 * time; timing.add(time); //adding that time to the ArrayList
				 * for timing }
				 */
			}
			break;
		case "Cymbal":
			sound = new File("cymbals.wav");

			if (recording) {
				lotsOfSounds.add(s.getActionCommand());
				// System.out.println("Yes sound added to array ");

				/*
				 * time = System.currentTimeMillis(); if ( timer ) {
				 * System.out.println("Got to the timer"); time =
				 * System.currentTimeMillis() - time; timing.add(time); }
				 */
			}
			break;
		case "Bell":
			sound = new File("bicycle_bell.wav");
			if (recording) {
				lotsOfSounds.add(s.getActionCommand());
				// System.out.println("Yes sound added to array ");

				/*
				 * time = System.currentTimeMillis(); if ( timer ) {
				 * System.out.println("Got to the timer"); time =
				 * System.currentTimeMillis() - time; timing.add(time); }
				 */
			}
			break;
		case "Clock":
			sound = new File("cuckoo_clock1_x.wav");
			if (recording) {
				lotsOfSounds.add(s.getActionCommand());
				// System.out.println("Yes sound added to array ");

				/*
				 * time = System.currentTimeMillis(); if ( timer ) {
				 * System.out.println("Got to the timer"); time =
				 * System.currentTimeMillis() - time; timing.add(time); }
				 */
			}
			break;
		case "Dolphin":
			sound = new File("dolphin.wav");
			if (recording) {
				lotsOfSounds.add(s.getActionCommand());
				// System.out.println("Yes sound added to array ");

				/*
				 * time = System.currentTimeMillis(); if ( timer ) {
				 * System.out.println("Got to the timer"); time =
				 * System.currentTimeMillis() - time; timing.add(time); }
				 */
			}
			break;
		case "Cow":
			sound = new File("cow.wav");
			if (recording) {
				lotsOfSounds.add(s.getActionCommand());
				// System.out.println("Yes sound added to array ");

				/*
				 * time = System.currentTimeMillis(); if ( timer ) {
				 * System.out.println("Got to the timer"); time =
				 * System.currentTimeMillis() - time; timing.add(time); }
				 */
			}
			break;
		default:
			System.exit(0);
		}

		timer = true;

		try {
			audioSound = AudioSystem.getAudioInputStream(sound); // accessing
																	// file
			format = audioSound.getFormat();
			// adding functionality to sounds
			DataLine.Info info = new DataLine.Info(Clip.class, format);
			// accessing file again after going through DataLine
			audioClip = (Clip) AudioSystem.getLine(info);
			audioClip.open(audioSound); // opening sound file

		} catch (Exception e) {
			System.out.print("ERROR");
		}

		audioClip.start(); // playing sound file
	}

}
