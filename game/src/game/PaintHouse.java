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


//  https://segmentfault.com/a/1190000003903965
public class PaintHouse {
    public int paintHouse(int[][] cost){
        if(cost == null || cost.length == 0) return 0;
        for(int i = 1; i< cost.length;i ++){
            cost[i][0] = cost[i][0]+Math.min(cost[i-1][1],cost[i-1][2]);
            cost[i][1] = cost[i][1]+Math.min(cost[i-1][0], cost[i-1][2]);
            cost[i][2] = cost[i][2]+Math.min(cost[i-1][0],cost[i-1][1]);
        
        }
        return Math.min(cost[cost.length][0], Math.min(cost[cost.length][1],cost[cost.length][2]));
    
    
    }
    
}
