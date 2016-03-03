import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;   // needed to inherit java.io.InputStream
import javax.sound.sampled.*;


/**
 * 
 * This program plays different sounds!!
 * @author Isabelle Schroeder
 *
 */
public class ButtonBox extends JFrame implements ActionListener, LineListener{
	
	private static final long serialVersionUID = 1;
	private JPanel panel;
	private JPanel forButtons;
	//private JLabel label;
	private File sounds;
	boolean playCompleted;
	
	
	public ButtonBox(){
		
		super( "ButtonBox" );
		
		JButton button; // for all the buttons
		//JLabel labeler;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // program close when exited
		setLayout( new BorderLayout() );
		
		panel = new JPanel(); // adding panel to frame
		forButtons = new JPanel(); // adding another panel to frame
		
		forButtons.setLayout( new GridLayout( 2, 3) ); // laying out the buttons in a 2 row, 3 column set up
		
		button = new JButton( "Ominous" );
		button.setActionCommand( "one" );
		button.addActionListener( this );
		forButtons.add( button );
		
		button = new JButton( "Seal" );
		button.setActionCommand( "two" );
		button.addActionListener( this );
		forButtons.add( button );
		
		button = new JButton( "Sheep" );
		button.setActionCommand( "three" );
		button.addActionListener( this );
		forButtons.add( button );
		
		button = new JButton( "Thunder" );
		button.setActionCommand( "four" );
		button.addActionListener( this );
		forButtons.add( button );
		
		button = new JButton( "Monkey" );
		button.setActionCommand( "five" );
		button.addActionListener( this );
		forButtons.add( button );
		
		button = new JButton( "Duck" );
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
	
    
   /**
    * This does the actual playing part.
    * @param takes a file
    */
   void play( File sounds ) {
       
       try {
    	   AudioInputStream audioStream = AudioSystem.getAudioInputStream( sounds );

           AudioFormat format = audioStream.getFormat();

           DataLine.Info info = new DataLine.Info(Clip.class, format);

           Clip audioClip = (Clip) AudioSystem.getLine(info);

           audioClip.addLineListener(this);

           audioClip.open(audioStream);
            
           audioClip.start();
            
           while (!playCompleted) {
               // wait for the playback completes
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
               }
           }
            
            
       } catch (UnsupportedAudioFileException e) {
           System.out.println("The specified audio file is not supported.");
           e.printStackTrace();
       } catch (LineUnavailableException e) {
           System.out.println("Audio line for playing back is unavailable.");
           e.printStackTrace();
       } catch (IOException e) {
           System.out.println("Error playing the audio file.");
           e.printStackTrace();
       }
        
   }
    
   
   /**
    * Listens to the START and STOP events of the audio line.
    */
   @Override
   public void update(LineEvent event) {
       LineEvent.Type type = event.getType();
        
       if (type == LineEvent.Type.START) {
            
       } else if (type == LineEvent.Type.STOP) {
           playCompleted = true;
       }

   }
	
   /**
    * Tells the program which sound to play!
    */
	public void actionPerformed( ActionEvent e ){
		JButton button = (JButton)e.getSource();
		switch( button.getActionCommand() ){
			case "one":
				sounds = new File("ominous.wav");
				play( sounds );
				break;
			case "two":
				sounds = new File("seal.wav");
				play( sounds );
				break;
			case "three":
				sounds = new File("sheep521.wav");
				play( sounds );
				break;
			case "four":
				sounds = new File("thunder-02.wav");
				play( sounds );
				break;
			case "five":
				sounds = new File("monkey2.wav");
				play( sounds );
				break;
			case "six":
				sounds = new File("duck.wav");
				play( sounds );
				break;
			default:
				JOptionPane.showMessageDialog( this,  "Unknown button pressed!" );
				break;
		}
	}
	
	
	public static void main(String[] args) {
		new ButtonBox(); // Run the program!!
	}

}
