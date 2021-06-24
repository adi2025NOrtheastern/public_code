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

public class StackGenericLLAditi<Item>{
private Node top ;
private int s; //size

private class Node{
    Item obj;
    Node next;
    }    

public StackGenericLLAditi(){
    top=null;
    s=0;
}

public void push(Item a)
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

public Item pop()
{
    
    Item n = null;
    if(!isEmpty())
    {
     n = top.obj;
     top=top.next;
     s--;
    }
    else {
        System.out.println("Underflow");
        return ((Item)new Object());
    }  //empty Item to say that stack is empty -- Underflow
    return n;
}


public boolean isEmpty()
{
    return (top==null) ;
}

public int size(){
    return s;
}

public void print(){
    Node s= this.top;
    System.out.print("Stack is: top-> ");
    while(s!=null){
        Item i = s.obj;
        s=s.next;
        System.out.print(i +" ");
        //s.push(i);
        
    }
   // this=s;
        //System.out.print(this.pop() + " ");
    System.out.println(" ");
}
}
/**
 *
 * @author aditi
 */


