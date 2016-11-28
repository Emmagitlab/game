/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        public int minDepthBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int dep = 1;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left == null && curr.right == null) {
                    return dep;
                }
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            dep++;
        }
        return dep;
    }
}


//  https://segmentfault.com/a/1190000004255645
