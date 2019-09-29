package org.unnati.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LetterCombinations {

    static String[][] map=new String[10][];

    static{
        map[2]=new String[]{"a","b","c"};
        map[3]=new String[]{"d","e","f"};
        map[4]=new String[]{"g","h","i"};
        map[5]=new String[]{"j","k","l"};
        map[6]=new String[]{"m","n","o"};
        map[7]=new String[]{"p","q","r","s"};
        map[8]=new String[]{"t","u","v"};
        map[9]=new String[]{"w","x","y","z"};
    }

    public List<String> letterCombinations(String digits) {
        List<String> result=new ArrayList<>();
        String[] strings=new String[0];
        for(int i=0;i<digits.length();i++){
            strings=addNewString(digits.charAt(i)-48,strings);
        }
        return Arrays.asList(strings);
    }

    String[] addNewString(int number,String[] existing){
        if(existing.length==0){
            existing=new String[1];
            existing[0]="";
        }
        String[] result=new String[existing.length*map[number].length];
        int index=0;
        for(String str1:existing){
            for(String str2:map[number]){
                result[index]=str1+str2;
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LetterCombinations letterCombinations=new LetterCombinations();
        letterCombinations.letterCombinations("23");
    }
}
