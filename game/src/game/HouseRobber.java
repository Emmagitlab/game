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
public class HouseRobber {
     public int rob(int[] nums) {  
    if(nums.length==0) return 0;
    if(nums.length==1) return nums[0];

    //Initialize an arrays to store the money
	int[] mark = new int[nums.length];

    //We can infer the formula from problem:mark[i]=max(num[i]+mark[i-2],mark[i-1])
    //so initialize two nums at first.
	mark[0] = nums[0];
	mark[1] = Math.max(nums[0], nums[1]);

    //Using Dynamic Programming to mark the max money in loop.
	for(int i=2;i<nums.length;i++){
		mark[i] = Math.max(nums[i]+mark[i-2], mark[i-1]);
	}
	return mark[nums.length-1];
}
    
}
