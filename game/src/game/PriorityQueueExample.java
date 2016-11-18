/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;
 
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
 
 
public class PriorityQueueExample {
 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Queue<Integer> qi = new PriorityQueue<Integer>();
 
		    qi.add(5);
		    qi.add(2);
		    qi.add(1);
		    qi.add(10);
		    qi.add(3);
 
		    while (!qi.isEmpty()){
		      System.out.print(qi.poll() + ",");
		    }
		    System.out.println();
		    System.out.println("-----------------------------");
 
		    Comparator<Integer> cmp;
		    cmp = new Comparator<Integer>() {
		      public int compare(Integer e1, Integer e2) {
		        return e2 - e1;
		      }
		    };
		    Queue<Integer> q2 = new PriorityQueue<Integer>(5,cmp);
		    q2.add(2);
		    q2.add(8);
		    q2.add(9);
		    q2.add(1);
		    while (!q2.isEmpty()){
			      System.out.print(q2.poll() + ",");
			    }
 
 
	}
 
}
