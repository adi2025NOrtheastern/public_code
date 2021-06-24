/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.parallelhw6.q3;

/**
 *
 * @author aditi
 */
import java.util.stream.IntStream;

public class ParallelExample3b {

    public static void main(String[] args) {

        System.out.println("Normal...");

        IntStream range = IntStream.rangeClosed(1, 10);
        range.forEach(x -> {
            System.out.println("Thread : " + Thread.currentThread().getName() + ", value: " + x);
        });

        System.out.println("Parallel...");

        IntStream range2 = IntStream.rangeClosed(1, 10);
        range2.parallel().forEach(x -> {
            System.out.println("Thread : " + Thread.currentThread().getName() + ", value: " + x);
        });

    }

}