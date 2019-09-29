package org.unnati.companies.cisco;

import java.util.*;

public class ArraySumCount {

    public static long playlist(List<Integer> songs) {
        // Write your code here
        int length=0;
        int[] counter=new int[60];
        for(int i=0;i<songs.size();i++){
            counter[songs.get(i)%60]=counter[songs.get(i)%60]+1;
        }
        
        if(counter[0]>0){
            length=length+counter[0]*(counter[0]-1)/2;
        }
        if(counter[30]>0){
            length=length+counter[30]*(counter[30]-1)/2;
        }
        
        for(int i=1;i<30;i++){
            length=length+(counter[i]*counter[60-i]);
        }

        return length;
    }

    public static long playlist2(List<Integer> songs) {
        // Write your code here
        int length=0;
        for(int i=0;i<songs.size();i++){
            songs.set(i,songs.get(i)%60);
        }
        
        Collections.sort(songs);
        
        int i=0,j=songs.size()-1;
        
        while(i<j){
            int totalLength=songs.get(i)+songs.get(j);
            if(totalLength%60==0){
                length++;
                if(songs.get(i+1)==songs.get(i)){
                    length++;
                    i=i+2;
                }
                if(songs.get(j)==songs.get(j-1)){
                    length++;
                    j=j-2;
                }
            }else{
                if(totalLength<60){
                    i++;
                }else{
                    j--;
                }
            }
        }
        
        return length;
    }
    
    public static long playlistOn2(List<Integer> songs) {
        // Write your code here
        Set<String> memory=new HashSet<>();
        int length=0;
        for(int i=0;i<songs.size();i++){
            for(int j=i;j<songs.size();j++){
                if(i!=j&&!memory.contains(i+"|"+j)){
                    if((songs.get(i)+songs.get(j))%60==0){
                        length++;
                        memory.add(i+"|"+j);
                    }
                } 
            }
        }
        return length;
    }
    
    
    public static long playlistDynamic(List<Integer> songs) {
        // Write your code here
        Map<String,Integer> memory=new HashMap<>();
        return countSongPair(songs,0,songs.size()-1,memory);
    }
    
    public static int countSongPair(List<Integer> songs, int start, int end, Map<String,Integer> memory ){
        if(start>=end){
            return 0;
        }
        
        if(memory.get(start+"|"+end)!=null){
            return 0;
        }
        int length=0;
        if((songs.get(start)+songs.get(end))%60==0){
            length=length+countSongPair(songs,start+1,end-1,memory)+1;
        }
        length=length+countSongPair(songs,start,end-1,memory);
        length=length+countSongPair(songs,start+1,end,memory);
        memory.put(start+"|"+end,length);
        return length;
    }

    public static void main(String[] args) {
        List<Integer> songs=new ArrayList<>();
        songs.add(30);
        songs.add(20);
        songs.add(150);
        songs.add(100);
        songs.add(40);
        System.out.println(playlist(songs));
    }
}
