/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algohomework4;

/**
 *
 * @author aditi
 */

class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val) { this.val = val; }
}

public class Q4CircularQueueAditi {
    int size;
    int queueSize=0;
    ListNode head,tail;
    public Q4CircularQueueAditi(int k) {
        this.size=k;
    }

    public int Head() {
        if(queueSize==0) {
            return -1;
        }
        return head.val;
    }

   
    public int Tail() {
        if(queueSize==0) {
            return -1;
        }
        return tail.val;
    }

   
    public boolean isEmpty() {
        return queueSize==0;
    }

   
    public boolean isFull() {
        return queueSize==size;
    }
    public void enQueue(int value) {
        if(isFull()) {
            System.out.println("Overflow!");
            return ;
        }
        if(queueSize==0){
            head = new ListNode(value);
            tail=head;
        }else{
            tail.next = new ListNode(value);
            tail = tail.next;
            tail.next = head;
        }
        queueSize++;
        return ;
    }

   
    public int deQueue() {
        int n=-1;
        if(isEmpty()) {
            System.out.println("Underflow!!");
            return -1;
        }
                
        if(queueSize==1){
            n=head.val;
            head=null;
            tail=null;
        }else{
            n=head.val;
            head = head.next;
            tail.next = head;
        }
        queueSize--;
        return n;
    }
public void displayQueue() {
     ListNode temp = this.head; 
     if(temp==null){
         System.out.println("Empty!");
         return;
     }
        System.out.print("\nElements in Circular Queue are: front-> "); 
        while (temp.next != this.head) { 
            System.out.print(" "+ temp.val); 
            temp = temp.next; 
        } 
        System.out.println(" "+ temp.val+"<-tail"); 
}
   
public static void main(String args[]) {
    Q4CircularQueueAditi obj = new Q4CircularQueueAditi(8);
    int[] inputData= {12, 22, 38, 3, 9, 82, 10, 31, 24, 33 };
    for(int i=0;i<inputData.length;i++){
        System.out.println("Enqueue "+inputData[i]);
        obj.enQueue(inputData[i]);
    }
    System.out.println("After Enqueue all-->");
    obj.displayQueue();
    for(int i=0;i<3;i++){
       System.out.println("Dequeue->>"+obj.deQueue());
    }
    System.out.println("After dequeue 3 elements-->");
    obj.displayQueue();
    
    for(int i=0;i<2;i++){
        System.out.println("Enqueue "+inputData[i]);
        obj.enQueue(inputData[i]);
    }
    System.out.println("After Enqueue 2-->");
    obj.displayQueue();
    int queSize=obj.queueSize;
    for(int i=0;i<queSize;i++){
        System.out.println("Dequeue->>"+obj.deQueue());
    }
    System.out.println("After dequeue all-->");
    obj.displayQueue();
    
}
}



