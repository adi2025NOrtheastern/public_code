/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parallelhw3.Q5;

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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aditi
 */
public 
class StudentThread extends Thread{
    Student student;
    int id;
    String name;
    Object lock ;
    int lower = 70;
    int upper = 100;
   //HashMap<String, String> map;
   List<Integer> list = new ArrayList();
   Map<Integer, List<Integer>> map;
   static int count=0;
    
    
    public StudentThread( Map<Integer, List<Integer>> map, Object lock)
    {
        
        //this.student = stu;//new Student();
        this.lock = lock;
        this.map =map;
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
    
    
     @Override
     public void run() {
        try {
            
            this.student = new Student();
            this.id = student.id;
            this.setName("Thread-"+student.id);
            list = new ArrayList<>();
            //System.out.println(this.id +" started.." );
            Thread.sleep(1000L);
            //generate grades
            int hw = (int) (Math.random()*30) + 70;
            student.homework = hw;
            list.add(hw);
            writeMap();
            Thread.sleep(1000L);
            
            int project = (int) (Math.random()*30) + 70;
            student.project = project;                     
            list.add(project);
            writeMap();
            Thread.sleep(1000L);
            
            
            int quiz = (int) (Math.random()*30) + 70;
            student.quiz = quiz;
            list.add(quiz);
            writeMap();
            Thread.sleep(1000L);
            
            
            int finaL = (int) (Math.random()*30) + 70;
            student.finaL = finaL;
            list.add(finaL);
            writeMap();
            Thread.sleep(1000L);
            
            
            int midterm = (int) (Math.random()*30) + 70;
            student.midterm = midterm;
            list.add(midterm);
            writeMap();
            Thread.sleep(1000L);
            
           
           
           
            while(student.grade.equals(""))
            {
            readGradeFromFile();
            }
            
            //System.out.println(Thread.currentThread().getName()+" done!!");
           count++;
            //System.out.println("++++++++++++++++++++++++++++++++++++++Count= "+count);
        } catch (Exception ex) {
            Logger.getLogger(StudentThread.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            System.out.println("StudentThread " +Thread.currentThread().getName()+ " " +ex);
        }
        }
    
     
    void writeMap(){
        //write in map
           synchronized(map)
           {
              // System.out.println(Thread.currentThread().getName() +" going in map to write marks.");
               map.put(this.id,list);
               //System.out.println(map);
             //  System.out.println(Thread.currentThread().getName() +" wrote in map.");
           }
    }
  void readGradeFromFile(){
        BufferedReader br = null;
       
            try {
                //read from file
                
                String line;
                br = new BufferedReader(new FileReader("C:\\aditi\\FinalGrades.txt"));
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
            myWriter = new FileWriter("C:\\aditi\\FinalGrades.txt", true);
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
