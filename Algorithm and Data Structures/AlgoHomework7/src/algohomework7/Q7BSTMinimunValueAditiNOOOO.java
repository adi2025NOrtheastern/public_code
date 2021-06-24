/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algohomework7;

/**
 *
 * @author aditi
 */
public class Q7BSTMinimunValueAditiNOOOO {
    
    static Node head; 
      
    Node insert(Node node, int data) { 
          
        
        if (node == null) { 
            return (new Node(data)); 
        } else { 
              
            
            if (data <= node.data) { 
                node.left = insert(node.left, data); 
            } else { 
                node.right = insert(node.right, data); 
            } 
  
            return node; 
        } 
    } 
  
    
    int minvalue(Node node) { 
        Node current = node; 
  
        while (current.left != null) { 
            current = current.left; 
        } 
        return (current.data); 
    } 
     
    public static void main(String[] args) { 
        Q7BSTMinimunValueAditiNOOOO tree = new Q7BSTMinimunValueAditiNOOOO(); 
        Node root = null; 
        root = tree.insert(root, 4); 
        tree.insert(root, 2); 
        tree.insert(root, 1); 
        tree.insert(root, 3); 
        tree.insert(root, 6); 
        tree.insert(root, 5); 
  
        System.out.println("Minimum value of BST is " + tree.minvalue(root)); 
    } 
} 


class Node { 
  
    int data; 
    Node left, right; 
  
    Node(int d) { 
        data = d; 
        left = right = null; 
    } 
} 