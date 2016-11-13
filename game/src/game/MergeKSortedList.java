/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author myang2
 */

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){val = x;}
}
public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists){
        if(lists.length ==0) return null;
        ListNode dummy = new ListNode(0);
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.length,new Comparator<ListNode>(){
            public int compare(ListNode n1, ListNode n2){
                return n1.val-n2.val;
                
            }
                    });
        for( int i = 0; i < lists.length;i++)
            if(lists[i] != null) q.offer(lists[i]);
        ListNode curr = dummy;
        while(!q.isEmpty()){
            curr.next = q.poll();
            curr = curr.next;
            if(curr.next != null){
                q.offer(curr.next);
            }
        }
        return dummy.next;
    }
}
