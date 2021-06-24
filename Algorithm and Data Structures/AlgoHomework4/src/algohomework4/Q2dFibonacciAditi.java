/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algohomework4;

/**
 *
 * @author aditi
 */
public class Q2dFibonacciAditi {
    public static int fibonacciRecursive(int n) 
    { 
    if (n <= 1) 
       return n; 
    return fibonacciRecursive(n-1) + fibonacciRecursive(n-2); 
    } 
     public int fibonacciIterative(int n) {
		if(n <= 1) {
			return n;
		}
		int a = 1;
		int b = 1;
		
		for(int i=2; i<n; i++) {
			int temp = a;
			a+= b;
			b = temp;
		}
		return a;
	}
       
    public static void main (String args[]) 
    { 
    int n = 6; 
    System.out.println("Recursive fibonacci(6)="+fibonacciRecursive(n)); 
    n = 7; 
    System.out.println("Recursive fibonacci(7)"+fibonacciRecursive(n));
    
    n = 6; 
    System.out.println("Iterative fibonacci(6)="+fibonacciRecursive(n)); 
    n = 7; 
    System.out.println("Iterative fibonacci(7)"+fibonacciRecursive(n));
    
    } 
}
