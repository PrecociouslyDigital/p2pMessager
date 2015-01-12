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
public static String parseName(String thing){
    if(thing.contains("http://www.cool-midi.com/download/"))
        thing = thing.substring(34, thing.length()-3);
    thing.replace('_', ' ');
    return thing;
}
}
