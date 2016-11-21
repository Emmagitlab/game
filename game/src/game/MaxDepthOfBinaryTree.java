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
public class MaxDepthOfBinaryTree { 
    
    public int maxDepth(TreeNode root) {
        
        if (root == null) return 0;
        
        return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
    }
    
}
