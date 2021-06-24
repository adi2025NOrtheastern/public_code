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
public class TestLinkedListQueue {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        QueueLinklist q = new QueueLinklist();
        String input  = "to be or not to - be - - that - - -";
        String[] in = input.split(" ");
        //pushing string on Stack 1-s
        System.out.println("Q1 : Input string is: " + input);
        for(String a : in)
        {
            if(a.equals("-")){
                System.out.println("Dequeue operation: " +q.dequeue());
                q.printQueue();
            }
            else {
                System.out.println("Enqueue operation: " + a);
                q.enqueue(a);
                q.printQueue();
            }
            
        }
        /*System.out.println("Remaining queue: ");
        while(!q.isEmpty())
            System.out.println(q.dequeue()); */
        q.printQueue();
    }
    
}
