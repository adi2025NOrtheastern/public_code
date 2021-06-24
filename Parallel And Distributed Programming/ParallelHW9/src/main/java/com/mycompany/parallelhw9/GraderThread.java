/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.parallelhw9;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aditi
 */

public class GraderThread extends Thread {

    Lock lock;
    //Lock lock;
    Student student;
    Set set;
    int waitTime = 20000;//100;//20000;
    HashMap<String, String> map;
    //static int count =0;
    public GraderThread(Lock lock, HashMap<String, String> map){
        this.lock = lock;
        set = new HashSet();
        this.map = map;
    }
    @Override
    public void run() {
        try {
            while(set.size() < 100) //chnage 5 to 50
            {
               // System.out.println("set size is: " + set.size());
            Thread.sleep(waitTime);
            readFromFile();
            }//while
            
            System.out.println("Grader done!");
        } catch (InterruptedException ex) {
            Logger.getLogger(GraderThread.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("GraderThread " +Thread.currentThread().getName()+ " " +ex);
        }
        catch(Exception e)
        {
              System.out.println("GraderThread " +Thread.currentThread().getName()+ " " +e);
            //System.out.println(e);
        }
        
    }
    
    void readFromFile(){
        BufferedReader br = null;
        //synchronized(lock)
        //{
            try {
                //read from file
                lock.lock();
                String line;
                br = new BufferedReader(new FileReader("C:\\aditi\\GradesHW9.txt"));
                try {
                    //Reading
                    while ((line = br.readLine()) != null) {
                        
                        System.out.println("Grader thread processing -> "+line);
                        String[] tokens = line.split(", ");
                        String name = tokens[0];
                        
                        //if already processed
                        if(set.contains(name))
                        {
                            continue;
                        }
                        int nextId = Integer.parseInt(tokens[1]);
                        String thread = (tokens[2]);
                        int homework = Integer.parseInt(tokens[3]);
                        int quiz = Integer.parseInt(tokens[4]);
                        int midterm = Integer.parseInt(tokens[5]);
                        int project = Integer.parseInt(tokens[6]);
                        int finaL = Integer.parseInt(tokens[7]);
                   
                        //process it and calculateGrade
                        String grade = calculateGrade(homework, quiz, midterm, project, finaL);
                        System.out.println("Grade calculated-> name +"+ name +" Thread " + thread + " Grade: "+grade );
                        set.add(name);
                        
                        //add in hashmap
                        //synchronized(map){
                      //  lock2.lock();
                        map.put(name, grade);
                           // System.out.println(map);
                      //  lock2.unlock();
                       // map.notifyAll();
                       // }
                      //  lock.notify();
                    }
                    br.close();
                   lock.unlock();
                } catch (IOException ex) {
                    Logger.getLogger(GraderThread.class.getName()).log(Level.SEVERE, null, ex);
                      System.out.println("GraderThread " +Thread.currentThread().getName()+ " " +ex);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GraderThread.class.getName()).log(Level.SEVERE, null, ex);
                  System.out.println("GraderThread " +Thread.currentThread().getName()+ " " +ex);
            }
            
            finally {
            try {
                br.close();
                
            } catch (IOException ex) {
                Logger.getLogger(GraderThread.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("GraderThread " +Thread.currentThread().getName()+ " " +ex);
            }
        }


      //  }
    }
    
    
    synchronized String calculateGrade(int homework, int quiz, int midterm, int project, int finaL){
        //20% homework, 20% quiz, 25% midterm, + 15% project, 20% final
        //25% homework + 25% quiz + 15% midterm+ 15% project+20% final -- new

        String grade = "";
        double total = (0.25 * homework + 0.25 * quiz + 0.15 * midterm + 0.15 * project + 0.2 * finaL) ;
        if(total >=90) grade = "A";
        else if (total>= 80 && total < 90) grade ="B";
        else if (total>= 70 && total < 80) grade ="C";
        else if (total>= 60 && total < 70) grade ="D";
       // else if (total>= 60 && total < 70) grade ="E";
        else if (total< 60) grade ="F";
        
        return grade;
    }
    
}