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
class Inteval{
    int start;
    int end;
    

}
public class MergeInterval {
    public List<Interval> merge(List<Interval> intervals){
        if(intervals.size() <= 1) return intervals;
        Collections.sort(intervals, new Comparator<Interval>(){
        public int compare(Interval i1, Interval i2){
            return Integer.compare(i1.start, i2.start);
        }
    
    });
        List<Interval> result = new LinkedList<Interval>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for(Interval item: intervals){
            if(item.start <= end)
                end = Math.max(item.end, end);
            else{
                result.add(new Interval(start, end));
                start = item.start;
                end = item.end;
            }
        }
        result.add(new Interval(start, end));
        return result;
    }
    
}
