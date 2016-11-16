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
public class UniquePath {
   
    
    public int uniquePaths(int m, int n) {  
        // DP with 1 dimension array  
        int[] a = new int[n];  
        for (int j = 0; j < n; j++) {  
            a[j] = 1;  
        }  
        for (int i = 1; i < m; i++) {  
            for (int j = 1; j < n; j++) {  
                a[j] += a[j-1];  
            }  
        }  
        return a[n-1];  
    } 

}
