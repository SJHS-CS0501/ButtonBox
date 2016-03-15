import java.io.*;
import java.util.ArrayList;
//import javax.swing.JOptionPane;

public class Recording{

	Recording( String command ){
	
		switch( command ){
			case "one":
				sounds.add( command );
				break;
			case "two":
				sounds.add( command );
				break;
			case "three":
				sounds.add( command );
				break;
			case "four":
				sounds.add( command );
				break;
			case "five":
				sounds.add( command );
				break;
			case "six":
				sounds.add( command );
				break;
		}
	
	}	
	
	ArrayList<String> sounds = new ArrayList<String>();
	//public long delay;
	
	public ArrayList<String> recordWav(){
		return sounds;
	}
	
	
		
}
