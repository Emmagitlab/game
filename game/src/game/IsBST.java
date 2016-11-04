/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author T440
 */
class Node{
    int data;
    Node left, right;
    public Node(int item){
        data = item;
        left = right = null;   
    
    }
}

public class IsBST {
    Node root;
    
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
    }
    
}
