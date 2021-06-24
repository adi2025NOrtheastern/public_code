/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parallelhw1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author aditi
 */

/*
Your GradesProgram is to create 35 Student Threads each to be identified with name-<Thread-nextId>. 
The default constructor for each thread calls a method to randomly generate grades for homework,
quiz, midterm, project, and final-exam ranging between 60 to 100 inclusive. You need to consider 
.5 second wait-time between each score generation for homework, quiz, midterm, project, and final. 
Each student thread writes the grade scores to “Grades” file in this format: name, nextId,
ThreadId, homework, quiz, midterm, project and final.
All student threads share this file and you need to protect it. 

*/


class StudentThread extends Thread{
    Student student;
    String name;
    Object lock ;
    int lower = 60;
    int upper = 100;
    
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
    
    
    
    public StudentThread(Object lock)
    {
        this.setName("Thread-"+Student.nextId);
        this.student = new Student();
        this.lock = lock;
        
        generateGrades();
    }
    
    void generateGrades()
    {
        try {
            student.homework = (int) (Math.random() * (upper - lower)) + lower;
            Thread.sleep(500);
            student.project = (int) (Math.random() * (upper - lower)) + lower;
            Thread.sleep(500);//(500);
            student.quiz = (int) (Math.random() * (upper - lower)) + lower;
            Thread.sleep(500);
            student.finaL = (int) (Math.random() * (upper - lower)) + lower;
            Thread.sleep(500);
            student.midterm = (int) (Math.random() * (upper - lower)) + lower;
            Thread.sleep(500);
            student.grade = student.calculateGrade();
        } catch (InterruptedException ex) {
            Logger.getLogger(StudentThread.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("InterruptedException");
        }
    }
    
    
     @Override
     public void run() {
       writeInFile();       
        
        
        }
    
    void writeInFile()
    {
        synchronized(lock)
        {
          
         FileWriter myWriter = null;
        try {
            //create file
            myWriter = new FileWriter("C:\\aditi\\Grades.txt", true);
            //true to append
            //System.out.println("File grades created");
            //name, nextId, ThreadId, homework, quiz, midterm, project and final
            myWriter.write(student.name + ", " + Student.nextId + ", " + 
                    this.getName() + ", " + student.homework
                    + ", " + student.quiz
                    + ", " + student.midterm
                    + ", " + student.project
            + ", " + student.finaL + ", "+ student.total +", "+ student.grade+"\n");
            //myWriter.close();
            System.out.println("writing done by- "+Thread.currentThread().getName());
            
            
        } catch (IOException ex) {
            Logger.getLogger(StudentThread.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception in Grades file writing!");
        }
          catch (Exception ex) {
            System.out.println(ex);
                    
                    }
         finally {
            try {
                myWriter.close();
                
            } catch (IOException ex) {
                Logger.getLogger(StudentThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        }//while
    }
    
}
public class GradesProgram {
    public static void main(String[] args) {
        //Student[] s = new Student[36];
        Object lock = new Object();
        StudentThread[] thread = new StudentThread[36];
        for(int i=1;i<36;i++){
        //s[i] = new Student();
        thread[i] = new StudentThread(lock);
        
        thread[i].start();
        }//end for 
    }
}
