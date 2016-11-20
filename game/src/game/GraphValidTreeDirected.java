/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.*;

/**
 *
 * @author myang2
 */


//Given n nodes labeled from 0 to n - 1 and a list of directed edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.
//
//For example:
//
//Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
//
//Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
//Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return false.

//复杂度
//time: O(V+E), space: O(h)


//有向图要注意的地方不仅是不能有多个root存在，与上题不同的是需要从root开始遍历才能慢慢遍历到整个图，
//其他方面基本跟上题一样，遍历过程中一个点只能visit一次，否则即是那种一个child多个parent情况。
public class GraphValidTreeDirected {
    
   
    public boolean validTree(int n, int[][] edges) {
        List<Integer>[] graph = new List[n];
        Set<Integer> inDegree = new HashSet<>();

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].add(edges[i][1]);
            inDegree.add(edges[i][1]);
        }

        int root = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!inDegree.contains(i)) {
                root = i;
                count++;
            }
        }

        if (count != 1)
            return false;

        boolean[] visited = new boolean[n];
        if (!dfs(graph, root, visited)) {
            return false;
        }

        return true;
    }

    private boolean dfs(List<Integer>[] graph, int i, boolean[] visited) {
        
        // 发现环或一child多个parents
        if (visited[i]) {
            return false;
        }
        visited[i] = true;

        for (int num : graph[i]) {
            if (!dfs(graph, num, visited)) {
                return false;
            }
        }

        return true;
    }          

    public static void main(String[] args){
        GraphValidTreeDirected sol = new GraphValidTreeDirected();
        int[][] edges = {
            {0,1},
            {1,2},
            {2,3},
            {1,3},
            {1,4}
        };
       System.out.println(sol.validTree(5, edges));
       
       int[][] edges2 = {
           {0,1},
           {0,2},
           {0,3},
           {1,4}
       
       };
       System.out.println(sol.validTree(5, edges2));
    
    
    }
    
}
