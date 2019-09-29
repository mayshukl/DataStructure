package org.unnati.companies.ola;

public class MinimumSwitchRequired {
    public static int theFinalProblem(String state) {
        // Write your code here
        if(state==null||state.length()==0){
            return 0;
        }
        int length=0;
        int allRightValue=0;
        for(int i=0;i<state.length();i++){
            if(state.charAt(i)-48!=allRightValue){
                length++;
                if(allRightValue==0){
                    allRightValue=1;
                }else {
                    allRightValue=0;
                }
            }
        }
        return length;
    }

    public static void main(String[] args) {
        theFinalProblem("0011");
    }
}
