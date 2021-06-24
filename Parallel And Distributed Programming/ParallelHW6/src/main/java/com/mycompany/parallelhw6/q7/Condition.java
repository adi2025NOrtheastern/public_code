/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.parallelhw6.q7;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author aditi
 */
public interface Condition {

    void await() throws InterruptedException;

    boolean await(long time, TimeUnit unit)
            throws InterruptedException;

    long awaitNanos(long nanosTimeout) throws InterruptedException;

    void awaitUninterruptibly();

    boolean awaitUntil(Date deadline) throws InterruptedException;

    void signal();

    void signalAll();
}
