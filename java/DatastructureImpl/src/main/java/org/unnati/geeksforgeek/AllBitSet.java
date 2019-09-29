package org.unnati.geeksforgeek;

public class AllBitSet {
    
    static boolean areAllBitsSet(int number){
        return number==0? false : (number&(number+1)) == 0;
    }

    public static void main (String[] args) {
        int n = 8;
        System.out.println(areAllBitsSet(n));
    }
}
