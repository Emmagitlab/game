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

class LNode{
    int val;
    LNode next;
    LNode(int x){val = x;}
}
public class MergeKSortedList {
    public LNode mergeKLists(LNode[] lists){
        if(lists.length ==0) return null;
        LNode dummy = new LNode(0);
        PriorityQueue<LNode> q = new PriorityQueue<LNode>(lists.length,new Comparator<LNode>(){
            public int compare(LNode n1, LNode n2){
                return n1.val-n2.val;
                
            }
                    });
        // 初始化大小为k的堆
        for( int i = 0; i < lists.length;i++)
            if(lists[i] != null) q.offer(lists[i]);
        LNode curr = dummy;
        while(!q.isEmpty()){
            // 拿出堆顶元素
            curr.next = q.poll();
            curr = curr.next;
            // 将堆顶元素的下一个加入堆中
            if(curr.next != null){
                q.offer(curr.next);
            }
        }
        return dummy.next;
    }
    
    // faster
    
    public LNode mergeKLists2(LNode[] lists){
        return ml(lists,0,lists.length-1);
    }
    public LNode ml(LNode[] lists, int l, int r){
        if(r<l) return null;
        if(r == l) return lists[r];
        int mid = (r+l)/2;
        LNode a = ml(lists,l,mid);
        LNode b = ml(lists,r,mid);
        LNode dummy = new LNode(0);
        LNode curr = dummy;
        while(a != null && b!= null){
            if(a.val < b.val){
                curr.next = a;
                a = a.next;
            }else{
                curr.next = b;
                b = b.next;
            }
            curr = curr.next;
        }
        curr.next = (a != null)? a:b;
        return dummy.next;
    }
    
    
    public static void main(String[] args){
        MergeKSortedList sol = new MergeKSortedList();
        LNode[] list = new LNode[3];
        list[0] = new LNode(1);
        list[0].next = new LNode(3);
        list[0].next.next = new LNode(5);
        list[1] = new LNode(2);
        list[2] = new LNode(4);
        list[1].next = new LNode(6);
        LNode head = sol.mergeKLists(list);
        LNode temp = head;
        while(temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }
        
        
    
    }
}
