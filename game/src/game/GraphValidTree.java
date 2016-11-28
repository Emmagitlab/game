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

//Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), 
//write a function to check whether these edges make up a valid tree.
//
//For example:
//
//Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
//
//Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
//
//Hint:
//
//Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], what should your return? 
//Is this case a valid tree? Show More Hint Note: you can assume that no duplicate edges will appear in edges. 
//Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.


//
//复杂度
//time: O(V + E), space: O(h)
//
//这种验证有效的图都是一类题。无非就是几种方法，比如DFS。注意树有个特征就是一个child不能有两个parent, 根平时拓扑排序找环的的差别，
//当然由于这道题是无向图，不用考虑这方面。这题有几个要注意的地方，
//比如一个树只能有一个root，如果这个树存在多个root, 那肯定无效。
//
//由于这道题是无向图，那么我们其实可以从任意一个点开始DFS，不用必须从root，
//因为无向图从任意一点都可以遍历到整块部分。添加edge的时候两个方向都添就可以了，另外就是还有个注意的地方就是如果在遍历neighbors的时候，
//自己parent不要遍历，否则直接返回false以为有环了。总结一句就是，这种无向图每个点遍历一次就可以了，否则就意味着有环。
public class GraphValidTree {

     public boolean validTree(int n, int[][] edges) {
        List<Integer>[] graph = new List[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }

        boolean[] visited = new boolean[n];
        if (!dfs(graph, 0, visited, -1)) {
            return false;
        }
        
        // 检测是否存在多个root, 如是意味着图无效
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(List<Integer>[] graph, int i, boolean[] visited, int prev) {
        // 发现环
        if (visited[i]) {
            return false;
        }
        visited[i] = true;

        for (int num : graph[i]) {
            if (prev != num && !dfs(graph, num, visited, i)) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args){
        GraphValidTree sol = new GraphValidTree();
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
