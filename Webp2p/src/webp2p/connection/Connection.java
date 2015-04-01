/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webp2p.connection;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import webp2p.p2p.Message;
import webp2p.p2p.Peer;
import webp2p.p2p.WireMessage;

/**
 *
 * @author s-yinb
 */
public class Connection {
    private Socket client;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private Peer peer;
    public String ip;
    public int port;
    
    
    public Connection(String ipAddress, int portnum, Peer peer){
        port = portnum;
        ip = ipAddress;
        try{
            client = new Socket(ip,port);
            out = new ObjectOutputStream(client.getOutputStream());
            in = new ObjectInputStream(client.getInputStream());
        }
        catch(Exception e){
        }
    }
    public void send(WireMessage message){
        try{
            out.writeObject(message);
        }
        catch(Exception e){
            
        }
    }
    public void run(){
        try{
            WireMessage mess = (WireMessage) in.readObject();
            peer.handleMessage(mess);
        }
        catch(Exception e){
            
        }
    }
}
