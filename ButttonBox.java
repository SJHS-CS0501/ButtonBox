//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import java.awt.Color;
//import java.awt.Font;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class ButttonBox extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1;
	private GridBagLayout layout;
	private  GridBagConstraints c;
	private JLabel l;
	private JButton b;
	
	public ButttonBox(){
		
		super("Button Box Sounds");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		layout = new GridBagLayout();
		setLayout(layout);
		
		JTextField inputField;
		
		c = new GridBagConstraints();
	      // general constraints
	    c.fill = GridBagConstraints.BOTH;
	    
	    c.weightx = 0.0;
        c.gridwidth = GridBagConstraints.RELATIVE;
        
        c.gridx = 0;
        c.gridy = 1;
        l = new JLabel( "Please enter a number to convert" );
        layout.setConstraints( l, c );
        add(l );
        
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 0;
        inputField = new JTextField(30);
        layout.setConstraints( inputField, c );
        add( inputField );
        
        c.weightx = 0;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.gridx = 2;
        c.gridy = 0;
        l = new JLabel("m");
        layout.setConstraints( l, c );
        add( l );
	    
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new  ButttonBox();
	}

}
