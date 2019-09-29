package org.unnati.geeksforgeek;

public class NumberAsPow {

    boolean isPower(int number){
        Double squareRoot=Math.sqrt(number);
        int squareRootInt=squareRoot.intValue();
        if(squareRoot.equals(squareRootInt)){
            return isPower(squareRootInt);
        }else{
            for(int i=2;i<=squareRoot;i++){
                
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
        for (int i = 2; i < 100; i++)
           // if (isPower(i))
                System.out.print(i + " ");
    }
}
