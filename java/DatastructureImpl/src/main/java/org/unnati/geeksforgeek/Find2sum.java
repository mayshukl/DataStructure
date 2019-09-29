package org.unnati.geeksforgeek;

import java.util.Arrays;

public class Find2sum {

    static boolean hasArrayTwoCandidates(int[] array,int sum){
        if(array==null||array.length<2){
            return false;
        }
        Arrays.sort(array);
        int i=0,j=array.length-1;
        
        while (i<j){
            if(array[i]+array[j]==sum){
                return true;
            }else if(array[i]+array[j] > sum){
                j--;
            }else {
                i++;
            }
        }
       return false;     
    }
    
    public static void main(String args[])
    {
        int A[] = { 1, 4, 45, 6, 10, -8 };
        int n = 16;
        int arr_size = A.length;

        // Function calling 
        if (hasArrayTwoCandidates(A, n))
            System.out.println("Array has two "
                    + "elements with given sum");
        else
            System.out.println("Array doesn't have "
                    + "two elements with given sum");
    }
}
