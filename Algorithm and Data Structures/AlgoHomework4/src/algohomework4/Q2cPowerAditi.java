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
public class Q2cPowerAditi {
        public static int powerInterative(int base, int power) {
        int res = 1;  
        
        while (power > 0)  
        {  
                res = res * base; 
                power--;
       
        } 
        return res;
    }
    public static int powerRecursive(int base, int power) {
       if(power>0)
           return (base*powerRecursive(base,power-1));
       else
           return 1;

    }
    
    public static void main(String[] args) {
        System.out.println("Power Iterative(x,6), x=10 is->"+ powerInterative(10, 6));
        System.out.println("Power Recursive(x,6), x=10 is->"+ powerRecursive(10, 6));
        
    }
}
