/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.paallelhw4.q6;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aditi
 */


public class TreeNode { 
  TreeNode parent   = null;  
  List  children = new ArrayList();
  public synchronized void addChild(TreeNode child){
    if(!this.children.contains(child)) {
      this.children.add(child);
      child.setParentOnly(this);
    }
  }
  public synchronized void addChildOnly(TreeNode child){
    if(!this.children.contains(child)){
      this.children.add(child);
    }
  }

  public synchronized void setParent(TreeNode parent){
    this.parent = parent;
    parent.addChildOnly(this);
  }
  public synchronized void setParentOnly(TreeNode parent){
    this.parent = parent;
  }
  
    public static void main(String[] args) {
        
        TreeNode tree1 = new TreeNode();
        TreeNode tree2 = new TreeNode();
        MThread t1 = new MThread(tree1, tree2);
        MThread2 t2 = new MThread2(tree1, tree2);
        t1.start();
        t2.start();
        //Thread t3 = new Thread();
        
    }
    
    
    
}

class MThread extends Thread{
    TreeNode t1, t2;    
    public MThread(TreeNode t1, TreeNode t2)
    {
        this.t1=t1;
        this.t2=t2;
    }
    
    
    @Override
                public void run()
        {
         //   TreeNode t1 = new TreeNode();
            t1.addChild(t2);
        }
    }


class MThread2 extends Thread{
    TreeNode t1, t2;    
    public MThread2(TreeNode t1, TreeNode t2)
    {
        this.t1=t1;
        this.t2=t2;
    }
    
    
    @Override
                public void run()
        {
         //   TreeNode t1 = new TreeNode();
            t2.setParent(t1);
        }
    }

