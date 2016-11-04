/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;
import java.util.*;
/**
 *
 * @author T440
 */
public class RepeatTaskWithCooldown {
    public String repeatTaskWithCooldown(String task, int k){
       if(task == null || task.length() == 0) return null;
       HashMap<Character, Integer> map = new HashMap<>();
       StringBuilder sb = new StringBuilder();
       int count = 0;
       for(int i = 0; i < task.length(); i++){
           count++;
           if(!map.containsKey(task.charAt(i))){
               map.put(task.charAt(i), count);
               sb.append(task.charAt(i));
           }else{
               int oldCount = map.get(task.charAt(i));
               if(count - oldCount >k){
                   sb.append(task.charAt(i));
               }else{
                   int temp = oldCount+k+1;
                   for(int j = count; j < temp; j++){
                       sb.append("_");
                   }
                   sb.append(task.charAt(i));
                   count = temp;
                   map.put(task.charAt(i), count);
                   
               }
           }
       }
       return sb.toString();
    }
    
    public static void main(String[] args){
        RepeatTaskWithCooldown sol = new RepeatTaskWithCooldown();
        String s = "aabbcc";
        System.out.println(sol.repeatTaskWithCooldown(s, 4));
    
    
    
    }
    
    
}
