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
public class Q1MergeSortAditi {
    
   public void mergeSort(int arr[], int left, int right) {
        if (left < right) {
            int m = (left + right) / 2;
            mergeSort(arr, left, m);
            mergeSort(arr, m + 1, right);
            merge(arr, left, m, right);
        }
    }
   
   public void merge(int arr[], int leftIndex, int mid, int rightIndex) {

        int a2 = rightIndex - mid;
        int right[] = new int[a2];
        
        int a1 = mid - leftIndex + 1;        
        int left[] = new int[a1];
        
        for (int j = 0; j < a2; ++j) {
            right[j] = arr[mid + 1 + j];
        }
        
        for (int i = 0; i < a1; ++i) {
            left[i] = arr[leftIndex + i];
        }
        
        int i = 0, j = 0,k = leftIndex;
        while (i < a1 && j < a2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < a1) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < a2) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    public static void printInputArray(int arr[]) {
        int len = arr.length;

        for (int i = 0; i < len; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = {91, 37, 42, 38, 3, 9, 62, 10, 21, 8, 34, 19, 6, 18, 21, 25};

        System.out.println("Input array is ->");
        printInputArray(arr);

        Q1MergeSortAditi mergeSortObj = new Q1MergeSortAditi();
        mergeSortObj.mergeSort(arr, 0, arr.length - 1);

        System.out.println("\nPrinting the array after sort->");
        printInputArray(arr);
    }
}
