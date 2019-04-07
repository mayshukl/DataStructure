package org.unnati.ds;

public class DataStructureUtils {


    public static int findIndex(Object[] array, Object value){
        int index=0;
        for(int i=0;i<array.length;i++){
            if(array[i].equals(value)){
                index=i;
                break;
            }
        }
        return index;
    }
    
    public static short findLeftMostDigit(long number){
        while(number>10) {
            number = number / 10;
        }
        return (short) number;
    }
    
    public static long appendNumber(long number,long numberToAppend){
        long temp=numberToAppend;
        while(temp>0){
            temp=temp/10;
            number=number*10;
        }
        return number+numberToAppend;
    }
}
