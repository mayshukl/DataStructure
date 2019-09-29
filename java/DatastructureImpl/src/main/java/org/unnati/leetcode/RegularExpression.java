package org.unnati.leetcode;

// Not Working

import java.util.*;

public class RegularExpression {

        public boolean isMatch(String s, String p) {
            Machine machine=new Machine(p);
            return machine.processString(s);
        }


        class State{
            Map<Character,State> stateMap=new HashMap<>();
            boolean isStart;
            boolean isEnd;
            boolean addState(Character character,State state){
                if(stateMap.get(character)!=null){
                    return false;
                }
                stateMap.put(character,state);
                return  true;
            }
            public void setEnd() {
                isEnd = true;
            }
            public void setStart() {
                isStart = true;
            }
            State processCharacter(char ch){
                return stateMap.get(ch);
            }

        }

        class Machine{
            State startState;
            Machine(String regEx){
                if(regEx.length()==0){
                    return;
                }
                this.startState=new State();
                this.startState.setStart();
                State buildState=this.startState;
                Character previousCharacter=null;
                for(int i=0;i<regEx.length();i++){
                    switch (regEx.charAt(i)){
                        case '*':
                            if(previousCharacter=='.'){
                                addAnyCharacter(buildState,buildState);
                            }else{
                                buildState.addState(previousCharacter,buildState);
                            }
                            break;
                        default:
                            if(previousCharacter !=null&&previousCharacter!='*') {
                                State newState=new State();
                                if(previousCharacter=='.'){
                                    addAnyCharacter(buildState,newState);
                                }else {
                                    buildState.addState(previousCharacter, newState);
                                }
                                buildState=newState;
                            }
                    }
                    previousCharacter=regEx.charAt(i);
                }
                switch (previousCharacter){
                    case '*':
                        if(previousCharacter=='.'){
                            addAnyCharacter(buildState,buildState);
                        }else{
                            buildState.addState(previousCharacter,buildState);
                        }
                        break;
                    default:
                        if(previousCharacter !=null&&previousCharacter!='*') {
                            State newState=new State();
                            boolean isAdded=false;
                            if(previousCharacter=='.'){
                                isAdded=addAnyCharacter(buildState,newState);
                            }else {
                                isAdded=buildState.addState(previousCharacter, newState);
                            }
                            if(isAdded) {
                                buildState = newState;
                             } 
                            }
                }
                
                buildState.setEnd();
            }

            boolean addAnyCharacter(State startState,State endState){
               boolean alreadyAdded=false;
                for(int i=0;i<26;i++){
                    alreadyAdded=alreadyAdded||startState.addState((char)(i+97),endState);
                }
                return alreadyAdded;
            }

            boolean processString(String str){
                State state=this.startState;
                for(int i=0;i<str.length();i++){
                    if(state==null){
                        return false;
                    }
                    state=state.processCharacter(str.charAt(i));
                }
                if(state!=null&&state.isEnd){
                    return true;
                }
                return false;
            }
        }

    public static void main(String[] args) {
        RegularExpression regularExpression=new RegularExpression();
        System.out.println(regularExpression.isMatch("mississippi","mis*is*ip*."));
        System.out.println(regularExpression.isMatch("aaa","a*a"));
        System.out.println(regularExpression.isMatch("aaa","a*"));
    }
}

        
