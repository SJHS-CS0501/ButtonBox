import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
import java.net.*;

/**
 * 
 */

/**
 * @author Ryan Smith
 *
 */
public class ButtonBox extends JFrame implements ActionListener{
	
	//declaring JLabels, JPanels and GridLayout
	private static final long serialVersionUID = 1;
	static JLabel myLabel;
	private JPanel mainPanel;
	private JPanel buttonPanel;
	static JButton quitButton;
	static GridLayout layout;
	
	/**
	 * Constructor
	 */
	public ButtonBox() {
		super("Button Box");//Called because this class extends another class
		JButton button;
		JLabel label;
		myLabel = new JLabel("Press a button to play a sound");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		//instantiating JPanels mainPanel and buttonPanel
		mainPanel = new JPanel();
		buttonPanel = new JPanel();
		
		buttonPanel.setLayout(new GridLayout(1, 3)); //setting the layout to 1 x 3
		
		//instantiating JButttons, setting the action commands, adding the listener, and adding the JButton to the JPanel
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
		
		add(buttonPanel, BorderLayout.SOUTH);
		
		label = new JLabel("Press a button to play a sound: ");
		mainPanel.add(label);
		
		myLabel = new JLabel();
		mainPanel.add(myLabel);
		
		add(mainPanel, BorderLayout.CENTER);
		
		setSize(getPreferredSize());
		pack();
		setVisible(true);
	}
	
	/**
	 * This method is the listener that plays the sound when the JButton is pressed.
	 */
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		switch(button.getActionCommand()) {
		case "one":
			myLabel.setText("Playing sound 1...");
			break;
		case "two":
			myLabel.setText("Playing sound 2...");
			break;
		case "three":
			myLabel.setText("Playing sound 3...");
			break;
		case "four":
			myLabel.setText("Playing sound 4...");
			break;
		case "five":
			myLabel.setText("Playing sound 5...");
			break;
		default:
			JOptionPane.showMessageDialog(this, "Unknown button pressed");//Will never happen.
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ButtonBox();

	}

}
