package org.unnati.algo.dp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class KnapsackProblemTest {
    List<List<Integer>> cargoList =new ArrayList<>();
    int knapsackWeight= 8;
    
    @Before
    public void before(){
        
        List<Integer> cargo=new ArrayList<>();
        cargo.add(23);
        cargo.add(1);
        cargo.add(2);
        cargoList.add(cargo);

        cargo=new ArrayList<>();
        cargo.add(24);
        cargo.add(5);
        cargo.add(4);
        cargoList.add(cargo);

        cargo=new ArrayList<>();
        cargo.add(25);
        cargo.add(2);
        cargo.add(3);
        cargoList.add(cargo);

        cargo=new ArrayList<>();
        cargo.add(26);
        cargo.add(6);
        cargo.add(5);
        cargoList.add(cargo);
        
    }
    
    @Test
    public void testFindItems(){
        List<List<Integer>> expected=cargoList =new ArrayList<>();
        List<Integer> cargo=new ArrayList<>();
        cargo=new ArrayList<>();
        cargo.add(24);
        cargo.add(5);
        cargo.add(4);
        cargoList.add(cargo);

        cargo=new ArrayList<>();
        cargo.add(25);
        cargo.add(2);
        cargo.add(3);
        cargoList.add(cargo);

        List<List<Integer>> result=KnapsackProblem.findItems(knapsackWeight,cargoList);
        Assert.assertEquals(expected,result);
    }
}
