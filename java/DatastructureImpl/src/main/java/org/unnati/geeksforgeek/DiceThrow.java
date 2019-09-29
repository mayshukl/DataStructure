package org.unnati.geeksforgeek;

public class DiceThrow {
    
    static int findWays(int diceFace,int diceCount,int sum){
        int[][] memory=new int[diceCount+1][sum+1];
        memory[0][0]=1;
        
        for(int i=1;i<=diceCount;i++){
            for(int j=1;j<=sum;j++){
                for(int k=1;k<=diceFace;k++){
                   if(j-k>=0){
                       memory[i][j]+=memory[i-1][j-k];   
                   }
                }
            }
        }
        return memory[diceCount][sum];
    }

    public static void main (String[] args) {
        System.out.println(findWays(4, 2, 1));
        System.out.println(findWays(2, 2, 3));
        System.out.println(findWays(6, 3, 8));
        System.out.println(findWays(4, 2, 5));
        System.out.println(findWays(4, 3, 5));
    }
}
