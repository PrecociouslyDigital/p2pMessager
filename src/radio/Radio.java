/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radio;

import java.util.*;
import java.io.IOException;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sound.midi.*;
import javax.sound.sampled.*;

/**
 *
 * @author s-yinb
 */
public class Radio /*extends Thread*/ {

    //List<URL> stack = new LinkedList<>();
    Sequencer song;

    /**
     * @param args the command line arguments
     */
    public Radio() {

    }

    /*public void skip() {
        song.stop();
        stack.remove(0);
        try {
            song.setSequence(MidiSystem.getSequence(stack.get(0)));
            song.start();
            System.out.println("now playing: " + getName(stack.get(0)));
            
        } catch (InvalidMidiDataException ex) {
            System.out.println("Error!");
            skip();
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }*/
    public String getName(URL url){
    	String[] parts = url.toString().split("/"); //http://www.cool-midi.com/midi/b/black_eyed_peas-i_gotta_feeling.mid
    	String target = parts[6];
    	target = target.substring(0, target.length()-4);
    	return target.replace("-", " ");
    }

    public void play(String url) {
    	if(song.isRunning())
    	song.stop();
    	try{
    	song.setSequence(MidiSystem.getSequence(new URL(url)));
    	song.start();
    	}catch(InvalidMidiDataException e){
    		
    	}catch(IOException e){
    		try{
    			url = url.toLowerCase();
    			String[] parts = url.split("-");
    			song.setSequence(MidiSystem.getSequence(new URL("http://www.cool-midi.com/midi/" + url.charAt(0) + "/" + parts[0].trim().replace(" ", "_") + "-" + parts[1].trim().replace(" ", "_") + ".mid")));
    			song.start();
            	System.out.println("Playing " + url);
    		}catch(InvalidMidiDataException | IOException err){
    				System.out.println("Not a Valid midi file!");
    		}
    	}
    }

    public void end() {
        song.stop();
    }

    public void turnOn() {
        try {
            song = MidiSystem.getSequencer();
            song.open();
        } catch (MidiUnavailableException ex) {
            System.out.println("Someone screwed something up.");
        }
        
    }

    public void turnOff() {
        song.stop();
        song = null;
    }

    /*public void run() {
        if (!song.isRunning()) {
            skip();
        }
    }*/
}
