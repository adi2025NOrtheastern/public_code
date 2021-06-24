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
public class Q2aFactorialAditi {
      public static int factorial(int n) {
        if (n <= 1){
            System.out.println("n =1");
           return 1;
        }
        else
        {
                    
            System.out.println("calculating "+n+" *factorial of" + (n-1));
           return n * factorial(n - 1);
      }
}

      
      public static void main(String[] args) {
          System.out.println("Factorial for 6 ->"+factorial(6));
    }

}