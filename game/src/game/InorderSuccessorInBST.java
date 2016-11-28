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
// Java program to find minimum value node in Binary Search Tree
// A binary tree node
//Time Complexity: O(h) where h is height of tree.
class BinaryTree {
            class TreeNode {

            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int x) {
                val = x;
            }
        }

    class Node {

        int data;
        Node left, right, parent;

        Node(int d) {
            data = d;
            left = right = parent = null;
        }
    }

    static Node head;

    /* Given a binary search tree and a number, 
     inserts a new node with the given number in 
     the correct place in the tree. Returns the new 
     root pointer which the caller should then use 
     (the standard trick to avoid using reference 
     parameters). */
    Node insert(Node node, int data) {

        /* 1. If the tree is empty, return a new,	 
         single node */
        if (node == null) {
            return (new Node(data));
        } else {

            Node temp = null;

            /* 2. Otherwise, recur down the tree */
            if (data <= node.data) {
                temp = insert(node.left, data);
                node.left = temp;
                temp.parent = node;

            } else {
                temp = insert(node.right, data);
                node.right = temp;
                temp.parent = node;
            }

            /* return the (unchanged) node pointer */
            return node;
        }
    }

    Node inOrderSuccessor(Node root, Node n) {

        // step 1 of the above algorithm 
        if (n.right != null) {
            return minValue(n.right);
        }

        // step 2 of the above algorithm
        Node p = n.parent;
        while (p != null && n == p.right) {
            n = p;
            p = p.parent;
        }
        return p;
    }

    /* Given a non-empty binary search tree, return the minimum data 
     value found in that tree. Note that the entire tree does not need
     to be searched. */
    Node minValue(Node node) {
        Node current = node;

        /* loop down to find the leftmost leaf */
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    // Driver program to test above functions
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Node root = null, temp = null, suc = null, min = null;
        root = tree.insert(root, 20);
        root = tree.insert(root, 8);
        root = tree.insert(root, 22);
        root = tree.insert(root, 4);
        root = tree.insert(root, 12);
        root = tree.insert(root, 10);
        root = tree.insert(root, 14);
        temp = root.left.right.right;
        suc = tree.inOrderSuccessor(root, temp);
        if (suc != null) {
            System.out.println("Inorder successor of " + temp.data
                    + " is " + suc.data);
        } else {
            System.out.println("Inorder successor does not exist");
        }
    }

        // no parent
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {



        if (root == null || p == null) return null;
        if (p.right != null) {
            TreeNode next = p.right;
            while(next.left != null) {
                next = next.left;
            }
            return next;
        } else {
            TreeNode node = root;
            TreeNode next = null;
            while (true) {
                if (node.val > p.val) {
                    next = node;
                    node = node.left;
                } else if (node.val < p.val) {
                    node = node.right;
                } else {
                    break;
                }
            }
            return next;
        }
    }
}

// This code has been contributed by Mayank Jaiswal

