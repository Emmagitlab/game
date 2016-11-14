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
public class DecodeWays {
    public int decodeWays(String s){
        if(s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        int r1 = 1;
        int r2 = 1;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == '0') r1 = 0;
            if(s.charAt( i-1) == '1'|| s.charAt(i-1) =='2' && s.charAt(i) <= '6')
            { r1 = r2 + r1;
                r2 = r1 - r2;}
            else r2 = r1;
        
        }
        return r1;
    
    }
    
     public int decodeWaysII(String s){
        if(s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        if(s.charAt(0) == '0' ) dp[1] = 0;
        else dp[1] = 1;
        for(int i = 2; i <= s.length(); i++){
      
            if('0' != s.charAt( i-1)){ 
                dp[i] += dp[i-1];}
            if( s.charAt( i-2) == '1'||s.charAt(i-2) =='2' && s.charAt(i-1) <= '6'){
                dp[i] += dp[i-2];
            }
        
        }
        return dp[s.length()];
    
    }
    public static void main(String[] args){
        DecodeWays sol = new DecodeWays();
        String s = "11S23";
        System.out.println( sol.decodeWays(s) + "");
        System.out.println( sol.decodeWaysII(s) +"");
    
    }
    
    
}
