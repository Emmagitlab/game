/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author myang2
 */
public class FlattenBTtoLinkedList {
    
    public void flatten(TreeNode root){
        
        if(root == null) return ;

        while(root!= null){
            if(root.left != null){
                TreeNode pre = root.left;
                while(pre.right != null){
                    pre = pre.right;
                
                }
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
            
            }
            
            root = root.right;
        
        }
    }
    
}
