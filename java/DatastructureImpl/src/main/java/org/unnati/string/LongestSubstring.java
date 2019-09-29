package org.unnati.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

    // Sliding Window Solution
    public int lengthOfLongestSubstring(String s) {
       int length=0;
       int i=0,j=0;
       Set<Character> set=new HashSet<>();
       
       while(i<s.length()&&j<s.length()){
           if(!set.contains(s.charAt(j))){
               set.add(s.charAt(j));
               length=Math.max(length,j-i+1);
               j++;
           }else{
               set.remove(s.charAt(i));
               i++;
           }
       }
       return length;
    }


    public String[] getSubStrings(String string){
        ArrayList<String> subStrings=new ArrayList<>();
        
        for(int i=0;i<string.length();i++){
            for(int j=i;j<string.length();j++){
                String result=null;
               if((result=findUniqueSubString(string,i,j+1))!=null){
                   subStrings.add(result);
               }
            }
        }
        String[] subStringArray=new String[subStrings.size()];
        return subStrings.toArray(subStringArray);
    }
    
    String findUniqueSubString(String string,int start,int end){
        StringBuilder sb=new StringBuilder();
        Set<Character> characters=new HashSet<>();
        for(int i=start;i<end;i++){
            if(characters.contains(string.charAt(i))){
                return null;
            }else {
                characters.add(string.charAt(i));
                sb.append(string.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LongestSubstring longestSubstring=new LongestSubstring();
        int size=0;
        for(String subString :longestSubstring.getSubStrings("abc")){
            if(subString.length()>size){
                size=subString.length();
            }
        }
        System.out.println(size);
    }
}
