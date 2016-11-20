/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author myang2
 */
public class BinaryTreepPaths {
    
    public List<String> binaryTreePaths(TreeNode root){
        
        List<String> result = new ArrayList<String>();
        if(root == null) return result;
        String path = root.value+"";
        dfs(result,path,root);
        return result;
    
    
    }
    public void dfs(List<String> result, String path, TreeNode root){
        if(root.left == null && root.right == null ) result.add(path);
        if(root.left != null) dfs(result,path+"->"+root.left.value,root.left);
        if(root.right != null) dfs(result,path+"->"+root.right.value,root.right);
    
    
    }
    
}
