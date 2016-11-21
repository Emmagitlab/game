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
public class MinmunDepthOfBinaryTree {
    //dfs
        public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left == null){
            return minDepth(root.right)+1;
        }
        
        if(root.right == null){
            return minDepth(root.left)+1;
        }
        return Math.min(minDepth(root.right),minDepth(root.left))+1;
    }
    //bfs
          public int maxDepth(TreeNode root) {
        
        if (root == null) return 0;
        
        return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}


//  https://segmentfault.com/a/1190000004255645
