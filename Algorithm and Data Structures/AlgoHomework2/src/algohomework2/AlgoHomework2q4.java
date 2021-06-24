/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algohomework2;

class Stack{
private Node top = null;
private class Node{
    String a;
    Node next;
}    


public void push(String a)
{
    Node n= new Node();
    n.a=a;
    
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
     n = top.a;
     top=top.next;
    }
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
public class AlgoHomework2q4 {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Stack s = new Stack();
        Stack y = new Stack();
        String input = "It was the best of time";
        String[] in = input.split(" ");
        //pushing string on Stack 1-s
        System.out.println("Q4 : Input string is: " + input);
        for(String a : in)
        {
            s.push(a);
            System.out.println("pushed "+a);
        }
        //for printing string in the same order as it was inserted we use a new stack
        //Then pop from s stack and push to new stack y and 
        // then pop from y stack and print
        System.out.println("Popping from stack s and pushing in y stack" );
        while(!s.isEmpty())
        {
            y.push(s.pop());
            
        }
        //print contents of stack y
        System.out.println("print contents of stack y");
        while(!y.isEmpty())
        {
            System.out.print(y.pop() + " ");
        }
        System.out.println("");
        System.out.println("This is the original order!");
    }
    
}
