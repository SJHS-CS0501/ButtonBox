/**
 * This class stores and plays a sequence of sound effects at specific intervals
 * @author Ryan Luchs
 * 
 */

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.sound.sampled.*;

/**
 * This class stores and plays a sequence of sound effects at specific intervals
 * @author Ryan Luchs
 * 
 */
public class SoundSequence extends Thread {
	
	/**
	 * Creates a reference variable for some primitives so they can be stored in an ArrayList
	 * I am lazy
	 * @author Ryan Luchs
	 * 
	 */
	private class SoundDataWrapper {
		public int index;
		public long delay;
		
		SoundDataWrapper(int i, long t){
			index = i;
			delay = t;
		}
	}

	private ArrayList<SoundDataWrapper> playList;
	
	private File[] files;
	
	/**
	 * Creates a new SoundSequence that uses the given file array to draw its sounds from
	 * @param f Array of .wav files
	 */
	SoundSequence(File[] f) {
		files = f;
		playList = new ArrayList<SoundDataWrapper>();
	}
	
	/**
	 * Creates a new SoundSequence using the provided filename
	 * @param filename
	 */
	SoundSequence(String filename) throws FileNotFoundException{
		playList = new ArrayList<SoundDataWrapper>();
		readFile(filename);
	}
	
	/**
	 * Creates a new SoundSequnce from a file array, a an ArrayList<SoundDataWrapper>
	 * @param f Array of .wav files
	 * @param w a sequence of indexes
	 * @param t a sequence of delay times
	 */
	private SoundSequence(File[] f, ArrayList<SoundDataWrapper> s){
		files = f;
		playList = new ArrayList<SoundDataWrapper>();
		
		for(int i = 0; i < s.size(); i++) {
			playList.add(new SoundDataWrapper(s.get(i).index, s.get(i).delay));
		}
	}
	
	/**
	 * Makes a copy of this object
	 */
	public SoundSequence clone() {	
		return new SoundSequence(files, playList);
	}
	
	/**
	 * Adds a sound to be played after a delay
	 * @param i The index of the sound to play
	 * @param t The delay in milliseconds
	 */
	public void add(int i, long t) {
		playList.add(new SoundDataWrapper(i, t));
	}
	
	/**
	 * Plays a sound clip
	 * @param sound a File object of .wav file
	 * @return Whether the sound was successfully played or not
	 */
	public boolean playSound(File sound) {
		try {
			// try to play sound
			AudioInputStream soundIn = AudioSystem.getAudioInputStream(sound);
			AudioFormat format = soundIn.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, format);

			Clip clip = (Clip)AudioSystem.getLine(info);
			clip.open(soundIn);
			clip.start();
			return true;
		} catch (Exception e) {
			// if failed, say so in a window and print error message
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Returns a string representation of the sound sequence
	 * @return String representation of sound sequence
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		
		for(int i = 0; i < files.length; i++) {
			s.append(files[i].getPath());
			s.append(' ');
		}
		
		s.append('\n');
		
		for(int i = 0; i < playList.size(); i++) {
			s.append(playList.get(i).index);
			s.append(':');
			s.append(playList.get(i).delay);
			s.append(' ');
		}
		
		return s.toString();
	}
	
	/**
	 * Creates a sequence to test functionality
	 */
	public void initTestSequence() {
		add(1, 100);
		add(2, 1000);
		add(0, 200);
		for(int i = 1; i < 5; i++) {
			add(1, i*100);
		}
	}
	
	/**
	 * Read a SoundSequence from the provided filename
	 * @throws FileNotFoundException 
	 */
	public void readFile(String filename) throws FileNotFoundException{
		// assume playList is initialized
		playList.clear(); // clear playList of data
		
		String[] fileLine;
		String[] playLine;

		BufferedReader reader = new BufferedReader(new FileReader(filename));
		try {
			fileLine = reader.readLine().split(" ");
			playLine = reader.readLine().split(" ");
			
			files = new File[fileLine.length];
			for(int i = 0; i < fileLine.length; i++) {
				files[i] = new File(fileLine[i]);
			}
			
			for(int i = 0; i < playLine.length; i++) {
				String[] dataPair = playLine[i].split(":");
				add(Integer.parseInt(dataPair[0]), Long.parseLong(dataPair[1]));
			}
			
			reader.close();
		} catch(IOException e) {
			System.out.print("IOException Encountered: " + e.getMessage());
		}
	}
	
	/**
	 * Write the SoundSequnce to disk at the provided filename
	 * @param filename File to write to
	 * @throws FileNotFoundException 
	 */
	public void writeFile(String filename) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter(filename);
		writer.print(toString());
		writer.close();
	}
	
	/**
	 * Plays the sound sequence in a new thread
	 */
	public void run() {
		for(int i = 0; i < playList.size(); i++) {
			// sleep for x milliseconds
			try {
				sleep(playList.get(i).delay);
			} catch (InterruptedException e) {
				System.out.println("Failure.");
				e.printStackTrace();
			}
			
			// then play a sound
			playSound(files[playList.get(i).index]);
		}
	}
}
