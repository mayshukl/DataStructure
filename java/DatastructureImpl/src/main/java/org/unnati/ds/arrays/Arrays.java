package org.unnati.ds.arrays;

import org.unnati.ds.DataStructureUtils;

public class Arrays {
    
    public static Long maxNumberByRotatingAndConcatenatingArray(Integer[] array){
        Long number=0L;
        int preMaxValueIndex=0;
        int preMaxValue=DataStructureUtils.findLeftMostDigit(array[0]);
        for(int index=0;index<array.length;index++){
            if(DataStructureUtils.findLeftMostDigit(array[index])>preMaxValue){
                preMaxValue=DataStructureUtils.findLeftMostDigit(array[index]);
                preMaxValueIndex=index;
            }
        }
        rotateArrayLeft(array,preMaxValueIndex);
        for(int index=0;index<array.length;index++){
            number=DataStructureUtils.appendNumber(number,array[index]);
        }
        return  number;
    }
   
   public static <T> void rotateArrayLeft(T[] array,int rotationFrequency){
       if (rotationFrequency>array.length){
           rotationFrequency=rotationFrequency-array.length; 
       }
       reverseArray(array,0,rotationFrequency-1);
       reverseArray(array,rotationFrequency,array.length-1);
       reverseArray(array,0,array.length-1);
   }
    public static <T> void rotateArrayRight(T[] array,int rotationFrequency){
        if (rotationFrequency>array.length){
            rotationFrequency=rotationFrequency-array.length;
        }
        rotationFrequency=array.length-rotationFrequency;
        reverseArray(array,0,rotationFrequency-1);
        reverseArray(array,rotationFrequency,array.length-1);
        reverseArray(array,0,array.length-1);
    }
   
    public static <T> void reverse(T[] array){
        if(array==null||array.length==0)
            return;
        reverseArray(array,0,array.length-1);
    }
    
    private static <T> void reverseArray(T[] array, int start, int end){
        while(start<end){
            T temp=array[start];
            array[start]=array[end];
            array[end]=temp;
            start++;
            end--;
        }
    }
    
    
    public static <T extends Comparable> int findKeyInRotatedArray(T[] array,T key){
        int index=-1;
        return index;
    } 
    
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
    
    public static <T extends Comparable> void quickSort(T[] array){
        if(array==null||array.length<2)
            return;
        quickSort(array,0,array.length-1);
    }
    
    private static <T extends Comparable> void quickSort(T[] array,int start,int end){
        if(end<start){
            return;
        }
        int pivotIndex=findPivot(array,start,end);
        quickSort(array,start,pivotIndex-1);
        quickSort(array,pivotIndex+1,end);
    }
    
    public static <T extends Comparable> int findPivot(T[] array,int start,int end){
        T pivot=array[end];
        int minIndex=start-1;
        for(int i=start;i<end;i++){
            if(array[i].compareTo(pivot)<0){
                minIndex++;
                T temp=array[minIndex];
                array[minIndex]=array[i];
                array[i]=temp;
            }
        }
        T temp=array[minIndex+1];
        array[minIndex+1]=pivot;
        array[end]=temp;
        return minIndex+1;
    }
}
