/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 *
 * @author aditi
 */
public class Q3ArraySort {

    static final ForkJoinPool fjPool = new ForkJoinPool();

//    static int[] reverse(int[] array) {
//
//// ADD A LINE HERE
//        fjPool.invoke(new Reverse(answer, array, 0, array.length)); // DO NOT CHANGE //
//
//       // ADD A LINE HERE
//
//    }
//
//}
    public static void main(String[] args) {
        
    
        long start = 0;
        long end = 0;
        int rows = 7;
        int cols = 7;
        //Integer[][] matrix = new Integer[rows][cols];
        int[][] arr = { { 9, 12, 6, 14, 10, 21, 13}, { 3, 5, 41, 16, 14, 10, 21},
            { 3, 15, 41, 17, 11, 10, 51}, { 3, 15, 41, 17, 11, 10, 51},
            { 4, 15, 35, 17, 11, 12, 55}, { 2, 16, 31, 18, 12, 11, 42},
            { 2, 15, 35, 10, 11, 12, 19}, { 1, 20, 33, 18, 12, 13, 44} };
        List<int[]> returned;
        returned = new ArrayList();
        Sorter[] tasks = new Sorter[rows];

        for(int i=0; i< rows; i++)
        {
            tasks[i]= new Sorter(arr[i]);
            returned.add((int[]) fjPool.invoke(tasks[i]));
            
        }
        //System.out.println("result: "+ returned.toArray().toString());
        
        for(int[] i: returned)
        {
             System.out.println("array sort->"+ i[0]+" "
                     +i[1]+" "+i[2]+" "+i[3]+" "+i[4]+" "+i[5]+" "+i[6]);
        }
    }

}

class Sorter extends RecursiveTask {

    int[] a;

    public Sorter(int[] a) {
        this.a = a;
        System.out.println("");
    }

    @Override
    protected int[] compute() {
        Arrays.sort(a);
        System.out.println("array sort->"+ a[0]+" " +a[1]+" "+a[2]+" "+a[3]+" "+
                a[4]+" "+a[5]+" "+a[6]);
        return a;
    }

}
