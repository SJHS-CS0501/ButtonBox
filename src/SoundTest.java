import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

import java.io.*;

/**
 * @author Jack Protivnak
 * 
 * This program is designed to allow the user to play different sounds
 * based on the click of a JButton.
 */
public class SoundTest extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1;
	private JFrame frame;
	private JPanel buttonPanel;
	private JPanel radioButtonPanel;
	private JPanel recordPanel;
	private JButton button;
	private JRadioButton radioButton;
	private ButtonGroup playbackGroup;
	private boolean toggle = false;

	/**
	 * Constructor to setup the JFrame and also to place the buttons
	 * into two different panels. One panel for the sound buttons and
	 * the other for the radio buttons.
	 */
	public SoundTest() {
		super("SoundTest");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(5, 1));

		button = new JButton("Chimp Yell");
		button.setActionCommand("chimpYell");
		button.addActionListener(this);
		buttonPanel.add(button);

		button = new JButton("Chimes");
		button.setActionCommand("chimes");
		button.addActionListener(this);
		buttonPanel.add(button);

		button = new JButton("Ding");
		button.setActionCommand("ding");
		button.addActionListener(this);
		buttonPanel.add(button);

		button = new JButton("Tada");
		button.setActionCommand("tada");
		button.addActionListener(this);
		buttonPanel.add(button);

		button = new JButton("Ring");
		button.setActionCommand("ring");
		button.addActionListener(this);
		buttonPanel.add(button);
		
		buttonPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED), "Sounds"));

		add(buttonPanel, BorderLayout.NORTH);

		radioButtonPanel = new JPanel();
		radioButtonPanel.setLayout(new GridLayout(1, 2));

		radioButton = new JRadioButton("Play Sounds Without Gap");
		radioButton.setActionCommand("gapless");
		radioButton.addActionListener(this);
		radioButton.setSelected(true);
		radioButtonPanel.add(radioButton);

		playbackGroup = new ButtonGroup();
		playbackGroup.add(radioButton);

		radioButton = new JRadioButton("Play Sounds With Gap");
		radioButton.setActionCommand("gap");
		radioButton.addActionListener(this);
		radioButtonPanel.add(radioButton);

		playbackGroup.add(radioButton);

		add(radioButtonPanel, BorderLayout.CENTER);
		
		recordPanel = new JPanel();
		recordPanel.setLayout(new GridLayout(1,2));
		
		button = new JButton("Record");
		button.setActionCommand("record");
		button.addActionListener(this);
		recordPanel.add(button);
		
		button = new JButton("Stop");
		button.setActionCommand("stop");
		button.addActionListener(this);
		recordPanel.add(button);
		
		recordPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED), "Recording Options"));
		
		add(recordPanel, BorderLayout.SOUTH);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 3 - this.getSize().width / 2, dim.height / 3 - this.getSize().height / 2);
		setResizable(false);
		setSize(getPreferredSize());
		pack();
		setVisible(true);
	}

	/**
	 * ActionListener to catch the actions performed by button click
	 * as well as for the radio buttons.
	 */
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
			case "chimpYell":
				try {
					String sound = "Chimpanzee_sound_effect-412407.wav";
					AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(sound));
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
					while(toggle) {
						Thread.sleep(10);
						if(clip.isRunning()) {
							toggle = true;
						} else {
							toggle = false;
						}
					}
				} catch (Exception es) {
					System.out.println("Problem with file: " + es.getMessage());
				}
				break;

			case "chimes":
				try {
					String sound = "chimes.wav";
					AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(sound));
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
					while(toggle) {
						Thread.sleep(10);
						if(clip.isRunning()) {
							toggle = true;
						} else {
							toggle = false;
						}
					}
				} catch (Exception es) {
					System.out.println("Problem with file: " + es.getMessage());
				}
				break;

			case "ding":
				try {
					String sound = "ding.wav";
					AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(sound));
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
					while(toggle) {
						Thread.sleep(10);
						if(clip.isRunning()) {
							toggle = true;
						} else {
							toggle = false;
						}
					}
				} catch (Exception es) {
					System.out.println("Problem with file: " + es.getMessage());
				}
				break;

			case "tada":
				try {
					String sound = "tada.wav";
					AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(sound));
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
					while(toggle) {
						Thread.sleep(10);
						if(clip.isRunning()) {
							toggle = true;
						} else {
							toggle = false;
						}
					}
				} catch (Exception es) {
					System.out.println("Problem with file: " + es.getMessage());
				}
				break;

			case "ring":
				try {
					String sound = "Windows Ringin.wav";
					AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(sound));
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
					while(toggle) {
						Thread.sleep(10);
						if(clip.isRunning()) {
							toggle = true;
						} else {
							toggle = false;
						}
					}
				} catch (Exception es) {
					System.out.println("Problem with file: " + es.getMessage());
				}
				break;
			
			case "gap":
				toggle = true;
				break;

			case "gapless":
				toggle = false;
				break;
			}
		}



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new SoundTest();

	}

}
