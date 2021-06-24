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

public class CASCounter {

    private SimulatedCAS value = new SimulatedCAS(); // starts with 0

    public int getValue() {
        return value.get();
    }
    
    public int increment() {
        int oldValue = value.get();
        while (value.compareAndSwap(oldValue, oldValue + 1) != oldValue) {
            oldValue = value.get();
        }
        return oldValue + 1;
    }
}