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

public class Calendar1 {
  List<Event> schedule ;
  List<ConflictedTimeWindow> res ; 
  PriorityQueue<Event> q ;
  Map<Date, HashMap<Date,HashSet<Integer>>> map;
  public Calendar1() {
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
      
      List<ConflictedTimeWindow> list= new ArrayList<>();
    
     for(int j = 0; j < schedule.size();j++){
         Date start = schedule.get(j).startDate;
         Date end = schedule.get(j).endDate;
         for(int i = j+1; i < schedule.size(); i++){
             if(schedule.get(i).startDate.compareTo(start)!= 0 && schedule.get(i).startDate.compareTo(end) <0){
                 start = schedule.get(i).startDate;
                 end = end.compareTo(schedule.get(i).endDate)<0 ? end:schedule.get(i).endDate;
                 int m = 0;
                 int index = -1;
                 while( m < list.size()){
                     if(list.get(m).startDate.compareTo(start) == 0 && list.get(m).endDate.compareTo(end) == 0){
                         list.get(m).conflictedEventIds.add(schedule.get(j).id);
                         list.get(m).conflictedEventIds.add(schedule.get(i).id);
                         index = m;
                     }
                     m++;
                     
                 }
                 if(index == -1){
                     ConflictedTimeWindow temp = new ConflictedTimeWindow(start, end,new HashSet<Integer>());
                     list.add(temp);
                     temp.conflictedEventIds.add(schedule.get(j).id);
                     temp.conflictedEventIds.add(schedule.get(i).id); 
                 }
                
             }
         }
     }

//     for(ConflictedTimeWindow ele: list){
//         res.add(ele);
//     }
     Date start = list.get(0).startDate;
     Date end = list.get(0).endDate;
     for(int i = 1; i < list.size()-1;i++){
         System.out.println("curr item: "+ list.get(i).toString());
         if(list.get(i).startDate.compareTo(end) <0){
             ConflictedTimeWindow temp = new ConflictedTimeWindow(start,list.get(i).startDate,new HashSet<Integer>());
             temp.conflictedEventIds.addAll(list.get(i-1).conflictedEventIds);
             System.out.println("add item temp:" + temp.toString());
             res.add(temp);
             int m = 0;
             int index = -1;
             if(list.get(i).endDate.compareTo(end) <0){
                ConflictedTimeWindow temp2 = new ConflictedTimeWindow(list.get(i).endDate,end,new HashSet<Integer>());
                temp2.conflictedEventIds.addAll(list.get(i-1).conflictedEventIds);
                System.out.println("add item temp2:" + temp2.toString());
                res.add(temp2);
             } else {        
                 while( m < res.size()){
                     if(res.get(m).startDate.compareTo(list.get(i).startDate) == 0 && res.get(m).endDate.compareTo(list.get(i).endDate) == 0){
                         index = m;
                     }
                     m++; 
                 }
                 if(index == -1){
                    ConflictedTimeWindow temp3 = new ConflictedTimeWindow(list.get(i).startDate,end,new HashSet<Integer>());
                    temp3.conflictedEventIds.addAll(list.get(i-1).conflictedEventIds);
                    System.out.println("add item temp3:" + temp3.toString());
                    res.add(temp3);
                    while( m < res.size()){
                        if(res.get(m).startDate.compareTo(list.get(i).startDate) == 0 && res.get(m).endDate.compareTo(list.get(i).endDate) == 0){
                            index = m;
                        }
                       m++; 
                    } 
                    if(index != -1){
                        res.get(index).conflictedEventIds.addAll(list.get(i).conflictedEventIds);
                    }
                 }
             
             }
             
         }else{
             res.add(list.get(i-1));
             System.out.println("add item:" + list.get(i-1).toString());
             start = list.get(i).startDate;
             System.out.println("Start:"+ start.toString());
             end = list.get(i).endDate;
             System.out.println("End:"+ end.toString());
         }
     }
          ConflictedTimeWindow curr = res.get(res.size()-1);
          if(list.get(list.size()-1).startDate.compareTo(curr.endDate)<0){
              ConflictedTimeWindow temp = new ConflictedTimeWindow(curr.endDate,list.get(list.size()-1).endDate,new HashSet<Integer>());
              temp.conflictedEventIds.addAll(list.get(list.size()-1).conflictedEventIds);
              res.add(temp);
          }
          
          Collections.sort(res, new Comparator<ConflictedTimeWindow>(){
         @Override
         public int compare(ConflictedTimeWindow e1, ConflictedTimeWindow e2){
             if(e1.startDate.equals(e2.startDate)){
                 return e1.endDate.compareTo(e2.endDate) ;
             }else 
                 return e1.startDate.compareTo(e2.startDate);
         }
     
     });
     
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
    Calendar1 calendar = new Calendar1();

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
