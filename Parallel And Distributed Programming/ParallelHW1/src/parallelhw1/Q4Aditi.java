/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parallelhw1;

/**
 *
 * @author aditi
 */
/*
Create interface-I that extends interface-I1 with m1(), m2(), m3() methods, 
and inter-face-I2 with m3() and m4() methods. Create class A that
implements interface-I. The implementation of each method must print the name of method. 
Create a Test class that instantiates an object of class A but uses interface-I as its type.
The Test class must execute all the methods of class A. Compile and run the code.
*/


interface I1{
    void m1();
    void m2();
    void m3();
    
}
interface I2{
    void m3();  
    void m4();
    
}

interface I extends I1, I2
{
    
}

class A implements I{

    @Override
    public void m1() {
        System.out.println("m1");
    }

    @Override
    public void m2() {
        System.out.println("m2");
    }

    @Override
    public void m3() {
        System.out.println("m3");
    }

    @Override
    public void m4() {
      System.out.println("m4");
    }
    
}

class Test{
    public static void main(String[] args) {
         I object = new A();
    object.m1();
    object.m2();
    object.m3();
    object.m4();
    //System.out.println("hii");
    }
}


public class Q4Aditi {
    
}
