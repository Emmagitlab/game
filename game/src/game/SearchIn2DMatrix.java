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
public class SearchIn2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target){
       if(matrix == null || matrix.length == 0) return false;
       int row = matrix.length;
       int col = matrix[0].length;
       int start = 0;
       int end = row * col -1;
       while(start <= end){
           int mid = start + (end - start)/2;
           if(matrix[mid/col][mid%col] == target) return true;
           else if(matrix[mid/col][mid%col] < target) start = mid+1;
           else end = mid-1;
       
       }
       return false;
    }
    public static void main(String[] args){
        SearchIn2DMatrix sol = new SearchIn2DMatrix();
        int[][] A = {{1,2,3},{4,5,6}};
        int target  = 2;
        System.out.println(sol.searchMatrix(A, target));
    
    }
    
}
