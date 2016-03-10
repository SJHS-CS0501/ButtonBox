//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import java.awt.Color;
//import java.awt.Font;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import sun.audio.AudioStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


/**
 * 
 * @author Ryley Danielson
 *This program creates a GUI Frame with buttons that allows you to
 * play sounds, record them, and start new ones
 */
public class ButttonBox extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1;
	private GridBagLayout layout;
	private  GridBagConstraints c;
	private JLabel l;
	private JButton b;
	private JPanel p;
	private Clip clip;// for playing audio clip
	private AudioInputStream audio;// helps to play audio
	private ArrayList <String> sl;// stores button Action Commands
	private ArrayList <Long> time;// stores time between each button press
	private long nanot;// nanoseconds
	static Color fail;
	private int assign;
	//private ActionListener listener = new MyListener();
	
	/**
	 * Extents frame and implements action listener for easier use of JFrame
	 */
	public ButttonBox(){
		
		super("Button Box Sounds");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		layout = new GridBagLayout();
		setLayout(layout);
		
		JTextField inputField;
		
		//sets constants
		c = new GridBagConstraints();
	      // general constraints
	    c.fill = GridBagConstraints.BOTH;
	    
	    c.weightx = 0.0;
        c.gridwidth = GridBagConstraints.RELATIVE;
        
        //first label
        c.gridx = 1;
        c.gridy = 0;
        l = new JLabel( "Sound Board" );
        layout.setConstraints( l, c );
        add(l );
        
        // not used up to this point
        p = new JPanel(new BorderLayout());
        
        //First sound
        c.weightx = 1;
       // c.gridwidth = GridBagConstraints.WEST;
        c.gridx = 0;
        c.gridy = 1;
        b = new JButton("First Ding");
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
        
        //Second Sound
        c.weightx = 1;
        //   c.gridwidth = GridBagConstraints.REMAINDER;
        c.gridx = 2;
        c.gridy = 1;
        b = new JButton("Annoying Sound");
        b.setActionCommand("two");
        b.addActionListener(this);
        layout.setConstraints( b, c );
        add( b );
           
        
        //Third Sound
        c.weightx = 1;
     //   c.gridwidth = GridBagConstraints.REMAINDER;
        c.gridx = 1;
        c.gridy = 2;
        b = new JButton("Piano");
        b.setActionCommand("three");
        b.addActionListener(this);
        layout.setConstraints( b, c );
        add( b );
        
        //Fourth Sound
        c.weightx = 1;
        //   c.gridwidth = GridBagConstraints.REMAINDER;
         c.gridx = 2;
         c.gridy = 2;
         b = new JButton("Chime");
         b.setActionCommand("four");
         b.addActionListener(this);
         layout.setConstraints( b, c );
         add( b );
           
         //Fifth Sound
         c.weightx = 1;
         //   c.gridwidth = GridBagConstraints.REMAINDER;
          c.gridx = 1;
          c.gridy = 3;
          b = new JButton("Soft Sound");
          b.setActionCommand("five");
          b.addActionListener(this);
          layout.setConstraints( b, c );
          add( b );
          
          //Sixth Sound
          c.weightx = 1;
          //   c.gridwidth = GridBagConstraints.REMAINDER;
          c.gridx = 2;
          c.gridy = 3;
          b = new JButton("Pointless Button");
          b.setActionCommand("six");
          b.addActionListener(this);
          layout.setConstraints( b, c );
          add( b );
          
        //Sixth Sound
          c.weightx = 1;
          //   c.gridwidth = GridBagConstraints.REMAINDER;
          c.gridx = 1;
          c.gridy = 4;
          b = new JButton("Fail Sound");
          b.setActionCommand("panic");
          b.addActionListener(this);
          layout.setConstraints( b, c ); 
          add( b );
          
          //Label used to separate buttons
          c.gridx = 1;
          c.gridy = 5;
          l = new JLabel("More Options");
          layout.setConstraints( l, c );
          add(l );
          
          //Playback Button
          c.weightx = 1;
          //   c.gridwidth = GridBagConstraints.REMAINDER;
          c.gridx = 1;
          c.gridy = 6;
          b = new JButton("Playback Sounds");
          b.setActionCommand("play");
          b.addActionListener(this);
         // p.add(b, BorderLayout.SOUTH);
          layout.setConstraints( b, c );
          add( b );
          
          //Important Second Half
          
          
          //new sound ArrayList button
          c.weightx = 1;
          //   c.gridwidth = GridBagConstraints.REMAINDER;
          c.gridx = 2;
          c.gridy = 6;
          b = new JButton("New Sound String");
          b.setActionCommand("newSound");
          b.addActionListener(this);
         // p.add(b, BorderLayout.SOUTH);
          layout.setConstraints( b, c );
          add( b );
          
          c.gridx = 1;
          c.gridy = 7;
          l = new JLabel( "Save/Load Sound" );
          layout.setConstraints( l, c );
          add(l );
          
          c.weightx = 1;
          //   c.gridwidth = GridBagConstraints.REMAINDER;
          c.gridx = 1;
          c.gridy = 6;
          b = new JButton("Playback Sounds");
          b.setActionCommand("play");
          b.addActionListener(this);
         // p.add(b, BorderLayout.SOUTH);
          layout.setConstraints( b, c );
          add( b );
          
          c.weightx = 1;
          //   c.gridwidth = GridBagConstraints.REMAINDER;
          c.gridx = 1;
          c.gridy = 8;
          b = new JButton("Save Sounds to File (Chose a name)");
          b.setActionCommand("save");
          b.addActionListener(this);
         // p.add(b, BorderLayout.SOUTH);
          layout.setConstraints( b, c );
          add( b );
          
          c.weightx = 1;
          //   c.gridwidth = GridBagConstraints.REMAINDER;
          c.gridx = 2;
          c.gridy = 8;
          b = new JButton("Load Sounds from File (Input the Name)");
          b.setActionCommand("load");
          b.addActionListener(this);
         // p.add(b, BorderLayout.SOUTH);
          layout.setConstraints( b, c );
          add( b );
          
          c.weightx = 1;
          //   c.gridwidth = GridBagConstraints.REMAINDER;
          c.gridx = 1;
          c.gridy = 9;
          c.gridwidth = GridBagConstraints.RELATIVE;
          inputField = new JTextField( b.getText(), 40 );
          layout.setConstraints(inputField, c);
          this.add( inputField );
          
          c.weightx = 1;
          //   c.gridwidth = GridBagConstraints.REMAINDER;
          c.gridx = 2;
          c.gridy = 9;
          c.gridwidth = GridBagConstraints.RELATIVE;
          inputField = new JTextField( b.getText(), 40 );
          layout.setConstraints(inputField, c);
          this.add( inputField );
             
             
             
          //instantiates command and time arrays
              sl = new ArrayList <String>();
              time = new ArrayList <Long>();
        
        setSize( getPreferredSize());
		pack();
		setVisible(true);
	}
	
	
	/**
	 * Action listener listens for actions and determines what to do based on each 
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		JButton button = (JButton)e.getSource();

		//saves to command and time arraylists
		
		if(!e.getActionCommand().equals("play") 
				&&!e.getActionCommand().equals("save")
				&&!e.getActionCommand().equals("load")){
			
		sl.add(e.getActionCommand());
		
		time.add(System.nanoTime());
		}
		
		//playSound(assign(e.getActionCommand()));
	 	
	 //determines what to do based on each command
	switch( button.getActionCommand()){
	
		case ("one"):
		
			File ding = new File("ding.wav");
		
			playSound(ding);
		
			//sl.add(button.getActionCommand());
			
			break;
		
			
		case ("two"):
			
			ding = new File("chord.wav");
		
			playSound(ding);
			
			
			break;
		
			
		case ("three"):
			
			ding = new File("chimes.wav");
		
			playSound(ding);
	
			//sl.add(button.getAction());
			
			break;
			
			
		case ("four"):
			
			ding = new File("WindowsNotify.wav");
		
			playSound(ding);
			
			//sl.add(button.getAction());
			
			break;
			
		
		case ("five"):
			
			ding = new File("WindowsRestore.wav");
		
			playSound(ding);
			
			//sl.add(button.getAction());
			
			break;
			
		
		case ("six"):
			
			ding = new File("WindowsStartup.wav");
		
			playSound(ding);
			
			//sl.add(button.getActionCommand());
			
			break;
			
		case ("panic"):
			
			ding = new File("ir_end.wav");
		
			playSound(ding);
			
			//sl.add(button.getActionCommand());
			
			break;
			
		case ("play"):
			
		playBack();
		
			
			
			break;
			
		case ("newSound"):
			
			sl = new ArrayList <String>();
        	time = new ArrayList <Long>();
		
        	break;
        	
		case ("save"):
			
			
			
			break;
		
		case ("load"):
			
			break;
			
		default:
			
			fail = Color.RED;
			
			ding = new File("ir_end.wav");
			
			l.setText("Button Error");
			l.setForeground(fail);
			
			playSound(ding);
			
			b.setEnabled(false);
			
			break;
			
		
		}
	        
		
	}
	
	/**
	 * Plays the chosen sound from file
	 * @param File ding
	 */
	public void playSound(File ding){
		
		try {
			audio = AudioSystem.getAudioInputStream(ding);
		} catch (UnsupportedAudioFileException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("y");
		} catch(NullPointerException e2){
			System.out.println("Something is null line 287");
		}
		//http://www.codejava.net/coding/how-to-play-back-audio-in-java-with-examples
		
		//AudioFormat format = new AudioFormat(getOpacity(), getDefaultCloseOperation(), getDefaultCloseOperation(), rootPaneCheckingEnabled, rootPaneCheckingEnabled);
		 
		AudioFormat format = audio.getFormat();
		
		DataLine.Info info = new DataLine.Info(Clip.class, format);
		
		try {
			clip = (Clip) AudioSystem.getLine(info);
		} catch (LineUnavailableException e1) {
			// TODO Auto-generated catch block
			System.out.println("why");
		}
		
		try {
			clip.open(audio);
		} catch (LineUnavailableException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		clip.start();
		
		
	}
	
	/**
	 * Plays back an Arraylist of sounds and the times between them
	 * based on the user's button clicks
	 */
	public void playBack() {
		
		for(int i = 0; i< sl.size(); i++){
			
			sl.get(i);
			time.get(i);
			
			//compares times for elements in the arraylist
			try{
			nanot = (time.get(i + 1)- time.get(i));
			}catch(Exception e){
				System.out.println("Its ok");
			}
			
			if(nanot > 1500000000){
				nanot = 10000000;
			}
			System.out.println(nanot);
			playSound(assign(sl.get(i)));
			
			//pauses program for given time
			try {
				Thread.sleep(nanot/1000000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
	}
	
	/**
	 * assigns file names to each action command for playback
	 * @param i
	 * @return File
	 */
	public File assign(String i){
		
		File ding;
		
		System.out.println(i);
		
		switch(i){
		

		case ("one"):
		
			 ding = new File("ding.wav");
		
			return ding;
		
			
		case ("two"):
			
			ding = new File("chord.wav");
			
			return ding;
			
		case ("three"):
			
			ding = new File("chimes.wav");
			
			return ding;
			
			
		case ("four"):
			
			ding = new File("WindowsNotify.wav");
			
			return ding;
			
		
		case ("five"):
			
			ding = new File("WindowsRestore.wav");
			
			return ding;
			
		
		case ("six"):
			
			ding = new File("WindowsStartup.wav");
			
			return ding;
		
		case ("panic"):
			
			ding = new File("ir_end.wav");
		
			return ding;
			
		}
		
		return null;
		
	}
	
	/**
	 * Main creates a new ButtonBox JFrame
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new  ButttonBox();
	}

}
