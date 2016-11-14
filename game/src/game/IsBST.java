/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.*;

/**
 *
 * @author T440
 */
class Node{
    int data;
    Node left, right;
    public Node(int item){
        data = item;
      
    
    }
}
class ResultType{
    boolean is_bst;
    int maxValue;
    int minValue;
    ResultType(boolean is_bst, int max, int min){
        this.is_bst = is_bst;
        this.maxValue = max;
        this.minValue = min;
    
    }

}

class BNode{
    Node n;
    int left;
    int right;
    public BNode(Node node, int left, int right){
        this.n = node;
        this.left = left;
        this.right = right;
    }
    

}


public class IsBST {
    Node root;
    // Recursive
    public boolean isBST(){
        return helper(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public boolean helper(Node node, int min, int max){
      if(node == null) return true;
      if(node.data < min || node.data >max){
          return false;
      }
      return helper(node.left, min, node.data-1) && helper(node.right,node.data+1,max);
    
    }
    
    // Iterative
    public boolean isValidBST(){
        if(root == null){
            return true;
        
        }
        LinkedList<BNode> queue = new LinkedList<BNode>();
        queue.add(new BNode(root, Integer.MIN_VALUE, Integer.MAX_VALUE) );
        while(!queue.isEmpty()){
            BNode temp = queue.poll();
            if(temp.n.data <= temp.left || temp.n.data >= temp.right) return false;
            if(temp.n.right != null){
                queue.add(new BNode(temp.n.right,temp.n.data,temp.right));
            }
            if(temp.n.left != null){
                queue.add(new BNode(temp.n.left,temp.left,temp.n.data));
            }
            
        
        }
    
        return true;
    
    }
    
    
    
    // Divide and Conquer
    
    public boolean isbst(){
       return divideAndConquer(root).is_bst;
  
    }
    
    public ResultType divideAndConquer (Node root){
        if(root == null){
            return new ResultType(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        ResultType left = divideAndConquer(root.left);
        ResultType right = divideAndConquer(root.right);
        
        if(!left.is_bst || !right.is_bst) return new ResultType(false,0,0);
        if(root.left != null && left.maxValue >= root.data||root.right != null && right.minValue <= root.data) 
            return new ResultType(false, 0 ,0);
        return new ResultType(true,Math.max(root.data,right.maxValue),Math.min(root.data, left.minValue));
        
    } 
    
    
    
    
    public static void main(String args[])
    {
        IsBST tree = new IsBST();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);
 
        if (tree.isBST())
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");
        
        if(tree.isbst())
           System.out.println("IS BST");
        else
            System.out.println("Not a BST"); 
        
        
        if(tree.isValidBST())
           System.out.println("IS BST");
        else
            System.out.println("Not a BST"); 
    }
    
}
