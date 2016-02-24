import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * 
 */

/**
 * @author SJHSStudent
 *
 */
public class ButtonBox extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1;
	static JLabel myLabel;
	private JPanel mainPanel;
	private JPanel buttonPanel;
	static JButton playSound;
	static JButton quitButton;
	static GridBagLayout layout;
	
	public ButtonBox() {
		super("Button Box");
		JButton button;
		JLabel label;
		myLabel = new JLabel("Press a button to play a sound");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		mainPanel = new JPanel();
		buttonPanel = new JPanel();
		
		button = new JButton("Play sound 1");
		button.setActionCommand("one");
		button.addActionListener(this);
		buttonPanel.add(button);
		
		button = new JButton("Play sound 2");
		button.setActionCommand("two");
		button.addActionListener(this);
		buttonPanel.add(button);
		
		button = new JButton("Play sound 3");
		button.setActionCommand("three");
		button.addActionListener(this);
		buttonPanel.add(button);
		
		button = new JButton("Play sound 4");
		button.setActionCommand("four");
		button.addActionListener(this);
		buttonPanel.add(button);
		
		button = new JButton("Play sound 5");
		button.setActionCommand("five");
		button.addActionListener(this);
		buttonPanel.add(button);
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		switch(button.getActionCommand()) {
		case "one":
			myLabel.setText("Playing sound 1...");
			break;
		case "two":
			break;
		case "three":
			break;
		case "four":
			break;
		case "five":
			break;
		default:
			JOptionPane.showMessageDialog(this, "Unknown button pressed");
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ButtonBox();

	}

}
