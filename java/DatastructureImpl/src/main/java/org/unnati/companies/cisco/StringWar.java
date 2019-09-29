package org.unnati.companies.cisco;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class StringWar {

    public static String string_at_index(int n, long m) {
        findString(new StringBuilder("A"),n-1,m);
        if(result==null){
            findString(new StringBuilder("B"),n-1,m);
        }
        return result==null?"Not Possible" : result;
    }

    static long count=0;
    static String result=null;
    public static void findString(StringBuilder preString,int n,long m){

        if(n==0){
            count++;
            if(count==m){
                result=preString.toString();
            }
        }else{
            findString((new StringBuilder(preString)).append('A'),n-1,m);
            if(result==null&&preString.charAt(preString.length()-1)!='B'){
                findString(new StringBuilder(preString).append('B'),n-1,m);
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(string_at_index(2,4));
    }
    
}
