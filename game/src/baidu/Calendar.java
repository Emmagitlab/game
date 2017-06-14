/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baidu;

/**
 *
 * @author T440
 */

//https://instant.1point3acres.com/thread/271863

import java.util.*;
import java.util.Map.Entry;

public class Calendar {
  List<Event> schedule ;
  List<ConflictedTimeWindow> res ; 
  PriorityQueue<Event> q ;
  Map<Date, HashMap<Date,HashSet<Integer>>> map;
  public Calendar() {
     schedule = new ArrayList<Event>();
     res = new ArrayList<ConflictedTimeWindow>();
     map = new HashMap<>();
  }

  // Should allow multiple events to be scheduled over the same time window.
  public void schedule(Event event) {
    // IMPLEMENT ME

      schedule.add(event);
         
  }

  public List<ConflictedTimeWindow> findConflictedTimeWindow() {
    // IMPLEMENT ME
     Collections.sort(schedule, new Comparator<Event>(){
         @Override
         public int compare(Event e1, Event e2){
             if(e1.startDate.equals(e2.startDate)){
                 return e1.endDate.compareTo(e2.endDate) ;
             }else 
                 return e1.startDate.compareTo(e2.startDate);
         }
     
     });
      for(Event ele: schedule){
        System.out.println(ele);
    }
     
     int index = 0;
     Date start = schedule.get(index).startDate;
     Date end = schedule.get(index).endDate;
     while(index < schedule.size()-1){
     for(int i = 1; i < schedule.size();i++){
         Event ele = schedule.get(i);
         if(ele.startDate.compareTo(end) <0){
             Date newEnd = ele.endDate.compareTo(end) < 0 ? ele.endDate : end;
             Date newStart = ele.startDate.compareTo(start) > 0 ? ele.startDate: start;
             if(!map.containsKey(newStart)){
                 HashMap<Date,HashSet<Integer>> temp = new HashMap<>();
                 temp.put(newEnd, new HashSet<Integer>());
                 temp.get(newEnd).add(ele.id);
                 temp.get(newEnd).add(schedule.get(index).id);
                 map.put(newStart,temp);
             }else{
                 HashMap<Date,HashSet<Integer>> temp = map.get(newStart);
                 if(!temp.containsKey(newStart)){
                     temp.put(newEnd, new HashSet<Integer>());
                 }
                 temp.get(newEnd).add(ele.id);
                 temp.get(newEnd).add(schedule.get(index).id);
             }
             

         } else{
             start = ele.startDate;
             end = ele.endDate;
         
         }
            index++;
            start = schedule.get(index).startDate;
            end =schedule.get(index).endDate;
         
     }
     
     }
      for(Map.Entry<Date, HashMap<Date,HashSet<Integer>>> entry : map.entrySet()){
            HashMap<Date,HashSet<Integer>> temp = map.get(entry.getKey());
            Date startT = entry.getKey();
            for(Map.Entry<Date,HashSet<Integer>> ele : temp.entrySet()){
                Date endT = ele.getKey();
                HashSet<Integer> tempSet = ele.getValue();
                res.add(new ConflictedTimeWindow(startT,endT,tempSet));         
            } 
      }
      return res;
  }

  public static class ConflictedTimeWindow {
    private final Date startDate;
    private final Date endDate;
    private final Set<Integer> conflictedEventIds;

    public ConflictedTimeWindow(Date startDate, Date endDate, Set<Integer> conflictedEventIds) {
      this.startDate = startDate;
      this.endDate = endDate;
      this.conflictedEventIds = conflictedEventIds;
    }

    public Date getStartDate() {
      return startDate;
    }

    public Date getEndDate() {
      return endDate;
    }

    public Set<Integer> getConflictedEventIds() {
      return conflictedEventIds;
    }

    @Override
    public String toString() {
      return "ConflictedTimeWindow{" +
          "startDate=" + startDate +
          ", endDate=" + endDate +
          ", conflictedEventIds=" + conflictedEventIds +
          '}';
    }
  }

  public static class Event {
    private final int id;
    private final Date startDate;
    private final Date endDate;

    public Event(int id, Date startDate, Date endDate) {
      this.id = id;
      this.startDate = startDate;
      this.endDate = endDate;
    }

    @Override
    public String toString() {
      return "Event{" +
          "id=" + id +
          ", startDate=" + startDate +
          ", endDate=" + endDate +
          '}';
    }
  }

  public static void main(String[] args) {
    Calendar calendar = new Calendar();

    calendar.schedule(new Event(1, new Date(114, 0, 1, 10, 0), new Date(114, 0, 1, 11, 0))); // 2014-01-01 10:00 - 11:00
    calendar.schedule(new Event(2, new Date(114, 0, 1, 11, 0), new Date(114, 0, 1, 12, 0))); // 2014-01-01 11:00 - 12:00
    calendar.schedule(new Event(3, new Date(114, 0, 1, 12, 0), new Date(114, 0, 1, 13, 0))); // 2014-01-01 12:00 - 13:00

    calendar.schedule(new Event(4, new Date(114, 0, 2, 10, 0), new Date(114, 0, 2, 11, 0))); // 2014-01-02 10:00 - 11:00
    calendar.schedule(new Event(5, new Date(114, 0, 2, 9, 30), new Date(114, 0, 2, 11, 30))); // 2014-01-02 09:30 - 11:30
    calendar.schedule(new Event(6, new Date(114, 0, 2, 8, 30), new Date(114, 0, 2, 12, 30))); // 2014-01-02 08:30 - 12:30

    calendar.schedule(new Event(7, new Date(114, 0, 3, 10, 0), new Date(114, 0, 3, 11, 0))); // 2014-01-03 10:00 - 11:00
    calendar.schedule(new Event(8, new Date(114, 0, 3, 9, 30), new Date(114, 0, 3, 10, 30))); // 2014-01-03 09:30 - 10:30
    calendar.schedule(new Event(9, new Date(114, 0, 3, 9, 45), new Date(114, 0, 3, 10, 45))); // 2014-01-03 09:45 - 10:45
    
   

    List<ConflictedTimeWindow> conflictedTimeWindows = calendar.findConflictedTimeWindow();
    System.out.println(conflictedTimeWindows);
    // should print something like
    // [ConflictedTimeWindow{startDate=Thu Jan 02 09:30:00 PST 2014, endDate=Thu Jan 02 10:00:00 PST 2014, conflictedEventIds=[5, 6]},
    //  ConflictedTimeWindow{startDate=Thu Jan 02 10:00:00 PST 2014, endDate=Thu Jan 02 11:00:00 PST 2014, conflictedEventIds=[4, 5, 6]},
    //  ConflictedTimeWindow{startDate=Thu Jan 02 11:00:00 PST 2014, endDate=Thu Jan 02 11:30:00 PST 2014, conflictedEventIds=[5, 6]},
    //  ConflictedTimeWindow{startDate=Fri Jan 03 09:45:00 PST 2014, endDate=Fri Jan 03 10:00:00 PST 2014, conflictedEventIds=[8, 9]},
    //  ConflictedTimeWindow{startDate=Fri Jan 03 10:00:00 PST 2014, endDate=Fri Jan 03 10:30:00 PST 2014, conflictedEventIds=[7, 8, 9]},
    //  ConflictedTimeWindow{startDate=Fri Jan 03 10:30:00 PST 2014, endDate=Fri Jan 03 10:45:00 PST 2014, conflictedEventIds=[7, 9]}]
  }

}
