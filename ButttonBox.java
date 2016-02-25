//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import java.awt.Color;
//import java.awt.Font;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;



public class ButttonBox extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1;
	private GridBagLayout layout;
	private  GridBagConstraints c;
	private JLabel l;
	private JButton b;
	private JPanel p;
	private Clip clip;
	private AudioSystem audio;
	
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
        
        c.gridx = 1;
        c.gridy = 0;
        l = new JLabel( "Sound Board" );
        layout.setConstraints( l, c );
        add(l );
        
        p = new JPanel(new GridLayout(1,2));
        
        c.weightx = 1;
       // c.gridwidth = GridBagConstraints.WEST;
        c.gridx = 0;
        c.gridy = 1;
        b = new JButton("First Sound");
        b.setActionCommand("one");
        b.addActionListener(this);
       // p.add(b);
        layout.setConstraints( b, c );
        add( b );
        
        /*
        c.weightx = 1;
        //c.gridwidth = GridBagConstraints.REMAINDER;
        c.gridx = 1;
        c.gridy = 1;
        b = new JButton("Second Sound");
        b.setActionCommand("two");
        b.addActionListener(this);
       // p.add(b);
        layout.setConstraints( b, c );
        add( b );
	   */
        
        c.weightx = 1;
        //   c.gridwidth = GridBagConstraints.REMAINDER;
           c.gridx = 2;
           c.gridy = 1;
           b = new JButton("Second Sound");
           b.setActionCommand("two");
           b.addActionListener(this);
           layout.setConstraints( b, c );
           add( b );
           
        
        
        c.weightx = 1;
     //   c.gridwidth = GridBagConstraints.REMAINDER;
        c.gridx = 2;
        c.gridy = 1;
        b = new JButton("Third Sound");
        b.setActionCommand("three");
        b.addActionListener(this);
        layout.setConstraints( b, c );
        add( b );
        
        
        setSize( getPreferredSize());
		pack();
		setVisible(true);
	}
	
	

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
JButton button = (JButton)e.getSource();
		
	switch( button.getActionCommand()){
		
	
		case ("one"):
			
			audio = new AudioSystem(getResourceAsStream("chord.wav"));
			clip = audio.getClip();
		
			clip.start();
	
			
		
			
		break;
		
		case ("two"):
			
			
		break;
		
		case ("three"):
	
			
		break;
		
		default:
			
			break;
			
		
		}
	        
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new  ButttonBox();
	}

}
