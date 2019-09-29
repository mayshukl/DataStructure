package org.unnati.leetcode;

import java.util.*;

public class IntegerToRoman {
    static Map<Integer,String> dictionary=new LinkedHashMap<>();
    static Map<Integer,String> preCharacter=new HashMap<>();
    static{
        
        dictionary.put(1,"I");  
        dictionary.put(5,"V");  
        dictionary.put(10,"X");  
        dictionary.put(50,"L");  
        dictionary.put(100,"C");  
        dictionary.put(500,"D");  
        dictionary.put(1000,"M");  
    }
    
    public String intToRoman(int num) {
        return intToRoman(num,1);
    }
    
    private  String intToRoman(int number,int tens){
        if(number<=0){
            return new String();
        }
        String prefix=intToRoman(number/10,tens*10);
        int digit=number%10;
        String result=new String();
        if(digit==5){
            result=dictionary.get(tens*5);
        }else if(digit>5){
            if(10-digit==1){
                result= dictionary.get(tens)+dictionary.get(tens*10);
            }else{
                 result=dictionary.get(tens*5);
                 switch (digit%5){
                     case 1:
                         result=result+dictionary.get(tens);
                         break;
                     case 2:
                         result=result+dictionary.get(tens)+dictionary.get(tens);
                         break;
                     case 3:
                         result=result+dictionary.get(tens)+dictionary.get(tens)+dictionary.get(tens);
                         break;
                 }
            }
        }else{
            if(5-digit==1){
                result= dictionary.get(tens)+dictionary.get(tens*5);
            }else{
                switch (digit%5){
                    case 1:
                        result=result+dictionary.get(tens);
                        break;
                    case 2:
                        result=result+dictionary.get(tens)+dictionary.get(tens);
                        break;
                    case 3:
                        result=result+dictionary.get(tens)+dictionary.get(tens)+dictionary.get(tens);
                        break;
                }
            }
        }
        return prefix+result;
    }

    public static void main(String[] args) {
        IntegerToRoman integerToRoman=new IntegerToRoman();
        System.out.println(integerToRoman.intToRoman(58));
    }
}
