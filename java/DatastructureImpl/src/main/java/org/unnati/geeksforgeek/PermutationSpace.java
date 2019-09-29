package org.unnati.geeksforgeek;

import java.util.HashSet;
import java.util.Set;

public class PermutationSpace {

      
   static void printPattern(String str,String prefix,Set<String> result){
       if(str.length()==1){
           result.add(prefix+str);
           return;
       }
       for(int i=1;i<str.length();i++){
           printPattern(str.substring(i,str.length()),prefix+str.substring(0,i),result);   
           printPattern(str.substring(i,str.length()),prefix+str.substring(0,i)+" ",result);   
       }
       
    }

    // Driver program 
    public static void main (String[] args)
    {
        Set<String> result=new HashSet<>();
        String str = "ABCD";
        printPattern(str,"",result);
        for(String subString:result){
            System.out.println(subString);
        }
    }
}
