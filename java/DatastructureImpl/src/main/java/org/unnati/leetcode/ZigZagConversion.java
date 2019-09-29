package org.unnati.leetcode;

//Input: s = "PAYPALISHIRING", numRows = 4
//        Output: "PINALSIGYAHRPI"
//        Explanation:
//
//        P     I    N
//        A   L S  I G
//        Y A   H R
//        P     I

public class ZigZagConversion {

    public String convert(String s, int numRows) {
        if(numRows==0){
            return "";
        }
        if(numRows==1) {
            return s;
        }
        StringBuilder[] rowString=new StringBuilder[numRows];
        for(int i=0;i<rowString.length;i++){
            rowString[i]=new StringBuilder();
        }
        int flip=-1;
        int rowNumber=0;
        for(int i=0;i<s.length();i++){
            if(rowNumber==0 ||rowNumber==numRows-1){
                flip=flip*-1;
            }
            rowString[rowNumber].append(s.charAt(i));
            rowNumber=rowNumber+flip;
        }
        StringBuilder result=new StringBuilder();
        for(StringBuilder sb:rowString){
            result.append(sb);
        }
        return result.toString();
    }
}
