package org.unnati.companies.ola;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HackerCards {
    static List<Integer> hackerCards(List<Integer> collection, int d) {
       List<Integer> cards=new ArrayList<>();
       if(d==0){
           return cards;
       }
       if(collection==null){
           collection=new ArrayList<>();
       }
        Collections.sort(collection);
       int collectionIndex=0;
       int costSum=0;
       for(int i=1;i<=d;i++){
           if(collectionIndex>=collection.size()||collection.get(collectionIndex)!=i){
               if(costSum+i<=d){
                   cards.add(i);
                   costSum=costSum+i;
               }else{
                   break;
               }
           }else{
               collectionIndex++;
               while (collectionIndex>0&&collectionIndex<collection.size()&&collection.get(collectionIndex)==collection.get(collectionIndex-1)){
                   collectionIndex++;
               }
           }
       }
        return cards;
    }

    public static void main(String[] args) {
        List<Integer> cards=new ArrayList<>();
        cards.add(1);
        cards.add(2);
        cards.add(3);
        cards.add(4);
        hackerCards(cards,5);
    }
}
