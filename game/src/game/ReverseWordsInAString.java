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
public class ReverseWordsInAString {
    public String reverseWordsInaString(String s){
        if(s == null || s.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        String[] word = s.split(" ");
        for(int i = word.length-1; i >= 0;i--){
            sb.append(word[i] + " ");
        
        }
        return sb.toString().trim();
    }
    
    public static void main(String[] args){
        ReverseWordsInAString reverse = new ReverseWordsInAString();
        String s = "The Sky is Blue";
        System.out.println(reverse.reverseWordsInaString(s));
        
    }

}
