/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.parallelhw6.q4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author aditi
 */
public class Sample {
    public static void main(String[] args) {
          System.out.println("Examples of ordering and parallelism:");
        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8 };
        List<Integer> listOfIntegers =
            new ArrayList<>(Arrays.asList(intArray));

        System.out.println("listOfIntegers:");
        listOfIntegers
            .stream()
            .forEach(e -> System.out.print(e + " "));
        System.out.println("");
        
        System.out.println("listOfIntegers sorted in reverse order:");
        Comparator<Integer> normal = Integer::compare;
        Comparator<Integer> reversed = normal.reversed(); 
        Collections.sort(listOfIntegers, reversed);             
        listOfIntegers
            .stream()
            .forEach(e -> System.out.print(e + " "));
        System.out.println("");
     
        System.out.println("Parallel stream");
        listOfIntegers
            .parallelStream()
            .forEach(e -> System.out.print(e + " "));
        System.out.println("");
    
        System.out.println("Another parallel stream:");
        listOfIntegers
            .parallelStream() 
            .forEach(e -> System.out.print(e + " "));
        System.out.println("");
     
        System.out.println("With forEachOrdered:");
        listOfIntegers
            .parallelStream()
            .forEachOrdered(e -> System.out.print(e + " "));
        System.out.println("");
    }
}
