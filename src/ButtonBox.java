import java.awt.*;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.*;

/**
 * This program will have buttons that make sounds.
 * @author Julianna Nichols
 */
public class ButtonBox extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1;
	private JPanel buttonPanel;
	private JLabel label;
	private Clip clip;
	
	public ButtonBox() {
		super("Button Box");
		
		
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		buttonPanel = new JPanel();
		
		JButton button;
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		
		c.weightx = 0.0;
        c.gridwidth = GridBagConstraints.RELATIVE;
        
        label = new JLabel("Click a button to make a sound!");
		
		button = new JButton( "Sound One" );
		button.setActionCommand( "One" );
		button.addActionListener( this );
		buttonPanel.add(button);
		
		button = new JButton( "Sound Two" );
		button.setActionCommand( "Two" );
		button.addActionListener( this );
		buttonPanel.add(button);
		
		button = new JButton( "Sound Three" );
		button.setActionCommand( "Three" );
		button.addActionListener( this );
		buttonPanel.add(button);
		
		button = new JButton( "Sound Four" );
		button.setActionCommand( "Four" );
		button.addActionListener( this );
		buttonPanel.add(button);
		
		button = new JButton( "Sound Five" );
		button.setActionCommand( "Five" );
		button.addActionListener( this );
		buttonPanel.add(button);
		
		button = new JButton( "Sound Six" );
		button.setActionCommand( "Six" );
		button.addActionListener( this );
		buttonPanel.add(button);
		
		add(label, BorderLayout.NORTH);
		add(buttonPanel, BorderLayout.SOUTH);
		
		setSize(getPreferredSize());
		pack();
		setVisible(true);
	}

	/**
	 * This is the main method for the ButtonBox program.
	 * @param args
	 */
	public static void main(String[] args) {
		new ButtonBox();
	}
	
	public void actionPerformed( ActionEvent e ) {
		JButton button = (JButton)e.getSource();
		switch( button.getActionCommand() ) {
		case "One":
			clip.open(stream);
			break;
		case "Two":
			
			break;
		case "Three":
			
			break;
		case "Four":
			
			break;
		case "Five":
			
			break;
		case "Six":
			
			break;			
		default:
			
			break;
		}
	}

}
