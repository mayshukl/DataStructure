package org.unnati.ds.arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QuickSortTest {

    Integer[] unsortedArray=new Integer[7];

    @Before
    public void before(){
        unsortedArray=new Integer[]{38, 27, 43, 3, 9, 82, 10};
    }

    @Test
    public void testQuickSort(){
        Integer[] result={3,9,10,27,38, 43,  82};
        QuickSort.quickSort(unsortedArray);
        Assert.assertEquals(result,unsortedArray);
    }

    @Test
    public void testQuickSortWith2Pointer(){
        Integer[] result={3,9,10,27,38, 43,  82};
        QuickSort.quickSortWith2Pointer(unsortedArray);
        Assert.assertEquals(result,unsortedArray);
    }

    @Test
    public void testThreeWayQuickSort(){
        Integer[] result={3,9,10,27,38, 43,  82};
        QuickSort.threeWayQuickSort(unsortedArray);
        Assert.assertEquals(result,unsortedArray);
    }
}
