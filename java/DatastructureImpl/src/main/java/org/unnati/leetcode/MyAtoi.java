package org.unnati.leetcode;

public class MyAtoi {
    enum STATE{
        STRING,
        NUMBER
    }
    public int myAtoi(String str) {
        Integer result=0;
        boolean isNegativeNumber=false;
        STATE state=STATE.STRING;
        for(int i=0;i<str.length();i++){
            if(state==STATE.STRING){
                if(str.charAt(i)==32){
                    continue;
                }else if(str.charAt(i)==45 || str.charAt(i)==43){
                   if(str.charAt(i)==45){
                       isNegativeNumber=true;
                   }
                    state=STATE.NUMBER;
                }else if (str.charAt(i) >= 48 && str.charAt(i) <= 57){
                    state=STATE.NUMBER;
                    i=i-1;
                }else{
                    return 0;
                }
            }else {
                int pos = (int) str.charAt(i) - 48;
                if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
                    if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && pos > 7)) {
                        return Integer.MAX_VALUE;
                    }
                    if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && pos > 8)) {
                        return Integer.MIN_VALUE;
                    }
                    result = result * 10 + pos * (isNegativeNumber ? -1 : 1);
                }else{
                    return result;
                }
            }
        }
        return result ==null ?0 : result;
    }
}
