/*


 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author T440
 */
public class TelephoneNumberCombination {
     public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<String>();
        if(digits == null || digits.length() == 0) return result;
        HashMap<Character, char[]> map = new HashMap<Character, char[]>();
        map.put('0', new char[] {});
        map.put('1', new char[] {});
        map.put('2', new char[] {'a','b','c'});
        map.put('3', new char[] {'d','e','f'});
        map.put('4', new char[] {'g','h','i'});
        map.put('5', new char[] {'j','k','l'});
        map.put('6', new char[] {'m','n','o'});
        map.put('7', new char[] {'p','q','r','s'});
        map.put('8', new char[] {'t','u','v'});
        map.put('9', new char[] {'w','x','y','z'});
        
        StringBuilder sb = new StringBuilder();
        dfs(digits, result, map, sb);
        return result;
        
        
    }
    
    public void dfs(String digits,ArrayList<String> result,HashMap<Character, char[]> map,StringBuilder sb){
        if(sb.length() == digits.length()){
            result.add(sb.toString());
            return ;
        }
        for(char c: map.get(digits.charAt(sb.length()))){
            sb.append(c);
            dfs(digits, result, map, sb);
            sb.deleteCharAt(sb.length()-1);
        }
        
    }
    
    public static void main(String[] args){
    TelephoneNumberCombination sol = new TelephoneNumberCombination();
    ArrayList<String> result = sol.letterCombinations("23");
    for(String item: result){
    
        System.out.println(item);
    }
    
    }
    
    
//复杂度
//假设有k个digit 每个digit可以代表m个字符, 时间O(m^k) 空间O(m^k)
    
    
    
    
    public List<String> letterCombinationsII(String digits) {
    List<String> res = new ArrayList<String>();
    if (digits == null || digits.length() == 0) {
        return res;
    }
    String[] map= {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    StringBuilder tem = new StringBuilder();
    helper(res, tem, digits, 0, map);
    return res;
}
public void helper(List<String> res, StringBuilder tem, String digits, int index, String[] map) {
    if (index == digits.length()) {
        res.add(tem.toString());
        return;
    }
    int m = digits.charAt(index) - '0';
    for (int i = 0; i < map[m].length(); i++) {
        tem.append(map[m].charAt(i));
        helper(res, tem, digits, index + 1, map);
        tem.deleteCharAt(tem.length() - 1);
    }
}
    
    
    
}
