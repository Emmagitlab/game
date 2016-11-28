/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author T440
 */
/*  首先定义了suffix string 或者说suffix arrary. from: 1point3acres.com/bbs 
 如果有个数组是 int[] text = {10, 20, 30, 25}
 那么 suffix[0] = {10, 20, 30, 25}
 suffix[1] = {20, 30, 25}
 suffix[2] = {30, 25}
 suffix[3] = {25}
 如果对这些数组进行lexical order 的排序，我们可以得到
 suffix[0] < suffix[1] < suffix[3] < suffix[2]
 问题是：
 input: int[] text
 output: int[] suffix_array_order 鏉ユ簮涓€浜�.涓夊垎鍦拌鍧�. 
 e.g.
 input: int[] text = {10, 20, 30, 25}
 output: int[] suffix_array_order = {0, 1, 3, 2}
 */
public class SuffixArray {

    public static class Entry implements Comparable<Entry> {

        int[] nums;
        int idx;

        public Entry(int[] nums, int idx) {
            this.nums = nums;
            this.idx = idx;
        }

        public int compareTo(Entry entry2) {
            return compare(nums, entry2.nums);
        }
    }

    private static int compare(int[] nums1, int[] nums2) {
        for (int i = 0; i < nums1.length && i < nums2.length; i++) {
            if (nums1[i] == nums2[i]) {
                continue;
            }
            return Integer.toString(nums1[i]).compareTo(Integer.toString(nums2[i]));
        }
        if (nums1.length < nums2.length) {
            return -1;
        } else if (nums1.length == nums2.length) {
            return 0;
        } else {
            return 1;
        }
    }

    private int[] sortSuffix(int[] nums) {
        List<Entry> entries = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int tmp[] = new int[nums.length - i];
            for (int j = 0; j < tmp.length; j++) {
                tmp[j] = nums[i + j];
            }
            Entry entry = new Entry(tmp, i);
            entries.add(entry);
        }
        Collections.sort(entries);
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = entries.get(i).idx;
            System.out.println(res[i]);
        }
        return res;
    }

    private boolean containSubArr(int[] nums, int subArr[], int[] suffix) {
        int s = 0;
        int e = nums.length - 1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            int idx = suffix[m];
            int compare = 0;
            int i = 0;
            for (; i < subArr.length; i++) {
                if (idx + i >= nums.length) {
                    compare = 1;
                    break;
                }
                if (subArr[i] != nums[idx + i]) {
                    compare = Integer.toString(subArr[i]).compareTo(Integer.toString(nums[idx + i]));
                    break;
                }
            }
            if (compare == 0) {
                return true;
            } else if (compare < 0) {
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SuffixArray s = new SuffixArray();
        int[] nums = new int[]{10, 20, 30, 25, 40, 50, 60, 10};
        int[] suffixArray = s.sortSuffix(nums);
        int[] sub = new int[]{10, 10};
        System.out.println(s.containSubArr(nums, sub, suffixArray));
    }

}
