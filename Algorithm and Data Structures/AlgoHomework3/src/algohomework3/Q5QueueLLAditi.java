/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algohomework3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



 /*class User{
    private int id;
    private String firstName;
    private String lastName;       
    private String course ;
       
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getCourse() {
            return course;
        }

        public void setCourse(String course) {
            this.course = course;
        }
        
    @Override
    public String toString() { 
        if(this.firstName== null)
            return ("****MyStackError: Underflow- NO element!!**Empty Stack**");
        return (getId() + " " + getFirstName() + " " + getLastName() + " " + getCourse());
     
    } 
        
}*/
public class Q5QueueLLAditi {
    
       
    public static void main(String[] args) {
        try {
            BufferedReader bufReader = null;
            try {
                bufReader = new BufferedReader(new FileReader("C:\\Users\\aditi\\Desktop\\input.txt"));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Q5QueueLLAditi.class.getName()).log(Level.SEVERE, null, ex);
            }
            ArrayList<String> listOfLines = new ArrayList<>();
            String line = bufReader.readLine();
           
           
            while (line != null) {
                listOfLines.add(line);
                line = bufReader.readLine();
            }
            QueueGenericLLAditi<User> s1 = new QueueGenericLLAditi<>();
             
            
            System.out.println("Enqueue all elements...");
            for(int i=0;i<10;i++)
            {
                User uobj = new User();
                 String[] data= listOfLines.get(i).split(",");
                uobj.setId(Integer.parseInt(data[0]));
                uobj.setFirstName(data[1]);
                uobj.setLastName(data[2]);
                uobj.setCourse(data[3]);
                 
                s1.enqueue(uobj);
            }
            s1.printQueue();
            //d 4 elements
            System.out.println("Dequeue 4 elements...");
            for(int i=0;i<4;i++)
                System.out.println(s1.dequeue());
            
             System.out.println("Enqueue all elements...");
            for(int i=0;i< listOfLines.size()  ;i++)                
            {
                User uobj = new User();
                 String[] data= listOfLines.get(i).split(",");
                uobj.setId(Integer.parseInt(data[0]));
                uobj.setFirstName(data[1]);
                uobj.setLastName(data[2]);
                uobj.setCourse(data[3]);
                 
                s1.enqueue(uobj);
            }
            s1.printQueue();
            //d all elements
            System.out.println("Dequeue all elements...");
            while(!s1.isEmpty()){
                System.out.println(s1.dequeue());
                
            }
            //d 1 elements
            System.out.println("Dequeue 1 element...");
            
                System.out.println(s1.dequeue());
            
                  System.out.println("Enqueue all elements...");
            for(int i=0;i< listOfLines.size()  ;i++)                
            {
                User uobj = new User();
                 String[] data= listOfLines.get(i).split(",");
                uobj.setId(Integer.parseInt(data[0]));
                uobj.setFirstName(data[1]);
                uobj.setLastName(data[2]);
                uobj.setCourse(data[3]);
                 
                s1.enqueue(uobj);
            }
            s1.printQueue();
                
             System.out.println("Enqueue 11 John Johnson Java Programming...");
          
                String input2="11,John,Johnson,Java Programming";
                User uobj = new User();
                 String[] data= input2.split(",");
                uobj.setId(Integer.parseInt(data[0]));
                uobj.setFirstName(data[1]);
                uobj.setLastName(data[2]);
                uobj.setCourse(data[3]);
                 
                s1.enqueue(uobj);
            
                System.out.println("Now queue is...");
                s1.printQueue();
                
                
                System.out.println("Print queue with the goal- Reverse order");
                System.out.println("Use q1 and q2, on new element dequeue all from q1 to q2 "
                        + "and enqueue new element to q1 and dequeue q2 and enqueue all to q1");
                 //System.out.println("Pushing all elements...");
                 QueueGenericLLAditi<User> s2 = new QueueGenericLLAditi<User>();
                 s1=new QueueGenericLLAditi<User>();
            for(int i=0;i< listOfLines.size()  ;i++)
            {
                User uobj1 = new User();
                String[] data1= listOfLines.get(i).split(",");
                uobj1.setId(Integer.parseInt(data1[0]));
                uobj1.setFirstName(data1[1]);
                uobj1.setLastName(data1[2]);
                uobj1.setCourse(data1[3]);
                 
                if(s1.isEmpty())
                s1.enqueue(uobj1);
                else
                {
                    while(!s1.isEmpty())
                    {
                        s2.enqueue(s1.dequeue());
                        
                    }
                    s1.enqueue(uobj1);
                     while(!s2.isEmpty())
                    {
                        s1.enqueue(s2.dequeue());
                        
                    }
                }
            }
            System.out.println("Priting final queue- ");
             while(!s1.isEmpty())
                {
                    System.out.println(s1.dequeue());
                }
             s1=new QueueGenericLLAditi<User>();

                System.out.println("Print queue with the goal- Original order");
                 System.out.println("Enqueu all elements...then dequeue all to get original order");
            for(int i=0;i< listOfLines.size()  ;i++)
            {
                User uobj1 = new User();
                String[] data1= listOfLines.get(i).split(",");
                uobj1.setId(Integer.parseInt(data1[0]));
                uobj1.setFirstName(data1[1]);
                uobj1.setLastName(data1[2]);
                uobj1.setCourse(data1[3]);
                 
                s1.enqueue(uobj1);
            }
            
            
           
                System.out.println("Dequeuing all elements in the original order...");
                while(!s1.isEmpty())
                {
                    System.out.println(s1.dequeue());
                }
                
                
                
            //close buffer reader
            bufReader.close();
        } catch (IOException ex) {
            Logger.getLogger(Q5QueueLLAditi.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    
   

}
