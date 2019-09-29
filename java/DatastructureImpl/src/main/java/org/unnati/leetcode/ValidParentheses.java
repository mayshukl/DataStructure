package org.unnati.leetcode;

import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            switch (s.charAt(i)){
                case '(':
                case '{':
                case '[':
                    stack.push(s.charAt(i));
                    break;
                case ')':
                    if(stack.empty()){
                        return false;
                    }
                    char ch=stack.pop();
                    if(ch !='('){
                        return false;
                    }
                    break;
                case '}':
                    if(stack.empty()){
                        return false;
                    }
                     ch=stack.pop();
                    if(ch !='{'){
                        return false;
                    }
                    break;

                case ']':
                    if(stack.empty()){
                        return false;
                    }
                     ch=stack.pop();
                    if(ch !='['){
                        return false;
                    }
                    break;    
            }
        }
        return stack.empty();
    }
}
