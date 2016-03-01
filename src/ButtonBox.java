import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import javax.sound.sampled.*;

/**
 * This program will have buttons that make sounds.
 * @author Julianna Nichols
 */
public class ButtonBox extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1;
	private JPanel buttonPanel;
	private JLabel label;
	
	AudioInputStream audioSound;
	Clip clip = null;
	File sound;
	AudioFormat format;
	DataLine.Info info;
	Clip audioClip;
	
	public ButtonBox() {
		super("Button Box");
		
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		buttonPanel = new JPanel();
		
		JButton button;
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		
		c.weightx = 0.0;
        c.gridwidth = GridBagConstraints.RELATIVE;
        
        label = new JLabel("Click a button to make a sound!");
		
		button = new JButton( "Bicycle Bell" );
		button.setActionCommand( "One" );
		button.addActionListener( this );
		buttonPanel.add(button);
		
		button = new JButton( "Cuckoo Clock" );
		button.setActionCommand( "Two" );
		button.addActionListener( this );
		buttonPanel.add(button);
		
		button = new JButton( "Cymbals" );
		button.setActionCommand( "Three" );
		button.addActionListener( this );
		buttonPanel.add(button);
		
		button = new JButton( "Drum roll" );
		button.setActionCommand( "Four" );
		button.addActionListener( this );
		buttonPanel.add(button);
		
		button = new JButton( "Sound Five" );
		button.setActionCommand( "Five" );
		button.addActionListener( this );
		buttonPanel.add(button);
		
		button = new JButton( "Sound Six" );
		button.setActionCommand( "Six" );
		button.addActionListener( this );
		buttonPanel.add(button);
		
		add(label, BorderLayout.NORTH);
		add(buttonPanel, BorderLayout.SOUTH);
		
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
			sound = new File("bicycle_bell.wav");
			
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
			break;
		case "Two":
			sound = new File("cuckoo_clock1_x.wav");
			
			try {
				audioSound = AudioSystem.getAudioInputStream(sound);
			} catch (UnsupportedAudioFileException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			format = audioSound.getFormat();
			
			info = new DataLine.Info(Clip.class, format);
			
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
			break;
		case "Three":
			sound = new File("cymbals.wav");
			
			try {
				audioSound = AudioSystem.getAudioInputStream(sound);
			} catch (UnsupportedAudioFileException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			format = audioSound.getFormat();
			
			info = new DataLine.Info(Clip.class, format);
			
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
			break;
		case "Four":
			sound = new File("drum_roll2.wav");
			
			try {
				audioSound = AudioSystem.getAudioInputStream(sound);
			} catch (UnsupportedAudioFileException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			format = audioSound.getFormat();
			
			info = new DataLine.Info(Clip.class, format);
			
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
			break;
		case "Five":
			sound = new File("duck.wav");
			
			try {
				audioSound = AudioSystem.getAudioInputStream(sound);
			} catch (UnsupportedAudioFileException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			format = audioSound.getFormat();
			
			info = new DataLine.Info(Clip.class, format);
			
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
			break;
		case "Six":
			sound = new File("cow.wav");
			
			try {
				audioSound = AudioSystem.getAudioInputStream(sound);
			} catch (UnsupportedAudioFileException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			format = audioSound.getFormat();
			
			info = new DataLine.Info(Clip.class, format);
			
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
			break;			
		default:
			
			break;
		}
		
	}

}
