/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q4;

/**
 *
 * @author aditi
 */
public class Lock{

  boolean isLocked = false;
  Thread  lockedBy = null;
  int     lockedCount = 0;

  public synchronized void lock()
  throws InterruptedException{
    Thread callingThread = Thread.currentThread();
    while(isLocked && lockedBy != callingThread){
        System.out.println(callingThread.getName() + " is Waiting , lock acquired by " + lockedBy.getName());
      wait();
    }
      System.out.println(callingThread.getName() + " acquiring lock");
    isLocked = true;
    lockedCount++;
    lockedBy = callingThread;
      System.out.println("locked count = "+lockedCount+" .... Locked success by "+ callingThread.getName());
  }


  public synchronized void unlock(){
    if(Thread.currentThread() == this.lockedBy){
      lockedCount--;
       System.out.println( Thread.currentThread().getName()+" locked count = "+ lockedCount);
      if(lockedCount == 0){
        isLocked = false;
          System.out.println(Thread.currentThread().getName() +" Unlocked...");
        notify();
      }
    }
  }
}
