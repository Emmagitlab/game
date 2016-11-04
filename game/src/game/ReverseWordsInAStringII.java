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
public class ReverseWordsInAStringII {
    
    public String reverseWordsInAString(String s){
        char[] input = s.toCharArray();
        reverse(0,input.length-1,input);
        String result = "";
        int start = 0;
        for(int i = 0; i < input.length; i++){
            if(input[i] ==' '){
                reverse(start,i-1,input);
                start = i+1;
            }
        }
        reverse(start,input.length-1,input);
        for(int i = 0; i < input.length;i++){
            result += input[i];
        }
        return result;
    }
    
    public void reverse(int i , int j,char[] s){
        while(i<j){
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
            
        }
    
    }
    
    public static void main(String args[]){
    ReverseWordsInAStringII  reverse = new ReverseWordsInAStringII();
    String s= "The sky is blue";
    System.out.println(reverse.reverseWordsInAString(s));
    
    }
    
}
