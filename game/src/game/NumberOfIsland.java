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
public class NumberOfIsland {
     public int numIslands(int[][] grid){
         int result = 0;
         if(grid.length == 0) return result;
         for( int i = 0; i < grid.length; i++){
             for(int j = 0; j < grid[0].length; j++){
                 if(grid[i][j] == 1){
                 searchIsland(grid, i, j);
                 result++;}
            }
         }
      return result;
     }
     
     public void searchIsland(int[][] grid, int i, int j){
         grid[i][j] = 0;
         if(i > 0 && grid[i-1][j] == 1) searchIsland(grid, i-1, j);
         if(j > 0 && grid[i][j-1] == 1) searchIsland(grid, i, j-1);
         if(i < grid.length-1 && grid[i+1][j] == 1) searchIsland(grid, i+1, j);
         if(j < grid[0].length-1 && grid[i][j+1] == 1) searchIsland(grid, i, j+1);
     
     }
     
     public static void main(String[] args){
         NumberOfIsland sol = new NumberOfIsland();
         int[][] grid = {
             {1,1,0,0,0},
             {1,1,0,0,0},
             {0,0,1,0,0},
             {0,0,0,1,1}
         
            };
         System.out.print(sol.numIslands(grid));
     
     }
}
