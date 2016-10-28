/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.*;
import java.util.*;

/**
 *
 * @author T440
 */
public class WordBreak {

    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0) {
            return true;
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {  // check substring 0 to j, and j to i, make sure both of them contians in Dict;
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }

    
    
    // fast version
    private Set<String> unmatch = new HashSet<String>();// save unmatched element.

    public boolean wordBreak2(String s, Set<String> dict) {
        for (String prefix : dict) {
            if (s.equals(prefix)) {
                return true;
            }
            if (s.startsWith(prefix)) {
                String suffix = s.substring(prefix.length(), s.length());
                if (!unmatch.contains(suffix)) {
                    return true;
                } else {
                    unmatch.add(suffix);
                }
            }
        }
        return false;
    }
}
