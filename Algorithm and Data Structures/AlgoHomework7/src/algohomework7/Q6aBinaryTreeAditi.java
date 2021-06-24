/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algohomework7;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author aditi
 */


public class Q6aBinaryTreeAditi {
   class Node {
    int value;
    Node left;
    Node right;
 
    Node(int value) {
        this.value = value;
        right = null;
        left = null;
    }

       
    }
   
   
   
    Node root;
    Node temp = root;  
    
 
 //delete 
    static int findMax(Node node)
    {
        if (node == null)
            return Integer.MIN_VALUE;
 
        int res = node.value;
        int lres = findMax(node.left);
        int rres = findMax(node.right);
 
        if (lres > res)
            res = lres;
        if (rres > res)
            res = rres;
        return res;
    }
  
    
    static int findMin(Node node)
{
    if (node == null)
        return Integer.MAX_VALUE;
 
    int res = node.value;
    int leftData = findMin(node.left);
    int rightData = findMin(node.right);
 
    if (leftData < rightData)
        rightData = leftData;
    if (rightData < rightData)
        res = rightData;
    return res;
}
// Inorder traversal of a binary tree 
static void inorder(Node temp)  
{  
    if (temp == null)  
        return;  
  
    inorder(temp.left);  
    System.out.print(temp.value + " ");  
    inorder(temp.right);  
}  


  static int searchFind(Node node, int data)
{
    if (node == null)
        return -1;
 
    int res = node.value;
    int leftData = searchFind(node.left,data);
    int rightData = searchFind(node.right,data);
 
    
    
    if (rightData == data || data==leftData)
        System.out.println("Found!");
    return res;
}



/*static boolean search(Node temp, int data)  
{  
    if (temp == null)  
    {
        //System.out.println("Not found!");
        return false;  
    }
  if(temp.value==data )
  {
      System.out.println("Found "+ data);
      return true;
  }
  else{
      if(temp.left != null){
    boolean r = search(temp.left,data); return r; } 
    //System.out.print(temp.value + " ");  
    if(temp.right !=null){
    boolean r=search(temp.right,data); return r; }
}
    //System.out.println("Not found!");
    return false;
}

  */
// Function to delete deepest  
// element in binary tree 
static void deleteDeepest(Node root, 
                          Node nodeD) 
{ 
    Queue<Node> q = new LinkedList<>();  
    q.add(root); 
      
    Node temp = null; 
   
    while (!q.isEmpty()) 
    {  
        temp = q.peek();  
        q.remove(); 
          
        if (temp == nodeD) 
        {  
            temp = null;  
            return;  
              
        }  
        if (temp.right!=null) 
        {  
            if (temp.right == nodeD) 
            {  
                temp.right = null;  
                return;  
        }  
        else
            q.add(temp.right);  
    }  
  
    if (temp.left != null)  
    {  
        if (temp.left == nodeD) 
        {  
            temp.left = null;  
            return;  
        }  
        else
            q.add(temp.left);  
    }  
}  
} 
  
// Function to delete given element  
// in binary tree 
static void delete(Node root, int key) 
{ 
    if (root == null)  
        return;  
          
    if (root.left == null &&  
       root.right == null) 
    {  
        if (root.value == key)  
            return;  
        else
            return;  
    } 
      
    Queue<Node> q = new LinkedList<>();  
    q.add(root); 
    Node temp = null, nodeKey = null; 
      
      
    while (!q.isEmpty()) 
    {  
        temp = q.peek();  
        q.remove();  
          
        if (temp.value == key)  
            nodeKey = temp;  
  
        if (temp.left != null)  
            q.add(temp.left);  
  
        if (temp.right != null)  
            q.add(temp.right);  
    }  
  
    if (nodeKey != null) 
    {  
        int x = temp.value;  
        deleteDeepest(root, temp);  
        nodeKey.value = x;  
    }  
} 
  

    public static void main(String[] args) {
        int[] input = {3,7,9,23,45,1,5,14,55,24,13,11,8,19,4,31,35,56};
                       
        Q6aBinaryTreeAditi obj = new Q6aBinaryTreeAditi();
        Node root=null;
        for(int i =0;i<input.length; i++){
           root= obj.insert(root, input[i]);
          //obj.add(input[i]);
            System.out.println("Inserting "+input[i]);
        }
        
        Q6aBinaryTreeAditi.inorder(root);
        System.out.println("");
        
        
        
         System.out.println("Search 4");
        Q6aBinaryTreeAditi.searchFind(root,4);
        System.out.println("Search 1");
        Q6aBinaryTreeAditi.searchFind(root, 1);
        System.out.println("Search 100");
        int i = Q6aBinaryTreeAditi.searchFind(root, 100);
        if(i==-1)
            System.out.println("not found");
        System.out.println("Search 55");
        Q6aBinaryTreeAditi.searchFind(root, 4);
        
        
        obj.deleteMin(root);
       
        obj.deleteMax(root);
        
        
        
    }

    
    public void deleteMax(Node root){
        //find max
        
        int key = findMax(root);
        delete(root, key);
         System.out.println("Deleted-> "+ key);
          System.out.println("Now ->");
         inorder(root);
         System.out.println("");
    }
    public void deleteMin(Node root){
        //find min
        
        int key = findMin(root);
        delete(root, key);
        System.out.println("Deleted-> "+ key);
        System.out.println("Now ->");
        inorder(root);
        System.out.println("");
    }
    
    
//insert
    
    
    
    
    Node insert(Node root, int data) {
    Node temp;
    Queue<Node> q = new LinkedList<>();
    if(root==null)
    {
        root= new Node(data);
        return root;
    }
    q.add(root);
    while(!q.isEmpty()) 
    {
        temp =q.peek();
        q.remove();

        /* Insert node as the left child of the parent node. */
        if(temp.left == null) {
            temp.left = new Node(data);
            break;
        }

        /* If the left node is not null push it to the queue. */
        else
            q.add(temp.left);
        
        /* Insert node as the right child of the parent node. */
        if(temp.right == null) {
            temp.right = new Node(data);
            break;
        }

        /* If the right node is not null push it to the queue. */
        else
            q.add(temp.right);
    }
    return root;
}

    
    Node newnode(int data) {
    Node node;
    node = new Node(data);
    node.value = data;
    node.left = null;
    node.right = null;
    return node;
}




}// class ending
