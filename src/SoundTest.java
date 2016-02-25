import java.awt.*;
import java.awt.event.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.*;

/**
 * @author SJHSStudent
 *
 */
public class SoundTest extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1;
	private JFrame frame;
	private JPanel buttonPanel;
	private JButton button;

	public SoundTest() {
		super("SoundTest");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(2, 3));

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

		button = new JButton("Damn Daniel");
		button.setActionCommand("daniel");
		button.addActionListener(this);
		buttonPanel.add(button);

		button = new JButton("What are those????");
		button.setActionCommand("whatAreThose");
		button.addActionListener(this);
		buttonPanel.add(button);

		button = new JButton("*Facsimile Noise*");
		button.setActionCommand("facsimile");
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

	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		switch (button.getActionCommand()) {
		case "chimpYell":
			try{
				String soundName = "C:/Users/SJHSStudent/Documents/jpro24_ GitHub/ButtonBox/Chimpanzee_sound_effect-412407.wav";
				AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
				Clip clip = AudioSystem.getClip();
				clip.open(audioInputStream);
				clip.start();
			} catch(Exception es) {
				System.out.println("Problem with file: " + es.getMessage());
			}
			break;
			
		case "chimes":
			try{
				String soundName = "C:/Users/SJHSStudent/Documents/jpro24_ GitHub/ButtonBox/chimes.wav";
				AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
				Clip clip = AudioSystem.getClip();
				clip.open(audioInputStream);
				clip.start();
			} catch(Exception es) {
				System.out.println("Problem with file: " + es.getMessage());
			}
			break;
			
		case "ding":
			try{
				String soundName = "C:/Users/SJHSStudent/Documents/jpro24_ GitHub/ButtonBox/ding.wav";
				AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
				Clip clip = AudioSystem.getClip();
				clip.open(audioInputStream);
				clip.start();
			} catch(Exception es) {
				System.out.println("Problem with file: " + es.getMessage());
			}
			break;
			
		case "daniel":
			try{
				String soundName = "C:/Users/SJHSStudent/Documents/jpro24_ GitHub/ButtonBox/Chimpanzee_sound_effect-412407.wav";
				AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
				Clip clip = AudioSystem.getClip();
				clip.open(audioInputStream);
				clip.start();
			} catch(Exception es) {
				System.out.println("Problem with file: " + es.getMessage());
			}
			break;
			
		case "whatAreThose":
			try{
				String soundName = "C:/Users/SJHSStudent/Documents/jpro24_ GitHub/ButtonBox/Chimpanzee_sound_effect-412407.wav";
				AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
				Clip clip = AudioSystem.getClip();
				clip.open(audioInputStream);
				clip.start();
			} catch(Exception es) {
				System.out.println("Problem with file: " + es.getMessage());
			}
			break;
			
		case "facsimile":
			try{
				String soundName = "C:/Users/SJHSStudent/Documents/jpro24_ GitHub/ButtonBox/Chimpanzee_sound_effect-412407.wav";
				AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
				Clip clip = AudioSystem.getClip();
				clip.open(audioInputStream);
				clip.start();
			} catch(Exception es) {
				System.out.println("Problem with file: " + es.getMessage());
			}
			break;
			//https://www.youtube.com/watch?v=PnI-byHtMN0
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new SoundTest();

	}

}
