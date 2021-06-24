/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import parallelhw1.*;
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
    static boolean lock = true;
    int lower = 60;
    int upper = 100;
    
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
    
    
    
    public StudentThread(Student s)
    {
        this.student = s;
        generateGrades();
    }
    
    void generateGrades()
    {
       // try {
            student.homework = (int) (Math.random() * (upper - lower)) + lower;
           // Thread.sleep(5);
            student.project = (int) (Math.random() * (upper - lower)) + lower;
           // Thread.sleep(5);//(500);
            student.quiz = (int) (Math.random() * (upper - lower)) + lower;
           // Thread.sleep(5);
            student.finaL = (int) (Math.random() * (upper - lower)) + lower;
           // Thread.sleep(5);
            student.midterm = (int) (Math.random() * (upper - lower)) + lower;
            //Thread.sleep(5);
            student.grade = student.calculateGrade();
     //   } //catch (InterruptedException ex) {
           // Logger.getLogger(StudentThread.class.getName()).log(Level.SEVERE, null, ex);
           // System.out.println("InterruptedException");
      //  }
    }
    
    
     @Override
     public void run() {
       writeInFile();       
        
        
        }
    
    synchronized void writeInFile()
    {
        while(lock)
        {
            lock = false;
         FileWriter myWriter = null;
        try {
            //create file
            myWriter = new FileWriter("C:\\Grades.txt", true);
            //true to append
            System.out.println("File grades created");
            //name, nextId, ThreadId, homework, quiz, midterm, project and final
            myWriter.write(student.name + ", " + Student.nextId + ", " + 
                    this.getName() + ", " + student.homework
                    + ", " + student.quiz
                    + ", " + student.midterm
                    + ", " + student.project
            + ", " + student.finaL + ", "+ student.total +", "+ student.grade);
            //myWriter.close();
            System.out.println("writing done by- "+this.name);
            
            
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
        lock = true;
        }//while
    }
    
}
public class GradesProgram {
    public static void main(String[] args) {
        Student[] s = new Student[36];
      //  StudentThread[] thread = new StudentThread[36];
        for(int i=1;i<36;i++){
        s[i] = new Student();
        s[i].calculateGrade();
      //  thread[i] = new StudentThread(s[i]);
      //  thread[i].setName("Thread-"+Student.nextId);
      //  thread[i].start();
        }//end for 
      
        
        
        
    }

   
}
