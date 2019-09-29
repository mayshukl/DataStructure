package org.unnati.geeksforgeek;

public class MatrixChainMultiplication {

    static int MatrixChainOrder(int[] array,int size){
        return MatrixChainOrder(array,0,size-1);
    }
    
    static int MatrixChainOrder(int[] array,int start,int end){
        int max=Integer.MAX_VALUE;
        
        if(end-start==0){
            return 0;
        }
        
        for(int i=start;i<end;i++){
            int multipleCount=MatrixChainOrder(array,start,i)+MatrixChainOrder(array,i+1,end)
                    +array[start-1]*array[i]*array[end];
            if(multipleCount<max){
                max=multipleCount;
            }
        }
        
        return max;
    }

    // Driver program to test above function 
    public static void main(String args[])
    {
        int arr[] = new int[] {1, 2, 3, 4};
        int size = arr.length;

        System.out.println("Minimum number of multiplications is "+
                MatrixChainOrder(arr, size));
    }
}
