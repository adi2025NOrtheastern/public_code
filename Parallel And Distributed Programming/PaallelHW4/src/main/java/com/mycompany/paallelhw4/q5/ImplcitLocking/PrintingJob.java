/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.paallelhw4.q5.ImplcitLocking;

import com.mycompany.paallelhw4.q5.*;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author aditi
 */
class PrintingJob implements Runnable
{
   private PrinterQueue printerQueue;
 
   public PrintingJob(PrinterQueue printerQueue)
   {
      this.printerQueue = printerQueue;
   }
 
   @Override
   public void run()
   {
    System.out.printf("%s: Going to print a document\n", Thread.currentThread().getName());
      printerQueue.printJob(new Object());
   }
}

class PrinterQueue {
   //private final Lock queueLock = new ReentrantLock();
 
   public void printJob(Object document)
   {
      //queueLock.lock();
       synchronized(this)
       {
      try {
         Long duration = (long) (Math.random() * 1000); //10000
         System.out.println(Thread.currentThread().getName() + 
": PrintQueue: Printing a Job during " + (duration / 1000) + 
" seconds :: Time - " + new Date());
         Thread.sleep(duration);
      } catch (InterruptedException e)
      {
         e.printStackTrace();
      } finally
      {
         System.out.printf("%s: The document has been printed\n",
		 Thread.currentThread().getName());
         //queueLock.unlock();     
         
      } 
} 
   
   }}
