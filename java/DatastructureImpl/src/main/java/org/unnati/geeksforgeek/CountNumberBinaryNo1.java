package org.unnati.geeksforgeek;

/****
 * 
 * https://www.geeksforgeeks.org/count-number-binary-strings-without-consecutive-1s/
 * Given a positive integer N, count all possible distinct binary strings of length N such that there are no consecutive 1’s.
 * */
public class CountNumberBinaryNo1 {
    
   static int countStrings(int number){
        int count0=1;
        int count1=1;
        
        for(int i=2;i<=number;i++){
            int temp=count0+count1;
            count1=count0;
            count0=temp;
        }
        return count0+count1;
    }

    public static void main (String args[])
    {
        System.out.println(countStrings(3));
    }
}
