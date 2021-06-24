/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q4;


import java.util.logging.Level;
import java.util.logging.Logger;
import q4.Lock;

/**
 *
 * @author aditi
 */

    
public class Reentrant {

   int level = 0;
   Lock lock = new Lock();// reentrant lock needed
    public synchronized void outer() {
       try {
           System.out.println("In outer");
           lock.lock();
           System.out.println("Lock acquired.. calling inner");
           inner();
           lock.unlock();
           System.out.println("Lock released");
       } catch (InterruptedException ex) {
           Logger.getLogger(Reentrant.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
     
    public synchronized void inner(){
            	try {
                    level++;
                    System.out.println(Thread.currentThread().getName()+" - level: "+ level);
                    lock.lock();
                    try {
                        if (level <= 3) {
                            System.out.println("level <=3... Calling inner");
                            inner();
                            if (level == 2) {
                                System.out.println("level is 2");
                                Thread.sleep(1000);
                            }
                        } else {
                            System.out.println("Level > 3");
                            Thread.sleep(1000);
                        }
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Reentrant.class.getName()).log(Level.SEVERE, null, ex);
                    } finally {
                        lock.unlock();
                        level--;
                    }
                } catch (InterruptedException ex) {
           Logger.getLogger(Reentrant.class.getName()).log(Level.SEVERE, null, ex);
       } 
    } 


    public static void main(String[] args) {
        //Reentrant obj = new Reentrant();
        //obj.outer();
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.start();
        t2.start();
    } 


}

class MyThread extends Thread{
    Reentrant obj;
    public MyThread(){
        this.obj = new Reentrant();
    }
    
    
    @Override 
    public void run(){
        obj.outer();
    }
}

