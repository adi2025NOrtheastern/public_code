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

public class Q14AVLTreeAditi {
    class Node {
  int item, height;
  Node left, right;

  Node(int d) {
    item = d;
    height = 1;
  }
}
    
  Node root;

  int height(Node N) {
    if (N == null)
      return 0;
    return N.height;
  }

  
  Node leftRotate(Node x) {
    Node y = x.right;
    Node T2 = y.left;
    y.left = x;
    x.right = T2;
    x.height = max(height(x.left), height(x.right)) + 1;
    y.height = max(height(y.left), height(y.right)) + 1;
    return y;
  }
  
  int max(int a, int b) {
    return (a > b) ? a : b;
  }

    // Get balance factor of a node
  int getBalanceFactor(Node N) {
    if (N == null)
      return 0;
    return height(N.left) - height(N.right);
  }
  
  Node rightRotate(Node y) {
    Node x = y.left;
    Node T2 = x.right;
    x.right = y;
    y.left = T2;
    y.height = max(height(y.left), height(y.right)) + 1;
    x.height = max(height(x.left), height(x.right)) + 1;
    return x;
  }

  // Insert a node
  Node insertionAvlTree(Node node, int item) {

   //check null
    if (node == null)
      return (new Node(item));
    if (item < node.item)
      node.left = insertionAvlTree(node.left, item);
    else if (item > node.item)
      node.right = insertionAvlTree(node.right, item);
    else
      return node;

    // Change the balance factor of each node
   
    node.height = 1 + max(height(node.left), height(node.right));
    int balanceFactor = getBalanceFactor(node);
     if (balanceFactor < -1) {
      if (item > node.right.item) {
        return leftRotate(node);
      } else if (item < node.right.item) {
        node.right = rightRotate(node.right);
        return leftRotate(node);
      }
    }
    if (balanceFactor > 1) {
      if (item < node.left.item) {
        return rightRotate(node);
      } else if (item > node.left.item) {
        node.left = leftRotate(node.left);
        return rightRotate(node);
      }
    }
   
    return node;
  }

  Node nodeWithMimumValue(Node node) {
    Node current = node;
    while (current.left != null)
      current = current.left;
    return current;
  }

  
  void preOrder(Node node) {
    if (node != null) {
      System.out.print(node.item + " ");
      preOrder(node.left);
      preOrder(node.right);
    }
  }

  // Print the tree
  private void printTree(Node thisPtr, String spaces, boolean last) {
    if (thisPtr != null) {
      System.out.print(spaces);
      if (last) {
        System.out.print("R----");
        spaces += "   ";
      } else {
        System.out.print("L----");
        spaces += "|  ";
      }
      System.out.println(thisPtr.item);
      printTree(thisPtr.left, spaces, false);
      printTree(thisPtr.right, spaces, true);
    }
  }

  // Driver code
  public static void main(String[] args) {
    Q14AVLTreeAditi tree = new Q14AVLTreeAditi();
    
    tree.root = tree.insertionAvlTree(tree.root, 10);
    tree.root = tree.insertionAvlTree(tree.root, 5);
    tree.root = tree.insertionAvlTree(tree.root, 20);
    tree.root = tree.insertionAvlTree(tree.root, 15);
    tree.root = tree.insertionAvlTree(tree.root, 25);
    tree.printTree(tree.root, "", true);
      System.out.println("insert 30");
    tree.root = tree.insertionAvlTree(tree.root, 30);
    
    tree.printTree(tree.root, "", true);
    
    System.out.println("insert 27");
    tree.root = tree.insertionAvlTree(tree.root, 27);
    tree.printTree(tree.root, "", true);
    
    System.out.println("insert 35");
    tree.root = tree.insertionAvlTree(tree.root, 35);
    tree.printTree(tree.root, "", true);
   
  }
}

