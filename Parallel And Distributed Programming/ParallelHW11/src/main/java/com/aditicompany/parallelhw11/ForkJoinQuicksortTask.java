/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aditicompany.parallelhw11;

/**
 *
 * @author aditi
 */
import static com.aditicompany.parallelhw11.Q5a.partition;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

//import static pmbauer.parallel.Quicksort.partition;

public class ForkJoinQuicksortTask extends RecursiveAction {
    private static final int SERIAL_THRESHOLD = 0x1000;

    private final int[] a;
    private final int left;
    private final int right;

    public ForkJoinQuicksortTask(int[] a) {
        this(a, 0, a.length - 1);
    }

    private ForkJoinQuicksortTask(int[] a, int left, int right) {
        this.a = a;
        this.left = left;
        this.right = right;
    }

    @Override
    protected void compute() {
        if (serialThresholdMet()) {
            Arrays.sort(a, left, right + 1);
        } else {
            int pivotIndex = partition(a, left, right);
            ForkJoinTask t1 = null;

            if (left < pivotIndex)
                t1 = new ForkJoinQuicksortTask(a, left, pivotIndex).fork();
            if (pivotIndex + 1 < right)
                new ForkJoinQuicksortTask(a, pivotIndex + 1, right).invoke();

            if (t1 != null)
                t1.join();
        }
    }

    private boolean serialThresholdMet() {
        return right - left < SERIAL_THRESHOLD;
    }
    
     public static void main(String[] args) {
        int arr[] = new int[100000];// {91, 37, 42, 38, 3, 9, 62, 10, 21, 8, 34, 19, 6, 18, 21, 25};

        Random rd = new Random(); // creating Random object

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(); // storing random integers in an array
            // System.out.println(arr[i]); // printing each array element
        }
        //int n = arr.length;
        
        ForkJoinQuicksortTask obj = new ForkJoinQuicksortTask(arr);
        long start = System.nanoTime();
        obj.compute();
        long finish = System.nanoTime();
        long timeElapsed1 = finish - start;
        System.out.println("time taken - " + timeElapsed1);

        
        
         System.out.println(arr[0]+ " "+ arr[99999]);
        
    }
}
