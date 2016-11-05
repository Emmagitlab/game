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
public class SortColor {
    public int[] sortColor(int[] color){
        int l = 0; int r = 0; int m = 0;
        for(int i = 0; i < color.length; i++){
            if(color[i] == 0){
                color[r++] = 2;
                color[m++] = 1;
                color[l++] = 0;
            } else if(color[i] == 1){
                color[r++] = 2;
                color[m++] = 1;
            } else if(color[i] == 2){
                color[r++] = 2;
            }
        
        
        }
        return color;
    }
    
    public int[] sortColor2Pass(int[] color){
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        for(int i = 0; i < color.length; i++){
             if(color[i] == 0) count0++;
             if(color[i] == 1) count1++;
             if(color[i] == 2) count2++;
        
        }
        for(int i = 0; i < color.length; i++){
            if( i < count0) color[i] = 0;
            else if( i < count1+count0) color[i] = 1;
            else color[i] = 2;
        
        
        }
        return color;
    
    }
    
    public static void main(String[] args){
        SortColor sol = new SortColor();
        int[] color = {0,1,2,1,2,0};
        for(int i = 0; i < color.length; i++){
        System.out.print(sol.sortColor(color)[i]);
        
        }
        System.out.println("");
        
        for(int i = 0; i < color.length; i++){
        System.out.print(sol.sortColor2Pass(color)[i]);
        }
    
    }
    
}
