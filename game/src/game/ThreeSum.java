/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.*;

/**
 *
 * @author T440
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        boolean isSame = false;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                List<Integer> tmp = map.get(nums[i]);
                tmp.add(i);

            } else {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(i);
                map.put(nums[i], tmp);
            }

        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int remain = target - nums[i] - nums[j];
                if (map.containsKey(remain)) {
                    List<Integer> tmp = map.get(remain);
                    for (int index : tmp) {
                        if (index > j) {
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[index]);
                            for(int m = 0; m < result.size(); m++){
                                if(list.equals(result.get(m))){
                                    isSame = true;
                                    list.remove(list.size()-3);
                                    list.remove(list.size()-2);
                                    list.remove(list.size()-1);
                                }
                            }
                            if (result.isEmpty() || !isSame) {
                                result.add(list);
                            }
                        }
                    }
                }

            }

        }
        return result;

    }

    public static void main(String[] args) {
        ThreeSum sol = new ThreeSum();
        int[] num = {2, 4,4, 2,2,2,1,4, 11,4, 15};
        int target = 9;
        int target2 = 8;
        List<List<Integer>> result3Sum = sol.threeSum(num, target2);
        for (int i = 0; i < result3Sum.size(); i++) {
            System.out.println(result3Sum.get(i).toString());
        }

    }
}
