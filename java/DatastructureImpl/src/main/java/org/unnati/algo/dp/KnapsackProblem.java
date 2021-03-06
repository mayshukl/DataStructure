package org.unnati.algo.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KnapsackProblem {
    
    
    static class ItemWeightComparator implements Comparator<Item>{

        @Override
        public int compare(Item item1, Item item2) {
            return item1.wight.compareTo(item2.wight);
        }
    }

    static class ItemInsertionOrderComparator implements Comparator<Item>{

        @Override
        public int compare(Item item1, Item item2) {
            return item1.insertionOrder.compareTo(item2.insertionOrder);
        }
    }
    
     static class Item{
        private Integer insertionOrder;
        private Integer wight;
        private Integer value;
        private String id;
        private boolean included;
        public Item( String id,int wight, int value) {
            this.wight = wight;
            this.value = value;
            this.id = id;
        }
        public Item( int insertionOrder,String id,int wight, int value) {
            this.insertionOrder=insertionOrder;
            this.wight = wight;
            this.value = value;
            this.id = id;
        }
    }
    
    private static class ItemFactory{
        
        private static List<Item> createItemList(List<List<Integer>> itemList){
            List<Item> list=new ArrayList<>();
            int insertionOrder=0;
            for(List<Integer> item:itemList){
                Item itemObj=new Item(insertionOrder,item.get(0).toString(),item.get(1),item.get(2));
                list.add(itemObj);
                insertionOrder++;
            }
            return list;
        }
        private static Item[] createItemArray(List<List<Integer>> itemList){
            Item[] list=new Item[itemList.size()];
            int insertionOrder=0;
            for(List<Integer> item:itemList){
                Item itemObj=new Item(insertionOrder,item.get(0).toString(),item.get(1),item.get(2));
                list[insertionOrder]=itemObj;
                insertionOrder++;
            }
            return list;
        }
        
        private static List<List<Integer>>  createListFromItemArray(Item[] items){
            List<List<Integer>> lists=new ArrayList<>();
            for (Item item:items){
                List<Integer> itemEntry=new ArrayList<>();
                itemEntry.add(Integer.parseInt(item.id));
                itemEntry.add(item.wight);
                itemEntry.add(item.value);
                lists.add(itemEntry);
            }
            return lists;
        }
    }
    
 
    
    /**
     * List will be consist of 
     * 
     * 
     * */
    public static Item[] getItems(int maxCargoWeight, Item[] itemList){
        Arrays.sort(itemList,new ItemWeightComparator());
        Integer[][] data= createKnapsackData(maxCargoWeight,itemList);
        findItems(maxCargoWeight,itemList,data);
        return findSelectedItems(itemList);
    }

    private static Integer[][] createKnapsackData(int maxWeight,  Item[]  itemList){
        Integer[][] data=new Integer[maxWeight+1][itemList.length+1];
        for(int i=0;i<data.length;i++){
            for(int j=0;j<maxWeight+1;j++){
                if(i!=0){
                    
                    /****
                     * If you want to include some item take max(value of knapsack without including new item  or value after removing same weight item + item's value) 
                     *
                     * (j-itemList[j-1].wight) condition is added to handle undefined array index condition in else block
                     * **/
                    if((j-itemList[j-1].wight)<=0){
                        data[i][j]=data[i-1][j] > itemList[j-1].value ? data[i][j]=data[i-1][j] :itemList[j-1].value;
                    }else{
                        data[i][j]=data[i-1][j] > data[i-1][j-itemList[j-1].wight]+itemList[j-1].value ? data[i][j]=data[i-1][j] :data[i-1][j-itemList[j-1].wight]+itemList[j-1].value;
                    }
                }else{
                    data[i][j]=0;
                }
            }
        }
        return data;
    }
    
    private static void findItems(int maxCargoWeight,Item[] itemList,Integer[][] data){

        int maxValue=data[itemList.length][maxCargoWeight];
        for(int i=itemList.length;i>0;i--) {
            for (int j = maxCargoWeight; j >0; j--) {
                if(data[i][j]<maxValue){
                    if(data[i-1][j]!=data[i-1][j]){
                        itemList[i].included=true;
                        maxValue=data[i-1][j];
                    }
                    i=i-1;
                }
            }
        }
    }
    
    private static Item[] findSelectedItems(Item[] items){
        List<Item> itemArrayList=new ArrayList<>();
        for(Item item:items){
            if(item.included) itemArrayList.add(item);
        }
        Item[] itemsArray=new Item[itemArrayList.size()];
        itemArrayList.toArray(itemsArray);
        Arrays.sort(itemsArray,new ItemInsertionOrderComparator());
        return itemsArray;
        
    }
    
    public static List<List<Integer>>  findItems(int maxCargoWeight, List<List<Integer>> cargoList){
        Item[] items=ItemFactory.createItemArray(cargoList);
        return  ItemFactory.createListFromItemArray(items);
    }
    
}
