/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.parallelhw6.q7;

import static com.sun.org.apache.xerces.internal.xinclude.XIncludeHandler.BUFFER_SIZE;
import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.concurrent.GuardedBy;

/**
 *
 * @author aditi
 */
public class ConditionBoundedBuffer {

    protected final Lock lock = new ReentrantLock();
// CONDITION PREDICATE: notFull (count < items.length)
    private final Condition notFull = lock.newCondition();
// CONDITION PREDICATE: notEmpty (count > 0)
    private final Condition notEmpty = lock.newCondition();
    @GuardedBy("lock")
    private final String[] items;
    @GuardedBy("lock")
    private int tail, head, count;
// BLOCKS-UNTIL: notFull

    public ConditionBoundedBuffer() {
        this.items =  new String[10];
    }

    public void put(String x) throws InterruptedException {
        lock.lock();
        //System.out.println(Thread.currentThread().getName());
        try {
            while (count == items.length) {
                notFull.await();
            }
            items[tail] = x;
            if (++tail == items.length) {
                tail = 0;
            }
            ++count;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }
// BLOCKS-UNTIL: notEmpty

    public String take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                notEmpty.await();
            }
            String x = items[head];
            items[head] = null;
            if (++head == items.length) {
                head = 0;
            }
            --count;
            notFull.signal();
            return x;
        } finally {
            lock.unlock();
        }
    }
    
    
    
    public static void main(String[] args) {
        ConditionBoundedBuffer obj = new ConditionBoundedBuffer();
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        try {
             System.out.println("Intially items-> "+ Arrays.toString(obj.items));
            for(int i=0;i<10;i++){
                String aa= "Ad"+i;
                  executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            obj.put(aa);
                            System.out.println(Thread.currentThread().getName()+" made items-> "+ Arrays.toString(obj.items) );
                            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        } catch (InterruptedException ex) {
                            Logger.getLogger(ConditionBoundedBuffer.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
            }
        executor.shutdown();
            
        
            System.out.println("after put-> "+ Arrays.toString(obj.items));
            obj.take();
            
            System.out.println("after take-> "+ Arrays.toString(obj.items));
        } catch (InterruptedException ex) {
            Logger.getLogger(ConditionBoundedBuffer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}