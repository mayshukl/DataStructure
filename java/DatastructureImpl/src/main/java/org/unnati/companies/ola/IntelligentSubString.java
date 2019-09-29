package org.unnati.companies.ola;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class IntelligentSubString {

    public static int getSpecialSubstringOpt(String s, int k, String charValue) {
        // Write your code here
        Set<Character> set=new HashSet<>();
        for(int i=0;i<26;i++){
            if(charValue.charAt(i)==48)
                set.add((char)(97+i));
        }
        Queue<Integer> queue=new LinkedList<>();
        int longestSubString=Integer.MIN_VALUE;
        int normalCount=0;
        int i=0,j=0;
        while(j<s.length()){
            if(set.contains(s.charAt(j))){
                queue.offer(j);
                if(normalCount==k){
                    i=queue.poll()+1;
                }else{
                    normalCount++;
                }
            }
            if(j-i+1>longestSubString){
                longestSubString=j-i+1;
            }
            j++;
            
        }
        return longestSubString;
    }
    
    public static int getSpecialSubstring(String s, int k, String charValue) {
        // Write your code here
        Set<Character> set=new HashSet<>();
        for(int i=0;i<26;i++){
            if(charValue.charAt(i)==48)
                set.add((char)(97+i));
        }
        int longestSubString=Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++){
            for (int j=i;j<s.length();j++){
                if(isNormal(s.substring(i,j+1),k,set)){
                   if(longestSubString<j-i+1){
                       longestSubString=j-i+1;
                   }
                }
            }
        }
        return longestSubString;
    }
    
   static boolean isNormal(String s, int k, Set<Character>normalCharacter){
        int normal=0;
        for(int i=0;i<s.length();i++){
            if(normalCharacter.contains(s.charAt(i))){
                normal++;
                if(normal>k){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        getSpecialSubstringOpt("giraffe",2,"01111001111111111011111111");
    }
}
