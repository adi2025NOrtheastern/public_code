///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package parallelhw1;
//
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
///**
// *
// * @author aditi
// */
//class Table {
//
//    synchronized void printTable(int n) {//synchronized method  
//       
//                        
//               for (int i = 1; i <= 5; i++) {
//                   System.out.println(n * i);
//                   try {
//                       Thread.sleep(400);
//                   } catch (Exception e) {
//                       System.out.println(e);
//                   }
//               }     
//    }
//}
//
//class MyThread1 extends Thread {
//
//    Table t;
//
//    MyThread1(Table t) {
//        this.t = t;
//    }
//
//    public void run() {
//        synchronized(t)
//        {
//            
//                t.printTable(5);
//               
//      
//    }
//}
//}
//
//class MyThread2 extends Thread {
//
//    Table t;
//
//    MyThread2(Table t) {
//        this.t = t;
//    }
//
//    public void run() {
//        synchronized(t)
//        {
//                t.printTable(100);
//               
//    }
//    }
//}
//
//public class Q9Aditi1 //TestSynchronization2{  
//{
//
//    public static void main(String args[]) {
//        Table obj1 = new Table();
//        Table obj2 = new Table();
//        MyThread1 t1 = new MyThread1(obj1);
//        MyThread2 t2 = new MyThread2(obj2);
//        t1.start();
//        t2.start();
//    }
//}
