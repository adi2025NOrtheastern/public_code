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
public class Counter1 {

    private int count = 0;

    public int inc() {
        synchronized (this) {
            return ++count;
        }
    }
}
