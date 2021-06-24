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

/*
Design a program that creates 20 Student objects with each student is size of 20 bytes. 
The JVM heap size is 500 bytes. Your program design should consider scenario where 
10 objects become Unreferenced for garbage collection. Provide the 
design criterion for Minor GC and Major GC. You should provide the detail design for JVM managing 
garbage collector memory management.



*/
class Student{
    String fname ;//2byte
    String lname ;//2byte
    int marks1; //4 bytes
    int marks2; //4 bytes
    int marks3; //4 bytes
    int marks4; //4 bytes
    
    
    
}


public class Q10Aditi {
    public static void main(String[] args) {
        Student[] s = new Student[20];
        for(int i=0;i<20;i++){
            s[i]= new Student();
        }
        
        //unrefernce 10 objects
        for(int i=0;i<10;i++){
            s[i]= null;
        }
        System.gc();
    }
}
