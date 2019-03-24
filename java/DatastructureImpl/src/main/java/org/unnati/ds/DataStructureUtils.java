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
}
