package org.unnati.leetcode;

/***
 * This is KMP algorithm
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * 
 * 
 * **/

public class IndexOf {

    private int[] subStringArray(String subString){
        int[] array=new int[subString.length()];
        int i=1;int j=0;
        array[0]=0;
        while(i<array.length){
            if(subString.charAt(i)==subString.charAt(j)){
                array[i]=j+1;
                i++;j++;
            }else{
                if(j>0){
                    j=array[j-1];
                }else{
                    array[i]=0;
                    i++;
                }
            }
        }
        return array;
    }
    
    public int strStr(String haystack, String needle) {
        if(needle==null||needle.length()==0){
            return 0;
        }
        int[] prefixSuffix=subStringArray(needle);
        int j=0,i=0;;
        while(i<haystack.length()){
         if(haystack.charAt(i)==needle.charAt(j)){
             i++;j++;
             if(j==needle.length()){
                 return i-j;
             }
         }else{
             if(j>0){
                 j=prefixSuffix[j-1]; 
             }else{
                 i++;
             }
         }
        }
        return -1;
    }

    public static void main(String[] args) {
        IndexOf indexOf=new IndexOf();
        System.out.println(indexOf.strStr("mississippi","issip"));
    }
}
