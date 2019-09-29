package org.unnati.leetcode;


/**
 * 
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 *
 * Return the quotient after dividing dividend by divisor.
 *
 * The integer division should truncate toward zero.
 * 
 * */
public class DivideTwoInteger {
    public int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE && divisor==-1){
            return Integer.MAX_VALUE;
        }
        
       boolean isNegative=false;
        if(divisor<0){
            isNegative=isNegative^true;
            divisor=~divisor+1;
        }
        if(dividend<0){
            isNegative=isNegative^true;
            dividend=~dividend+1;
        }
        int temp=0,result=0;
        int counter=0;
        while(dividend - divisor >= 0){

            int x = 0;
            while( dividend - (divisor << 1 << x) >= 0){
                x++;
            }
            result += 1 << x;
            dividend -= divisor<< x;
        }
        return isNegative ? ~result+1 : result;
    }

    public long divide(long dividend, long divisor) {
        long sign = ((dividend < 0) ^
                (divisor < 0)) ? -1 : 1;

// remove sign of operands  
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

// Initialize the quotient  
        long quotient = 0, temp = 0;

// test down from the highest  
// bit and accumulate the  
// tentative value for  
// valid bit  
// 1<<31 behaves incorrectly and gives Integer 
// Min Value which should not be the case, instead  
        // 1L<<31 works correctly.  
        for (int i = 31; i >= 0; --i)
        {

            if (temp + (divisor << i) <= dividend)
            {
                temp += divisor << i;
                quotient |= 1L << i;
            }
        }

        return (sign * quotient);
    }

    public static void main(String[] args) {
        DivideTwoInteger divideTwoInteger=new DivideTwoInteger();
        
        //System.out.println(divideTwoInteger.divide(10,3));
        System.out.println(divideTwoInteger.divide(7,2));
        System.out.println(1<<31);
    }
}
