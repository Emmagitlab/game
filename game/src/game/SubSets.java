/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author T440
 */
public class SubSets {
    public List<List<Integer>> subSets(int[] num){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(num == null || num.length == 0) return result;
        List<Integer> list = new ArrayList<Integer>();
        dfs(num,0,result,list);
        return result;
    }
    public void dfs(int[] num, int pos,List<List<Integer>> result,List<Integer> list){
        result.add(new ArrayList<Integer>(list));
        for(int i = pos; i < num.length; i++ ){
            list.add(num[i]);
            dfs(num,i+1,result,list);
            list.remove(list.size()-1);
        
        }
    
    }
    public static void main(String[] args){
        SubSets sol = new SubSets();
        int[] num = {1,2,3};
        List<List<Integer>> result = sol.subSets(num);
        for(int i = 0; i < result.size(); i++){
            for(int j = 0; j < result.get(i).size();j++){
                System.out.print(result.get(i).get(j)+"");
            
            }
            System.out.println();
        }
        
    }
}
