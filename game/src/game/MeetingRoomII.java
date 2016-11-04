/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;
import java.util.*;
import game.InsertInterval;
/**
 *
 * @author T440
 */


public class MeetingRoomII {
    public int minMeetingRoomes(Interval[] intervals){
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        int count = 0;
        for(int i = 0; i < intervals.length; i++){
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int endsIndex = 0;
        for(int i = 0; i < intervals.length; i++){
            if(starts[i] < ends[endsIndex])
                count++;
            else
                endsIndex++;
                
        }
        return count;
    }
    public static void main(String[] args){
        MeetingRoomII sol = new MeetingRoomII();
        Interval[] intervals = {new Interval(0,30),new Interval(5,10),new Interval(15,20)};
  
        System.out.println(sol.minMeetingRoomes(intervals));
    
    
    }
    
}
