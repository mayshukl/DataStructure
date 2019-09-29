package org.unnati.string;

public class ExcelColumnTitle {
    
    private String convertToExlColumnName(int columnNumber){
        StringBuilder columnName=new StringBuilder();
        while(columnNumber>0){
            int remainder=columnNumber%(26);
            remainder=remainder==0?26:remainder;
            columnNumber=columnNumber-remainder;
            columnNumber=columnNumber/(26);
            columnName.append(Character.toChars(remainder+64));
        }
        return columnName.reverse().toString();
    }
    
    
    public static void main(String args[]){
        ExcelColumnTitle excelColumnTitle=new ExcelColumnTitle();
        System.out.println(excelColumnTitle.convertToExlColumnName(703));
    }
}
