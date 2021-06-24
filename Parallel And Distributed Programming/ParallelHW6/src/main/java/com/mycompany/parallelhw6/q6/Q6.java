/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.parallelhw6.q6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aditi
 */
public class Q6 {

    static List<List<Integer>> list;
    static List<List<Integer>> resultlist;
    static int[][] arr = {{9, 12, 6, 14, 10, 21, 13}, {3, 5, 41, 16, 14, 10, 21},
    {3, 15, 41, 17, 11, 10, 51}, {3, 15, 41, 17, 11, 10, 51},
    {2, 15, 35, 10, 11, 12, 19}, {1, 20, 33, 18, 12, 13, 44}};

    

    public static void main(String[] args) {

        
          System.out.println("Initial array->");
         for( int i=0;i<arr.length;i++)
        {
            System.out.println(" ");
            for(int j=0;j<arr[i].length;j++)
            {
                System.out.print(arr[i][j] + ", ");
            }
        }
        
        Lock lock = new ReentrantLock();
        
        list = new ArrayList<List<Integer>>();
        resultlist = new ArrayList<List<Integer>>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> l = new ArrayList<Integer>();
            for (int j = 0; j < arr[i].length; j++) {
                //System.out.print(arr[i][j] + ", ");
                l.add(arr[i][j]);
            }
            list.add(l);
        }
        MThread[] thr = new MThread[6];

        for (int i = 0; i < 6; i++) {
            thr[i] = new MThread(list.get(i),i,resultlist, lock);
            thr[i].start();
            
            //System.out.println(Thread.currentThread().getName() + " has row: " + i);
        }

        System.out.println("");
        System.out.println("List before sort: "+ list.toString());
        
        //sort
        for (int i = 0; i < 6; i++) {
            try {
                thr[i].join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Q6.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
        System.out.println("");
       //  System.out.println("List after sort: "+ list.toString());
         
         System.out.println("List after sort: "+ resultlist.toString());

         
         //convert list to arr
        // list.toArray(arr);
          int n = arr.length;
        int m = arr[0].length;
        //int[][] b = new int[n][m];
        int i=0;
        for(List<Integer> l: list)
        {
            int j=0;
            while(j!=l.size())
            {
                
                arr[i][j] = l.get(j);
                j++;
            }
            i++;
        }
         System.out.println("Sorted array->");
         for( i=0;i<arr.length;i++)
        {
            System.out.println(" ");
            for(int j=0;j<arr[i].length;j++)
            {
                System.out.print(arr[i][j] + ", ");
            }
        }
         
         
//         //Sort each by heap sort
//         int[][] arr = {{9, 12, 6, 14, 10, 21, 13}, {3, 5, 41, 16, 14, 10, 21},
//    {3, 15, 41, 17, 11, 10, 51}, {3, 15, 41, 17, 11, 10, 51},
//    {2, 15, 35, 10, 11, 12, 19}, {1, 20, 33, 18, 12, 13, 44}};
//        System.out.println("");
//         System.out.println("Before heap sort->"
//                 + "array is ");
//        
//         for(int k=0;k<arr.length;k++)
//         {
//             HeapSort.printArray(arr[k]);
//         }
//         
//         HeapSort obj = new HeapSort();
//         for(int k=0;k<arr.length;k++)
//         {
//             obj.sort(arr[k]);
//         }
//         System.out.println("");
//         System.out.println("After heap sort->"
//                 + "array is ");
//        
//         for(int k=0;k<arr.length;k++)
//         {
//             HeapSort.printArray(arr[k]);
//         }
//         
//          //sort
//        for ( i = 0; i < 6; i++) {
//            try {
//                System.out.println("Thread "+i+" ->"+thr[i].list.toString());
//            } catch (Exception ex) {
//                Logger.getLogger(Q6.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//        }
         
         
    }
}

class MThread extends Thread {

    List<List<Integer>> mainList;
    List<Integer> list;
    Lock lock;
   // List<Integer> oldlist;
        public MThread() {
        }
        
        public MThread(List<Integer> l, int i,List<List<Integer>> mainList , Lock lock) {
            list = l;
           // oldlist=l;
            this.setName("Thread"+i);
            this.mainList= mainList;
            this.lock=lock;
            
        }

        @Override
        public void run() {
            //System.out.println(Thread.currentThread().getName()+" in Run. Sorting ->" +list.toString());
            
            Collections.sort(list);
           // System.out.println(Thread.currentThread().getName()+" Sorted ->" +list.toString()+"Sorted!! ");
            
            
            //now write back in list
            lock.lock();
            synchronized(mainList)
            {
                //mainList.remove(oldlist);
                mainList.add(list);
                System.out.println(Thread.currentThread().getName()+" wrote in list");
            }
            lock.unlock();
            
            
            
            //print the sorted data
            System.out.println(Thread.currentThread().getName()+" Sorted using Collection.sort() ->" +list.toString());
            
        try {
            Thread.sleep(5000);
            //heapsort
        } catch (InterruptedException ex) {
            Logger.getLogger(MThread.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            HeapSort obj = new HeapSort();
            int[] array = new int[list.size()];
            for(int i=0;i<list.size(); i++)
            {
                array[i]=list.get(i);
            }
            obj.sort(array);
         
            lock.lock();
            HeapSort.printArray(array);
            lock.unlock();
        }

    }



 class HeapSort 
{ 
    public void sort(int arr[]) 
    { 
        int n = arr.length; 
  
        // Build heap (rearrange array) 
        for (int i = n / 2 - 1; i >= 0; i--) 
            heapify(arr, n, i); 
  
        // One by one extract an element from heap 
        for (int i=n-1; i>=0; i--) 
        { 
            // Move current root to end 
            int temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp; 
  
            // call max heapify on the reduced heap 
            heapify(arr, i, 0); 
        } 
    } 
  
    // To heapify a subtree rooted with node i which is 
    // an index in arr[]. n is size of heap 
    void heapify(int arr[], int n, int i) 
    { 
        int largest = i;  // Initialize largest as root 
        int l = 2*i + 1;  // left = 2*i + 1 
        int r = 2*i + 2;  // right = 2*i + 2 
  
        // If left child is larger than root 
        if (l < n && arr[l] > arr[largest]) 
            largest = l; 
  
        // If right child is larger than largest so far 
        if (r < n && arr[r] > arr[largest]) 
            largest = r; 
  
        // If largest is not root 
        if (largest != i) 
        { 
            int swap = arr[i]; 
            arr[i] = arr[largest]; 
            arr[largest] = swap; 
  
            // Recursively heapify the affected sub-tree 
            heapify(arr, n, largest); 
        } 
    } 
  
    /* A utility function to print array of size n */
    static void printArray(int arr[]) 
    { 
        
        int n = arr.length; 
        
        
        System.out.println(Thread.currentThread().getName()+ " heap sort printing sorted");
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+" "); 
        System.out.println(); 
    } 
  

} 
