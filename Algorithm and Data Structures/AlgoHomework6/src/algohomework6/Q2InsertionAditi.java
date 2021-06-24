/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algohomework6;

/**
 *
 * @author aditi
 */

public class Q2InsertionAditi {  
    
     
    public static void main(String a[]){    
        int[] inputArray = {91, 37, 42, 38, 3, 9, 62, 10, 21, 8, 34, 19, 6, 18, 21, 25};    
        System.out.println("Before Insertion Sort");    
        for(int i:inputArray){    
            System.out.print(i+" ");    
        }    
        System.out.println();    
            
        //sorting inputArray using insertion sort    
           long start = System.nanoTime();
        insertionSort(inputArray);
         long finish = System.nanoTime();
         long timeElapsed1 = finish - start;
        System.out.println("After Insertion Sort");    
        for(int i:inputArray){    
            System.out.print(i+" ");    
        }    
        System.out.println("time taken - "+ timeElapsed1);
    }    
    public static void insertionSort(int inputArray[]) {  
        int len = inputArray.length;  
        int swapCount=0;
        for (int j = 1; j < len; j++) {  
            int key = inputArray[j];  
            System.out.println("Element to compare "+key);
            int i = j-1;  
            while ( (i >= 0) && ( inputArray[i] > key )  ) {  
                //System.out.println("Swap "+ inputArray[i+1]+ " and " + inputArray[i] );
                inputArray[i+1] = inputArray[i];  
                i--;  
                swapCount++;
                
            }  
            inputArray[i+1] = key; 
            System.out.println("Swaps = "+swapCount);
            System.out.println("Array in pass i= " +j);
            for(int in:inputArray){    
            System.out.print(in+" ");    
            } 
            System.out.println("");
            
        }  
    }  
      
}    