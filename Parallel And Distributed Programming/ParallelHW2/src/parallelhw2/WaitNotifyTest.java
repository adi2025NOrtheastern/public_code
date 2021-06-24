/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parallelhw2;
import parallelhw2.Message;
/**
 *
 * @author aditi
 */


public class WaitNotifyTest {

    public static void main(String[] args) {
        Message msg = new Message("process it");

        Waiter waiter1= new Waiter(msg);
        new Thread(waiter1,"waiter1").start();
        
        Waiter waiter2 = new Waiter(msg);
        new Thread(waiter2, "waiter2").start();
        
        Waiter waiter3= new Waiter(msg);
        new Thread(waiter3,"waiter3").start();

        Notifier notifier = new Notifier(msg);
        new Thread(notifier, "notifier").start();

        System.out.println("All the threads are started");
    }
}
