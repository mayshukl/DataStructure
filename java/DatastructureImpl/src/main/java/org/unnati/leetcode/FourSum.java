package org.unnati.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;



public class FourSum {

    class Tuple{
        int start;
        int end;

        Tuple(int start,int end){
            this.start=start;
            this.end=end;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Tuple tuple = (Tuple) o;
            return start == tuple.start ||start == tuple.end || end == tuple.start   || end == tuple.end;
        }
        @Override
        public int hashCode() {
            return Objects.hash(start, end)+ Objects.hash(end, start);
        }
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result=new ArrayList<>();
        Set<String> resultSet=new HashSet<>();
        Map<Integer,List<Tuple>> memory=new HashMap<>();
       
       // Without Sort there will be duplicate 
      //  Arrays.sort(nums);

        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                int sum=nums[i]+nums[j];
                Tuple currentTuple=new Tuple(i,j);
                if(memory.get(target-sum)!=null){
                    for(Tuple tuple:memory.get(target-sum) ){
                        if(!tuple.equals(currentTuple)){
                            List<Integer> integerList=new ArrayList<>();
                            integerList.add(nums[i]);
                            integerList.add(nums[j]);
                            integerList.add(nums[tuple.start]);
                            integerList.add(nums[tuple.end]);
                            Collections.sort(integerList);
                            if(!resultSet.contains(integerList.get(0)+"|"+integerList.get(1)+"|"+integerList.get(2)+"|"+integerList.get(3))){
                                result.add(integerList); 
                            }
                            resultSet.add(integerList.get(0)+"|"+integerList.get(1)+"|"+integerList.get(2)+"|"+integerList.get(3));
                            
                        }
                    }
                }
                if(memory.get(sum)==null){
                    memory.put(sum,new ArrayList<>());
                }
                memory.get(sum).add(currentTuple);
            }
        }
        return result;
    }

    public List<List<Integer>> fourSumN3(int[] nums, int target) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length-3;i++){
            if(i!=0&&nums[i]==nums[i-1]){
                continue;
            }
            for(int j=i+1;j<nums.length-2;j++){
                if(j!=i+1&&nums[j]==nums[j-1]){
                    continue;
                }
                int start=j+1;
                int end=nums.length-1;
                while (start<end){
                    if(nums[i]+nums[j]+nums[start]+nums[end]==target){
                        List<Integer> integerList=new ArrayList<>();
                        integerList.add(nums[i]);
                        integerList.add(nums[j]);
                        integerList.add(nums[start]);
                        integerList.add(nums[end]);
                        result.add(integerList);
                    }
                    
                    if(nums[i]+nums[j]+nums[start]+nums[end] <target ){
                        start++;
                        while(start<end&&nums[start]==nums[start-1]){
                            start++;
                        }
                    }else {
                        end--;
                        while (start<end&&nums[end]==nums[end+1]){
                            end--;
                        }
                        
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FourSum fourSum=new FourSum();
        int[] array=new int[]{0,0,0,0};
        List<List<Integer>> result=fourSum.fourSum(array,0);
        for(List<Integer> indexes:result){
            System.out.print(indexes.get(0));
            System.out.print(indexes.get(1));
            System.out.print(indexes.get(2));
            System.out.print(indexes.get(3));
            System.out.println();
        }
    }
}
