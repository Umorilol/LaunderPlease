package Main;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
	
	Clip clip;
	URL soundURL[] = new URL[10];
	
	public Sound() {
		soundURL[0] = getClass().getResource("/sounds/hello.wav");
		soundURL[1] = getClass().getResource("/sounds/war.wav");
		soundURL[2] = getClass().getResource("/sounds/synth.wav");
		soundURL[3] = getClass().getResource("/sounds/welcome.wav");
	}
	
	public void setFile(int i) {
		try {
			// open audio file
			AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
			clip = AudioSystem.getClip();
			clip.open(ais);
			
		}catch (Exception e) {
		}
	}
	
	public void play() {
		clip.start();
	}
	
	public void stop() {
		clip.stop();
	}
}
