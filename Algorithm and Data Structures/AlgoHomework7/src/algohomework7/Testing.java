/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algohomework7;

/**
 *
 * @author aditi
 */

class Test{  
 static synchronized void printTable(int n){ //synchronized method  
   for(int i=1;i<=5;i++){  
     System.out.println(n*i);  
     try{  
      Thread.sleep(400);  
     }catch(Exception e){System.out.println(e);}  
   }  
 }  
} 

class MyThread1 extends Thread{  
Test t;  
MyThread1(Test t){  
this.t=t;  
}  
public void run(){  
t.printTable(5);  
}  
}  
class MyThread2 extends Thread{  
Test t;  
MyThread2(Test t){  
this.t=t;  
}  
public void run(){  
t.printTable(100);  
}  }  
 
public class Testing{  
public static void main(String args[]){  
Test obj[] = new Test[2]; 

MyThread1 t1=new MyThread1(obj[0]);  
MyThread2 t2=new MyThread2(obj[1]);  
t1.start();  t2.start();  }}
