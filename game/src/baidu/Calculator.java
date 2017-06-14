/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baidu;

import java.util.Stack;

/**
 *
 * @author T440
 */
public class Calculator {
    
    public int calculate(String s) {
        int start = -1;
        int end = s.length()-1;
        int pre = -1;
        while(start <= end){
            for(int i = start+1; i < s.length(); i++){
                pre = start;
                if(s.charAt(i)=='('){
                    start = i; 
                    break;
                } 
            }
            if(start == pre) return recursive(s);
            for(int i = end; i >0; i--){
                if(s.charAt(i)==')'){
                    end = i;  
                    break;
                } 
            }
            
            String result = s.substring(start+1, end);
            System.out.println("result:"+ result);
            int replace = recursive(result);
            System.out.println("replace:" + replace );
            if(start == 0 && end+1 < s.length()){
                s = replace+ s.substring(end+1);
            } else if(start == 0 && end+1 >= s.length()){
                s = replace+"";
            } else if(end +1 < s.length()){
                s = s.substring(0,start)+replace + s.substring(end+1);
            } else{
                s = s.substring(0,start)+replace;
            }
            System.out.println("s:"+s);
            end = s.length()-1;
            start = -1;
        }
        
        return recursive(s) ;
    }
   
    
    public int recursive(String s){
        if(s == null && s.length() == 0) return 0;
        Stack<Long> stack = new Stack<Long>();
        char sign = '+';
        int result = 0;
        long num = 0;
        long mark = Integer.MAX_VALUE+1;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num *10 + s.charAt(i) - '0';
            } 
             if(!Character.isDigit(c) && c != ' ' || i == s.length()-1){
               
                if(sign == '+') {
                    stack.push(num);
                }else if(sign == '-'){
                    stack.push(-num);
                }else if(sign == '/'){
                    stack.push(stack.pop() / num);
                }else if(sign == '*'){
                    stack.push(stack.pop() * num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }
        for(long i: stack){
            result += i;
        }
        return result;
    }
    
//    public int CalcWithVars(String[] input){
//    
//    
//    }
    
 

    public static void main(String[] args){
        Calculator cal = new Calculator();
        String s = "3+2*2";
        String s2 = "(3+4) * 5/7";
        System.out.println(cal.calculate(s));
        System.out.println(cal.calculate(s2));
        String s3 = "1+2*(3+4)";
        cal.calculate(s3);
        System.out.println(cal.calculate(s3));
        System.out.println(cal.calculate("1+(3+4*2)+1"));
    }
    
}
