package org.unnati.companies.ola;

/****
 * 
 * n       n
 *  C    =  C    * (n-r)/(r+1)
 *   r+1     r
 * */

public class PascalTriangle {
    
   static void printPascalTriangle(int level){
        int preSum=0;
        
        for(int i = 0 ;i<level;i++){
            for(int j=0;j<=i;j++){
                if(j==0){
                    preSum=1;
                }else{
                    preSum = preSum * ( i - (j-1) )/j;
                }
                System.out.print(preSum +" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printPascalTriangle(5);
    }
    
}
