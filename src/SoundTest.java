import java.awt.*;
import java.awt.event.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
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
	private JButton button;

	
	/**
	 * Constructor to setup the JFrame and also to 
	 * place the buttons.
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

		add(buttonPanel, BorderLayout.CENTER);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 3 - this.getSize().width / 2, dim.height / 3 - this.getSize().height / 2);
		setResizable(false);
		setSize(getPreferredSize());
		pack();
		setVisible(true);
	}

	/**
	 * ActionListener to catch the actions performed by
	 * button click.
	 */
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		switch (button.getActionCommand()) {
		case "chimpYell":
			try{
				String sound = "Chimpanzee_sound_effect-412407.wav";
				AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(sound));
				Clip clip = AudioSystem.getClip();
				clip.open(audioInputStream);
				clip.start();
			} catch(Exception es) {
				System.out.println("Problem with file: " + es.getMessage());
			}
			break;
			
		case "chimes":
			try{
				String sound = "chimes.wav";
				AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(sound));
				Clip clip = AudioSystem.getClip();
				clip.open(audioInputStream);
				clip.start();
			} catch(Exception es) {
				System.out.println("Problem with file: " + es.getMessage());
			}
			break;
			
		case "ding":
			try{
				String sound = "ding.wav";
				AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(sound));
				Clip clip = AudioSystem.getClip();
				clip.open(audioInputStream);
				clip.start();
			} catch(Exception es) {
				System.out.println("Problem with file: " + es.getMessage());
			}
			break;
			
		case "tada":
			try{
				String sound = "tada.wav";
				AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(sound));
				Clip clip = AudioSystem.getClip();
				clip.open(audioInputStream);
				clip.start();
			} catch(Exception es) {
				System.out.println("Problem with file: " + es.getMessage());
			}
			break;
			
		case "ring":
			try{
				String sound = "Windows Ringin.wav";
				AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(sound));
				Clip clip = AudioSystem.getClip();
				clip.open(audioInputStream);
				clip.start();
			} catch(Exception es) {
				System.out.println("Problem with file: " + es.getMessage());
			}
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
