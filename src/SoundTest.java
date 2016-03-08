import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

import java.io.*;
import java.util.*;

/**
 * @author Jack Protivnak
 * 
 *         This program is designed to allow the user to play different sounds
 *         based on the click of a JButton.
 */
public class SoundTest extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1;
	private JFrame frame;
	private JPanel recordPanel;
	JPanel playbackPanel;
	JPanel radioButtonPanel;
	JPanel buttonPanel;
	private JButton button;
	private JRadioButton radioButton;
	private ButtonGroup playbackGroup;
	private boolean toggle = false;
	boolean recording = false;
	private ArrayList<SoundRecording> recordedSounds = new ArrayList<SoundRecording>();
	private SoundRecording AN = new SoundRecording();
	SoundRecording AN1 = new SoundRecording();

	/**
	 * Constructor to setup the JFrame and also to place the buttons into two
	 * different panels. One panel for the sound buttons and the other for the
	 * radio buttons.
	 */
	public SoundTest() {
		super("SoundTest");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

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

		buttonPanel.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED), "Sounds"));

		add(buttonPanel);

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

		add(radioButtonPanel);

		recordPanel = new JPanel();
		recordPanel.setLayout(new GridLayout(1, 2));

		button = new JButton("Record");
		button.setActionCommand("record");
		button.addActionListener(this);
		recordPanel.add(button);

		button = new JButton("Stop");
		button.setActionCommand("stop");
		button.addActionListener(this);
		recordPanel.add(button);

		recordPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED),
				"Recording Options"));

		add(recordPanel);

		playbackPanel = new JPanel();
		playbackPanel.setLayout(new GridLayout(1, 2));

		button = new JButton("Play");
		button.setActionCommand("playback");
		button.addActionListener(this);
		playbackPanel.add(button);

		playbackPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED),
				"Playback Options"));

		add(playbackPanel);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 3 - this.getSize().width / 2, dim.height / 3 - this.getSize().height / 2);
		setResizable(false);
		setSize(getPreferredSize());
		pack();
		setVisible(true);
	}

	/**
	 * ActionListener to catch the actions performed by button click as well as
	 * for the radio buttons.
	 */
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "gap":
			toggle = true;
			break;

		case "gapless":
			toggle = false;
			break;

		case "record":
			recording = true;
			break;

		case "stop":
			recording = false;
			break;

		case "playback":
			playbackSounds();

		default:
			handle(e.getActionCommand());
		}
	}

	public void playbackSounds() {
		for (int i = 0; i < recordedSounds.size(); i++) {
			AN = recordedSounds.get(i);
			AN1 = recordedSounds.get(i);
			handle(AN.sound);
			System.out.println(AN.sound);
			try {
				Thread.sleep((AN1.delay - AN.delay));
			} catch (Exception es) {
				System.out.println("DUH DUH DUHHHHHHHH");
			}

		}
	}


	public void handle(String s) {
		switch (s) {
		case "chimpYell":
			chimpYell();
			if (recording) {
				AN.sound = s;
				AN.delay = System.currentTimeMillis();
				recordedSounds.add(AN);
			}
			break;

		case "chimes":
			chimes();
			if (recording) {
				AN.sound = s;
				AN.delay = System.currentTimeMillis();
				recordedSounds.add(AN);
			}
			break;

		case "ding":
			ding();
			if (recording) {
				AN.sound = s;
				AN.delay = System.currentTimeMillis();
				recordedSounds.add(AN);
			}
			break;

		case "tada":
			tada();
			if (recording) {
				AN.sound = s;
				AN.delay = System.currentTimeMillis();
				recordedSounds.add(AN);
			}
			break;

		case "ring":
			ring();
			if (recording) {
				AN.sound = s;
				AN.delay = System.currentTimeMillis();
				recordedSounds.add(AN);
			}
			break;
		}
	}

	public void chimpYell() {
		try {
			String sound = "Chimpanzee_sound_effect-412407.wav";
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(sound));
		Clip chimpClip = AudioSystem.getClip();
		chimpClip.open(audioInputStream);
		chimpClip.start();
		} catch (Exception es) {
			System.out.println("Problem with file: " + es.getMessage());
		}
	}

	public void chimes() {
		try {
			String sound = "chimes.wav";
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(sound));
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (Exception es) {
			System.out.println("Problem with file: " + es.getMessage());
		}
	}

	public void ding() {
		try {
			String sound = "ding.wav";
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(sound));
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (Exception es) {
			System.out.println("Problem with file: " + es.getMessage());
		}
	}

	public void tada() {
		try {
			String sound = "tada.wav";
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(sound));
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (Exception es) {
			System.out.println("Problem with file: " + es.getMessage());
		}
	}

	public void ring() {
		try {
			String sound = "Windows Ringin.wav";
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(sound));
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (Exception es) {
			System.out.println("Problem with file: " + es.getMessage());
		}
	}

	public void record(ActionEvent e) {
		handle(e.getActionCommand());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new SoundTest();

	}

}
