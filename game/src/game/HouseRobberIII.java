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

/*
这种方法的递归函数返回一个大小为2的一维数组res，其中res[0]表示不包含当前节点值的最大值，
res[1]表示包含当前值的最大值，那么我们在遍历某个节点时，首先对其左右子节点调用递归函数，
分别得到包含与不包含左子节点值的最大值，和包含于不包含右子节点值的最大值，
那么当前节点的res[0]就是左子节点两种情况的较大值加上右子节点两种情况的较大值，
res[1]就是不包含左子节点值的最大值加上不包含右子节点值的最大值，和当前节点值之和，返回即可，参见代码如下：

 
*/
public class HouseRobberIII {
    public int rob(TreeNode root) {
        int[] res = robSub(root);
        return Math.max(res[0],res[1]);
        
    }
    public int[] robSub(TreeNode root){
        if(root == null)
        return new int[2];
        
        int[] left = robSub(root.left);
        int[] right = robSub(root.right);
        
        int[] res = new int[2];
        res[0] = Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        res[1] = root.val + left[0] + right[0];
        
        return res;
    }
}
