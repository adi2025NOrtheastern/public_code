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
public class QueueLinklist1 {
    Node first;
    Node last;
    int N;
        
    class Node {
    String d;
    Node next;

        public String getD() {
            return d;
        }

        public void setD(String d) {
            this.d = d;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
    
    public QueueLinklist1(){
        first= last =null;
    }
    
    
    public void enqueue(String d)
    {
        if(first == null)
        {
            first=new Node();
            first.setD(d);
            first.setNext(null);
            last = first;
        }
        else {
            Node n = new Node();
            n.setD(d);
            n.setNext(null);
            last.setNext(n);
            last=n;
        }
        N++;
    }
    
    public String dequeue(){
        String data;
        if(first==null)
        {
            return "Underflow: Empty Queue.";
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
        return (last == null && first == null);
    }
    
    public void printQueue(){
          QueueLinklist1 q= this;
          System.out.print("Queue: ");
          while(!q.isEmpty())
            System.out.print(q.dequeue() +" ");
          System.out.println();
    }
    
    
}
