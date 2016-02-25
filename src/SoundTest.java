import java.awt.*;
import java.awt.event.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
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

		button = new JButton("Cat's Meow");
		button.setActionCommand("catMeow");
		button.addActionListener(this);
		buttonPanel.add(button);

		button = new JButton("Isabelle's Yell");
		button.setActionCommand("yell");
		button.addActionListener(this);
		buttonPanel.add(button);

		button = new JButton("Mr. Woytek's Boom");
		button.setActionCommand("boom");
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
			case "catMeow":
				try {
			        Clip clip = AudioSystem.getClip();
			        AudioInputStream inputStream = AudioSystem.getAudioInputStream(
			        SoundTest.class.getResourceAsStream());
			        clip.open(inputStream);
			        clip.start(); 
			      } catch (Exception e1) {
			        System.err.println(e1.getMessage());
			      }
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new SoundTest();

	}

}
