import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.sound.sampled.*;

/**
 * This program will have buttons that make sounds.
 * @author Julianna Nichols
 */
public class ButtonBox extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1;
	AudioInputStream audioSound;
	private JPanel buttonPanel; //buttons that will make sounds
	private JPanel startStop; //start and stop buttons
	private JLabel label;
	Boolean stop = false;
	DataLine.Info info;
	AudioFormat format;
	Clip clip = null;
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
         * - Making button for [drum roll] sound
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
		
		button = new JButton( "Start" );
		button.setActionCommand("Seven");
		button.addActionListener( this );
		startStop.add(button);
		
		button = new JButton( "Stop" );
		button.setActionCommand("Eight");
		button.addActionListener( this );
		startStop.add(button);
		
		add(label, BorderLayout.NORTH);
		add(buttonPanel, BorderLayout.CENTER);
		add(startStop, BorderLayout.SOUTH);
		
		setSize(getPreferredSize());
		pack();
		setVisible(true);
	}

	/**
	 * This is the main method for the ButtonBox program.
	 * @param args
	 */
	public static void main(String[] args) {
		new ButtonBox();
	}
	
	public void actionPerformed( ActionEvent e ) {
		JButton button = (JButton)e.getSource();
		switch( button.getActionCommand() ) {
		case "One":
			sound = new File("drum_roll2.wav");
			play(sound);
			break;
		case "Two":
			sound = new File("cymbals.wav");
			play(sound);
			break;
		case "Three":
			sound = new File("bicycle_bell.wav");
			play(sound);
			break;
		case "Four":
			sound = new File("cuckoo_clock1_x.wav");
			play(sound);
			break;
		case "Five":
			sound = new File("dolphin.wav");
			play(sound);
			break;
		case "Six":
			sound = new File("cow.wav");
			play(sound);
			break;
		case "Seven":
			audioClip.start();
			break;
		case "Eight":
			audioClip.stop();
			break;
		default:
			System.exit(0);
			break;
		}
	}
	
	/**
	 * Plays sound
	 * @param sound
	 */
	public void play( File sound ) {
		try {
			audioSound = AudioSystem.getAudioInputStream(sound);
		} catch (UnsupportedAudioFileException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		format = audioSound.getFormat();
		
		DataLine.Info info = new DataLine.Info(Clip.class, format);
		
		try {
			audioClip = (Clip) AudioSystem.getLine(info);
		} catch (LineUnavailableException e1) {
			e1.printStackTrace();
		}
		
		try {
			audioClip.open(audioSound);
		} catch (LineUnavailableException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		audioClip.start();
	}

}
