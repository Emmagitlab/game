/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author myang2
 */

 class LinkedListNode{
        int data;
        LinkedListNode next;
        LinkedListNode(int d){
            data = d;
            next = null;
        }
    }


public class RemoveDuplicateFromUnsortedLinkedList {
    
    public void removeDuplicate(LinkedListNode head){
        LinkedListNode ptr1 = head;
        LinkedListNode ptr2 = null;
        
        while(ptr1 != null && ptr1.next != null ){
            ptr2 = ptr1;
            
            while (ptr2.next != null) {
                if (ptr1.data == ptr2.next.data) {
                   
                    ptr2.next = ptr2.next.next;
                    
                }else{
                    ptr2 = ptr2.next;
                
                }
            }
            ptr1 = ptr1.next;
        }
    
    
    
    }
    public void printList(LinkedListNode head){
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    
    }
    
    public static void main(String[] args){
        RemoveDuplicateFromUnsortedLinkedList sol = new RemoveDuplicateFromUnsortedLinkedList();
        LinkedListNode head = new LinkedListNode(10);
        head.next = new LinkedListNode(12);
        head.next.next = new LinkedListNode(10);
        head.next.next.next = new LinkedListNode(12);
       // sol.printList(head);
        
        sol.removeDuplicate(head);
        sol.printList(head);

    
    
    }
    
}
