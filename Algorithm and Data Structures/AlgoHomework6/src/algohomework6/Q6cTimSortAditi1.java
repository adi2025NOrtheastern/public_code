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
public class Q6cTimSortAditi1 
{ 

	static int MIN_ELEMENT_SIZE = 3; 

	

	
	public static void insertionSort(char[] inputArray, int left, int right) 
	{ 
		for (int i = left + 1; i <= right; i++) 
		{ 
			char temp = inputArray[i]; 
			int j = i - 1; 
			while (j >= left && inputArray[j] > temp) 
			{ 
                            System.out.print("  Swap "+ inputArray[j+1]+ " and " + inputArray[j] );
				inputArray[j + 1] = inputArray[j]; 
				j--; 
			} 
                        System.out.println("");
			inputArray[j + 1] = temp; 
                        System.out.println("Array is-> ");
                        displayAr(inputArray, inputArray.length);
		} 
	} 

        public static void timSort(char[] inputArray, int n) 
	{ 
		int minRun = numberMinLengthRun(MIN_ELEMENT_SIZE); 
		
		for (int i = 0; i < n; i += minRun) 
		{ 
                    System.out.println("insertionSort on inputArray, "+i+" , Math.min of "+(i + 2) + " , "+ (n-1));
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
        
	public static void merge(char[] inputArray, int l, int m, int r) 
	{ 
		int len1 = m - l + 1, len2 = r - m; 
		char[] left = new char[len1]; 
		
		for (int x = 0; x < len1; x++) 
		{ 
			left[x] = inputArray[l + x]; 
		} 
                char[] right = new char[len2]; 
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

	 
	//  display the Array 
	public static void displayAr(char[] inputArray, int n) 
	{ 
		for (int i = 0; i < n-1; i++) { 
			System.out.print(inputArray[i] + " ,  "); 
		} 
                System.out.print(inputArray[n-1]);
		System.out.print("\n"); 
	} 

	public static void main(String[] args) 
	{ 
		char[] inputArrayInput = {'M','E','R','G','E','S','O','R','T','E','X','A','M','P','L','E'}; 
                int n = inputArrayInput.length; 
		System.out.println("Input Array is -"); 
		displayAr(inputArrayInput, n); 

		timSort(inputArrayInput, n); 

		System.out.println("After Sorting Array is -"); 
		displayAr(inputArrayInput, n); 
	} 
} 

