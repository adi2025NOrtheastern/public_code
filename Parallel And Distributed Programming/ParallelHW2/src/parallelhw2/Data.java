/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parallelhw2;

import java.util.logging.Level;
import jdk.internal.instrumentation.Logger;

/**
 *
 * @author aditi
 */
public class Data {
    private String packet;
     
    // True if receiver should wait
    // False if sender should wait
    private boolean transfer = true;
  
    public synchronized void send(String packet) {
        while (!transfer) {
            try { 
                wait();
            } catch (InterruptedException e)  {
                Thread.currentThread().interrupt(); 
                //Log.error("Thread interrupted", e); 
               //Logger.classgetLogger(Data.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        transfer = false;
         
        this.packet = packet;
        notifyAll();
    }
  
    public synchronized String receive() {
        while (transfer) {
            try {
                wait();
            } catch (InterruptedException e)  {
                Thread.currentThread().interrupt(); 
                //Log.error("Thread interrupted", e); 
            }
        }
        transfer = true;
 
        notifyAll();
        return packet;
    }

//main method
    
    public static void main(String[] args) {
    Data data = new Data();
    Thread sender = new Thread(new Sender(data));
    Thread receiver = new Thread(new Receiver(data));
    
    sender.start();
    receiver.start();
}


}

