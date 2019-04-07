package org.unnati.ds.arrays;

public class QuickSort {

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

    public static <T extends Comparable> void quickSortWith2Pointer(T[] array){
        if(array==null||array.length<2)
            return;
        quickSortWith2Pointer(array,0,array.length-1);
    }

    private static <T extends Comparable> void quickSortWith2Pointer(T[] array,int start,int end){
        if(end<start){
            return;
        }
        int pivotIndex=findPivotWith2Pointer(array,start,end);
        quickSortWith2Pointer(array,start,pivotIndex);
        quickSortWith2Pointer(array,pivotIndex,end);
    }

    public static <T extends Comparable> int findPivotWith2Pointer(T[] array,int start,int end){
        T pivot=array[end];
        int leftIndex=start-1;
        int rightIndex=end+1;
        while(true){
           do{
               leftIndex++;
           }while (array[leftIndex].compareTo(pivot)<0);
            do{ 
                rightIndex--;
            }while(array[rightIndex].compareTo(pivot)>0);
                
           if(rightIndex<=leftIndex){
               return rightIndex;
           }
            T temp=array[leftIndex];
            array[leftIndex]=array[rightIndex];
            array[rightIndex]=temp;
        }
    }

    
    private static <T extends Comparable> void swap(T[] array, int start,int end){
        T temp=array[start];
        array[start]=array[end];
        array[end]=temp;
    }

    
    private static class MiddlePoints{
        private  int mid1;
        private  int mid2;
    }
   
    private static <T extends Comparable>  void threeWayPartition(T[] array,int start,int end,MiddlePoints middlePoints){
        if(end-start<=0){
            return ;
        }
        if(end-start==1){
            if(array[start].compareTo(array[end])>0)
                swap(array,start,end);
            middlePoints.mid1=start-1;
            middlePoints.mid2=end+1;
            return;
        }
        T pivot=array[end];
        int low=start;
        int high=end;
        int mid=low;
        while (mid<=high){
                if(pivot.compareTo(array[mid])>0){
                    swap(array,mid++,low++);
                }else if(pivot.compareTo(array[mid])==0){
                    mid++;
                }else{
                    swap(array,mid,high);
                    high--;
                    
                }
            
        }
        middlePoints.mid1=low-1;
        middlePoints.mid2=mid;
    }

    private static <T extends Comparable>  void threeWayQuickSort(T[] array,int start,int end){
       if(end-start<=0)
           return;
        MiddlePoints middlePoints=new MiddlePoints();
        threeWayPartition(array,start,end,middlePoints);
        threeWayQuickSort(array,start,middlePoints.mid1);
        threeWayQuickSort(array,middlePoints.mid2,end);
    }

    public static <T extends Comparable>  void threeWayQuickSort(T[] array){
        if(array==null||array.length==0){
            return;
        }
        threeWayQuickSort(array,0,array.length-1);
    }
}
