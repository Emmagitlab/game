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


public class EditDistanceIterator {
   
    public boolean isOneEditDistance(String s, String t) {
        List<Character> s1 = new ArrayList<>();
        for (char c : s.toCharArray()) {
            s1.add(c);
        }
        List<Character> t1 = new ArrayList<>();
        for (char c : t.toCharArray()) {
            t1.add(c);
        }
        if (s.equals(t)) return false;
        return isOneEditDistance(s1.iterator(), t1.iterator());
    }
   
    public static boolean isOneEditDistance(Iterator<Character> a, Iterator<Character> b) {
        boolean isSame = true, isChanged = false, isAdd = false, isRemove = false;
        int prevA = 0, prevB = 0, curA = 0, curB = 0;
        while (a.hasNext() && b.hasNext()) {
            prevA = curA;
            prevB = curB;
            curA = a.next();
            curB = b.next();
            if (isSame) {
                if (curA != curB) {
                    isSame = false;
                    isChanged = true;
                    isAdd = true;
                    isRemove = true;
                }
            } else {
                if (isChanged) {
                    if (curA != curB) {
                        isChanged = false;
                    }
                }
                if (isAdd) {
                    if (prevA != curB) {
                        isAdd = false;
                    }
                }
                if (isRemove) {
                    if (curA != prevB) {
                        isRemove = false;
                    }
                }
            }
            if (!isSame && !isChanged && !isAdd && !isRemove) {
                return false;
            }
        }
        if (isSame) {
            if (a.hasNext()) {
                a.next();
                return !a.hasNext();
            } else if (b.hasNext()) {
                b.next();
                return !b.hasNext();
            } else {
                return true;
            }
        }
        if (isChanged) {
            if (!a.hasNext() && !b.hasNext()) {
                return true;
            }
        }
        if (isRemove) {
            if (a.hasNext()) {
                prevA = a.next();
                return prevA == curB && !a.hasNext();
            }
        }
        if (isAdd) {
            if (b.hasNext()) {
                prevB = b.next();
                return prevB == curA && !b.hasNext();
            }
        }
        return false;
    }

}
