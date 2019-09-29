package org.unnati.geeksforgeek;

public class Knapsack {

    static int knapSack(int limitValue,int[] weightArray,int[] valueArray,int length){
        int[][] matrix=new int[length+1][limitValue+1];
        for(int item=0;item<=length;item++){
            for(int wight=0;wight<=limitValue;wight++){
                if(item==0||wight==0){
                    matrix[item][wight]=0;
                }else if(wight-weightArray[item-1]>=0 ){
                    matrix[item][wight]=Math.max(matrix[item-1][wight],matrix[item-1][wight-weightArray[item-1]]+valueArray[item-1]);
                }else{
                    matrix[item][wight]=matrix[item-1][wight];
                }
            }
        }
        return matrix[length][limitValue];
    }
    public static void main(String args[])
    {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int  W = 50;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));
    }
}
