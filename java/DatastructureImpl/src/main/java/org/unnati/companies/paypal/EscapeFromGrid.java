package org.unnati.companies.paypal;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EscapeFromGrid {

    public static void main(String[] args) {
        int [][] array={
                {1, 1, 1,1,1,1, 1, 1,1,1,1, 1, 1,1,1,1, 1, 1,1,1,1, 1, 1,1,1,1, 1, 1,1,1,1, 1, 1,1,1,1, 1, 1,1,1,1, 1, 1,1,1,1, 1, 1,1,1},
                {1,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {1,1,1,1,1},
                {1,0,1,1,0},
        };

        System.out.println(solveIt(4,50,array));
    }
    
    enum DIRECTION{
        UP,
        DOWN,
        LEFT,
        RIGHT
    }
    
    static Map<String,Integer> memory=new HashMap<>();
    public static int solveIt(int n, int m, int[][] grid) {
      // look for current Position
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    findPaths(grid,i,j,n,m);
                    return memory.get(i+"|"+j) ==null || (memory.get(i+"|"+j) == Integer.MAX_VALUE) ?-1: memory.get(i+"|"+j);
                }
            }
        }
        return -1;
    }

    static int findPaths(int[][] grid, int n, int m,int ROW,int COLUMN){
        if(n==0||m==0 || n==ROW-1 || m ==COLUMN-1 ){
            memory.put(n+"|"+m,0);
            return 0;
        }
        if(memory.get(n+"|"+m)!=null){
            return memory.get(n+"|"+m);
        }
        memory.put(n+"|"+m,Integer.MAX_VALUE);
        int up,left,right,bottom;
        up=left=right=bottom=Integer.MAX_VALUE;
        // go right
        if(grid[n][m+1]==0 && memory.get((n)+"|"+(m+1))==null){
            right = findPaths(grid,n,m+1,ROW,COLUMN);
            right=right==Integer.MAX_VALUE ? Integer.MAX_VALUE :right+1;
        }
        // go left
        if(grid[n][m-1]==0 && memory.get((n)+"|"+(m-1))==null){
           left = findPaths(grid,n,m-1,ROW,COLUMN);
            left=left==Integer.MAX_VALUE ? Integer.MAX_VALUE :left+1; 
        }
        // go bottom
        if(grid[n+1][m]==0 && memory.get((n+1)+"|"+(m))==null){
            bottom = findPaths(grid,n+1,m,ROW,COLUMN);
            bottom=bottom==Integer.MAX_VALUE ? Integer.MAX_VALUE :bottom+1;
        }
        // go up
        if(grid[n-1][m]==0&& memory.get((n-1)+"|"+(m))==null){
            up = findPaths(grid,n-1,m,ROW,COLUMN);
            up=up==Integer.MAX_VALUE ? Integer.MAX_VALUE :up+1;
        }
       

        int result=  Math.min(Math.min(up,bottom),Math.min(left,right));
        memory.put(n+"|"+m,result);
        return result;
    }
    
    
}
