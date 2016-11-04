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

class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){ value = x;}

}
public class BinaryTreeLevelOrderTraversal {
    TreeNode root;
    public List<List<Integer>> levelOrder (TreeNode root){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> temp = new ArrayList<Integer>();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                temp.add(node.value);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            
            
            }
            result.add(temp);
        
        }
        return result;
    }
    
        public static void main(String[]  args){
        BinaryTreeLevelOrderTraversal sol = new BinaryTreeLevelOrderTraversal();
      
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(10);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(25);
        root.right.left = new TreeNode(30);
        root.right.right = new TreeNode(35);
       
        List<List<Integer>> result = sol.levelOrder(root);
        for(int i = 0; i < result.size(); i++){
          System.out.println(result.get(i).toString());
        }
        }
    
}
