/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parallelhw2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aditi
 */
public 
class StudentThread extends Thread{
    Student student;
    String name;
    Object lock ;
    int lower = 70;
    int upper = 100;
   HashMap<String, String> map;
    
    
    public StudentThread(Object lock, HashMap<String, String> map)
    {
        this.setName("Thread-"+Student.nextId);
        this.student = new Student();
        this.lock = lock;
        this.map =map;
        generateGrades();
    }
    
    void generateGrades()
    {
        try {
            student.homework = (int) (Math.random() * (upper - lower)) + lower;
            Thread.sleep(1000);
            student.project = (int) (Math.random() * (upper - lower)) + lower;
            Thread.sleep(1000);//(500);
            student.quiz = (int) (Math.random() * (upper - lower)) + lower;
            Thread.sleep(1000);
            student.finaL = (int) (Math.random() * (upper - lower)) + lower;
            Thread.sleep(1000);
            student.midterm = (int) (Math.random() * (upper - lower)) + lower;
            Thread.sleep(1000);
            //student.grade = student.calculateGrade();
        } catch (InterruptedException ex) {
            Logger.getLogger(StudentThread.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("InterruptedException");
        }
    }
    
    
     @Override
     public void run() {
        try {
            writeInFile();
            
            getGrade();
           
        } catch (Exception ex) {
            Logger.getLogger(StudentThread.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("StudentThread " +Thread.currentThread().getName()+ " " +ex);
        }
        }
    
     
     void getGrade(){
         synchronized (map) {
         try {
         while(map.get(student.name) == null )//student.grade == null)
            {
             
                 System.out.println(Thread.currentThread().getName() + " Grade is " + student.grade +" so waiting");
                 map.wait();  // for notify by grader thread
                 //wait();
                 }// while
         }catch (InterruptedException ex) {
                 Logger.getLogger(StudentThread.class.getName()).log(Level.SEVERE, null, ex);
                 System.out.println("StudentThread " +Thread.currentThread().getName()+ " " +ex);
             
            }
         
       
        
             System.out.println(Thread.currentThread().getName() +" Wait over, checking if found!");
                 
                    System.out.println(Thread.currentThread().getName() + " reading map");
                     if(map.get(student.name) != null)
                     {
                         student.grade = map.get(student.name);
                         System.out.println(Thread.currentThread().getName()+ " found data, "+ student+ " no wait");
                     }                    
               
                 System.out.println(Thread.currentThread().getName() + " Grade is " + student.grade );
                  
         }   
         
         writeInFileFinal();
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
            + ", " + student.finaL + "\n");//+ ", "+ student.total +", "+ student.grade+"\n");
            //myWriter.close();
            System.out.println("writing done by- "+Thread.currentThread().getName()+ ". Now, waiting..");
           
            
        } catch (IOException ex) {
            Logger.getLogger(StudentThread.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception in Grades file writing!");
        }
          catch (Exception ex) {
            //System.out.println(ex);
             System.out.println("StudentThread " +Thread.currentThread().getName()+ " " +ex);       
                    }
         finally {
            try {
                myWriter.close();
                
            } catch (IOException ex) {
                Logger.getLogger(StudentThread.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("StudentThread " +Thread.currentThread().getName()+ " " +ex);
            }
        }
        
        }//while
    }
    
    
    
        void writeInFileFinal()
    {
        synchronized(lock)
        {
          
         FileWriter myWriter = null;
        try {
            //create file
            myWriter = new FileWriter("C:\\aditi\\GradesFinal.txt", true);
            //true to append
            //System.out.println("File grades created");
            //name, nextId, ThreadId, homework, quiz, midterm, project and final
            myWriter.write(student.name + ", " + student.id  + ", " + 
                    this.getName() + ", " + student.homework
                    + ", " + student.quiz
                    + ", " + student.midterm
                    + ", " + student.project
            + ", " + student.finaL + ", "+ student.grade+"\n");
            //myWriter.close();
            System.out.println("writing done by- "+Thread.currentThread().getName()+ ". Now, byee");
           
            
        } catch (IOException ex) {
            Logger.getLogger(StudentThread.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception in Grades file writing!");
        }
          catch (Exception ex) {
            //System.out.println(ex);
             System.out.println("StudentThread " +Thread.currentThread().getName()+ " " +ex);       
                    }
         finally {
            try {
                myWriter.close();
                
            } catch (IOException ex) {
                Logger.getLogger(StudentThread.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("StudentThread " +Thread.currentThread().getName()+ " " +ex);
            }
        }
        
        }//while
    }
    
}
