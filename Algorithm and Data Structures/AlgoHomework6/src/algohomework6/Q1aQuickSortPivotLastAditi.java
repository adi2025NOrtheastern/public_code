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
public class Q1aQuickSortPivotLastAditi {
  
    
    /*  print array of size n */
	static void displayArray(int arr[]) 
	{ 
		int n = arr.length; 
		for (int i=0; i<n-1; ++i) 
			System.out.print(arr[i]+" , "); 
                System.out.println(arr[n-1]);
		System.out.println(); 
	}  
	void Quicksort(int arr[], int low, int high) 
	{ 
		if (low < high) 
		{ 
			System.out.println("partition arr"+ " , "+low+" , "+high);
			int pi = partition(arr, low, high); 

                        System.out.println("quickSort arr"+","+low+","+(pi-1));
			Quicksort(arr, low, pi-1); 
                        System.out.println("quickSort arr,"+(pi+1)+","+high);
			Quicksort(arr, pi+1, high); 
		} 
	} 
        
        
	int partition(int arr[], int low, int high) 
	{ 
		int pivot = arr[high]; 
		int i = (low-1); // index of smaller element 
                System.out.println("low ="+ low+" high ="+ high+" pivot= "+ pivot+" ");
                System.out.println("Traverse from j= "+low +" to "+(high-1));
		for (int j=low; j<high; j++) 
		{ 
                    System.out.print("j ="+j);
			// If current element is smaller than the pivot 
			if (arr[j] < pivot) 
			{ 
				i++; 
                                System.out.println(" arr[j] < pivot"+ arr[j] +" < "+ pivot + " Perform , i++ and do swap");
				// swap arr[i] and arr[j] 
				int temp = arr[i]; 
				arr[i] = arr[j]; 
				arr[j] = temp; 
			} 
                        else {
                            System.out.println(" arr[j] > pivot Nothing ");
                        }
                        System.out.print("Printing Array now -> ");
                        displayArray(arr); 
		} 

                System.out.println("iteration over");
		// swap  
		int temp = arr[i+1]; 
		arr[i+1] = arr[high]; 
		arr[high] = temp; 
                System.out.println("Swap pivot and i +1");
                displayArray(arr);
		return i+1; 
	} 

	public static void main(String args[]) 
	{ 
		int arr[] = {91, 37, 42, 38, 3, 9, 62, 10, 21, 8, 34, 19, 6, 18, 21, 25}; 
		int n = arr.length; 

		Q1aQuickSortPivotLastAditi ob = new Q1aQuickSortPivotLastAditi(); 
		
                
                long start = System.nanoTime();
       ob.Quicksort(arr, 0, n-1); 
         long finish = System.nanoTime();
         long timeElapsed1 = finish - start;
                System.out.println("time taken - "+ timeElapsed1);

		System.out.println("sorted array"); 
		displayArray(arr); 
	} 
} 


