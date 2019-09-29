package org.unnati.leetcode;

public class ReverseInteger {
    public int reverse(int x) {
        int result=0;
        int multiple=1;
        if(x<0){
            multiple=-1;
            x=x*-1;
        }
        while(x>0){
            result=result*10+x%10;
            x=x/10;
        }
        return result*multiple;
    }
}
