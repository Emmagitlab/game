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
public class AddBinary {
    
    public String addBinary(String a, String b){
        StringBuilder sb = new StringBuilder();
        int i = a.length()-1; int j = b.length()-1;
        int carry = 0;
        while(i >=0 && j >=0){
            int sum = carry;
            if(i >= 0) sum += a.charAt(i--) -'0';
            if(j >= 0) sum += b.charAt(j--) -'0';
            sb.append(sum %2);
            carry = sum/2;
        
        }
        if(carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
    
}
