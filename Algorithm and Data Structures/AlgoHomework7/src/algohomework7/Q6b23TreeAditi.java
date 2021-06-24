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
public class Q6b23TreeAditi {
    
 
    public static void main(String[] args) {
        T23Node t23obj = new T23Node();
        int[] input = {3,7,9,23,45,1,5,14,55,24,13,11,8,19,4,31,35,56};
        
        
        for(int i =0;i<input.length; i++){
            t23obj.
            
            
          t23obj.add();
            System.out.println("Inserting "+input[i]);
        }
    }
  
  
  
}

 class T23Node<Key extends Comparable<? super Key>,E> {
  private E lval;        // The left record
  private Key lkey;        // The node's left key
  private E rval;        // The right record
  private Key rkey;        // The node's right key
  private T23Node<Key,E> left;   // Pointer to left child
  private T23Node<Key,E> center; // Pointer to middle child
  private T23Node<Key,E> right;  // Pointer to right child

  public T23Node() { center = left = right = null; }
  public T23Node(Key lk, E lv, Key rk, E rv,
                T23Node<Key,E> p1, T23Node<Key,E> p2,
                T23Node<Key,E> p3) {
    lkey = lk; rkey = rk;
    lval = lv; rval = rv;
    left = p1; center = p2; right = p3;
  }

  public boolean isLeaf() { return left == null; }
  public T23Node<Key,E> lchild() { return left; }
  public T23Node<Key,E> rchild() { return right; }
  public T23Node<Key,E> cchild() { return center; }
  public Key lkey() { return lkey; }  // Left key
  public E lval() { return lval; }  // Left value
  public Key rkey() { return rkey; }  // Right key
  public E rval() { return rval; }  // Right value
  public void setLeft(Key k, E e) { lkey = k; lval = e; }
  public void setRight(Key k, E e) { rkey = k; rval = e; }
  public void setLeftChild(T23Node<Key,E> it) { left = it; }
  public void setCenterChild(T23Node<Key,E> it)
    { center = it; }
  public void setRightChild(T23Node<Key,E> it)
    { right = it; }

    private T23Node<Key,E> inserthelp(T23Node<Key,E> rt, Key k, E e) {
  T23Node<Key,E> retval;
  if (rt == null) // Empty tree: create a leaf node for root
    return new T23Node<Key,E>(k, e, null, null, null, null, null);
  if (rt.isLeaf()) // At leaf node: insert here
    return rt.add(new T23Node<Key,E>(k, e, null, null, null, null, null));
  // Add to internal node
  if (k.compareTo(rt.lkey()) < 0) { // Insert left
    retval = inserthelp(rt.lchild(), k, e);
    if (retval == rt.lchild()) return rt;
    else return rt.add(retval);
  }
  else if((rt.rkey() == null) || (k.compareTo(rt.rkey()) < 0)) {
    retval = inserthelp(rt.cchild(), k, e);
    if (retval == rt.cchild()) return rt;
    else return rt.add(retval);
  }
  else { // Insert right
    retval = inserthelp(rt.rchild(), k, e);
    if (retval == rt.rchild()) return rt;
    else return rt.add(retval);
  }
}

// Add a new key/value pair to the node. 
public T23Node<Key,E> add(T23Node<Key,E> it) {
  if (rkey == null) { // Only one key, add here
    if (lkey.compareTo(it.lkey()) < 0) {
      rkey = it.lkey(); rval = it.lval();
      center = it.lchild(); right = it.cchild();
    }
    else {
      rkey = lkey; rval = lval; right = center;
      lkey = it.lkey(); lval = it.lval();
      center = it.cchild();
    }
    return this;
  }
  else if (lkey.compareTo(it.lkey()) >= 0) { // Add left
    T23Node<Key,E> N1 = new T23Node<Key,E>(lkey, lval, null, null, it, this, null);
    it.setLeftChild(left);
    left = center; center = right; right = null;
    lkey = rkey; lval = rval; rkey = null; rval = null;
    return N1;
  }
  else if (rkey.compareTo(it.lkey()) >= 0) { // Add center
    it.setCenterChild(new T23Node<Key,E>(rkey, rval, null, null, it.cchild(), right, null));
    it.setLeftChild(this);
    rkey = null; rval = null; right = null;
    return it;
  }
  else { // Add right
    T23Node<Key,E> N1 = new T23Node<Key,E>(rkey, rval, null, null, this, it, null);
    it.setLeftChild(right);
    right = null; rkey = null; rval = null;
    return N1;
  }
}


private E findhelp(T23Node<Key,E> root, Key k) {
  if (root == null) return null;          // val not found
  if (k.compareTo(root.lkey()) == 0) return root.lval();
  if ((root.rkey() != null) && (k.compareTo(root.rkey())
       == 0))
    return root.rval();
  if (k.compareTo(root.lkey()) < 0)       // Search left
    return findhelp(root.lchild(), k);
  else if (root.rkey() == null)           // Search center
    return findhelp(root.cchild(), k);
  else if (k.compareTo(root.rkey()) < 0)  // Search center
    return findhelp(root.cchild(), k);
  else return findhelp(root.rchild(), k); // Search right
}
    }//internal class 23 tree ends
  
  
