/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author T440
 */
public class IntersectionOfTwoArrays {
    public int[] intersectWithDuplicate(int[] num1, int[]num2){
        List<Integer> result =new ArrayList<Integer>();
        Arrays.sort(num1);
        Arrays.sort(num2);
        int i = 0;
        int j = 0;
        while(i < num1.length && j < num2.length){
            if(num1[i] < num2[j]){
                i++;
            }else if(num1[i] == num2[j]){
                result.add(num1[i]);
                i++;
                j++;
            }else {
                j++;
            }
        }
        int[] res = new int[result.size()];
        for(int m = 0;  m < result.size(); m++){
            res[m] = result.get(m);
        
        }
        return res;
    }
    
}
