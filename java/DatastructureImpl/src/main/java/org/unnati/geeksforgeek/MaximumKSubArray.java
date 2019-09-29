package org.unnati.geeksforgeek;

import java.util.Deque;
import java.util.LinkedList;

public class MaximumKSubArray {
    
    static void printMax(int[] array,int arrayLength, int size){
        Deque<Integer> indexes=new LinkedList<>();
        
        for(int i=0;i<Math.min(arrayLength,size);i++ ){
            while((!indexes.isEmpty())&&array[indexes.peekLast()]<=array[i]){
                indexes.removeLast();
            }
            indexes.add(i);
        }
        System.out.print(array[indexes.peekFirst()]+" ");
        if(arrayLength>size){
            for(int i=size;i<arrayLength;i++ ){

                while ((!indexes.isEmpty())&&indexes.peekFirst()<=i-size){
                    indexes.removeFirst();
                }
                while((!indexes.isEmpty())&&array[indexes.peekLast()]<=array[i]){
                    indexes.removeLast();
                }
                indexes.add(i);
                System.out.print(array[indexes.peekFirst()]+" ");
            }
        } 
    }
    

    public static void main(String[] args)
    {
        int arr[] = { 12, 1, 78, 90, 57, 89, 56 };
        int k = 3;
        printMax(arr,arr.length, k);
    }
}
