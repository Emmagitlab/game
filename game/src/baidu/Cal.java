/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baidu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author T440
 */
public class Cal{
    
    public double calculate(String s) {
        int start = -1;
        int end = s.length()-1;
        List<Integer> starts = new ArrayList<>();
        List<Integer> ends = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
                if(s.charAt(i)=='('){
                    starts.add(i);
                } 
        }
        for(int i = s.length()-1; i >0; i--){
                if(s.charAt(i)==')'){
                    ends.add(i);
                } 
        }
        int count = 0;
        
        for(int i = starts.size()-1; i >= 0; i--){
            if(starts.get(i) < count){
                start = starts.get(i);
            }else {
                start = starts.get(i)- count;
            }
            end = ends.get(i) -count;
            String result = s.substring(start+1, end);
            //System.out.println("result:"+ result);
            double replace = recursive(result);
            //System.out.println("replace:" + replace );
            //System.out.println("S O: "+s + " "+ s.length());
            if(start == 0 && end+1 < s.length()){
                s = replace+ s.substring(end+1);
            } else if(start == 0 && end+1 >= s.length()){
                s = replace+"";
            } else if(end +1 < s.length()){
                s = s.substring(0,start)+replace + s.substring(end+1);
            } else{
                s = s.substring(0,start)+replace;
            }
            //System.out.println("S C: "+s + " "+ s.length());
            count = end - start;
            //System.out.println("Count ：" + count);
        }
        
        return recursive(s) ;
    }
   
    
    public double recursive(String s){
        if(s == null && s.length() == 0) return 0;
        Stack<Double> stack = new Stack<Double>();
        char sign = '+';
        double result = 0;
        double num = 0;
      
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
        for(double i: stack){
            result += i;
        }
        return result;
    }
    HashMap<String, Double> map = new HashMap<>();
    public List<Double> CalcWithVars(String[] input){
        List<Double> res = new ArrayList<>();
        List<String> keys = new ArrayList<>();
        for(int i = 0; i< input.length;i++){
            String[] items = input[i].replaceAll("\\s","").split("=");
            String key = items[0];
            keys.add(key);
            char[] formula  = items[1].toCharArray();
            int j = 0;
            while(j < formula.length && (isDigit(formula[j]) || isOperator(formula[j])) ){
                j++;
            }
            if(j == formula.length){
                double result = calculate(items[1]);
                map.put(key, result);
            } else{
                StringBuilder sb  = new StringBuilder();
                int start = j;
                while(j < items[1].length() && isCharacter(formula[j])){
                    sb.append(formula[j]);
                    j++;
                }
                int end = j;
                String v = sb.toString();
                String cal = null;
                double replace = map.get(v);
                if(start == 0 && end+1 < items[1].length()){
                    cal = replace+ items[1].substring(end+1);
                } else if(start == 0 && end+1 >= items[1].length()){
                    cal = replace+"";
                } else if(end +1 < items[1].length()){
                    cal = items[1].substring(0,start)+replace + items[1].substring(end+1);
                } else{
                    cal = items[1].substring(0,start)+replace;
                }
                double result = calculate(cal);
                map.put(items[0],result);
            }
            
        }
        for(String ele : keys){
            res.add(map.get(ele));
            //System.out.print(map.get(ele) + " ");
        }
        return res;
    }
    public boolean isDigit(char c){
        if(c <='9' && c >='0') return true;
        else return false;
    }
    public boolean isCharacter(char c){
        if(c <='z' && c >='a') return true;
        else return false;
    }
    public boolean isOperator(char c){
        if(c == '+' || c == '-'|| c == '*' || c =='/') return true;
        else return false;
    }
    
 

    public static void main(String[] args){
        Cal cal = new Cal();
        String s = "3+4*5";
        System.out.println(cal.calculate(s));
        String s2 = "3+4*5/7";
        System.out.println(cal.calculate(s2));
        String s3 = "(3+4) *5/7";
        cal.calculate(s3);
        System.out.println(cal.calculate(s3));
        //System.out.println(cal.calculate("1+(1+(3+4)*2)+1"));
        String[] input = { "pi = 3", "pizza = 9 * 9 * pi" };
        System.out.println(cal.CalcWithVars(input));
    }
    
}
