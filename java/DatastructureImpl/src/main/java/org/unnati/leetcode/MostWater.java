package org.unnati.leetcode;

public class MostWater {
    public int maxArea(int[] height) {
        int highestY=height[0];
        int highestX=0;
        int volumeY=height[0];
        int volumeX=0;
        int currentVolume=Math.min(height[0],height[1]);
        if(height.length==2){
            return currentVolume;
        }
        for(int i=3;i<height.length;i++){
            int volume1=Math.min(volumeY,height[i])*(i-volumeX);
           // int volumne2=
        }
        return -1;
    }
}
