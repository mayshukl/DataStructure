package org.unnati.geeksforgeek;

public class CelebrityProblem {

    static int MATRIX[][] = { { 0, 0, 1, 0 },
            { 0, 0, 1, 0 },
            { 0, 0, 0, 0 },
            { 0, 0, 1, 0 } };

    // Returns true if a knows  
    // b, false otherwise 
    static boolean knows(int a, int b)
    {
        boolean res = (MATRIX[a][b] == 1) ?
                true :
                false;
        return res;
    }

    static int findCelebrity(int number){
        
        int i=0,j=number-1;
        while(i!=j){
            if(knows(i,j)){
                i++;
            }else {
                j--;
            }
        }
        for(int k=0;k<number-1;k++){
            if(k!=i){
                if(!knows(k,i)||knows(i,k)){
                    return -1;
                }
            }
        }
        return i;
    }

    // Driver Code 
    public static void main(String[] args)
    {
        int n = 4;
        int result = findCelebrity(n);
        if (result == -1)
        {
            System.out.println("No Celebrity");
        }
        else
            System.out.println("Celebrity ID " +
                    result);
    }

}
