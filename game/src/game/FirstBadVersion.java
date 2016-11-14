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
public class FirstBadVersion {
    public int firstBad(int n){
        int start = 1;
        int end = n;
        while(start < end){
            int mid = start + (end - start)/2;
            if(isBadVersion(mid)) end = mid;
            else start = mid+1;
        }
        return start;
    }
}
