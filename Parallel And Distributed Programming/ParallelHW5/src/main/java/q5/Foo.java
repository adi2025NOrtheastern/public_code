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


public class Foo {
    static public void main(String args[]) throws Exception {
        System.out.println("Foo Constructor >>> " + args[0] + " " + args[1]);
        Bar bar = new Bar(args[0], args[1]);
        bar.printCL();
        Student stu = new Student();
        stu.printCL();
    }
 
    public static void printCL() {
        System.out.println("Foo ClassLoader: "+Foo.class.getClassLoader());
    }
}

