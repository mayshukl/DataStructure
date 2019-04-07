package org.unnati.ds.arrays;

import java.lang.reflect.Array;

public class MergeSort {
    
    public static <T extends Comparable> T[] mergeSort(T[] array){
        if(array==null||array.length==0)
            return array;
        mergeSort(array,0,array.length-1);
        return array;
    }

    private static <T extends Comparable> void mergeSort(T[] array,int start,int end){
        if(start>=end)
            return ;
        int pivot=(end+start)/2;
        mergeSort(array,start,pivot);
        mergeSort(array,pivot+1,end);
        merge(array,start,pivot+1,end);
    }

    public static <T extends Comparable> void merge(T[] array,int start,int middle,int end){
        T[] array1= (T[]) new Comparable[middle-start];
        T[] array2=(T[]) new Comparable[end-middle+1];

        for (int index=0;index<array1.length;index++){
            array1[index]=array[start+index];
        }
        for(int index=0;index<array2.length;index++){
            array2[index]=array[middle+index];
        }
        merge(array,start,array1,array2);
        return;
    }

    public static <T extends Comparable> void merge(T[] array,int counter,T[] array1,T[] array2){
        if(array1==null||array2==null||array==null)
            return;
        int counter1=0;
        int counter2=0;
        while(true) {
            if(counter1==-1&&counter2==-1){
                break;
            }
            if(counter1==-1){
                array[counter++]=array2[counter2++];
                counter2=array2.length==counter2?-1:counter2++;
            }else if(counter2==-1){
                array[counter++]=array1[counter1++];
                counter1=array1.length==counter1?-1:counter1++;
            }else if (array1[counter1].compareTo(array2[counter2])<0){
                array[counter++]=array1[counter1++];
                counter1=array1.length==counter1?-1:counter1++;
            }else{
                array[counter++]=array2[counter2++];
                counter2=array2.length==counter2?-1:counter2++;
            }
        }
    }
    
    
    public static <T extends Comparable> T[] threeWayMergeSort(T[] array){
        if(array==null||array.length==0)
            return array;
        threeWayMergeSort(array,0,array.length-1);
        return array;
    }

    public static <T extends Comparable> void threeWayMergeSort(T[] array,int start,int end){
        if(end<=start){
            return; 
        }
        int size=(end-start+1)/3;
        int mid1=start+size;
        int mid2=start+2*size;
        threeWayMergeSort(array,start,mid1);
        threeWayMergeSort(array,mid1+1,mid2);
        threeWayMergeSort(array,mid2+1,end);
        threeWayMerge(array,start,mid1,mid2,end);
    }
    public static <T extends Comparable> void threeWayMerge(T[] array,int start,int mid1,int mid2,int end){
        T[] array1=(T[])new Comparable[mid1-start+1];
        T[] array2=(T[])new Comparable[mid2-(mid1+1)+1];
        T[] array3=(T[])new Comparable[end-(mid2+1)+1];

        for(int i=0;i<array1.length;i++){
            array1[i]=array[start+i];
        }
        for(int i=0;i<array2.length;i++){
            array2[i]=array[mid1+1+i];
        }
        for(int i=0;i<array3.length;i++){
            array3[i]=array[mid2+1+i];
        }
        threeWayMergeSortMerge(array,array1,array2,array3,start,end);
    }


    public static <T extends Comparable> void threeWayMergeSortMerge(T[] array,T[] array1,T[] array2,T[] array3,int start,int end){
        int array1Index=0;
        int array2Index=0;
        int array3Index=0;

        for(int i=start;i<=end;i++){
            T array1Value=array1Index<array1.length ? array1[array1Index] : null;
            T array2Value=array2Index<array2.length ? array2[array2Index] : null;
            T array3Value=array3Index<array3.length ? array3[array3Index] : null;
            if(array1Value==null && array2Value==null && array3Value==null){
                break;
            }
            else if(array2Value==null && array3Value==null){
               array[i] =array1Value;
                array1Index++;
            }
            else if(array1Value==null && array3Value==null){
                array[i] =array2Value;
                array2Index++;
            }
            else if(array1Value==null && array2Value==null){
                array[i] =array3Value;
                array3Index++;
            }
            else if(array3Value==null){
                if(array2Value.compareTo(array1Value)<=0){
                    array[i] =array2Value;
                    array2Index++; 
                }else{
                    array[i] =array1Value;
                    array1Index++;
                }
            }
            else if(array2Value==null){
                if(array3Value.compareTo(array1Value)<=0){
                    array[i] =array3Value;
                    array3Index++;
                }else{
                    array[i] =array1Value;
                    array1Index++;
                }
            }
            else if(array1Value==null){
                if(array3Value.compareTo(array2Value)<=0){
                    array[i] =array3Value;
                    array3Index++;
                }else{
                    array[i] =array2Value;
                    array2Index++;
                }
            }else{
                if(array3Value.compareTo(array2Value)<=0 && array3Value.compareTo(array1Value)<=0){
                    array[i] =array3Value;
                    array3Index++;
                }else if(array2Value.compareTo(array1Value)<=0 && array2Value.compareTo(array3Value)<=0){
                    array[i] =array2Value;
                    array2Index++;
                }else{
                    array[i] =array1Value;
                    array1Index++;
                }
            }

        }
    }


}
