/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q4;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aditi
 */
public 
class StudentThread implements Runnable, Callable{  //extends Thread 
    Student student;
    int id;
    String name;
    Object l1;
    Object result=null;
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    Lock lock ;
    int lower = 70;
    int upper = 100;
   //HashMap<String, String> map;
   
   Map<StudentThread, Double> scoresHashmap;
   static int count=0;
    
    
    public StudentThread( Map<StudentThread, Double> scoresHashmap, Lock lock)
    {
        
        //this.student = stu;//new Student();
        this.lock = lock;
        this.scoresHashmap =scoresHashmap;
        this.l1 = new Object();
                
        //this.id = student.id;
        //generateGrades();
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
    
      public synchronized Object get() 
          throws InterruptedException 
    { 
        synchronized(l1){
        while (result==null ) 
        {  System.out.println(Thread.currentThread().getName()+" is waiting as result is: "+result);
            l1.wait(); 
        }}
        System.out.println(Thread.currentThread().getName()+" is "+result +" after wait, wait over!!!");
        return result; 
    } 
    
    
    
     @Override
     public void run() {
        try {
            
            this.student = new Student();
            this.id = student.id;
            this.setName("Thread-"+student.id);
            generateGrades();
            //calculate avergae ans store in map
            this.student.average = (student.finaL + student.homework
                    +  student.quiz
                    +  student.midterm
                    +  student.project) / 5;
            
            
            writeMap();
            System.out.println(this.getName()+" wrote in map");
           
           this.student.grade = (String) this.get();
            //while(student.grade.equals(""))
            //{
            //readGradeFromFile();
            //}
            System.out.println(student);
            writeInFileFinal();
            //System.out.println(Thread.currentThread().getName()+" done!!");
           //count++;
           
        
            //System.out.println("++++++++++++++++++++++++++++++++++++++Count= "+count);
        } catch (Exception ex) {
            Logger.getLogger(StudentThread.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            System.out.println("StudentThread " +Thread.currentThread().getName()+ " " +ex);
        }
        }
     @Override
    public Object call() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        // System.out.println("in call()");
         //return this;
        // throw new Exception();
    }
     
    void writeMap(){
        //write in scoresHashmap
           //synchronized(scoresHashmap)
           lock.lock();
           
           //{
              // System.out.println(Thread.currentThread().getName() +" going in scoresHashmap to write marks.");
               scoresHashmap.put(this,this.student.average);
               lock.unlock();
               //System.out.println(scoresHashmap);
             //  System.out.println(Thread.currentThread().getName() +" wrote in scoresHashmap.");
          // }
    }
  void readGradeFromFile(){
        BufferedReader br = null;
       
            try {
                //read from file
                
                String line;
                br = new BufferedReader(new FileReader("C:\\aditi\\FinalGradeHW5.txt"));
                try {
                    //Reading
                    while ((line = br.readLine()) != null) {
                        
                        //todo//System.out.println("Student thread reading -> "+line);
                        String[] tokens = line.split(", ");
                        int id = Integer.parseInt(tokens[0]);
                        
                        if(id == this.id)
                        {
                            this.student.grade = tokens[1];
                            //System.out.println("got grade");
                            System.out.println( this.student);
                        }
                      
               }
                 //   br.close();
                    
                } catch (IOException ex) {
                    Logger.getLogger(StudentThread.class.getName()).log(Level.SEVERE, null, ex);
                     ex.printStackTrace(); 
                    System.out.println("StudentThread " +Thread.currentThread().getName()+ " " +ex);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(StudentThread.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
                System.out.println("StudentThread " +Thread.currentThread().getName()+ " " +ex);
            }
            
            finally {
            try {
                br.close();
                
            } catch (IOException ex) {
                Logger.getLogger(StudentThread.class.getName()).log(Level.SEVERE, null, ex);
                 ex.printStackTrace();
                System.out.println("StudentThread " +Thread.currentThread().getName()+ " " +ex);
            }
        }


        
    }
       
     
    
    
    void writeInFileFinal()
    {
        synchronized(lock)
        {
          
         FileWriter myWriter = null;
        try {
            //create file
            myWriter = new FileWriter("C:\\aditi\\FinalGradeHW5.txt", true);
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
