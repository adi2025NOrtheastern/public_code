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
public class Q4BubbleAditi 
{ 
    void bubbleSort(int inputArray[]) 
    { 
        int n = inputArray.length; 
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (inputArray[j] > inputArray[j+1]) 
                { 
                   // System.out.println(inputArray[j]+ " > "+ inputArray[j+1]+"=> swap "+inputArray[j+1] +" "+ inputArray[j] );
                    int temp = inputArray[j]; 
                    inputArray[j] = inputArray[j+1]; 
                    inputArray[j+1] = temp; 
                } 
                System.out.print("for j= "+j + " arr -> ");
                display(inputArray);
            }
            System.out.println("in pass "+(i+1) + " element at its position -> "+inputArray[n-i-1]);
                display(inputArray);
        }
    } 
  
    /* Prints the inputArrayay */
    void display(int inputArray[]) 
    { 
        int n = inputArray.length; 
        for (int i=0; i<n-1; ++i) 
            System.out.print(inputArray[i] + " , "); 
        System.out.println(inputArray[n-1]);
       // System.out.println(); 
    } 
   
    public static void main(String args[]) 
    { 
        Q4BubbleAditi ob = new Q4BubbleAditi(); 
        int inputArray[] = {91, 37, 42, 38, 3, 9, 62, 10, 21, 8, 34, 19, 6, 18, 21, 25}; 
        ob.display(inputArray); 
        ob.bubbleSort(inputArray); 
        System.out.println("Sorted inputArrayay"); 
        ob.display(inputArray); 
    } 
} 