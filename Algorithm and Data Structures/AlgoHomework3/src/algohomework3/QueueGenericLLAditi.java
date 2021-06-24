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

public class QueueGenericLLAditi<Item> {
    Node first;
    Node last;
    int N;
        
    class Node {
    Item d;
    Node next;

        public Item getD() {
            return d;
        }

        public void setD(Item d) {
            this.d = d;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
    
    public QueueGenericLLAditi(){
        first= last =null;
    }
    
    
    public void enqueue(Item d)
    {
       Node oldlast = last;
        last = new Node();
        last.d = d;
        last.next = null;
        if (isEmpty()) first = last;
        else if(oldlast==null)
        {}    
        else
            oldlast.next = last;
        N++;
    }
    
    public Item dequeue(){
        Item data=null;
        if(first==null)
        {
            System.out.println("Underflow: Empty Queue.");
        }
        else if(first==last){
             data= first.getD();
            first=last=null;
        }
        else{
             data = first.getD();
             first = first.next;
            
        }
        N--;
        return  data;

    }
    
    public int size()
    {  return N;
    }
    
    public boolean isEmpty()
    {
        return (first == null);
    }
    
    public void printQueue(){
          Node q=  this.first;
          System.out.print("Queue: ");
          while(q!=null){
            System.out.print(q.d+" ");
            q=q.next;
          }
          System.out.println();
    }
    
    
}
