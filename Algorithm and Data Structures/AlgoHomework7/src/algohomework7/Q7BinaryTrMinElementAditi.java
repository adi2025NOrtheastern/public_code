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

class Q7BinaryTrMinElementAditi {
    
    static class Node {
    char data;
    Node left, right;
 
    public Node(char data)
    {
        this.data = data;
        left = right = null;
    }
}
     
    Node root;

    //iterative function for min in BST..not binary tree
    static char minvalue(Node node) { 
        Node current = node; 
  
        while (current.left != null) { 
            current = current.left; 
        } 
        return (current.data); 
    }    
    
    static char minValue1(Node node) 
{ 
    if (node.left == null) 
        return node.data; 
    return minValue1(node.left); 
} 
    
static char findMin(Node node)
{
    if (node == null)
        return Character.MAX_VALUE;
 
    char res = node.data;
    char leftData = findMin(node.left);
    char rightData = findMin(node.right);
 
    if (leftData < res)
        res = leftData;
    if (rightData < res)
        res = rightData;
    return res;
}

    /* Driver code */
    public static void main(String args[])
    {
        Q7BinaryTrMinElementAditi tree = new Q7BinaryTrMinElementAditi();
        tree.root = new Node('A');
        tree.root.left = new Node('B');
        tree.root.right = new Node('C');
        tree.root.left.right = new Node('D');
        tree.root.left.right.left = new Node('G');
        tree.root.left.right.left.left = new Node('I');
        tree.root.right.left = new Node('E');
        tree.root.right.left.right = new Node('H');
        tree.root.right.left.right.left = new Node('J');
        tree.root.right.left.right.right = new Node('K');
        tree.root.right.right = new Node('F');
        
 
        // Function call
        System.out.println("In binary tree using recursive function, minimum element is "
                           + (tree.findMin(tree.root)));
        
        
        System.out.println("In binary tree using iterative function, minimum element is "
                           + (tree.minValue1(tree.root)));
    }
}
