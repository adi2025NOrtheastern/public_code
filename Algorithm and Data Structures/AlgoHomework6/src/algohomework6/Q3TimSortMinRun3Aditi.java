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
public class Q3TimSortMinRun3Aditi 
{ 

	static int MIN_ELEMENT_SIZE = 3; 

	

	
	public static void insertionSort(int[] inputArray, int left, int right) 
	{ 
		for (int i = left + 1; i <= right; i++) 
		{ 
			int temp = inputArray[i]; 
			int j = i - 1; 
			while (j >= left && inputArray[j] > temp) 
			{ 
                            System.out.print("  Swap "+ inputArray[j+1]+ " and " + inputArray[j] );
				inputArray[j + 1] = inputArray[j]; 
				j--; 
			} 
                        System.out.println("");
			inputArray[j + 1] = temp; 
                      //  System.out.println("Array is-> ");
                       // displayAr(inputArray, inputArray.length);
		} 
	} 

        public static void timSort(int[] inputArray, int n) 
	{ 
		int minRun = numberMinLengthRun(MIN_ELEMENT_SIZE); 
		
		for (int i = 0; i < n; i += minRun) 
		{ 
                    System.out.println("insertionSort(inputArray, "+i+" , Math.min(( "+(i + 2) + " , "+ (n-1)+ " ))");
			insertionSort(inputArray, i,Math.min((i + 2), (n - 1))); 
		} 
                System.out.println("running merge if size > 3");
		for (int size = minRun; size < n; size = 2 * size) 
		{ 	//System.out.println("hello");		
			for (int left = 0; left < n;left += 2 * size) 
			{ 
				int mid = left + size - 1; 
				int right = Math.min((left + 2 * size - 1),(n - 1)); 
                                System.out.println("Merge array, "+ left +" , "+ mid +" , "+right);
				merge(inputArray, left, mid, right); 
			} 
		} 
	}
        public static int numberMinLengthRun(int n) 
	{ 
		assert n >= 0; 
		
		int r = 0; 
		while (n >= MIN_ELEMENT_SIZE) 
		{ 
			r |= (n & 1); 
			n >>= 1; 
		} 
		return n + r; 
	} 
        
	public static void mergeUseless(int[] inputArray, int l, int m, int r) 
	{ 
		int len1 = m - l + 1, len2 = r - m; 
		int[] left = new int[len1]; 
		
		for (int x = 0; x < len1; x++) 
		{ 
			left[x] = inputArray[l + x]; 
                        System.out.println("l= "+l +" x= "+x);
		} 
                int[] right = new int[len2]; 
		for (int x = 0; x < len2; x++) 
		{ 
			right[x] = inputArray[m + 1 + x]; 
		} 
                int k = l; 
		int i = 0; 
		int j = 0; 
		

		while (i < len1 && j < len2) 
		{ 
			if (left[i] <= right[j]) 
			{ 
				inputArray[k] = left[i]; 
				i++; 
			} 
			else { 
				inputArray[k] = right[j]; 
				j++; 
			} 
			k++; 
		} 

		
		while (i < len1) 
		{ 
			inputArray[k] = left[i]; 
			k++; 
			i++; 
		} 

		while (j < len2) 
		{ 
			inputArray[k] = right[j]; 
			k++; 
			j++; 
		} 
                System.out.println("After merge ->");
                displayAr(inputArray, inputArray.length);
	} 
        
        
        public static void merge(int arr[], int leftIndex, int mid, int rightIndex) {

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
     //   System.out.println("After merge ->");
         //       displayAr(inputArray, inputArray.length);
    }


	 
	//  display the Array 
	public static void displayAr(int[] inputArray, int n) 
	{ 
		for (int i = 0; i < n-1; i++) { 
			System.out.print(inputArray[i] + " ,  "); 
		} 
                System.out.print(inputArray[n-1]);
		System.out.print("\n"); 
	} 

	public static void main(String[] args) 
	{ 
		int[] inputArrayInput = {91, 37, 42, 38, 3, 9, 62, 10, 21, 8, 34, 19, 6, 18, 21, 25}; 
		int n = inputArrayInput.length; 
		System.out.println("Input Array is -"); 
		displayAr(inputArrayInput, n); 

		timSort(inputArrayInput, n); 

		System.out.println("After Sorting Array is -"); 
		displayAr(inputArrayInput, n); 
	} 
} 

