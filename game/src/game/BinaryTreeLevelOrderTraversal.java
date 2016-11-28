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
    int val;
    TreeNode(int x){ value = x;}
   // TreeNode(int y){ val = y;}

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
    
    public List<Double> getAverage(List<List<Integer>> result){
        List<Double> res= new ArrayList<Double>();
        double sum = 0;
        double average = 0;
        for(int i = 0; i < result.size();i++){
            for(int j = 0; j < result.get(i).size(); j++){
                sum += result.get(i).get(j);
            }
            
            res.add((Double)sum/result.get(i).size());
            sum = 0;
        }
        return res;
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
        
        List<Double> res = sol.getAverage(result);
        for(int j = 0; j < res.size(); j++){
            System.out.println(res.get(j)+"");
        
        }
        }
        
    
}
