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
public class ValidPalindrome {
    public boolean isPalindrome(String s){
        if(s.length() == 0) return true;
        s = s.toUpperCase();
        int low1 = 'A';
        int high1 = 'Z';
        int low2 = '0';
        int high2 = '9';
        int start = 0; int end = s.length()-1;
        while(start < end){
            if((s.charAt(start) < low1 || s.charAt(start) > high1) && (s.charAt(start) <low2 || s.charAt(start ) > high2)){
            start++;
            continue;
        }
            if((s.charAt(end) < low1 || s.charAt(end) > high1) && (s.charAt(end) <low2 || s.charAt(end ) > high2)){
            end--;
            continue;
        
        }
          if(s.charAt(start) == s.charAt(end)){
              start++;
              end--;
          }else return false;
        }
        return true;
    
    }
    
    public static void main(String[] args){
        ValidPalindrome sol = new ValidPalindrome();
        String s= "raca a car";
        System.out.println(sol.isPalindrome(s));
    
    
    }
    
}
