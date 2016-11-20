/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;

/**
 *
 * @author myang2
 */
public class RemoveDuplicateFromUnsortedArray {
    public int[] remove (int[] arr){
        
        if(arr == null || arr.length==0) return null;
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int i = 0; i < arr.length;i++){
            
            if(!hs.contains(arr[i])){
                hs.add(arr[i]);
            }
        
        
        }
        int[] a = new int[hs.size()];
        int i = 0;
       for(Integer item: hs){
           a[i++] = item;
       }
       return a;
    
    
    }
    
    public static void main(String[] args){
        RemoveDuplicateFromUnsortedArray sol = new RemoveDuplicateFromUnsortedArray();
        int[] arr = {1,2,5,2,3,4,5};
        int[] result = sol.remove(arr);
        for(int i = 0; i < result.length;i++){
            System.out.println(result[i]);
        }
    
    }
    
    
}
