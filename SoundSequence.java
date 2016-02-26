/**
 * This class stores and plays a sequence of sound effects at specific intervals
 * @author Ryan Luchs
 * 
 */

import java.util.ArrayList;
import java.io.File;
import javax.sound.sampled.*;
import javax.swing.JOptionPane;

public class SoundSequence extends Thread {
	
	private class TimeSpanWrapper {
		public long time;
		
		TimeSpanWrapper(long t){
			time = t;
		}
	}
	
	private class FileListIndexWrapper {
		public int index;
		
		FileListIndexWrapper(int t){
			index = t;
		}
	}

	private ArrayList<FileListIndexWrapper> playList;
	private ArrayList<TimeSpanWrapper> playTimes;
	
	private File[] files;
	
	SoundSequence(File[] f) {
		files = f;
	}
	
	public void add(int i) {
		playList.add(new FileListIndexWrapper(i));
	}
	
	public void add(int i, long t) {
		playList.add(new FileListIndexWrapper(i));
		playTimes.add(new TimeSpanWrapper(t));
	}
	
	/**
	 * Plays a sound clip
	 * @param sound a File object of .wav file
	 * @return Whether the sound was successfully played or not
	 */
	public boolean playSound(File sound) {
		try {
			// try to play sound
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(sound));
			clip.start();
			return true;
		} catch (Exception e) {
			// if failed, say so in a window and print error message
			e.printStackTrace();
			return false;
		}
	}
	
	private File translateIndexToFile(int i ) {
		return files[playList.get(i).index];
	}

	public void run() {
		int index = 0;
		
		playSound(translateIndexToFile(index));
		try {
			sleep(playTimes.get(index).time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
