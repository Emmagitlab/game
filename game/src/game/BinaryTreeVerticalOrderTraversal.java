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

class TNode{
    int value;
    TNode left;
    TNode right;
    public TNode(int value){
        this.value = value;
    }

}
public class BinaryTreeVerticalOrderTraversal {
    public List<List<Integer>> BTVerticalOrder(TNode root){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;
        int max = 0, min = 0;
        Queue<TNode> queue = new LinkedList<TNode>();
        Queue<Integer> cols = new LinkedList<>();
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        queue.offer(root);
        cols.offer(0);
        while(!queue.isEmpty()){
            TNode temp = queue.poll();
            int col = cols.poll();
            if(!map.containsKey(col))
                map.put(col, new ArrayList<>());
            map.get(col).add(temp.value);
            
            if(temp.left != null){
                queue.offer(temp.left);
                cols.offer(col - 1);
                min = min < col? min:col-1;
               // System.out.println("min:" +min);
            }
            if(temp.right != null){
                queue.offer(temp.right);
                cols.offer(col +1);
                max = max > col+1? max:col+1;
               // System.out.println("max:" +max);
            }  
        
        }
        for(int i = min; i <= max; i++){
            result.add(map.get(i));
        }
        return result;
    }
    
    public static void main(String[] args){
    BinaryTreeVerticalOrderTraversal sol = new BinaryTreeVerticalOrderTraversal();
        TNode root = new TNode(3);
        root.left = new TNode(9);
        root.right = new TNode(20);
        root.right.left = new TNode(15);
        root.right.right = new TNode(7);
       
        List<List<Integer>> result = sol.BTVerticalOrder(root);
        
        for(int i = 0; i < result.size(); i++){
          System.out.println(result.get(i).toString());
        }
    
    }
}
