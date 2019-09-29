package org.unnati.geeksforgeek;

public class SeacrhInRotatedArray {

    static int search(int[] array,int value,int start,int end){
        if(end<start){
            return -1;
        }
        if(start==end){
            return array[start]==value ? start:-1;
        }
        int mid=(start+end)/2;
        if(array[mid]==value){
            return mid;
        }
        
        if(array[start]<array[mid]){
            if(array[start]<=value&&array[mid]>=value){
                return search(array,value,start,mid); 
            }else {
                return search(array,value,mid+1,end); 
            }
        }else{
            if(array[mid+1]<=value&&array[end]>=value){
                return search(array,value,mid+1,end);
            }else {
                return search(array,value,start,mid);
            }
        }
    }


    static int  search(int[] arary,int value){
        return search(arary,value,0,arary.length);
    }

    public static void main(String args[])
    {
        int arr[] = {4, 5, 6, 7, 8, 9, 1, 2, 3};
        int n = arr.length;
        int key = 2;
        int i = search(arr, key);
        if (i != -1)
            System.out.println("Index: " + (i));
        else
            System.out.println("Key not found");
    }
}
