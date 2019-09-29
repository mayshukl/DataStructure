package org.unnati.Heap;

public class TournamentTree {

    public static void main(String[] args) {
        int[] result=createWinnerTree(new int[]{1,2,3});
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);  
        }
        
    }
    
    public static int[] createWinnerTree(int[] array) {
        if (array == null || array.length < 2) {
            return null;
        }
        int sizeOfTree=array.length%2==0 ? array.length+array.length-1 : array.length+array.length+1;
        int[] tree=new int[sizeOfTree];
        int remainingLength=sizeOfTree;
        if(array.length%2!=0){
            tree[sizeOfTree-1]=Integer.MIN_VALUE;
            remainingLength--;
        }
        for(int i=0;i<array.length;i++){
            tree[remainingLength-i-1]=array[array.length-i-1];
        }
        for(int i=remainingLength-array.length-1;i>=0;i--){
            tree[i]=Math.max(tree[2*i+1] ,tree[2*i+2]);
        }
        return tree;
    }
}
