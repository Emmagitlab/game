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

class Interval{
    int start;
    int end;
    Interval(){start = 0; end = 0;}
    Interval(int s, int e){start = s; end = e;}
}
public class InsertInterval {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval){
        if(newInterval == null || intervals == null) return intervals;
        ArrayList<Interval> result = new ArrayList<>();
        int position = 0;
        for(Interval item : intervals){
            if(item.end < newInterval.start){
               result.add(item);
               position++;
            }else if(item.start > newInterval.end){
                result.add(item);
            }else{
                newInterval.start = Math.min(item.start,newInterval.start);
                newInterval.end = Math.max(item.end, newInterval.end);
            }
        }
        result.add(position,newInterval);
        return result;
    
    }
    public static void main(String[] args){
        Interval interval1 = new Interval(1,3);
        Interval interval2 = new Interval(6,9);
        Interval interval3 = new Interval(2,5);
        
        ArrayList<Interval> l = new ArrayList<>();
        l.add(interval1);
        l.add(interval2);
        InsertInterval ii = new InsertInterval();
        ArrayList<Interval> result = ii.insert(l, interval3);
        for( int i = 0; i < result.size();i++)
            System.out.println(result.get(i).start +" "+ result.get(i).end);
    
    
    }
    
    
    
}
