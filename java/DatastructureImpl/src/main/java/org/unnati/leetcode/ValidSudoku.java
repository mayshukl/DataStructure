package org.unnati.leetcode;

import java.util.*;

public class ValidSudoku {
    Map<Integer,Set<Integer>> columns=new HashMap<>();
    Map<Integer,Set<Integer>> rows=new HashMap<>();
    Set<Integer> grid=new HashSet<>();
    
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                grid.clear();
                for (int c=0;c<3;c++){
                    for (int r=0;r<3;r++){
                        if(board[i*3+r][j*3+c]=='.'){
                            continue;
                        }
                        int value=board[i*3+r][j*3+c]-48;
                        if(grid.contains(value)  || ( rows.get(i*3+r)!=null&&rows.get(i*3+r).contains(value) )||
                                ( columns.get(j*3+c)!=null&&columns.get(j*3+c).contains(value) )){
                            return false;
                        }
                        grid.add(value);
                        if(rows.get(i*3+r)==null){
                            rows.put(i*3+r,new HashSet<>());  
                        }
                        rows.get(i*3+r).add(value);
                        if(columns.get(j*3+c) == null){
                            columns.put(j*3+c,new HashSet<>());
                        }
                        columns.get(j*3+c).add(value);
                    }    
                }
            }
        }
        return true;
    }

    public boolean isValidSudokuFast(char[][] board) {
        int [] vset = new int [9];
        int [] hset = new int [9];
        int [] bckt = new int [9];
        int idx = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    idx = 1 << (board[i][j] - '0') ;
                    if ((hset[i] & idx) > 0 ||
                            (vset[j] & idx) > 0 ||
                            (bckt[(i / 3) * 3 + j / 3] & idx) > 0) return false;
                    hset[i] |= idx;
                    vset[j] |= idx;
                    bckt[(i / 3) * 3 + j / 3] |= idx;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] sudoku={{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        ValidSudoku validSudoku=new ValidSudoku();
        validSudoku.isValidSudokuFast(sudoku);
    }
    
}
