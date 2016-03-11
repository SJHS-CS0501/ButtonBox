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
 *         based on the click of a JButton. They also have the ability to record
 *         the different sounds in any order with the time between as well. They can
 *         then playback the recorded sounds. 
 */
public class SoundTest extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1;
	private JFrame frame;
	private JPanel recordPanel; JPanel playbackPanel; JPanel radioButtonPanel; JPanel buttonPanel;
	private JButton button; JButton recordButton;
	private JRadioButton radioButton;
	private ButtonGroup playbackGroup;
	private boolean toggle = false; boolean recording = false;
	private ArrayList<SoundRecording> recordedSounds = new ArrayList<SoundRecording>();
	private SoundRecording AN = new SoundRecording(); SoundRecording AN1 = new SoundRecording();
	private long waitTime = 0;

	/**
	 * Constructor to setup the JFrame and also to place the buttons into four
	 * different panels. One panel for the sound buttons, one for the
	 * radio buttons, another for recording options, and a final one for playback. 
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

		recordButton = new JButton("Record");
		recordButton.setActionCommand("record");
		recordButton.addActionListener(this);
		recordPanel.add(recordButton);

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
	 * for the radio buttons. The sounds are redirected to a handle method. 
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
			recordButton.setBackground(Color.RED);
			recordedSounds = new ArrayList<SoundRecording>();
			recording = true;
			break;

		case "stop":
			recordButton.setBackground(((JButton)e.getSource()).getBackground());
			recording = false;
			break;

		case "playback":
			playbackSounds();

		default:
			handle(e.getActionCommand());
		}
	}

        /**
         * This method is designed to playback the sounds recorded by the user. 
         */

	public void playbackSounds() {
		for (int i = 0; i < recordedSounds.size(); i++) {
			AN = recordedSounds.get(i);
			System.out.println(AN.sound);
			try {
				if(i < (recordedSounds.size() - 1)) {
					AN1 = recordedSounds.get(i + 1);
					Thread.sleep(AN1.delay - AN.delay);
				}
			} catch (Exception es) {
				System.out.println("Error: " + es.getMessage());
			}

		}
	}

        /**
         * This method will get information from the action listener
         * and play a sound based on the button click of the user. 
         */

	public void handle(String s) {
		switch (s) {
		case "chimpYell":
			chimpYell();
			if (recording) {
				AN = new SoundRecording();
				AN.sound = s;
				AN.delay = System.currentTimeMillis();
				recordedSounds.add(AN);
			}
			break;

		case "chimes":
			chimes();
			if (recording) {
				AN = new SoundRecording();
				AN.sound = s;
				AN.delay = System.currentTimeMillis();
				recordedSounds.add(AN);
			}
			break;

		case "ding":
			ding();
			if (recording) {
				AN = new SoundRecording();
				AN.sound = s;
				AN.delay = System.currentTimeMillis();
				recordedSounds.add(AN);
			}
			break;

		case "tada":
			tada();
			if (recording) {
				AN = new SoundRecording();
				AN.sound = s;
				AN.delay = System.currentTimeMillis();
				recordedSounds.add(AN);
			}
			break;

		case "ring":
			ring();
			if (recording) {
				AN = new SoundRecording();
				AN.sound = s;
				AN.delay = System.currentTimeMillis();
				recordedSounds.add(AN);
			}
			break;
		}
	}

       /**
        * Method for sound playback. 
        */

	public void chimpYell() {
		try {
			String sound = "Chimpanzee_sound_effect-412407.wav";
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(sound));
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
			while(toggle) {
				Thread.sleep(10);
				if(clip.isActive()) {
					toggle = true;
				} else {
					toggle = false;
				}
			}
		} catch (Exception es) {
			System.out.println("Problem with file: " + es.getMessage());
		}
	}

       /**
        * Method for sound playback. 
        */

	public void chimes() {
		try {
			String sound = "chimes.wav";
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(sound));
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
			if(toggle) {
				while(clip.isRunning()) {
					System.out.println("asdf");
					Thread.sleep(10);
				}
			}
			
		} catch (Exception es) {
			System.out.println("Problem with file: " + es.getMessage());
		}
	}

        /**
        * Method for sound playback. 
        */

	public void ding() {
		try {
			String sound = "ding.wav";
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(sound));
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
			while(toggle) {
				Thread.sleep(10);
				if(clip.isActive()) {
					toggle = true;
				} else {
					toggle = false;
				}
			}
		} catch (Exception es) {
			System.out.println("Problem with file: " + es.getMessage());
		}
	}

        /**
        * Method for sound playback. 
        */

	public void tada() {
		try {
			String sound = "tada.wav";
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(sound));
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
			while(toggle) {
				Thread.sleep(10);
				if(clip.isActive()) {
					toggle = true;
				} else {
					toggle = false;
				}
			}
		} catch (Exception es) {
			System.out.println("Problem with file: " + es.getMessage());
		}
	}

        /**
        * Method for sound playback. 
        */

	public void ring() {
		try {
			String sound = "Windows Ringin.wav";
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(sound));
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
			while(toggle) {
				Thread.sleep(10);
				if(clip.isActive()) {
					toggle = true;
				} else {
					toggle = false;
				}
			}
		} catch (Exception es) {
			System.out.println("Problem with file: " + es.getMessage());
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new SoundTest();

	}

}
