/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algohomework3;

/**
 *
 * @author aditi
 */

public class QueueGenericArrayAditi<Item> {
    int first;
    int last;
    int N;  //capacity
    Item[] array;
        
        
    public QueueGenericArrayAditi(int capacity){
        first= last =-1;
        array=  (Item[]) new Object[capacity]; 
    }
    
    
    public void enqueue(Item d)
    {
       if(this.isEmpty())
       {
           last = (last+1) % array.length;
           array[last]=d;
           first = last;
       }
       else if(N==array.length){
           System.out.println("Overflow");
           return ;
       }
           
       else{
           last = (last+1) % array.length;
           array[last]=d;
       }
        
        N++;
    }
    
    public Item dequeue(){
        Item data=null;
        if(isEmpty())
        {
            System.out.println("Underflow!"); 
            return null;
        }
        else{
            
            data=array[first];
            array[first]=null;
            first=(first+1)%array.length;
        }
        //first=first%array.length;
        N--;
        return  data;

    }
    
    public int size()
    {  return N;
    }
    
    public boolean isEmpty()
    {
        return (N==0);
    }
    
    public void printQueue(){
          int q=  this.first;
          int r= this.last;
          System.out.print("Queue: first->");
          while(q!=r){
            System.out.print(array[q++]+" ");
            q=q%array.length;
          }
          System.out.print(array[q]+" ");
          System.out.print(" <-last");
          System.out.println();
    }
    
    
}
