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
public class Q2HeapSortMaxHeapifyAditi {

    public void sort(int arr[]) {
      int n = arr.length; 
      
      for (int i = n / 2 - 1; i >= 0; i--) {
        heapify(arr, n, i);
      }  
      
      for (int i = n - 1; i >= 0; i--) {
        int temp = arr[0];
        arr[0] = arr[i];
        arr[i] = temp;         
        heapify(arr, i, 0);
      }
    }
  
    void heapify(int arr[], int n, int i) {
      
      int largest = i;
      int l = 2 * i + 1;
      int r = 2 * i + 2;
  
      if (l < n && arr[l] > arr[largest])
        largest = l;
  
      if (r < n && arr[r] > arr[largest])
        largest = r;
       
      if (largest != i) {
        int swap = arr[i];
        arr[i] = arr[largest];
        arr[largest] = swap;  
        heapify(arr, n, largest);
      }
    }
  
    static void printInputArray(int arr[]) {
      int n = arr.length;
      for (int i = 0; i < n; ++i){
        System.out.print(arr[i] + " ");
      }
      System.out.println();
    }
  
    public static void main(String args[]) {
      int arr[] = {91, 37, 42, 38, 3, 9, 62, 10, 21, 8, 34, 19, 6, 18, 21, 25};
  
      Q2HeapSortMaxHeapifyAditi hs = new Q2HeapSortMaxHeapifyAditi();
      hs.sort(arr);
  
      System.out.println("Sorted array is-> ");
      printInputArray(arr);
    }
  }
