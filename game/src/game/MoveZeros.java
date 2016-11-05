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
public class MoveZeros {
    public int[] moveZeros(int[] A){
        int count = 0; 
        for(int i = 0; i < A.length; i++){
            if(A[i] != 0){
                A[count++] = A[i];
            }
        }
        while(count < A.length){
            A[count++] = 0;
        }
        return A;
    }
    
    public static void main(String[] args){
        MoveZeros sol = new MoveZeros();
        int[] A = {0,1,2,0,3,4};
        for(int i = 0; i < A.length; i++){
            System.out.print(sol.moveZeros(A)[i]);
        }
    }
    
}
