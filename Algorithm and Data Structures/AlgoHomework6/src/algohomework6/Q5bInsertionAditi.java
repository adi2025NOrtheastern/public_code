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

public class Q5bInsertionAditi {  
    
     
        public static void insertionSort(double inputArray[]) {  
        int len = inputArray.length;  
        int swapCount=0;
        for (int j = 1; j < len; j++) {  
            double key = inputArray[j];  
          //  System.out.println("Element to compare "+key);
            int i = j-1;  
            while ( (i >= 0) && ( inputArray[i] > key )  ) {  
            //    System.out.println("Swap "+ inputArray[i+1]+ " and " + inputArray[i] );
                inputArray[i+1] = inputArray[i];  
                i--;  
                swapCount++;
                
            }  
            inputArray[i+1] = key; 
           // System.out.println("Swaps = "+swapCount);
           // System.out.println("Array in pass i= " +j);
          //  for(double in:inputArray){    
          //  System.out.print(in+" ");    
          //  } 
          //  System.out.println("");
            
        }  
    }  
      
}    