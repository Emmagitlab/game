/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.Stack;

/**
 *
 * @author T440
 */

/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
*/
public class MinStack {
    Node top = null;

    public int getMin() {
        return top.min;
    }   

    public void pop() {
        top = top.next;
    }   

    public void push(int x) {
        top = new Node(top, x, top == null ? x : Math.min(x, top.min));
    }   

    public int top() {
        return top.data;
    }   

    static class Node {
        int data, min;
        Node next;

        Node(Node next, int data, int min) {
            this.next = next;
            this.data = data;
            this.min = min;
        }   
    }   
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
