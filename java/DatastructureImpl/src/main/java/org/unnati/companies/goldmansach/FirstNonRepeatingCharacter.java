package org.unnati.companies.goldmansach;

public class FirstNonRepeatingCharacter {
    class CharacterCount{
        int index;
        int count;
        public CharacterCount(int index){
            this.index=index;
            count=1;
        }
        void increaseCount(){
            count++;
        }
    }
    
    public char findFirstNonRepeatCharacter(String str){
        CharacterCount charCount[]=new CharacterCount[26];
        int index=0;
        for(char ch:str.toCharArray()){
            if(charCount[((short)ch)-97]==null){
                charCount[((short)ch)-97]=new CharacterCount(index); 
            }else{
                charCount[((short)ch)-97].increaseCount();
            }
            index++;
        }

        CharacterCount firstNonRepeatCharacter=null;
        short character=-1;
        for(short i=0;i<charCount.length;i++){
            CharacterCount characterCount=charCount[i];
            if(characterCount!=null&&characterCount.count==1){
                  if(firstNonRepeatCharacter==null){
                      firstNonRepeatCharacter=characterCount;
                      character=i;
                  }
                  if(firstNonRepeatCharacter.index>characterCount.index){
                      firstNonRepeatCharacter=characterCount;
                      character=i;
                  }
            }
        }
        return (char) (character+(short)97);
    }
    
    public static void main(String args[]){
        FirstNonRepeatingCharacter firstNonRepeatingCharacter=new FirstNonRepeatingCharacter();
        System.out.println(firstNonRepeatingCharacter.findFirstNonRepeatCharacter("geeksforgeeks"));
    }
}
