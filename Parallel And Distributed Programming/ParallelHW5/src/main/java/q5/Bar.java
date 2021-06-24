/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q5;

/**
 *
 * @author aditi
 */
 
public class Bar {
 
    public Bar(String a, String b) {
        System.out.println("Bar Constructor >>> " + a + " " + b);
    }
 
    public void printCL() {
        System.out.println("Bar ClassLoader: "+Bar.class.getClassLoader());
    }
}
