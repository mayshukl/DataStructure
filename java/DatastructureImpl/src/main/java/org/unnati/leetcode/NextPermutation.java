package org.unnati.leetcode;

import java.util.Arrays;

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if(nums==null){
            return;
        }
        int minIndex=-1;
        for(int i=nums.length-1;i>0;i--){
            if(nums[i]>nums[i-1]){
                minIndex=i-1;
                break;
            }
        }

        if(minIndex==-1){
            int start=0;
            int end=nums.length-1;
            while(end>start){
                swap(nums,start,end);
                start++;
                end--;
            }
        }else{
            int i=nums.length-1;
            while(i>minIndex&&nums[i]<=nums[minIndex]){
                i--;
            }
            swap(nums,minIndex,i);
            Arrays.sort(nums,minIndex+1,nums.length);
        }
    }
    
    void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public static void main(String[] args) {
        NextPermutation nextPermutation=new NextPermutation();
       // nextPermutation.nextPermutation(new int[]{100,99,98,97,96,95,94,93,92,91,90,89,88,87,86,85,84,83,82,81,80,79,78,77,76,75,74,73,72,71,70,69,68,67,66,65,64,63,62,61,60,59,58,57,56,55,54,53,52,51,50,49,48,47,46,45,44,43,42,41,40,39,38,37,36,35,34,33,32,31,30,29,28,27,26,25,24,23,22,21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1});
        nextPermutation.nextPermutation(new int[]{2,3,1});
    }
    
}
