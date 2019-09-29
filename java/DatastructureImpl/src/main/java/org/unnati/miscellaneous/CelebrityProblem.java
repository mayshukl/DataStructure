package org.unnati.miscellaneous;

import java.util.Stack;

public class CelebrityProblem {

    int findCelebrityIndex(int matrix[][], int n)
    {
        if(n==0){
            return -1;
        }

        if(n==1){
            return 1;
        }
        // Start index
        int i=0;
        //End Index
        int j=n-1;

        while(i<j){
            if(matrix[i][j]==1){
                i++;
            }else if(matrix[j][i]==1){
                j--;
            }else{
                i++;
                j--;
            }
        }


        // check if everyOne know j or j know anyone
        for(int k=0;k<n;k++){
            if(k!=j){
                if(matrix[j][k]==1 || matrix[k][j]!=1){
                    return -1;
                }
            }
        }
        return j;
    }

    int findCelebrityIndexUsingStack(int matrix[][], int n)
    {
        if(n==0){
            return -1;
        }

        if(n==1){
            return 1;
        }

        Stack<Integer> stack=new Stack<Integer>();
        for(int i=0;i<n;i++){
            stack.push(i);
        }

        while(stack.size()>1){
            int person1=stack.pop();
            int person2=stack.pop();
            if(matrix[person1][person2]!=1){
                stack.push(person1);
            }else if(matrix[person2][person1]!=1){
                stack.push(person2);
            }
        }

        if(stack.size()==0){
            return -1;
        }

        int celebrity=stack.pop();

        for(int k=0;k<n;k++){
            if(k!=celebrity){
                if(matrix[k][celebrity]!=1||matrix[celebrity][k]==1){
                    return -1;
                }
            }
        }
        return celebrity;
    }
}
