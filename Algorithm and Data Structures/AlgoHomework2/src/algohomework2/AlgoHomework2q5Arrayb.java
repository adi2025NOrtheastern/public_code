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

/**
 *
 * @author aditi
 */
class UserData{
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
        if(this.firstName ==null )
            return ("****MyStackError:Underflow- NO element!!**Empty Stack**");
        return (getId() + " " + getFirstName() + " " + getLastName() + " " + getCourse());
     
    } 
        
}

class Fix_Array_Stack
{
 private UserData[] s;
 private int N = 0;

 public Fix_Array_Stack(int capacity)
 { s = new UserData[capacity]; }

 public boolean isEmpty()
 { return N == 0; }

 public void push(UserData item)
 { 
     if(N<s.length)
     s[N++] = item; 
     else
         System.out.println("Overflow!!!");
 }

 public UserData pop()
 { 
     UserData item = null;
     if(N==0)
     {
         //no elements
         return new UserData();
     }
     else  {
      item = s[--N];
      s[N] = null;
 }
 return item;
 }
 
 public int size(){
     return N;
 }
}

public class AlgoHomework2q5Arrayb{
           
    public static void main(String[] args) {
        try {
            BufferedReader bufReader = null;
            try {
                bufReader = new BufferedReader(new FileReader("C:\\Users\\aditi\\Desktop\\input.txt"));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AlgoHomework2q5Arrayb.class.getName()).log(Level.SEVERE, null, ex);
            }
            ArrayList<String> listOfLines = new ArrayList<>();
            String line = bufReader.readLine();
           
           
            while (line != null) {
                listOfLines.add(line);
                line = bufReader.readLine();
            }
            Fix_Array_Stack s1 = new Fix_Array_Stack(10);
             
            //push 9 elements
            System.out.println("Pushing 9 elements...");
            for(int i=0;i<9;i++)
            {
                UserData uobj = new UserData();
                 String[] data= listOfLines.get(i).split(",");
                uobj.setId(Integer.parseInt(data[0]));
                uobj.setFirstName(data[1]);
                uobj.setLastName(data[2]);
                uobj.setCourse(data[3]);
                 
                s1.push(uobj);
            }
            //pop 10 elements
            System.out.println("Popping 10 elements from top...");
            for(int i=0;i<10;i++)
            {
                
                    System.out.println((i+1) + "th element- " +s1.pop());
                
            }
            
             System.out.println("Pushing all elements...");
            for(int i=0;i< listOfLines.size()  ;i++)                
            {
                UserData uobj = new UserData();
                 String[] data= listOfLines.get(i).split(",");
                uobj.setId(Integer.parseInt(data[0]));
                uobj.setFirstName(data[1]);
                uobj.setLastName(data[2]);
                uobj.setCourse(data[3]);
                 
                s1.push(uobj);
            }
            
            
             System.out.println("Pushing 11 John Johnson Java Programming...");
          
                String input2="11,John,Johnson,Java Programming";
                UserData uobj = new UserData();
                 String[] data= input2.split(",");
                uobj.setId(Integer.parseInt(data[0]));
                uobj.setFirstName(data[1]);
                uobj.setLastName(data[2]);
                uobj.setCourse(data[3]);
                 
                s1.push(uobj);
            
                System.out.println("Popping all elements...");
                while(!s1.isEmpty())
                {
                    uobj = s1.pop();
                    System.out.println(uobj.toString());
                }
                
                //push 4 elements
            System.out.println("Pushing 4 elements...");
            for(int i=0;i<4;i++){
                UserData uobj1 = new UserData();
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
            { System.out.println(s1.pop());
            
            }
            
             System.out.println("Pushing all elements...");
            for(int i=0;i< listOfLines.size()  ;i++)
            {
                   UserData uobj1 = new UserData();
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
                   UserData uobj1 = new UserData();
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
                   UserData uobj1 = new UserData();
                 String[] data1= listOfLines.get(i).split(",");
                uobj1.setId(Integer.parseInt(data1[0]));
                uobj1.setFirstName(data1[1]);
                uobj1.setLastName(data1[2]);
                uobj1.setCourse(data1[3]);
                 
                s1.push(uobj1);
            }
            
            Fix_Array_Stack s2 = new Fix_Array_Stack(10);
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

