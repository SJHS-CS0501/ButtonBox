import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * 
 * This program plays different sounds!!
 * @author Isabelle Schroeder
 *
 */
public class ButtonBox extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1;
	private JPanel panel;
	private JPanel forButtons;
	//private JLabel label;
	
	public ButtonBox(){
		
		super( "ButtonBox" );
		
		JButton button;
		//JLabel labeler;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout( new BorderLayout() );
		
		panel = new JPanel();
		forButtons = new JPanel();
		
		forButtons.setLayout( new GridLayout( 2, 3) );
		button = new JButton( "One" );
		button.setActionCommand( "one" );
		button.addActionListener( this );
		forButtons.add( button );
		
		button = new JButton( "Two" );
		button.setActionCommand( "two" );
		button.addActionListener( this );
		forButtons.add( button );
		
		button = new JButton( "Three" );
		button.setActionCommand( "three" );
		button.addActionListener( this );
		forButtons.add( button );
		
		button = new JButton( "Four" );
		button.setActionCommand( "four" );
		button.addActionListener( this );
		forButtons.add( button );
		
		button = new JButton( "Five" );
		button.setActionCommand( "five" );
		button.addActionListener( this );
		forButtons.add( button );
		
		button = new JButton( "Six" );
		button.setActionCommand( "six" );
		button.addActionListener( this );
		forButtons.add( button );
		
		add( forButtons, BorderLayout.SOUTH );
		
		panel.setLayout( new FlowLayout() );
		
		add( panel, BorderLayout.CENTER );
			
		setSize( getPreferredSize() );
		pack();
		setVisible( true );
	}
	
	
	public void actionPerformed( ActionEvent e ){
		
	}
	
	
	public static void main(String[] args) {
		new ButtonBox();
	}

}
