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
public class MinimumWindowSubstring {
    public String minWindow(String s, String t){
        int[] src = new int[255];
        for(int i = 0; i < t.length(); i++){
            src[t.charAt(i)]++;
        }
        int start = 0;
        int i = 0;
        int[] dest = new int[255];
        int found = 0;
        int begin = -1;
        int end = s.length();
        int minLength = s.length();
        for(start = i = 0; i < s.length();i++){
            dest[s.charAt(i)]++;
            if(dest[s.charAt(i)] <= src[s.charAt(i)]) found++;
            if(found == t.length()){
                while(start < i && dest[s.charAt(start)] > src[s.charAt(start)]){
                    dest[s.charAt(start)]--;
                    start++;
                }
                if(i-start < minLength){
                    minLength = i- start;
                    begin = start;
                    end = i;
                }
                dest[s.charAt(start)]--;
                found--;
                start++;
                    
            }
        }
        return begin == -1 ? "":s.substring(begin,end+1);
    }
    
    public static void main(String[] args){
        MinimumWindowSubstring sol = new MinimumWindowSubstring();
        String s= "ADOBECODEBANC";
        String t ="ABC";
        System.out.print(sol.minWindow(s, t));
    
    }
    
}
