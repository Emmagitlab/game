/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;
import java.io.*;
import java.util.*;
/**
 *
 * @author T440
 */
public class SparseVectorDotProduct {
    // method1
    public int multiply(int[] A, int[] B){ 
        HashMap<Integer,Integer> mapA = new HashMap<>();
        HashMap<Integer,Integer> mapB = new HashMap<>();
        int result =0;
        for(int i = 0; i < A.length; i++){
            if(A[i] != 0){
                mapA.put(i, A[i]); }
        }
        for(int i = 0; i < B.length; i++){
            if(B[i] != 0){
                mapB.put(i, B[i]); }
        }
        int len = A.length < B.length? A.length:B.length;
        for(int i = 0; i < len; i++){
            if(mapA.get(i)!= null && mapB.get(i)!= null){
                result += mapA.get(i)*mapB.get(i);}
        }
        return result;
    }
    public static void main(String[] args){
        int[] A = {0,2,0,2,0,0,3,0,0,4};
        int[] B = {0,0,0,0,5,0,2,0,0,8};
        SparseVectorDotProduct svd = new SparseVectorDotProduct();
        System.out.print(""+svd.multiply(A, B));
    }
    
    
}
