package org.unnati.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringNonRepeating {
    
    public int lengthOfLongestSubstring(String s) {

       
        
        int length=0;
        Map<Character,Integer> map=new HashMap<>();
        for (int j = 0, i = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            length = Math.max(length, j - i + 1);
            map.put(s.charAt(j), j+1);
        }
        return length;
    }

    public int lengthOfLongestSubstringArray(String s) {
        int length=0;
        Integer[] integers=new Integer[128];
        for (int j = 0, i = 0; j < s.length(); j++) {
            if (integers[s.charAt(j)]!=null) {
                i = Math.max(integers[s.charAt(j)], i);
            }
            length = Math.max(length, j - i + 1);
            integers[s.charAt(j)]=j + 1;
        }
        return length;
    }

    public static void main(String[] args) {
        //ul
        LongestSubstringNonRepeating longestSubstringNonRepeating=new LongestSubstringNonRepeating();
        System.out.println(longestSubstringNonRepeating.lengthOfLongestSubstring("vuqspzyiuljqeyllfnbbohswkckial"));
        //System.out.println(longestSubstringNonRepeating.lengthOfLongestSubstring("vuqspzyiuljqeyllfnbbohswkckialaxissxrqfoereippwwfxxtespowcwwnyuvqmukecyitetkwphbmgusyliunetdfnaxbxhhzhsumleicnlqufissqpiwindxnbakkhlszfgmmqozbgvioqagfkfpximnlmzwvlovsuhemygnebvvrxbykinhtzwenwajjqebmniylonqrinjiqhszxbsyyymwbxhrdigqsgeiuwaejlmzugyrisqiteeublnevvwqcaywwaafnpfivfbfarntvtpygeccazuczuyyvadipksnsusulgpjzehgimkkngmmammxpqgecarwumqisfttjcbuongbttquhcrwuzdzawvwimecrzwdczzqnfuiakciowgjxjizgfworcrlcpogopwdwsmxcqhropcmzmnhrjvloowsfmyudwzzpnytehmuxqiycwfwhcjvthpytnuwmuxbjywnfjkezsceojayolvhslhlacjmyiphgmxoxhswzxaqicownlfhwnuxpflpodwwptkocfkecnwkrmjhxooubjtqqgfejedaznocsbiwqehhqqqpghjiqeailipwmsxnhnraqzygfhovzglgnwofdoooydmkvlaczreprfywmoumuhuifiniydyxgljdwjixboputnqgdmuxtohbyxjyaivjvhmtqurtlinexgmasixoyfpwcaveisndzaxqwqjjazoxfcxxnwnldckhdfmnzbtzdsrckclkbbjgeggteteiyordvfsvhlwkdnmppyztzizfqfyvzffzvycreuolikvnzkdqicjjnjrforapwhqsislmpzzxlukkgnaoskahvtmjkpbjyrdgmosbpraaommuamluynbtgpfqegzdzcjnseqhxqjndvifkvbiiecqthgypidqmoehuwosnafsvpzfmaowesmxbvxqdcirroyllpdyplsmcrsprinxaawdvwtaydrps"));
    }
}
