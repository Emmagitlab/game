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
public class SubarraySumToTargetNegative {
    
    public void subarraySumToTarget(int[] A, int target){
        if(A == null || A.length == 0) return;
        int currSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < A.length; i++){
            currSum += A[i];
            if(currSum == target){
                System.out.println("subarray: 0 -" +i +" " );
            }else if(map.containsKey(A[i])){
                System.out.println("subarray: "+ (map.get(A[i])+1)+ "-" +i );
                map.put(A[i], i);
            }else{
                map.put(A[i]+target,i);
                
            }
        
        }
    
    
    }
    public static void main(String[] args){
        SubarraySumToTargetNegative sol = new SubarraySumToTargetNegative();
        int[] A = {1,2,3,4,-1,5,6,6,6};
        int target = 6;
        sol.subarraySumToTarget(A, target);
    }
    
}
