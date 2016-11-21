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

//Find the K closest points to the origin in a 2D plane, given an array containing N points.
// 
//Max Heap: O(NlogN)
//Selection Algorithm: O(N)
//下面给出基于Max Heap的实现。



class Point{
    public int x;
    public int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    

}
public class FindKClosestPointsIn2DPlane {
    public List<Point> findKClosest(Point[]p,int k){
        PriorityQueue<Point> queue = new PriorityQueue<>(10,new Comparator<Point>(){
            @Override
            public int compare(Point a,  Point b){
                return (b.x * b.x + b.y * b.y) -(a.x * a.x + a.y*a.y);
            
            } 
        });
        for(int i = 0; i < p.length;i++){
            if(i < k) queue.offer(p[i]);
            else{
                Point tmp = queue.peek();
                if((p[i].x * p[i].x +p[i].y * p[i].y) < (tmp.x * tmp.x +tmp.y * tmp.y )){
                    queue.poll();
                    queue.offer(p[i]);
                
                }
            
            
            }

        }
        List<Point> result = new ArrayList<>();
        while(!queue.isEmpty())
            result.add(queue.poll());
        
        return result;
    
    }
    
}
