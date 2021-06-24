/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.parallelhw6.q4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author aditi
 */
public class Q4 {
    
    public static void main(String[] args) {
        
        int[][] arr = { { 9, 12, 6, 14, 10, 21, 13}, { 3, 5, 41, 16, 14, 10, 21},
            { 3, 15, 41, 17, 11, 10, 51}, { 3, 15, 41, 17, 11, 10, 51},
            { 4, 15, 35, 17, 11, 12, 55}, { 2, 16, 31, 18, 12, 11, 42},
            { 2, 15, 35, 10, 11, 12, 19}, { 1, 20, 33, 18, 12, 13, 44} };
        for(int i=0;i<arr.length;i++)
        {
            System.out.println(" ");
            for(int j=0;j<arr[i].length;j++)
            {
                System.out.print(arr[i][j] + ", ");
            }
        }
        System.out.println(" ");
        //convert to list of list of integer
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for(int i=0;i<arr.length;i++)
        {
            List<Integer> l = new ArrayList<Integer>();
            for(int j=0;j<arr[i].length;j++)
            {
                //System.out.print(arr[i][j] + ", ");
                l.add(arr[i][j]);
            }
            list.add(l);
        }
        
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "8");
        //list print
        
        System.out.println("List: initially");
        list
                .parallelStream()
                .forEach(e -> System.out.print(Thread.currentThread().getName()+" "+e + " "));
        //sort
        System.out.println("");
        System.out.println("Sorting");
        System.out.println("");
        list
                .parallelStream()
                .forEach(e -> {Collections.sort(e);
                System.out.println(Thread.currentThread().getName()+" "+e + " ");    
                try {
                    //Thread.currentThread().sleep(10000);
                } catch (Exception ex) {
                    Logger.getLogger(Q4.class.getName()).log(Level.SEVERE, null, ex);
                }
                }) ;
        // Thread.currentThread().sleep(500);
        

        System.out.println("List: after sort");
        System.out.println("");
        list
                .parallelStream()
                .forEach(e -> System.out.print(Thread.currentThread().getName()+" "+e + " "));
        System.out.println("");
        //convert lisi of list of integer to array
        int n = arr.length;
        int m = arr[0].length;
        int[][] b = new int[n][m];
        int i=0;
        for(List<Integer> l: list)
        {
            int j=0;
            while(j!=l.size())
            {
                
                b[i][j] = l.get(j);
                j++;
            }
            i++;
        }
        //final array
        System.out.println("");
        System.out.println("Final array after sort");
        for( i=0;i<b.length;i++)
        {
            System.out.println(" ");
            for(int j=0;j<b[i].length;j++)
            {
                System.out.print(b[i][j] + ", ");
            }
        }
     
        
        //System.out.println("threads total count"+ Runtime.getRuntime().availableProcessors());
     
    }
    
    
}
