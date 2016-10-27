/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;
import java.io.*;
import java.util.*;

/**
 *
 * @author T440
 */
public class RandomReturnMax {
    
    public int find(int[] A){
    Random rand = new Random();
    int reserve = 0 ;
    int maxValue = Integer.MIN_VALUE;
    int count = 0;
    for(int i = 0; i < A.length; i++){
        if(A[i] == maxValue){
            count++;
            int randNum = rand.nextInt(count);
            if(randNum <1){
                reserve = i;
            }
        
        }
        if(A[i] > maxValue ){
         maxValue =  A[i];
         count = 1;
         reserve = i;
        
        }
        
    }
    
    return reserve;
    
    }
    
    public static void main(String[] args){
        RandomReturnMax rrm = new RandomReturnMax();
        int[] A = {1,2,3,4,5,3,5,5};
        int count4 = 0;
        int count6 = 0;
        int count7 = 0;
        for(int i =0; i < 1000; i++){
            int res = rrm.find(A);
            if(res == 4){
            count4++;
            }
            if(res == 6){
            count6++;
            }
            if(res == 7){
            count7++;
            }
            
        }
    System.out.println("6 appears " + count6 + " times");
    System.out.println("4 appears " + count4 + " times");
    System.out.println("7 appears " + count7 + " times");
    }
    
}
