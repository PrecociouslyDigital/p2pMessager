/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webp2p;

import java.util.List;
import webp2p.p2p.Message;

/**
 *
 * @author s-yinb
 */
public class Webp2p {
    static List<Message> messages;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    }
    public static boolean addMsg(Message msg){
        if(messages.contains(msg))
            return false;
        messages.add(msg);
        System.out.println(msg);
        return true;
    }
}
