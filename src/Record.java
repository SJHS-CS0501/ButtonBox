import java.io.FileWriter;
import java.util.ArrayList;
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
				lotsOfSounds.add(c, button.getActionCommand());
				break;
			case "Two":
				lotsOfSounds.add(c, button.getActionCommand());
				break;
			case "Three":
				lotsOfSounds.add(c, button.getActionCommand());
				break;
			case "Four":
				lotsOfSounds.add(c, button.getActionCommand());
				break;
			case "Five":
				lotsOfSounds.add(c, button.getActionCommand());
				break;
			case "Six":
				lotsOfSounds.add(c, button.getActionCommand());
				break;
			default:
				System.exit(0);
			}
			c++;
			if( button.getActionCommand().equals("Eight") ) {
				FileWriter writer = new FileWriter("soundFile.txt");
				writer.write(lotsOfSounds);
				i = -1;
			}
		}
	}
	
	/**
	 * Writing to file
	 */
	public void writer() {
		
	}

}
