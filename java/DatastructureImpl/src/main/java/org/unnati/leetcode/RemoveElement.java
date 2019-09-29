package org.unnati.leetcode;

/*****
 * 
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * 
 * https://leetcode.com/problems/remove-element/
 * 
 * */

public class RemoveElement {

    public int removeElement(int[] nums, int val) {

        if(nums==null||nums.length==0){
            return 0;
        }
        int end=nums.length;
        while(end>0&&nums[end-1]==val){
            end--;
        }
        int start=0;
        while(start<end-1){
            if(nums[start]==val){
                int temp=nums[end-1];
                nums[end-1]=val;
                nums[start]=temp;
                end--;
            }
            start++;
        }
        return end;
    }

    public static void main(String[] args) {
        RemoveElement removeElement=new RemoveElement();
        removeElement.removeElement(new int[]{3,2,2,3},3);
    }
}
