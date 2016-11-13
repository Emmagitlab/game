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
class node{
    int data;
    node next;
    node(int value){data = value; next = null; }
}

public class PrintReverseLinkedList {
    node head;
    node tail;
    public void printReverse(node head){
        if(head == null) return;
        printReverse(head.next);
        System.out.println(head.data+" ");
       
    
    }
    
    public void push (int value){
        node newNode = new node(value);
        node tmp = newNode;
        if(head == null) {
            head = tmp;
            tail = tmp;
        }
        else{
        tail.next = tmp;
        tail = tmp ;
        
        }
      
        
    }
    
    public static void main(String[] args){
        PrintReverseLinkedList sol = new PrintReverseLinkedList();
        sol.push(1);
        sol.push(2);
        sol.push(3);
        sol.push(4);
        
        sol.printReverse(sol.head);
    
    
    }
    
    
    
}
