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
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
public class ReverseLinkedList {
    ListNode head;
    public ListNode reverseLinkedList(ListNode head){
        ListNode pre = null;
        ListNode curr = head;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        
        }
  
    return pre;
    
    }
    public void printReverse(ListNode head)
    {
        if (head == null) return;
 
        // print list of head node
        printReverse(head.next);
 
        // After everything else is printed
        System.out.print(head.val+" ");
    }
   public void push(int new_data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        ListNode new_node = new ListNode(new_data);
 
        /* 3. Make next of new Node as head */
        new_node.next = head;
 
        /* 4. Move the head to point to new Node */
        head = new_node;
    }
    
    public static void main(String[] args){
        ReverseLinkedList sol = new ReverseLinkedList();
        sol.push(4);
        sol.push(3);
        sol.push(2);
        sol.push(1);
 
        sol.printReverse(sol.head);
    }
}
