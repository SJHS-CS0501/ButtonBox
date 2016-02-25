import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.sound.sampled.*;

public class ButtonBox extends JFrame implements ActionListener/*, Runnable*/ {

	private static final long serialVersionUID = 1;
	
	Clip clip;
	private File gastrodon;
	
	public ButtonBox() {
		super("Button Box");
		
		JButton button;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(6, 1));
		
		gastrodon = new File("423.wav");
		
		add(new JLabel("Press a button to play a sound!"));
		
		button = new JButton("Gastrodon");
		button.setActionCommand("gastrodon");
		button.addActionListener(this);
		add(button);
		
		setSize(getPreferredSize());
		pack();
		setResizable(false);
		setVisible(true);
	}
	
//	public static synchronized void playSound(final String url) {
//		try {
//    	  Clip clip = AudioSystem.getClip();
//    	  AudioInputStream inputStream = 
//        clip.open(inputStream);
//        clip.start(); 
//      } catch (Exception e) {
//        System.err.println(e.getMessage());
//      }
//    }
	
	public void playSound(File sound) {
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(sound));
			clip.start();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "The sound clip could not be played.");
			e.printStackTrace();
		}
	}
		
	
	public void actionPerformed(ActionEvent e) {
		JButton button  = (JButton)e.getSource();
		switch(button.getActionCommand()) {
			case "gastrodon":
				playSound(gastrodon);
				break;
			default:
				JOptionPane.showMessageDialog(this, "Unknown button pressed!");
				break;
		}
	}
	
	public static void main(String[] args) {
		new ButtonBox();
	}
}
