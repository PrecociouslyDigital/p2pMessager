/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webp2p.p2p;

import webp2p.connection.Connection;

/**
 *
 * @author s-yinb
 */
public class Peer extends Thread{
    private Connection server;
    public void sendToPeer(WireMessage mess){
        server.send(mess);
    }
    public void sendToPeer(Message mess){
        WireMessage sending = new WireMessage(mess, server.ip, new String[]{server.ip});
    }
    public void handleMessage(WireMessage mess){
        
    }
}
