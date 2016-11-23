/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.HashMap;

/**
 *
 * @author T440
 */



//implement function strstrp(String a, String b) returns index where any permutation of b is a substring of a.
//第二题是leetcode上strstr那道的衍生题, 要求implement function strstrp(String a, String b) returns index where any permutation of b is a substring of a.
//e.g.
//strstrp("hello", ''ell") returns 1
//strstrp("hello",  "lle") returns 1
//strstrp("hello",  "wor") returns -1
public class Strstrp {
    
 public static boolean isExist(String str, String t) {
    int req = t.length();
    HashMap<Character, Integer> map = new HashMap<>();
    for (char c : t.toCharArray()) {
      if (map.containsKey(c)) map.put(c, map.get(c) + 1);
      else map.put(c, 1);
    }
    int s = 0;
    int e = 0;
    while (true) {
      if (e - s < t.length()) {
        if (e == str.length()) break;
        char c = str.charAt(e);
        if (map.containsKey(c)) {
          if (map.get(c) > 0) {
            req--;
          }
          map.put(c, map.get(c) - 1);
        }
        e++;
      }
      if (e - s == t.length()) {
        if (req == 0) return true;
        char c = str.charAt(s);
        if (map.containsKey(c)) {
          if (map.get(c) >= 0) {
            req++;
          }
          map.put(c, map.get(c) + 1);
        }
        s++;
      }   
    }
    return false;
  }
 
 public int returnIndex(String a , String  b){
     if(b.length() == 0 || b == null) return 0;
     HashMap<Character, Integer> aMap = new HashMap<Character, Integer>();
     HashMap<Character, Integer> bMap = new HashMap<Character, Integer>();
     for(int i = 0; i < a.length();i++){
         if(!aMap.containsKey(i))
            aMap.put(b.charAt(i),1);
         else 
             aMap.put(b.charAt(i), aMap.get(b.charAt(i))+1);
     
     }
     for(int i = 0; i < b.length();i++){
         if(!bMap.containsKey(i))
            bMap.put(b.charAt(i),1);
         else 
             bMap.put(b.charAt(i), bMap.get(b.charAt(i))+1);
     }
     int k = b.length();
//     for(int i = 0; i < b.length();i++){
//         if(aMap.containsKey(b.charAt(i))&& aMap.get(b.charAt(i))>= bMap.get(b.charAt(i))){
//             if(i == k && a.substring(0, k).equals(b)) return 0;
//             else if(i > k ) {
//              int start = i-k, end = i+k;
//              if(end > b.length()) end = b.length();
//              for(int j = start; j<= end; j++ ){
//                  
//              }
//             }
//         }
         
 //    }
     return -1;
     
     
 }

  public static void main(String[] args) {
    System.out.println(isExist("hello", "ell"));
  }
}


 