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

class MyStack{
private Node top = null;
private class Node{
    private int id;
    private String firstName;
    private String lastName;       
    private String course ;
    Node next;
    
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
    }    


public void push(String a)
{
    Node n= new Node();
    String[] s = a.split(",");
    n.setId(Integer.parseInt(s[0]));
    n.setFirstName(s[1]);
    n.setLastName(s[2]);
    n.setCourse(s[3]);
    
    
    if(! isEmpty())
    {
      n.next=top;
    }
    else
    {
        n.next = null;
    }
    
    top=n;
}

public String pop()
{
    String n = null;
    if(!isEmpty())
    {
     n = top.getId() + " " + top.getFirstName() + " " + top.getLastName() + " " + top.getCourse();
     top=top.next;
    }
    else return("****MyStackError: NO element!!**Empty Stack**");
    return n;
}

public boolean isEmpty()
{
    return (top==null) ;
}
}
/**
 *
 * @author aditi
 */
public class AlgoHomework2q5Ll {
    public static void main(String[] args) {
        try {
            BufferedReader bufReader = null;
            try {
                bufReader = new BufferedReader(new FileReader("C:\\Users\\aditi\\Desktop\\input.txt"));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AlgoHomework2q5Ll.class.getName()).log(Level.SEVERE, null, ex);
            }
            ArrayList<String> listOfLines = new ArrayList<>();
            String line = bufReader.readLine();
            while (line != null) {
                listOfLines.add(line);
                line = bufReader.readLine();
            }
            MyStack s1 = new MyStack();
            
            //push 9 elements
            System.out.println("Pushing 9 elements...");
            for(int i=0;i<9;i++)
                s1.push(listOfLines.get(i));
            
            //pop 10 elements
            System.out.println("Popping 10 elements...");
            for(int i=0;i<10;i++)
                System.out.println(s1.pop());
            
             System.out.println("Pushing all elements...");
            for(int i=0;i< listOfLines.size()  ;i++)
                s1.push(listOfLines.get(i));
            
             System.out.println("Pushing 11 John Johnson Java Programming...");
          
                s1.push("11,John,Johnson,Java Programming");
            
                System.out.println("Popping all elements...");
                while(!s1.isEmpty())
                {
                    System.out.println(s1.pop());
                }
                
                //push 4 elements
            System.out.println("Pushing 4 elements...");
            for(int i=0;i<4;i++)
                s1.push(listOfLines.get(i));
            
            //pop 5 elements
            System.out.println("Popping 5 elements...");
            for(int i=0;i<5;i++)
                System.out.println(s1.pop());
            
             System.out.println("Pushing all elements...");
            for(int i=0;i< listOfLines.size()  ;i++)
                s1.push(listOfLines.get(i));
            
                System.out.println("Popping all elements...");
                while(!s1.isEmpty())
                {
                    System.out.println(s1.pop());
                }
                
                System.out.println("Print stack with the goal- Reverse order");
                 System.out.println("Pushing all elements...");
            for(int i=0;i< listOfLines.size()  ;i++)
                s1.push(listOfLines.get(i));
            
                System.out.println("Popping all elements...");
                while(!s1.isEmpty())
                {
                    System.out.println(s1.pop());
                }
                
                System.out.println("Print stack with the goal- Original order");
                 System.out.println("Pushing all elements...");
            for(int i=0;i< listOfLines.size()  ;i++)
                s1.push(listOfLines.get(i));
            
            MyStack s2 = new MyStack();
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
            Logger.getLogger(AlgoHomework2q5Ll.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    
   

}
