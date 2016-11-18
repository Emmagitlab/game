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

/*Given a set of distinct integers, nums, return all possible subsets.
Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,3], a solution is:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]*/
public class SubSets {
    
    //recursive
    public List<List<Integer>> subSets(int[] num){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if( num == null||num.length == 0) return result;
        List<Integer> list = new ArrayList<Integer>();
        int pos = 0;
        Arrays.sort(num);
        DFS(num,pos,result,list);
        return result;
    
    }
    
    
    public void DFS(int[] num, int pos, List<List<Integer>> result, List<Integer> list){
        result.add(new ArrayList<>(list));
        for(int j = pos; j < num.length; j++){
            list.add(num[j]);
            DFS(num,j+1,result,list);
            list.remove(list.size()-1);
        
        }
    
    
    }
    
    //iterative
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
	if (S == null)
		return null;
 
	Arrays.sort(S);
 
	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
 
	for (int i = 0; i < S.length; i++) {
		ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
 
		//get sets that are already in result
		for (ArrayList<Integer> a : result) {
			temp.add(new ArrayList<Integer>(a));
		}
 
		//add S[i] to existing sets
		for (ArrayList<Integer> a : temp) {
			a.add(S[i]);
		}
 
		//add S[i] only as a set
		ArrayList<Integer> single = new ArrayList<Integer>();
		single.add(S[i]);
		temp.add(single);
 
		result.addAll(temp);
	}
 
	//add empty set
	result.add(new ArrayList<Integer>());
 
	return result;
}
    public static void main(String[] args){
        SubSets sol = new SubSets();
        int[] num = {1,2,3};
        List<List<Integer>> result = sol.subSets(num);
        ArrayList<ArrayList<Integer>> res = sol.subsets(num);
        for(int i = 0; i < result.size(); i++){
            for(int j = 0; j < result.get(i).size();j++){
                System.out.print(result.get(i).get(j)+"");
            
            }
            System.out.println();
        }
        
    }
}
