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


//和I的思路一样，不过这里我们有K个颜色，不能简单的用Math.min方法了。
//如果遍历一遍颜色数组就找出除了自身外最小的颜色呢？我们只要把最小和次小的都记录下来就行了，
//这样如果和最小的是一个颜色，就加上次小的开销，反之，则加上最小的开销。
public class PaintHoustII {
    public int minCostII(int cost[][]){
        if(cost == null || cost.length ==0) return 0;
        int preMin = 0, preSec = 0, preIdx = -1;
        for(int i = 0; i < cost.length;i++){
            int currMin = Integer.MAX_VALUE, currSec = Integer.MAX_VALUE, currIdx = -1;
            for(int j = 0; j < cost[0].length;j++){
                cost[i][j] = cost[i][j]+(preIdx == j? preSec : preMin);
                if(cost[i][j] < currMin){
                    currSec = currMin;
                    currMin = cost[i][j];
                    currIdx = j;
                
                }else if(cost[i][j] < currSec){
                    currSec = cost[i][j];
                }
            }
            preMin = currMin;
            preSec = currSec;
            preIdx = currIdx;
        
        
        
        }
    
        return preMin;
    }
    
}
