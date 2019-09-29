package org.unnati.companies.flipkart;

public class CoPrime {

    static int[] coprimeCount(int[] A) {
       int[] result=new int[A.length];
       for(int i=0;i<A.length;i++){
           result[i]=countPrime(A[i]);
       }
       return result; 
    }
    
    static int countPrime(int number){
        int count=0;
        for(int i=1;i<=number;i++){
            if(greatestCommonDevisior(i,number)){
                count++;
            }
        }
        return count;
    }
    
    static boolean greatestCommonDevisior(int a,int b){
        if (a == 0 || b == 0)
            return true;

        // base case 
        if (a == b)
            return true;

        // a is greater 
        if (a > b)
            return greatestCommonDevisior(a-b, b);

        return greatestCommonDevisior(a, b-a);
    }
    
    
    static boolean isCoPrime(int number1,int number2){
        for(int i=2;i<=number1;i++){
            if(number2%i==0){
                return false;
            }
        }
        return true;
    }
}
