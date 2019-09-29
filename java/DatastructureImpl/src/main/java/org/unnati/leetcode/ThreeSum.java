package org.unnati.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.*;
import java.util.Set;

/**
 * 
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * 
 * */

public class ThreeSum {
    
//    public List<List<Integer>> threeSumMap(int[] nums) {
//        List<List<Integer>> result=new ArrayList<>();
//        Map<Integer,Integer> map=new HashMap<>();
//        Set<Set<Integer>> set=new HashSet<>();
//        for(int i=)
//        for(int i=0;i<=nums.length-2;i++){
//            for(int j=i+1;j<=nums.length-1;j++){
//                Integer k=0-(nums[i]+nums[j]);
//                if(map.get(k)!=null){
//                    Set<Integer> integerSet=new HashSet<>();
//                    integerSet.add(nums[i]);
//                    integerSet.add(nums[j]);
//                    integerSet.add(k);
//                    if(!set.contains(integerSet)){
//                        set.add(integerSet);
//                        List<Integer> list=new ArrayList<>();
//                        list.add(nums[i]);
//                        list.add(nums[j]);
//                        list.add(k);
//                        result.add(list);
//                    }
//                }
//            }
//        }
//
//        return result;
//    }


    public List<List<Integer>> threeSumTreeSet(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        
        for(int i=0;i<nums.length-2;i++){
            if(i!=0 && nums[i]==nums[i-1]){
                continue;
            }
            int j=i+1;
            int k=nums.length-1;

            while(j<k){
                if(nums[i]+nums[j]+nums[k]==0){
                    List<Integer> list=new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
                }

                if (nums[i]+nums[j]+nums[k] < 0){
                    j++;
                    while(j<k&&nums[j]==nums[j-1]){
                        j++;
                    }
                }else{
                    k--;
                    while(j<k&&nums[k]==nums[k+1]){
                        k--;
                    }
                }
            }

        }

        return result;
    }

    public List<List<Integer>> threeSumOpt(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0;i<nums.length-2;i++){
            if(i!=0 && nums[i]==nums[i-1]){
                continue;
            }
            int j=i+1;
            int k=nums.length-1;

            while(j<k){
                if(nums[i]+nums[j]+nums[k]==0){
                    List<Integer> list=new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
                }
                
                if (nums[i]+nums[j]+nums[k] < 0){
                    j++;
                    while(j<k&&nums[j]==nums[j-1]){
                        j++;
                    }
                }else{
                    k--;
                    while(j<k&&nums[k]==nums[k+1]){
                        k--;
                    }
                }
            }

        }

        return result;
    }
    
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        Set<String> set=new HashSet<>();
        Arrays.sort(nums);

        for(int i=0;i<nums.length-2;i++){
            int j=i+1;
            int k=nums.length-1;

            while(j<k){
                if(nums[i]+nums[j]+nums[k]==0){
                    if(!set.contains(nums[i]+"|"+nums[j]+"|"+nums[k])){
                        set.add(nums[i]+"|"+nums[j]+"|"+nums[k]);
                    }
                    j++;
                    k--;
                }else if (nums[i]+nums[j]+nums[k] < 0){
                    j++;
                }else{
                    k--;
                }
            }

        }

        for(String indexes: set){
            String indexArray[]=indexes.split("\\|");
            List<Integer> list=new ArrayList<>();
            list.add(Integer.parseInt(indexArray[0]));
            list.add(Integer.parseInt(indexArray[1]));
            list.add(Integer.parseInt(indexArray[2]));
            result.add(list);
        }

        return result;
    }

    public static void main(String[] args) {
        ThreeSum threeSum=new ThreeSum();
        int[] array=new int[]{0,0,};
        List<List<Integer>> result=threeSum.threeSum(array);
        for(List<Integer> indexes:result){
            System.out.print(indexes.get(0));
            System.out.print(indexes.get(1));
            System.out.print(indexes.get(2));
            System.out.println();
        }
    }
}
