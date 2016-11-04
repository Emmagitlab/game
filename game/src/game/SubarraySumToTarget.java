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
public class SubarraySumToTarget {
    public boolean subarraySumToTarget(int[] A, int target){
        if(A == null || A.length == 0 || target < 0) return false;
        int currSum = 0;
        int start = 0;
        for(int i = 0 ; i < A.length; i++){
            currSum += A[i];
            while(currSum > target){
                currSum -= A[i];
                start++;
            }
            if(currSum == target) return true;  
        
        }

        return false;
    }
    
    public static void main(String[] args){
        SubarraySumToTarget sol = new SubarraySumToTarget();
        int[] A = {15,2,4,8,9,5,10,23};
        int target = 7;
        System.out.print(sol.subarraySumToTarget(A, target));
    }
    
    
}
