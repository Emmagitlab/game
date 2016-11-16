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
public class UniquePathII {
    //二維
    public int uniquePathsWithObstacles(int[][] A) {
       int m = A.length, n = A[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (A[i][0] == 0) dp[i][0] = 1;
            else break;
        }
        for (int j = 0; j < n; j++) {
            if (A[0][j] == 0) dp[0][j] = 1;
            else break;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (A[i][j] == 0) dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
        
    }

    //一維
    public class Solution {
    public int uniquePathsWithObstacles(int[][] A) {
        int n = A[0].length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) dp[j] = 0;
                else if (j > 0) dp[j] += dp[j-1];
            }
        }
        return dp[n-1];
    }
}
    
}
