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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
    * this flag indicates whether the playback completes or not.
    */
   boolean playCompleted;
    
   /**
    * Play a given audio file.
    * @param audioFilePath Path of the audio file.
    */
   void play(String audioFilePath) {
       //File audioFile = new File(audioFilePath);

  
       
       try {
    	   sounds = new File("ominous.wav");
           
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
                   e.printStackTrace();
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
           System.out.println("Playback started.");
            
       } else if (type == LineEvent.Type.STOP) {
           playCompleted = true;
           System.out.println("Playback completed.");
       }

   }


	
	











	
	
	
	
	
	
	public void actionPerformed( ActionEvent e ){
		JButton button = (JButton)e.getSource();
		switch( button.getActionCommand() ){
			case "one":
				
				
				
				break;
			case "two":
				break;
			case "three":
				break;
			case "four":
				break;
			case "five":
				break;
			case "six":
				break;
			default:
				JOptionPane.showMessageDialog( this,  "Unknown button pressed!" );
				break;
		}
	}
	
	
	public static void main(String[] args) {
		new ButtonBox();
	}


	//@Override
	//public void update(LineEvent arg0) {
	//}

}
