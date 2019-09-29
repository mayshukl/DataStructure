package org.unnati.geeksforgeek;

import java.util.ArrayList;
import java.util.List;

public class StockBuySell {

    private class LocalMinMax{
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
    }
    
    List<LocalMinMax> getLocalMinMax(int[] array){
        List<LocalMinMax> localMinMaxes=new ArrayList<>();
        int minIndex=0;
        int maxIndex=0;
        for(int i =1;i<array.length;i++){
            if(array[i]<array[i-1]){
                if(array[minIndex]<array[maxIndex]){
                    LocalMinMax localMinMax=new LocalMinMax();
                    localMinMax.min=minIndex;
                    localMinMax.max=maxIndex;
                    localMinMaxes.add(localMinMax);
                    maxIndex=i;
                }
                minIndex=i;
            }else {
                maxIndex=i;
            }
        }
        if(array[minIndex]<array[maxIndex]){
            LocalMinMax localMinMax=new LocalMinMax();
            localMinMax.min=minIndex;
            localMinMax.max=maxIndex;
            localMinMaxes.add(localMinMax);
        }
        return localMinMaxes;
    }
    
    

    public static void main(String args[])
    {
        StockBuySell stock = new StockBuySell();

        // stock prices on consecutive days 
        int price[] = { 100, 180, 260, 310, 40, 535, 695 };
        int n = price.length;

        // fucntion call 
        stock.getLocalMinMax(price);
    }
}
