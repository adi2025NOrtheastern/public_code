/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q7;

import com.mycompany.paallelhw4.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author aditi
 */

public class GradesDriver {
    public static void main(String[] args) {
        
        Map<StudentThread, Double> map = new HashMap<>();
        Lock lock = new ReentrantLock();
        int n =51;// 51; sudentThread count
        StudentThread[] sudentThread = new StudentThread[n];
        for(int i=1;i<n;i++){
            try {
                
                sudentThread[i] = new StudentThread(map,lock);
                Thread t = new Thread(sudentThread[i]);
                //sudentThread[i].start();
                t.start();
                //t.join();
               // sudentThread[i].join();
            } //end for
            catch (Exception ex) {
                Logger.getLogger(GradesDriver.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex);
            }
        }
        
        GraderThread gt = new GraderThread(lock,map);
        gt.start();
       // System.out.println("Grader thread started..");
      
        
        
//        for(int i=1;i<n;i++){
//            try {
//                sudentThread[i].join();
//            } catch (InterruptedException ex) {
//                Logger.getLogger(GradesDriver.class.getName()).log(Level.SEVERE, null, ex);
//                System.out.println(ex);
//            }
//        }
          try {
            gt.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(GradesDriver.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gt" +ex );
        }
          
          
          
//          
//        for (int i = 0; i < n; i++) 
//            try {
//                System.out.println(sudentThread[i].get());
//            } catch (InterruptedException ex) {
//                System.out.println(ex);
//                Logger.getLogger(GradesDriver.class.getName()).log(Level.SEVERE, null, ex);
//            } 
//    } 
          
    }    
        
    
}
