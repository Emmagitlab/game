/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author myang2
 */
/*
 * There're 3 possibilities to satisfy one edit distance apart: 
 * 
 * 1) Replace 1 char:
 	  s: a B c
 	  t: a D c
 * 2) Delete 1 char from s: 
	  s: a D  b c
	  t: a    b c
 * 3) Delete 1 char from t
	  s: a   b c
	  t: a D b c
 */
public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t){
        if(s.length() == t.length()){
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) != t.charAt(i)) return false;
            }
            return true;
        }
        if(Math.abs(s.length() - t.length())==1){
            for(int i = 0; i < Math.min(s.length(), t.length()); i++){
                if(s.charAt(i) != t.charAt(i)) 
                    return s.length() > t.length() ? s.substring(i+1).equals(t.substring(i)):t.substring(i+1).equals(s.substring(i));
            return true;
            }
        
        }
        return false;
    }
}
