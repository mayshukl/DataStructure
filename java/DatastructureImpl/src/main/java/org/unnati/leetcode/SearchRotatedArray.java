package org.unnati.leetcode;

public class SearchRotatedArray {
    public int search(int[] nums, int target) {
        if(nums==null||nums.length==0){
            return -1;
        }
        int pivot=findPivot(nums,0,nums.length-1);
        if(nums[nums.length-1]>=target){
            return searchWithPivot(nums,target,pivot,nums.length-1);
        }else{
            return searchWithPivot(nums,target,0,pivot-1);
        }
    }

    int findPivot(int[] nums,int start,int end){
        if(start==end){
            return start;
        }
        int mid=(start+end)/2;
        if(nums[start]<=nums[mid] && nums[mid] >nums[end]){
           return findPivot(nums,mid+1,end);
        }else if(nums[start]<=nums[mid] && nums[mid] <nums[end]){
            return start;
        }else if (nums[start]>nums[mid] && nums[mid] >nums[end]){
            return -1;
        }else {
            return findPivot(nums,start,mid);
        }

    }
    
    int searchWithPivot(int[] nums,int target,int start,int end){
        if(end<start){
            return -1;
        }
        int mid=(start+end)/2;
        if(nums[mid]==target){
            return mid;
        }
        if(nums[mid]<target){
            return searchWithPivot(nums,target,mid+1,end);
        }else {
            return searchWithPivot(nums,target,start,mid-1);
        }
    }

//
//    int search(int[] nums,int number,int start,int end){
//        if(end<start){
//            return -1;
//        }
//        int mid=(start+end)/2;
//        if(nums[mid]==number){
//            return mid;
//        }
//        
//        if(nums[start]<nums[mid] && nums[mid] >nums[end]){
//            if(nums[mid]>number&&nums[start]<=number){
//                return search(nums,number,start,mid);
//            }else{
//                return search(nums,number,mid+1,end);
//            }
//        }else if(nums[start]<nums[mid] && nums[mid] <nums[end]){
//            if(nums[mid]<number){
//                return search(nums,number,mid+1,end);
//            }else {
//                return search(nums,number,start,mid);
//            }
//        }else if (nums[start]>nums[mid] && nums[mid] >nums[end]){
//            throw new IllegalArgumentException();
//        }else {
//            if(nums[mid]>number&&nums[start]<=number){
//                return search(nums,number,start,mid);
//            }else{
//                return search(nums,number,mid+1,end);
//            }
//        }
//        
//    }
    
    public static void main(String[] args) {
        SearchRotatedArray searchRotatedArray=new SearchRotatedArray();
        System.out.println(searchRotatedArray.search(new int[]{4,5,6,7,0,1,2},3));    
       // System.out.println(searchRotatedArray.findPivot(new int[]{5,1,3},0,2));    
    }
}
