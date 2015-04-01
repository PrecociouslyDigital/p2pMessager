/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webp2p.p2p;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author s-yinb
 */
public class WireMessage implements Serializable{
    public final Message mess;
    public final Set<String> sentTo;
    public WireMessage(Message message, String ip, String[] ips){
        this.mess = message;
        this.sentTo = new HashSet<>();
        this.sentTo.add(ip);
        for(String s : ips)
            this.sentTo.add(s);
    }
    public void addChildren(Collection<String> children){
        sentTo.addAll(children);
    }
}
