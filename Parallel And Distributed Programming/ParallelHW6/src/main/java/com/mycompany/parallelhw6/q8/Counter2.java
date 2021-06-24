/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.parallelhw6.q8;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author aditi
 */
public class Counter2 {

    private Lock lock = new ReentrantLock();

    private int count = 0;

    public int inc() {
        lock.lock();
        try {
            int newCount = ++count;
            return newCount;
        } finally {
            lock.unlock();
        }
    }
}
