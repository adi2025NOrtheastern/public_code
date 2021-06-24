/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q4;


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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aditi
 */
public class GraderThread implements Runnable{ //extends Thread {

    Lock lock;
    //Student student;
    Set<Integer> set;
    int waitTime = 10000;//100;//20000;
    Map<StudentThread, Double> map;
    int setSize = 80;//80;
    //static int count =0;

    public GraderThread(Lock lock, Map<StudentThread, Double> map) {
        this.lock = lock;
        set = new HashSet();
        this.map = map;
    }

    @Override
    public void run() {
        try {
            while (set.size() < setSize) //chnage 5 to 50
            {
                //System.out.println("set size is: " + set.size());
                Thread.sleep(waitTime);
                readFromMapCalculateGrade();

            }//while
            //System.out.println("set size is: " + set.size());
        } catch (InterruptedException ex) {
            Logger.getLogger(GraderThread.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            System.out.println("GraderThread " + Thread.currentThread().getName() + " " + ex);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("GraderThread " + Thread.currentThread().getName() + " " + e);
            //System.out.println(e);
        } finally {
            System.out.println("Grader done!!!!!!!!!!!!!!!!!!!!!!");
        }

    }

    void readFromMapCalculateGrade() {
        StudentThread stuThread;
        //List<Integer> list;
        
        String grade;
        //read from map
        for (Map.Entry<StudentThread, Double> e : map.entrySet()) {
            
            stuThread = e.getKey();
            if (set.contains(stuThread.id)) {
                // alreday processed
                continue;
            }

            //calculate grade
            System.out.println("Grader Thread: calculating for ->"+stuThread.id);
            grade = calculateGrade(e.getValue());
            stuThread.result = grade;
            //stuThread.student.grade = grade;
            //  System.out.println("Grader Thread: calculated for ->"+id +" completed.. now writing grade: "+ grade);
            //synchronously write to file 
            //writeInFileFinal(id, grade);
            //System.out.println(grade+ " grade- for"+ stuThread.getName());
            //System.out.println(stuThread.student);
            //call notifyAll()
           // notifyAll();
           //stuThread.l1.notify();
           
        synchronized(stuThread.l1) 
        { 
            stuThread.l1.notify();
            //notifyAll(); 
        } 
            set.add(stuThread.id);
        }

    }

    synchronized String calculateGrade(Double total) {
        //20% homework, 20% quiz, 25% midterm, + 15% project, 20% final
        //25% homework + 25% quiz + 15% midterm+ 15% project+20% final -- new

        String grade = "";
        //double total = (0.25 * homework + 0.25 * quiz + 0.15 * midterm + 0.15 * project + 0.2 * finaL);

        if (total >= 90) {
            grade = "A";
        } else if (total >= 80 && total < 90) {
            grade = "B";
        } else if (total >= 70 && total < 80) {
            grade = "C";
        } else if (total >= 60 && total < 70) {
            grade = "D";
        } // else if (total>= 60 && total < 70) grade ="E";
        else if (total < 60) {
            grade = "F";
        }

        return grade;
    }

    void writeInFileFinal(int id, String grade) {
        lock.lock();
        try {
            //synchronized(lock)
            //{
            FileWriter myWriter = null;
            try {
                //create file
                myWriter = new FileWriter("C:\\aditi\\FinalGradeHW5.txt", true);
                //true to append
                //System.out.println("File grades created");
                //name, nextId, ThreadId, homework, quiz, midterm, project and final
//            myWriter.write(student.name + ", " + student.id  + ", " +
//                    this.getName() + ", " + student.homework
//                    + ", " + student.quiz
//                    + ", " + student.midterm
//                    + ", " + student.project
//            + ", " + student.finaL + ", "+ student.grade+"\n");
//myWriter.close();
//System.out.println("writing done by- "+Thread.currentThread().getName()+ ". Now, byee");
                myWriter.write(id + ", " + grade + "\n");
            } catch (IOException ex) {
                Logger.getLogger(GraderThread.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
                System.out.println("Exception in Grades file writing!");
            } catch (Exception ex) {
                //System.out.println(ex);
                ex.printStackTrace();
                System.out.println("GraderThread " + Thread.currentThread().getName() + " " + ex);
            } finally {
                try {
                    myWriter.close();

                } catch (IOException ex) {
                    Logger.getLogger(GraderThread.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                    System.out.println("GraderThread " + Thread.currentThread().getName() + " " + ex);
                }
            }
            // }//while

        } finally {
            lock.unlock();
        }
        //lock.unlock();
    }

}
