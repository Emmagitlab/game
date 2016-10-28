/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package work;

import java.io.*;
import java.util.*;

/**
 *
 * @author T440
 */
public class RandomReturnMax {

    public int find(int[] A) {
        int maxValue = Integer.MIN_VALUE;
        int count = 0; // count # of max value
        Random rand = new Random();
        int reserve = 0;  // remeber max values index
        for (int i = 0; i < A.length; i++) {
            if (A[i] == maxValue) {
                count++;
                int randomIndex = rand.nextInt(count);
                if (randomIndex == 0) {  // make sure reserve index randomly
                    reserve = i; // randomly change index
                }
            }
            if (A[i] > maxValue) {
                count = 1;   // update count #
                maxValue = A[i];  // update maxValue;
                reserve = i;  //update index

            }
        }
        return reserve;

    }

    public static void main(String[] args) {
        RandomReturnMax rrm = new RandomReturnMax();
        int[] A = {1, 2, 6, 4, 5, 3, 6, 6};
        int count2 = 0;
        int count6 = 0;
        int count7 = 0;
        for (int i = 0; i < 1000; i++) {
            int res = rrm.find(A);
            if (res == 2) {
                count2++;
            }
            if (res == 6) {
                count6++;
            }
            if (res == 7) {
                count7++;
            }

        }
        System.out.println("6 appears " + count6 + " times");
        System.out.println("4 appears " + count2 + " times");
        System.out.println("7 appears " + count7 + " times");
    }

}
