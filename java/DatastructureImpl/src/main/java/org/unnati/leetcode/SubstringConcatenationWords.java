package org.unnati.leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class SubstringConcatenationWords {

    public static List<Integer> findSubstringWorking(String S, String[] L) {
        List<Integer> res = new ArrayList<Integer>();
        if (S == null || L == null || L.length == 0) return res;
        int len = L[0].length(); // length of each word

        Map<String, Integer> map = new HashMap<String, Integer>(); // map for L
        for (String w : L) map.put(w, map.containsKey(w) ? map.get(w) + 1 : 1);

        for (int i = 0; i <= S.length() - len * L.length; i++) {
            Map<String, Integer> copy = new HashMap<String, Integer>(map);
            for (int j = 0; j < L.length; j++) { // checkc if match
                String str = S.substring(i + j*len, i + j*len + len); // next word
                if (copy.containsKey(str)) { // is in remaining words
                    int count = copy.get(str);
                    if (count == 1) copy.remove(str);
                    else copy.put(str, count - 1);
                    if (copy.isEmpty()) { // matches
                        res.add(i);
                        break;
                    }
                } else break; // not in L
            }
        }
        return res;
    }
    
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list=new ArrayList<>();
        if(words==null||words.length==0){
            return list;
        }
        Map<Integer,Integer> wordsIndex=new HashMap<>();
        List<Integer> sortedIndex=new ArrayList<>();
        Map<String,Integer> wordCount=new HashMap<>();
        for(int i=0;i<words.length;i++){
            Integer count=wordCount.get(words[i]);
            if(count!=null){
                wordCount.put(words[i],count+1);
                continue;
            }else {
                wordCount.put(words[i],1);
            }
            int index=-1;
            do{
                index=s.indexOf(words[i],index+1);
                if(index!=-1){
                    wordsIndex.put(index,i);
                    sortedIndex.add(index);
                }
            }while((index!=-1));
                  
        }
        Collections.sort(sortedIndex);
        int wordSize=words[0].length();
        Map<String,Integer> visitedWords=new HashMap<>();
        for(int i=0;i<sortedIndex.size()-words.length+1;i++){
            visitedWords.clear();
            int expectedIndex=-1;
            for(int j=i;j<i+words.length;j++){
                int stringIndex=sortedIndex.get(j);
                int arrayIndex=wordsIndex.get(sortedIndex.get(j));
                String word=words[arrayIndex];
                if(expectedIndex==-1||expectedIndex==stringIndex){
                    Integer count=visitedWords.get(word);
                    if(count==null){
                        visitedWords.put(word,1); 
                    }else {
                        visitedWords.put(word,count+1);
                    }
                    expectedIndex=expectedIndex+wordSize;
                    if(visitedWords.equals(wordCount)){
                        list.add(expectedIndex-words.length*wordSize);
                    }
                }
            }
        }
     return list;
    }
    
    

    public static void main(String[] args) {
        
                
        SubstringConcatenationWords concatenationWords=new SubstringConcatenationWords();
        concatenationWords.findSubstring("aaaaaa" , new String[]{"aaa","aaa"});
    }
    
}
