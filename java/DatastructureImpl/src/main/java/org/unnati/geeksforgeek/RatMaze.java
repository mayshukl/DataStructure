package org.unnati.geeksforgeek;

public class RatMaze {
    // Size of the maze 
    static int N;

    /* A utility function to print solution matrix  
    sol[N][N] */
    void printSolution(int sol[][])
    {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + sol[i][j] + " ");
            System.out.println();
        }
    }
    
    boolean isSafe(int[][] maze,int[][] solution,int i,int j){
        return i>=0 && i<=N-1 && j>=0 && j<N-1 && maze[i][j]==1 && solution[i][j]==0;
    }

    boolean solveMaze(int[][] maze,int[][] solution,int i,int j){
        if(i==N-1 && j==N-1){
            solution[i][j]=1;
            return true;
        }

        if(!isSafe(maze,solution,i,j)){
            return false;
        }
        
        solution[i][j]=1;
        boolean goRight=solveMaze(maze,solution,i,j+1);
        boolean goDown=solveMaze(maze,solution,i+1,j);
        if(goDown||goRight){
            return true;
        }else {
            solution[i][j]=0;
            return false; 
        }
    }
    
    void solveMaze(int[][] maze){
        int[][] solution=new int[N][N];
        int i=0,j=0;
        solveMaze(maze,solution,i,j);
        printSolution(solution);
    }
    
    public static void main(String args[])
    {
        RatMaze rat = new RatMaze();
        int maze[][] = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 } };

        N = maze.length;
        rat.solveMaze(maze);
    }
}
