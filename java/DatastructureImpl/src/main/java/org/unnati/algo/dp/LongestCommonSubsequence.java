package org.unnati.algo.dp;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubsequence {

    public int maxCommonSubSequence(String seq1, String seq2) {
        if (StringUtils.isEmpty(seq1) || StringUtils.isEmpty(seq2)) {
            return 0;
        }
        int maxLength = 0;
        if (seq1.charAt(seq1.length() - 1) == seq2.charAt(seq2.length() - 1)) {
            maxLength = maxCommonSubSequence(seq1.substring(0, seq1.length() - 1), seq2.substring(0, seq2.length() - 1)) + 1;
        } else {
            maxLength = Math.max(maxCommonSubSequence(seq1.substring(0, seq1.length() - 1), seq2.substring(0, seq2.length())), maxCommonSubSequence(seq1.substring(0, seq1.length()), seq2.substring(0, seq2.length() - 1)));
        }
        return maxLength;
    }


    private Map<String, Integer> memory = new HashMap<>();

    public int maxCommonSubSequenceWithDP(String seq1, String seq2) {
        if (StringUtils.isEmpty(seq1) || StringUtils.isEmpty(seq2)) {
            return 0;
        }
        String key = seq1 + "|" + seq2;
        if (memory.get(key) != null) {
            return memory.get(key);
        }
        int maxLength = 0;
        if (seq1.charAt(seq1.length() - 1) == seq2.charAt(seq2.length() - 1)) {
            maxLength = maxCommonSubSequenceWithDP(seq1.substring(0, seq1.length() - 1), seq2.substring(0, seq2.length() - 1)) + 1;
        } else {
            maxLength = Math.max(maxCommonSubSequenceWithDP(seq1.substring(0, seq1.length() - 1), seq2.substring(0, seq2.length())), maxCommonSubSequenceWithDP(seq1.substring(0, seq1.length()), seq2.substring(0, seq2.length() - 1)));
        }
        memory.put(key, maxLength);
        return maxLength;
    }

    private Map<String, String> memoryString = new HashMap<>();

    public String maxCommonSubSequenceStringWithDP(String seq1, String seq2) {
        if (StringUtils.isEmpty(seq1) || StringUtils.isEmpty(seq2)) {
            return "";
        }
        String key = seq1 + "|" + seq2;
        if (memoryString.get(key) != null) {
            return memoryString.get(key);
        }
        String maxSeq = "";
        if (seq1.charAt(seq1.length() - 1) == seq2.charAt(seq2.length() - 1)) {
            maxSeq = maxCommonSubSequenceStringWithDP(seq1.substring(0, seq1.length() - 1), seq2.substring(0, seq2.length() - 1)) + seq1.charAt(seq1.length() - 1);
        } else {
            String result1 = maxCommonSubSequenceStringWithDP(seq1.substring(0, seq1.length() - 1), seq2.substring(0, seq2.length()));
            String result2 = maxCommonSubSequenceStringWithDP(seq1.substring(0, seq1.length()), seq2.substring(0, seq2.length() - 1));
            maxSeq = result1.length() > result2.length() ? result1 : result2;
        }
        memoryString.put(key, maxSeq);
        return maxSeq;
    }


    /***
     * Create a Matrix that will have number of common character before current index 
     * */
    int[][] prefixMatrix;
    private void prepareMatrix(String seq1, String seq2) {
        prefixMatrix = new int[seq1.length() + 1][seq2.length() + 1];
        for (int i = 0; i < seq1.length() + 1; i++) {
            prefixMatrix[i][0] = 0;
        }
        for (int i = 0; i < seq2.length() + 1; i++) {
            prefixMatrix[0][i] = 0;
        }
        for (int i = 1; i < seq1.length() + 1; i++) {
            for (int j = 1; j < seq2.length() + 1; j++) {
                if (seq1.charAt(i - 1) == seq2.charAt(j - 1)) {
                    prefixMatrix[i][j] = prefixMatrix[i - 1][j - 1] + 1;
                } else {
                    prefixMatrix[i][j] = Math.max(prefixMatrix[i - 1][j], prefixMatrix[i][j - 1]);
                }
            }
        }

    }

    public int getLCSLength(String seq1, String seq2) {
        prepareMatrix(seq1, seq2);
        return prefixMatrix[seq1.length()][seq2.length()];
    }

    private String findOneLCS(String seq1, String seq2) {
        if (StringUtils.isEmpty(seq1) || StringUtils.isEmpty(seq2)) {
            return "";
        }
        String result = "";
        int i = seq1.length();
        int j = seq2.length();
        if (seq1.charAt(i - 1) == seq2.charAt(j - 1)) {
            result = findLCS(seq1.substring(0, seq1.length() - 1), seq2.substring(0, seq2.length() - 1)) + seq1.charAt(i - 1);
        } else {
            if (prefixMatrix[i - 1][j] > prefixMatrix[i][j - 1]) {
                result = findLCS(seq1, seq2.substring(0, seq2.length() - 1));
                
            } else {
                result = findLCS(seq1.substring(0, seq1.length() - 1), seq2);
            }

        }
        return result;
    }
    public String findLCS(String seq1, String seq2) {
        prepareMatrix(seq1, seq2);
        return findOneLCS(seq1, seq2);
    }


}
