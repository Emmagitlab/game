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
public class UniquePaths {
    public int uniquePaths(int m, int n){
        int[] dp = new int[n];
        for(int i= 0; i < n; i++){
            dp[i] =1;
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dp[j] += dp[j-1];
            }
        }
        return dp[n-1];
    }
    
}
