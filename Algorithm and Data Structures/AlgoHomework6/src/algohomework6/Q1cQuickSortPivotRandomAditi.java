/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algohomework6;
import java.util.*; 
/**
 *
 * @author aditi
 */
public class Q1cQuickSortPivotRandomAditi 
     
{
     
      void quickSort(int arr[], int low, int high) 
    { 
        if (low < high) 
        { 
            System.out.println("partition arr"+ " , "+low+" , "+high);
            int pi = partition(arr, low, high);  
            System.out.println("quickSort arr"+" , "+low+" , "+(pi-1));
            quickSort(arr, low, pi-1); 
            System.out.println("quickSort arr,"+(pi+1)+","+high);
            quickSort(arr, pi+1, high); 
        } 
    } 

     int partition(int arr[], int low, int high) 
    { 
        // pivot is choosen randomly 
        random(arr,low,high);
        int pivot = arr[high]; 
		int i = (low-1); // index of smaller element 
                System.out.println("low ="+ low+" high ="+ high+" pivot= "+ pivot+" ");
               // System.out.println("Traverse from j= "+low +" to "+(high-1));
		for (int j=low; j<high; j++) 
		{ 
                //    System.out.print("j ="+j);
			
			if (arr[j] < pivot) 
			{ 
				i++; 
                               // System.out.println(" arr[j] < pivot"+ arr[j] +" < "+ pivot + " Perform, i++ and swap");
				// swap arr[i] and arr[j] 
				int temp = arr[i]; 
				arr[i] = arr[j]; 
				arr[j] = temp; 
			} 
                        else {
                        //    System.out.println(" arr[j] > pivot Nothing ");
                        }
                      //  System.out.print("Printing Array now-> ");
                      //  displayArray(arr); 
		} 

		// swap  
		int temp = arr[i+1]; 
		arr[i+1] = arr[high]; 
		arr[high] = temp; 
                //System.out.println("Swap pivot and i+1");
                displayArray(arr);
		return i+1;  
    } 

     void random(int arr[],int low,int high) 
    { 
     
        Random rand= new Random(); 
        int pivot = rand.nextInt(high-low)+low; 
         System.out.println("Random index = "+pivot);
        int temp1=arr[pivot];  
        arr[pivot]=arr[high]; 
        arr[high]=temp1; 
        System.out.println("Array becomes->");
        displayArray(arr);
    }
 
    /*print array of size n */
    static void displayArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i = 0; i < n-1; ++i) 
            System.out.print(arr[i]+" , "); 
        System.out.print(arr[n-1]);
        System.out.println(); 
    } 
 
 
	public static void main(String args[]) 
	{ 
		int arr[] = {91, 37, 42, 38, 3, 9, 62, 10, 21, 8, 34, 19, 6, 18, 21, 25}; 
		int n = arr.length; 
                System.out.println("Intial array"); 
		displayArray(arr); 
		Q1cQuickSortPivotRandomAditi ob = new Q1cQuickSortPivotRandomAditi(); 
		long start = System.nanoTime();
       ob.quickSort(arr, 0, n-1); 
         long finish = System.nanoTime();
         long timeElapsed1 = finish - start;
                System.out.println("time taken - "+ timeElapsed1); 

		System.out.println("sorted array"); 
		displayArray(arr); 
	} 
} 


