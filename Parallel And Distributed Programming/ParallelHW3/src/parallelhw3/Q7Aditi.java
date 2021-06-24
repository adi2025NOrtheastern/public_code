/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parallelhw3;

/**
 *
 * @author aditi
 */

public class Q7Aditi extends Thread {
     //String name;
    public Q7Aditi(String name)
    {
        this.setName(name);
        
    }
    @Override
     public void run() {
         System.out.println(calculate(1,1,1));
     }
    
     public int calculate (int i, int j, int k) {
		int a = i * j * k + k * i + 20 ;
		return a;
    }
    
   
    public static void main(String[] args) {
         Q7Aditi t1 = new Q7Aditi("Thread-Aditi");
    t1.start();
  
    
    }
    
   
}
