package org.unnati.ds.arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;

public class MergeSortTest {

    Integer[] unsortedArray=new Integer[7];

    @Before
    public void before(){
        unsortedArray=new Integer[]{38, 27, 43, 3, 9, 82, 10};
    }
    

    @Test
    public void testMergeSort(){
        Integer[] result={3,9,10,27,38, 43,  82};
        MergeSort.mergeSort(unsortedArray);
        Assert.assertEquals(result,unsortedArray);
    }

    @Test
    public void testMergeSort3Way(){
        Integer[] result={3,9,10,27,38, 43,  82};
        MergeSort.threeWayMergeSort(unsortedArray);
        Assert.assertEquals(result,unsortedArray);
    }


}
