/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algohomework4;

import java.util.Vector;

/**
 *
 * @author aditi
 */
public class Q3GrayCodeAditi {
    

static int num; 
  

public static void helperGrayCode(int n,Vector<Integer> answer) 
{ 

    if (n == 0) 
    { 
        answer.add(num); 
        return; 
    } 
  
    // ignore the bit. 
    helperGrayCode(n - 1,answer); 
  
    // invert the bit. 
    num = num ^ (1 << (n - 1)); 
    helperGrayCode( n - 1,answer); 
} 
  public static void main(String[] args) 
{ 
    int n = 6; 
    Vector<Integer> code = generateGrayCodes(n); 
    for (int i = 0; i < code.size(); i++)  
        System.out.print(Integer.toBinaryString(code.get(i)) +"\n");  
} 

public static Vector<Integer> generateGrayCodes(int n) 
{ 
    Vector<Integer> finalAns = new Vector<Integer>(); 
  
    num = 0; 
    helperGrayCode(n,finalAns); 
  
    return finalAns; 
} 
  
 

} 
  