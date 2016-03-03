/**
 * This program plays sounds when you press buttons in a box!
 * @author Ryan Luchs
 * 
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.sound.sampled.*;

/**
 * ButtonBox main class
 * @author Ryan Luchs
 * 
 */
public class ButtonBox extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1;
	
	private boolean recording = false;
	private long startTime = 0L;
	
	private File[] sounds = new File[7];
	private JButton recButton;
	private JTextField filenameField;
	private String openFile;
	
	private SoundSequence recorder;
	
	/**
	 * ButtonBox constructor
	 */
	public ButtonBox() {
		super("Button Box");
		
		JButton button;
		JPanel panel;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(10, 1));
		
		// load sound files
		sounds[0] = new File("clips/423.wav");
		sounds[1] = new File("clips/Waluigi1.wav");
		sounds[2] = new File("clips/Waluigi5.wav");
		sounds[3] = new File("clips/041.wav");
		sounds[4] = new File("clips/478.wav");
		sounds[5] = new File("clips/PandaRed_Adult_WhistleA.wav");
		sounds[6] = new File("clips/PandaRed_Young_WhistleA.wav");
		
		// create the sound sequence object
		try {
			recorder = new SoundSequence("test.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		
		// make sound button panel
		//panel = new JPanel(new GridLayout(8, 1));
		
		add(new JLabel("Press a button to play a sound!"));
		
		// create buttons
		button = new JButton("Gastrodon");
		button.setActionCommand("0");
		button.addActionListener(this);
		add(button);
		
		button = new JButton("\"Wa\"");
		button.setActionCommand("1");
		button.addActionListener(this);
		add(button);
		
		button = new JButton("\"Move!\"");
		button.setActionCommand("2");
		button.addActionListener(this);
		add(button);
		
		button = new JButton("Zubat");
		button.setActionCommand("3");
		button.addActionListener(this);
		add(button);
		
		button = new JButton("Froslass");
		button.setActionCommand("4");
		button.addActionListener(this);
		add(button);
		
		button = new JButton("Red Panda");
		button.setActionCommand("5");
		button.addActionListener(this);
		add(button);
		
		button = new JButton("Baby Red Panda");
		button.setActionCommand("6");
		button.addActionListener(this);
		add(button);
		
		//add(panel, BorderLayout.CENTER);
		
		// make record/play panel
		panel = new JPanel(new GridLayout(1, 2));
		
		button = new JButton("Play");
		button.setActionCommand("play");
		button.addActionListener(this);
		panel.add(button, BorderLayout.CENTER);
		
		recButton = new JButton("Record");
		recButton.setActionCommand("record");
		recButton.setBackground(Color.GREEN);
		recButton.addActionListener(this);
		panel.add(recButton, BorderLayout.CENTER);
		
		add(panel);
		
		filenameField = new JTextField("text.txt", 10);
		openFile = filenameField.getText();
		add(filenameField);
		
//		label = new JLabel("*I do not own any of these sounds, they are the property of their respective owners*");
//		label.setFont(new Font("TimesRoman", Font.BOLD, 6));
//		add(label);
		
		setSize(getPreferredSize());
		pack();
		setResizable(false);
		setVisible(true);
	}
	
	/**
	 * Plays a sound clip
	 * @param sound a File object of .wav file
	 */
	public void playSound(File sound) {
		try {
			// try to play sound
			AudioInputStream soundIn = AudioSystem.getAudioInputStream(sound);
			AudioFormat format = soundIn.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, format);

			Clip clip = (Clip)AudioSystem.getLine(info);
			clip.open(soundIn);
			clip.start();
		} catch (Exception e) {
			// if failed, say so in a window and print error message
			JOptionPane.showMessageDialog(this, "The sound clip could not be played.");
			e.printStackTrace();
		}
	}
	
	/**
	 * Records button presses
	 * @param b the ActionCommand string from the button pressed, this should be an integer number
	 */
	public void recordButtonPress(String b) {
		recorder.add(Integer.parseInt(b), ((System.nanoTime() - startTime) / 1000000L));
		startTime = System.nanoTime();
	}
		
	/**
	 * Reacts to ActionEvents
	 */
	public void actionPerformed(ActionEvent e) {
		JButton button  = (JButton)e.getSource();
		String b;
		switch(b = button.getActionCommand()) {
			case "0":
				playSound(sounds[0]);
				if(recording) recordButtonPress(b);
				break;
			case "1":
				playSound(sounds[1]);
				if(recording) recordButtonPress(b);
				break;
			case "2":
				playSound(sounds[2]);
				if(recording) recordButtonPress(b);
				break;
			case "3":
				playSound(sounds[3]);
				if(recording) recordButtonPress(b);
				break;
			case "4":
				playSound(sounds[4]);	
				if(recording) recordButtonPress(b);
				break;
			case "5":
				playSound(sounds[5]);
				if(recording) recordButtonPress(b);
				break;
			case "6":
				playSound(sounds[6]);
				if(recording) recordButtonPress(b);
				break;
			case "play":
				if(!filenameField.getText().equals(openFile)) {
					try {
						SoundSequence s = new SoundSequence(filenameField.getText());
						System.out.println(s.toString());
						s.start();
					} catch (FileNotFoundException e2) {
						JOptionPane.showMessageDialog(this, "File not found!");
						e2.printStackTrace();
					}
				} else {
					SoundSequence s = recorder.clone();
					System.out.println(s.toString());
					s.start();
				}
				break;
			case "record":
				recButton.setText("Stop");
				recButton.setActionCommand("stop");
				recButton.setBackground(Color.RED);
				recording = true;
				
				recorder = new SoundSequence(sounds);
				startTime = System.nanoTime();
				break;
			case "stop":
				recButton.setText("Record");
				recButton.setBackground(Color.GREEN);
				recButton.setActionCommand("record");
				recording = false;
				
				if(filenameField.getText().equals("") || filenameField.getText().contains("\\") || filenameField.getText().contains("/")) {
					JOptionPane.showMessageDialog(this, "Filename contains invalid characters!");
				} else {
					try {
						recorder.writeFile(filenameField.getText());
						openFile = filenameField.getText();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
				}
				break;
			default:
				JOptionPane.showMessageDialog(this, "Unknown button pressed!");
				break;
		}
	}
	
	/**
	 * ButtonBox main method
	 * @param args
	 */
	public static void main(String[] args) {
		new ButtonBox();
	}
}
