import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * This program will have buttons that make sounds.
 * @author Julianna Nichols
 */
public class ButtonBox extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1;
	private JPanel buttonPanel;
	
	public ButtonBox() {
		super("Button Box");
		
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		buttonPanel = new JPanel();
		
		JButton button;
		
		buttonPanel.setLayout(new GridLayout(1, 3));
		
		button = new JButton( "Sound One" );
		button.setActionCommand( "Sound One" );
		button.addActionListener( this );
		buttonPanel.add(button);
		
		button = new JButton( "Sound Two" );
		button.setActionCommand( "Sound Two" );
		button.addActionListener( this );
		buttonPanel.add(button);
		
		button = new JButton( "Sound Three" );
		button.setActionCommand( "Sound Three" );
		button.addActionListener( this );
		buttonPanel.add(button);
		
		button = new JButton( "Sound Four" );
		button.setActionCommand( "Sound Four" );
		button.addActionListener( this );
		buttonPanel.add(button);
		
		button = new JButton( "Sound Five" );
		button.setActionCommand( "Sound Five" );
		button.addActionListener( this );
		buttonPanel.add(button);
		
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
		
	}

}
