package org.unnati.geeksforgeek;

public class SearchRotationIndexArray {

    int findPivot(int[] nums,int start,int end){
        if(end-start==0){
            return -1;
        }
        if(nums[start]<nums[end]){
            return -1;
        }
        int mid=(start+end)/2;
        if(nums[start]<=nums[mid]){
            if(nums[mid+1] <= nums[end]){
                return mid+1;
            }else {
               return findPivot(nums,mid+1,end); 
            }
        }else{
            if(nums[start] <= nums[mid]){
                return mid+1;
            }else {
                return  findPivot(nums,start,mid);
            }
        }
    }

    int findPivot(int[] nums){
        return findPivot(nums,0,nums.length-1);
    }

    public static void main(String[] args) {
        SearchRotationIndexArray searchRotatedArray=new SearchRotationIndexArray();
        System.out.println(searchRotatedArray.findPivot(new int[]{0,1,1,2}));
        // System.out.println(searchRotatedArray.findPivot(new int[]{5,1,3},0,2));    
    }
}
