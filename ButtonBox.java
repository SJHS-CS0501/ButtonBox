import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import sun.audio.*;

public class ButtonBox extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1;
	
	private AudioStream gastrodon;
	
	public ButtonBox() {
		super("Button Box");
		
		JButton button;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(6, 1));
		
		try {
			gastrodon = new AudioStream(new FileInputStream("423.wav"));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "One or more audio files are missing!");
			System.exit(0);
		}
		
		add(new JLabel("Press a button to play a sound!"));
		
		button = new JButton("Gastrodon");
		button.setActionCommand("gastrodon");
		button.addActionListener(this);
		add(button);
		
		setSize(getPreferredSize());
		pack();
		//setResizable(false);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton button  = (JButton)e.getSource();
		switch(button.getActionCommand()) {
			case "gastrodon":
				AudioPlayer.player.start(gastrodon);
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
