

import java.util.ArrayList;

/**
 * This saves sound arrays and times in an object
 * @author Ryley Danielson
 *
 */
public class SoundLists {
	
	private String listName;
	private ArrayList<String> command;
	private ArrayList<Long> time;
	
	/**
	 * Constructs a sound list from a string name
	 *
	 */
	public SoundLists(){
		
		
	}
	
	public void setName(String name){
		
		listName = name;
	}
	
	public String getName(){
		
		return listName;
	}
	
	public void setCommand(ArrayList<String> thing){
		
		command = thing;
	}
	
	public ArrayList<String> getCommand(){
		
		return command;
	}
	
	public void setTime(ArrayList<Long> times){
		
		time = times;
	}
	
	public ArrayList<Long> getTime(){
		
		return time;
	}

}
