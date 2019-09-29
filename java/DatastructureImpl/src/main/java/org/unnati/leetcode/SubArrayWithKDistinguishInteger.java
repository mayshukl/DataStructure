package org.unnati.leetcode;

import java.util.*;

public class SubArrayWithKDistinguishInteger {

    // Sliding Window Problem 
    public int subarraysWithKDistinct(int[] array, int k) {
        int number=0;
        Map<Integer,LinkedList<Integer>> map=new HashMap<>();
        int i=0,j=0;
        while(i<array.length&&j<array.length){
            if(map.get(array[j])==null){
                if(map.size()==k){
                    map.get(array[i]).removeLast();
                    if(map.get(array[i]).size()==0){
                        map.remove(array[i]);
                    }
                    i++;
                }else{
                    LinkedList<Integer> list=new LinkedList<>() ; 
                  list.addFirst(j);
                  map.put(array[j],list);  
                  j++;
                }
            }else{
                map.get(array[j]).addFirst(j);
                j++; 
            }
            if(map.size()==k){
                number++;
            }
        }
        
        return number;
    }
    
    // O(n^3)
    public int subarraysWithKDistinctSlow(int[] array, int k) {
      int number=0;
      
      for(int i=0;i<array.length;i++){
          for(int j=i;j<array.length;j++){
              if(isGoodSubArray(array,i,j+1,k)){
                  number++;
              }
          }
      }
      return number;
    }
    
    boolean isGoodSubArray(int[] array,int start,int end, int k){
        Set<Integer> integers=new HashSet<>();
        for(int i=start;i<end;i++){
            integers.add(array[i]);
        }
        System.out.print(start +","+end+"[");
        for(Integer integer:integers){
            System.out.print(integer+",");
        }
        System.out.print("] - ");
        if(integers.size()==k){
            System.out.println(true);
            return true;
        }else {
            System.out.println(false);
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println((new SubArrayWithKDistinguishInteger()).subarraysWithKDistinct(new int[]{1,2,1,2,3},2));
    }
   
}
