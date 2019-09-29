package org.unnati.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class IntegerToRoman2 {
    static int[] numberValue=new int[]{1,4,5,9,10,40,50,90,100,400,500,900,1000};
    static String[] romanValue=new String[]{"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
    
    public String intToRoman(int num) {
        StringBuilder roman=new StringBuilder();
        int index=numberValue.length-1;
        while(num>0){
            if(num>=numberValue[index]){
                num=num-numberValue[index];
                roman.append(romanValue[index]);
            }else {
                index--;
            }
        }
        return roman.toString();
    }
    

    public static void main(String[] args) {
        IntegerToRoman2 integerToRoman=new IntegerToRoman2();
        System.out.println(integerToRoman.intToRoman(1994));
    }
}
