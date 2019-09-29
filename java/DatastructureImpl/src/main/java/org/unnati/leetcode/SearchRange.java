package org.unnati.leetcode;

public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        if(nums==null||nums.length==0){
            return new int[]{-1,-1};
        }

        return searchIndex(nums,target,0,nums.length-1);
    }
    
    int[] searchIndex(int[] nums, int target,int start,int end){
        if(start==end&&nums[start]==target){
            return new int[]{start,start};
        }
        if(nums[start]>target||nums[end]<target){
            return new int[]{-1,-1};
        }
        int mid=(start+end)/2;
        if(nums[mid]== target){
            int[] leftIndex=searchIndex(nums,target,start,mid);
            int[] rightIndex=searchIndex(nums,target,mid+1,end);
            if(rightIndex[0]==-1)
                return leftIndex;
            return new int[]{leftIndex[0],rightIndex[1]};
        }else{
            if(nums[mid] > target){
              return  searchIndex(nums,target,0,mid-1);
            }else {
                return searchIndex(nums,target,mid+1,end);
            }
        }
        
    }

    public static void main(String[] args) {
        SearchRange searchRange=new SearchRange();
        searchRange.searchRange(new int[] {5,7,7,8,8,10},8);
    }
    
    
}
