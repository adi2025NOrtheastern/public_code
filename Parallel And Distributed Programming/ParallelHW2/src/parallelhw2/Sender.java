/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parallelhw2;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author aditi
 */
public class Sender implements Runnable {
    private Data data;
 
    // standard constructors
    public Sender(Data d)
    {
        this.data = d;
    }
 
    public void run() {
        String packets[] = {
          "1 packet",
          "2 packet",
          "3 packet",
          "4 packet",
          "Over"
        };
 
        for (String packet : packets) {
            data.send(packet);

            // Thread.sleep() to mimic heavy server-side processing
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(100, 500));
            } catch (InterruptedException e)  {
                Thread.currentThread().interrupt(); 
                //Log.error("Thread interrupted", e); 
            }
        }
    }
}