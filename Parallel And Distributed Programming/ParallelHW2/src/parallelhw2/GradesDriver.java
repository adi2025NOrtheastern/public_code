/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parallelhw2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author aditi
 */

public class GradesDriver {
    public static void main(String[] args) {
        
        HashMap<String, String> map = new HashMap<>();
        Object lock = new Object();
        int n =51;// 51; thread count
        StudentThread[] thread = new StudentThread[n];
        for(int i=1;i<n;i++){
            try {
                
                thread[i] = new StudentThread(lock, map);
                
                thread[i].start();
                System.out.println(thread[i].getName() +" started.." );
               // thread[i].join();
            } //end for
            catch (Exception ex) {
                Logger.getLogger(GradesDriver.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex);
            }
        }
        
        GraderThread gt = new GraderThread(lock,map);
        gt.start();
        System.out.println("Grader thread started..");
      
        
        
        for(int i=1;i<n;i++){
            try {
                thread[i].join();
            } catch (InterruptedException ex) {
                Logger.getLogger(GradesDriver.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex);
            }
        }
          try {
            gt.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(GradesDriver.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gt" +ex );
        }
        
    }
}
