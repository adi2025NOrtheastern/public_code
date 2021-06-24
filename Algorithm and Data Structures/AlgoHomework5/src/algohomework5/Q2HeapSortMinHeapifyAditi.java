/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algohomework5;

/**
 *
 * @author aditi
 */
public class Q2HeapSortMinHeapifyAditi {
    
     public static void minHeapSort(int arr[], int n) 
    { 
        // Build heap (rearrange array) 
        for (int i = n / 2 - 1; i >= 0; i--) 
            heapify(arr, n, i); 
  
        // One by one extract an element from heap 
        for (int i = n - 1; i >= 0; i--) { 
              
            // Move current root to end 
            int temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp; 
  
            // call max heapify on the reduced heap 
            heapify(arr, i, 0); 
        } 
    } 
  
  public static void heapify(int arr[], int n, int i) 
    { 
        int smallest = i; // Initialize smalles as root 
        int l = 2 * i + 1; // left = 2*i + 1 
        int r = 2 * i + 2; // right = 2*i + 2 
  
        // If left child is smaller than root 
        if (l < n && arr[l] < arr[smallest]) 
            smallest = l; 
  
        // If right child is smaller than smallest so far 
        if (r < n && arr[r] < arr[smallest]) 
            smallest = r; 
  
        // If smallest is not root 
        if (smallest != i) { 
            int temp = arr[i]; 
            arr[i] = arr[smallest]; 
            arr[smallest] = temp; 
  
            // Recursively heapify the affected sub-tree 
            heapify(arr, n, smallest); 
        } 
    } 
         
    public static void printArray(int arr[], int n) 
    { 
        for (int i = 0; i < n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    } 
  
    // Driver program 
    public static void main(String[] args) 
    { 
        int arr[] = {91, 37, 42, 38, 3, 9, 62, 10, 21, 8, 34, 19, 6, 18, 21, 25}; 
        int n = arr.length; 
  
        minHeapSort(arr, n); 
  
        System.out.println("Sorted array is "); 
        printArray(arr, n); 
    } 
} 
