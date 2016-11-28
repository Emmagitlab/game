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
public class IntegerToEnglish {
     private String[] belowTen = {" ","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
    private String[] belowTwenty = {"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    private String[] belowHundred = {" ","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    public String numberToWords(int num){
        if(num == 0) return "Zero";
        else return helper(num);
    }
    public String helper(int num){
        String result = new String();
        if(num < 10) result = belowTen[num];
        else if(num < 20) result = belowTwenty[num-10];
        else if(num < 100) result = belowHundred[num/10] +" "+ helper(num %10);
        else if(num < 1000) result = belowTen[num/100] +" Hundred "+ helper(num%100);
        else if(num < 1000000) result = helper(num/1000) + " Thousand "+ helper(num %1000);
        else if(num < 1000000000) result = helper(num/1000000) + " Million " + helper(num%1000000);
        else result = helper(num/1000000000) + " Billion " + helper(num%1000000000);
        return result.trim();
        
    }
}
