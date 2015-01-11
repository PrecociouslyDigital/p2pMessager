/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radio;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author s-yinb
 */
public class RadioClientCode {

    public static Radio radio = new Radio();

    public static void main(String[] args) {
        Scanner con = new Scanner(System.in);

        String input = con.nextLine();
        while (!input.equalsIgnoreCase("quit")) {
            switch (input) {
                case "turnOn":
                    radio.turnOn();
                    System.out.println("Turned on");
                    break;
                case "turnOff":
                    radio.turnOff();
                    System.out.println("Turned off");
                    break;
                case "stop":
                    radio.end();
                    System.out.println("Stopped");
                    break;
                default:
                    String[] thing = input.split(" ", 2);
                    if (thing[0].equalsIgnoreCase("play")) {
                        //parseUrl(thing[1]);
                    	radio.play(thing[1]);
                    }
                    /*if(thing[0].equalsIgnoreCase("playlist")){
                        parsePlayList(thing[1]);
            }*/

        }
            input = con.nextLine();
    }
    }

    /*public static URL addSong(Scanner in) {
        System.out.println("Artist?");
        String urlpart = in.nextLine().replace(' ', '_');
        System.out.println("Song?");
        urlpart += "-" + in.nextLine().replace(' ', '_');
        try {
            radio.add(new URL("http://www.cool-midi.com/download/" + urlpart + ".htm"), urlpart.replace('_', ' '));
        } catch (Exception ex) {
            Logger.getLogger(RadioClientCode.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }*/

    public static void parseUrl(String thing) {

        /*URL url;
        try {
            url = new URL(thing);
        } catch (Exception e) {
            try {
                url = new URL("http://www.cool-midi.com/download/" + thing.replace(' ', '_') + ".htm");
            } catch (MalformedURLException ex) {
                System.out.println("Not a valid song/url!");
                return;
            }
        }
        try {
            radio.add(url, parseName(thing));
            System.out.println("Added " + thing);
        } catch (Exception ex) {
            System.out.println("Not a valid song/url!");
            return;
        }*/
        
    }

public static void parsePlayList(String file){
        File filed = new File(file);
        Scanner scn = new Scanner("");
        try {
            scn = new Scanner(filed);
        } catch (FileNotFoundException ex) {
            System.out.println("Can't find that file!");
        }
        while(scn.hasNext()){
            parseUrl(scn.nextLine());
        }
        
    }
public static String parseName(String thing){
    if(thing.contains("http://www.cool-midi.com/download/"))
        thing = thing.substring(34, thing.length()-3);
    thing.replace('_', ' ');
    return thing;
}
}
