package org.unnati.companies.flipkart;

import java.util.ArrayList;
import java.util.List;

public class ActiveFountain {
    public static int fountainActivation(List<Integer> a) {
        // Write your code here
        if(a.size()==0){
            return 0;
        }
         int[] startRange=new int[a.size()];
         int[] endRange=new int[a.size()];
         for(int i=0;i<a.size();i++){
             startRange[i]=Math.max((i-a.get(i)),0);
             endRange[i]=Math.min((i+a.get(i)),a.size()-1);             
         }
        Integer resultCount=fountainActivation(startRange,endRange,0,a.size()-1);
        return resultCount==null?0:resultCount;
    }


    public static Integer fountainActivation(int[] startRange,int[] endRange,int start,int end ) {
        // Write your code here
        if(start>end){
            return 0;
        }
        Integer count=null;
        for(int i=0;i<endRange.length;i++){
            if(endRange[i]==end){
                if(start<=startRange[i]){
                    Integer resultCount=fountainActivation(startRange,endRange,start,startRange[i]-1);
                    if(resultCount!=null){
                        resultCount++;
                        
                        if(count==null||resultCount<count){
                            count=resultCount;
                        }
                    }
                   
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        List<Integer> a=new ArrayList<>();
        a.add(1);
        a.add(1);
        a.add(1);
        a.add(1);
        a.add(1);
        a.add(1);
        a.add(1);
        a.add(1);
        a.add(1);
        a.add(5);

        fountainActivation(a);
    }
}
