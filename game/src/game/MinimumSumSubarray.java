/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;

/**
 *
 * @author T440
 */
public class MinimumSumSubarray {
     public int minSubArray(ArrayList<Integer> nums) {
        if (nums == null)
            return 0;
        int len = nums.size();
        int min = Integer.MAX_VALUE, currSum = 0;
        int []localmin  = new int[len];
        int []globalmin = new int[len];
        for (int i = 0; i < len; i++) {
            if( i ==0 )
                globalmin[i] = localmin[i] = nums.get(i);
            else {
                localmin[i] = Math.min(localmin[i - 1] + nums.get(i), nums.get(i));
                globalmin[i] = Math.min(globalmin[i - 1], localmin[i]);
            }
            
        }
        return globalmin[len-1];
    }
    
}
