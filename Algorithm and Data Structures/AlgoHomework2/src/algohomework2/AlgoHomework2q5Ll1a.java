/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algohomework2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

class MyStack1{
private Node top ;
private int s; //size

private class Node{
    User obj;
    Node next;
    }    

public MyStack1(){
    top=null;
    s=0;
}

public void push(User a)
{
    Node n= new Node();
    //String[] s = a.split(",");
    n.obj=a;
    
    
    if(! isEmpty())
    {
      n.next=top;
    }
    else
    {
        n.next = null;
    }
    
    top=n;
    s++;
}

public User pop()
{
    
    User n = null;
    if(!isEmpty())
    {
     n = top.obj;
     top=top.next;
     s--;
    }
    else return new User();  //empty User to say that stack is empty -- Underflow
    return n;
}


public boolean isEmpty()
{
    return (top==null) ;
}

public int size(){
    return s;
}

}
/**
 *
 * @author aditi
 */

 class User{
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
        
}
public class AlgoHomework2q5Ll1a {
    
       
    public static void main(String[] args) {
        try {
            BufferedReader bufReader = null;
            try {
                bufReader = new BufferedReader(new FileReader("C:\\Users\\aditi\\Desktop\\input.txt"));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AlgoHomework2q5Ll1a.class.getName()).log(Level.SEVERE, null, ex);
            }
            ArrayList<String> listOfLines = new ArrayList<>();
            String line = bufReader.readLine();
           
           
            while (line != null) {
                listOfLines.add(line);
                line = bufReader.readLine();
            }
            MyStack1 s1 = new MyStack1();
             
            //push 9 elements
            System.out.println("Pushing 9 elements...");
            for(int i=0;i<9;i++)
            {
                User uobj = new User();
                 String[] data= listOfLines.get(i).split(",");
                uobj.setId(Integer.parseInt(data[0]));
                uobj.setFirstName(data[1]);
                uobj.setLastName(data[2]);
                uobj.setCourse(data[3]);
                 
                s1.push(uobj);
            }
            //pop 10 elements
            System.out.println("Popping 10 elements...");
            for(int i=0;i<10;i++)
                System.out.println(s1.pop());
            
             System.out.println("Pushing all elements...");
            for(int i=0;i< listOfLines.size()  ;i++)                
            {
                User uobj = new User();
                 String[] data= listOfLines.get(i).split(",");
                uobj.setId(Integer.parseInt(data[0]));
                uobj.setFirstName(data[1]);
                uobj.setLastName(data[2]);
                uobj.setCourse(data[3]);
                 
                s1.push(uobj);
            }
            
            
             System.out.println("Pushing 11 John Johnson Java Programming...");
          
                String input2="11,John,Johnson,Java Programming";
                User uobj = new User();
                 String[] data= input2.split(",");
                uobj.setId(Integer.parseInt(data[0]));
                uobj.setFirstName(data[1]);
                uobj.setLastName(data[2]);
                uobj.setCourse(data[3]);
                 
                s1.push(uobj);
            
                System.out.println("Popping all elements...");
                while(!s1.isEmpty())
                {
                    System.out.println(s1.pop());
                }
                
                //push 4 elements
            System.out.println("Pushing 4 elements...");
            for(int i=0;i<4;i++){
                User uobj1 = new User();
                 String[] data1= listOfLines.get(i).split(",");
                uobj1.setId(Integer.parseInt(data1[0]));
                uobj1.setFirstName(data1[1]);
                uobj1.setLastName(data1[2]);
                uobj1.setCourse(data1[3]);
                 
                s1.push(uobj1);
            }
            //pop 5 elements
            System.out.println("Popping 5 elements...");
            for(int i=0;i<5;i++)
                System.out.println(s1.pop());
            
             System.out.println("Pushing all elements...");
            for(int i=0;i< listOfLines.size()  ;i++)
            {
                   User uobj1 = new User();
                 String[] data1= listOfLines.get(i).split(",");
                uobj1.setId(Integer.parseInt(data1[0]));
                uobj1.setFirstName(data1[1]);
                uobj1.setLastName(data1[2]);
                uobj1.setCourse(data1[3]);
                 
                s1.push(uobj1);
            }
            
                System.out.println("Popping all elements...");
                while(!s1.isEmpty())
                {
                    System.out.println(s1.pop());
                }
                
                System.out.println("Print stack with the goal- Reverse order");
                 System.out.println("Pushing all elements...");
            for(int i=0;i< listOfLines.size()  ;i++)
            {
                   User uobj1 = new User();
                 String[] data1= listOfLines.get(i).split(",");
                uobj1.setId(Integer.parseInt(data1[0]));
                uobj1.setFirstName(data1[1]);
                uobj1.setLastName(data1[2]);
                uobj1.setCourse(data1[3]);
                 
                s1.push(uobj1);
            }
            
                System.out.println("Popping all elements...");
                while(!s1.isEmpty())
                {
                    System.out.println(s1.pop());
                }
                
                System.out.println("Print stack with the goal- Original order");
                 System.out.println("Pushing all elements...");
            for(int i=0;i< listOfLines.size()  ;i++)
            {
                   User uobj1 = new User();
                 String[] data1= listOfLines.get(i).split(",");
                uobj1.setId(Integer.parseInt(data1[0]));
                uobj1.setFirstName(data1[1]);
                uobj1.setLastName(data1[2]);
                uobj1.setCourse(data1[3]);
                 
                s1.push(uobj1);
            }
            
            MyStack1 s2 = new MyStack1();
            while(!s1.isEmpty())
        {
            s2.push(s1.pop());
            System.out.println("popped from s1" );
        }
                System.out.println("Popping all elements in the original order...");
                while(!s2.isEmpty())
                {
                    System.out.println(s2.pop());
                }
                
                
                
            //close buffer reader
            bufReader.close();
        } catch (IOException ex) {
            Logger.getLogger(AlgoHomework2q5Ll1a.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    
   

}
