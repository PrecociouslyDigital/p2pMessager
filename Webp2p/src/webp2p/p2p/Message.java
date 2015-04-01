package webp2p.p2p;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author s-yinb
 */
public class Message implements Serializable{
    public final String message;
    public final long timeStamp;
    public final String sender;
    public Message(String message, String sender){
        this.message = message;
        this.sender = sender;
        this.timeStamp = System.nanoTime();
    }
    @Override
    public int hashCode(){
        return message.hashCode() + (int)timeStamp + sender.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Message other = (Message) obj;
        if(obj.hashCode() != this.hashCode())
            return false;
        if (!Objects.equals(this.message, other.message)) {
            return false;
        }
        if (this.timeStamp != other.timeStamp) {
            return false;
        }
        if (!Objects.equals(this.sender, other.sender)) {
            return false;
        }
        return true;
    }
    @Override
    public String toString(){
        return sender + " [" + timeStamp + "]: " + message;
    }
}
