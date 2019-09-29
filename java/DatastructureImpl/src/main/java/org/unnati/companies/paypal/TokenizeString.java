package org.unnati.companies.paypal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TokenizeString {

    public static void main(String[] args) throws IOException {
        tokenize_string(null);
    }
    
    enum STATE{
            QUOTE,
            NO_QUOTE
    }
    
    static String[] tokenize_string(String str){
        // Write your code here
        List<String> result=new ArrayList<>();
        boolean isInQuotes=false;
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<str.length();i++){
            char ch= str.charAt(i);
            switch (ch){
                case '"':
                    sb.append(ch);
                    isInQuotes=!isInQuotes;
                    break;
                case ' ':
                    if(!isInQuotes){
                        result.add(sb.toString());
                        sb=new StringBuffer();
                    }else{
                        sb=sb.append(ch);
                    }
                    break;
                default:
                    sb=sb.append(ch);
            }
        }
        String[] stringArray=new String[result.size()];
        return result.toArray(stringArray);
    }
}
