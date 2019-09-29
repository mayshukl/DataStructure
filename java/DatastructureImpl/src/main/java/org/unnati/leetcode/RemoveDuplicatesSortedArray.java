package org.unnati.leetcode;

public class RemoveDuplicatesSortedArray {

    public int removeDuplicates(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return 1;
        }
        int lastUniqueNumber=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                lastUniqueNumber++;
                nums[lastUniqueNumber]=nums[i];
            }
        }
        return lastUniqueNumber+1;
    }
    
}
