import java.io.*;
import java.util.*;
import javax.swing.*;

public class Record {
	
	ArrayList<String> lotsOfSounds = new ArrayList<String>();
	
	Record() {
		
	}
	
	/**
	 * Making array (recording)
	 * @param button
	 */
	public void makeRecording(JButton button) {
		for(int i = 0; i >= 0; i ++) {
			int c = 0;
			switch( button.getActionCommand() ) {
			case "One":
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
			case "Eight":
				break;
			default:
				System.exit(0);
			}
			
			if( button.getActionCommand()!=("Eight") ) {
				lotsOfSounds.add(c, button.getActionCommand());
				c++;
			} else {
				try {
					PrintWriter writer = new PrintWriter("soundFile.txt");
					
					for (int ctr = 0; ctr >= 0; ctr++ ) {
						writer.println( lotsOfSounds[ctr].button.getActionCommand() );
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				
			}
		}
	}

}
