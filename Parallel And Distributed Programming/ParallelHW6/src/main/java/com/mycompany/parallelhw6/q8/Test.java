/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.parallelhw6.q8;

/**
 *
 * @author aditi
 */
class MyRunnable implements Runnable {
    public CASCounter g;
    public int total = 0;

    MyRunnable(CASCounter g) {
        this.g = g;
    }

    public void run() {
        for (int i=0; i < 10000; i++) {
            synchronized(g) {
            g.increment();
            total += g.getValue();
            }
        }

    }
}
public class Test {

    public static void main(String... s) throws InterruptedException {
        CASCounter g3 = new CASCounter();
        MyRunnable r1 = new MyRunnable(g3);
        MyRunnable r2 = new MyRunnable(g3);
        Thread t1 = new Thread(r1);
        t1.start();
        Thread t2 = new Thread(r2);
        t2.start();
        t1.join();
        t2.join();
        System.out.println(r1.total + r2.total);
    }
}

	
