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




/*

After robbing those houses on that street, the thief has found himself a new place for his thievery 
so that he will not get too much attention. This time, all houses at this place are arranged in a circle. 
That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses 
remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, 
determine the maximum amount of money you can rob tonight without alerting the police.
*/
public class HouseRobberII {
    public int rob(int[] nums){
        if(nums.length == 0 ) return 0;
        if(nums.length == 1) return nums[0];
      //  if(nums.length == 2) return Math.max(nums[0],nums[1]);
        return Math.max(helper(nums,0,nums.length - 2), helper( nums, 1, nums.length-1));
    
    }
    
    public int helper(int[] nums, int start, int end){
        int curr, pre, pre2;
        curr = pre = pre2 = 0;
        for(int i = start; i <= end; i++){
        
            curr = Math.max(pre, pre2+ nums[i]);
            pre2 = pre;
            pre = curr;
        }
        return curr;
    
    }
    
    
    public static void main(String[] args){
        HouseRobberII sol = new HouseRobberII();
        int[] nums = {1,1,1};
        System.out.println(sol.rob(nums));
        
        
    
    
    }
}
