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
    
    public int numberOfIsland(char[][] matrix){
        int sum = 0;
        if(matrix.length == 0) return sum;
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i = 0; i<row; i++){
            for(int j = 0; j < col; j++){
                if(matrix[i][j] == '1'){
                    search(matrix,i,j);
                    sum++;
                }
            }
        }
        return sum;
    
    }
    
    public void search(char[][] matrix, int i, int j){
        matrix[i][j] = '0';
        if(i>0&&matrix[i-1][j] =='1') search(matrix, i-1, j);
        if(j>0&&matrix[i][j-1] =='1') search(matrix, i, j-1);
        if(i< matrix.length -1 && matrix[i+1][j] == '1') search(matrix,i+1,j);
        if(j< matrix[0].length -1 && matrix[i][j+1] == '1') search(matrix,i,j+1);
        
    }
    
    public static void main(String[] args){
        NumberOfIsland sol = new NumberOfIsland();
        char[][] matrix = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };
        
        System.out.println(sol.numberOfIsland(matrix));
        
    
    }
}
