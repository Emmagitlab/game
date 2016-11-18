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
    
    
    // up to down to check by definition : 1ms
public boolean isValidBST(TreeNode root){
	return valid(root, null, null);
}
private boolean valid(TreeNode root, Integer low, Integer high){
	if(root == null) return true;
	return (low == null || root.val > low) && (high == null || root.val < high) 
			&& valid(root.left, low, root.val) && valid(root.right, root.val, high);
}

// in-order seq is incresing seq
//recursive inorder : 1ms
private Integer lastVal = null;
public boolean isValidBST4(TreeNode root) {
	return recursiveInOder(root);
}
private boolean recursiveInOder(TreeNode root){
	if(root == null) return true;
	if(recursiveInOder(root.left)){
		if(lastVal != null && lastVal >= root.val) return false;
		lastVal = root.val;
		return recursiveInOder(root.right);
	}
	return false;
}

//non-recursive inorder 1: 10ms
public boolean isValidBST3(TreeNode root) {
	long lastNum = Long.MIN_VALUE;
	Stack<TreeNode> stack = new Stack<>();
	TreeNode p = root;
	stack.push(p);
	while(!stack.isEmpty()){
		while(!stack.isEmpty() && (p = stack.peek()) != null){
			p = p.left;
			stack.push(p);
		}
		stack.pop();
		if (!stack.isEmpty()) {
			p = stack.pop();
			//visit p
			if (lastNum >= p.val)
				return false;
			lastNum = p.val;
			stack.push(p.right);
		}
	}
	return true;
}

//non-recursive inoder 2 : 4ms
public boolean isValidBST2(TreeNode root) {
	long lastNum = Long.MIN_VALUE;
	Stack<TreeNode> stack = new Stack<>();
	TreeNode p = root;
	while(p != null || !stack.isEmpty()){
		if(p != null){
			stack.push(p);
			p = p.left;
		}
		else{
			p = stack.pop();
			//visit p
			if(lastNum >= p.val) return false;
			lastNum = p.val;
			p = p.right;
		}
	}
	return true;
}
    
    
//Assume a BST is defined as follows:
//
//The left subtree of a node contains only nodes with keys less than the node's key.
//The right subtree of a node contains only nodes with keys greater than the node's key.
//Both the left and right subtrees must also be binary search trees.
//Java Solution 1 - Recursive
//
//All values on the left sub tree must be less than root, and all values on the right sub tree must be greater than root. So we just check the boundaries for each node.
//
public boolean isValidBST(TreeNode root) {
    return isValidBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);    
}
 
public boolean isValidBST(TreeNode p, double min, double max){
    if(p==null) 
        return true;
 
    if(p.val <= min || p.val >= max)
        return false;
 
    return isValidBST(p.left, min, p.val) && isValidBST(p.right, p.val, max);
}
//This solution also goes to the left subtree first. If the violation occurs close to the root but on the right subtree, the method still cost O(n). The second solution below can handle violations close to root node faster.
//
//This solution can also be written as the following:
//
public boolean isValidBST(TreeNode root) {
    if(root==null)
        return true;
 
    return helper(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
}
 
public boolean helper(TreeNode root, double low, double high){
 
    if(root.val<=low || root.val>=high)
        return false;
 
    if(root.left!=null && !helper(root.left, low, root.val)){
        return false;
    }
 
    if(root.right!=null && !helper(root.right, root.val, high)){
        return false;
    }
 
    return true;    
}
//Java Solution 2 - Iterative

public class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
 
        LinkedList<BNode> queue = new LinkedList<BNode>();
        queue.add(new BNode(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY));
        while(!queue.isEmpty()){
            BNode b = queue.poll();
            if(b.n.val <= b.left || b.n.val >=b.right){
                return false;
            }
            if(b.n.left!=null){
                queue.offer(new BNode(b.n.left, b.left, b.n.val));
            }
            if(b.n.right!=null){
                queue.offer(new BNode(b.n.right, b.n.val, b.right));
            }
        }
        return true;
    }
}
//define a BNode class with TreeNode and it's boundaries
class BNode{
    TreeNode n;
    double left;
    double right;
    public BNode(TreeNode n, double left, double right){
        this.n = n;
        this.left = left;
        this.right = right;
    }
} 
    
    
}
