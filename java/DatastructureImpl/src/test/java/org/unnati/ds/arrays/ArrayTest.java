package org.unnati.ds.arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayTest {
    Integer[] unsortedArray=new Integer[7];
    Integer[] sortedIntArray=new Integer[6];
    Integer[] arrayIntArray=new Integer[5];
    
    @Before
    public void before(){
        unsortedArray=new Integer[]{38, 27, 43, 3, 9, 82, 10};
        sortedIntArray=new Integer[]{1,2,3,4,5,6};
        arrayIntArray=new Integer[]{54, 546, 548, 60};
    }
    
    @Test
    public void testReverse(){
        Integer[] reverseSortedIntArray={6,5,4,3,2,1};
        Arrays.reverse(sortedIntArray);
        Assert.assertEquals(reverseSortedIntArray,sortedIntArray);
    }

    @Test
    public void testRotateLeft(){
        Integer[] result={3,4,5,6,1,2};
        Arrays.rotateArrayLeft(sortedIntArray,2);
        Assert.assertEquals(result,sortedIntArray);
    }

    @Test
    public void testRotateRight(){
        Integer[] result={5,6,1,2,3,4};
        Arrays.rotateArrayRight(sortedIntArray,2);
        Assert.assertEquals(result,sortedIntArray);
    }

    @Test
    public void testMaxNumberByRotatingAndConcatenatingArray(){
        Long number=6054546548L;
        Long result=Arrays.maxNumberByRotatingAndConcatenatingArray(arrayIntArray);
        Assert.assertEquals(number,result);
    }

    @Test
    public void testMergeSort(){
        Integer[] result={3,9,10,27,38, 43,  82};
        Arrays.mergeSort(unsortedArray);
        Assert.assertEquals(result,unsortedArray);
    }

    @Test
    public void testQuickSort(){
        Integer[] result={3,9,10,27,38, 43,  82};
        Arrays.quickSort(unsortedArray);
        Assert.assertEquals(result,unsortedArray);
    }

}
