package org.unnati.algo.dp;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LongestCommonSubsequenceTest {

    private LongestCommonSubsequence longestCommonSubsequence;
    
    @Before
    public void beforeEach(){
        this.longestCommonSubsequence=new LongestCommonSubsequence();
    }
    
    @Test
    public void findLength(){
        String seq1="abc";
        String seq2="def";
        
        int maxCount=this.longestCommonSubsequence.maxCommonSubSequence(seq1,seq2);
        Assert.assertEquals(maxCount,0);
        
    }

    @Test
    public void findLengthWithEnd(){
        String seq1="abcd";
        String seq2="def";

        int maxCount=this.longestCommonSubsequence.maxCommonSubSequence(seq1,seq2);
        Assert.assertEquals(maxCount,1);

    }

    @Test
    public void findLengthWithEndMiddle(){
        String seq1="abcd";
        String seq2="kdef";

        int maxCount=this.longestCommonSubsequence.maxCommonSubSequence(seq1,seq2);
        Assert.assertEquals(maxCount,1);

    }
    @Test
    public void findLengthWithRandomMatch(){
        String seq1="ABCBDAB";
        String seq2="BDCABA";

        int maxCount=this.longestCommonSubsequence.maxCommonSubSequence(seq1,seq2);
        Assert.assertEquals(maxCount,4);

    }


    @Test
    public void findLengthWithDP(){
        String seq1="abc";
        String seq2="def";

        int maxCount=this.longestCommonSubsequence.maxCommonSubSequenceWithDP(seq1,seq2);
        Assert.assertEquals(maxCount,0);

    }

    @Test
    public void findLengthWithEndWithDP(){
        String seq1="abcd";
        String seq2="def";

        int maxCount=this.longestCommonSubsequence.maxCommonSubSequenceWithDP(seq1,seq2);
        Assert.assertEquals(maxCount,1);

    }

    @Test
    public void findLengthWithEndMiddleWithDP(){
        String seq1="abcd";
        String seq2="kdef";

        int maxCount=this.longestCommonSubsequence.maxCommonSubSequenceWithDP(seq1,seq2);
        Assert.assertEquals(maxCount,1);

    }
    @Test
    public void findLengthWithRandomMatchWithDP(){
        String seq1="ABCBDAB";
        String seq2="BDCABA";

        int maxCount=this.longestCommonSubsequence.maxCommonSubSequenceWithDP(seq1,seq2);
        Assert.assertEquals(maxCount,4);

    }

    @Test
    public void findStringWithDP(){
        String seq1="abc";
        String seq2="def";

        String result=this.longestCommonSubsequence.maxCommonSubSequenceStringWithDP(seq1,seq2);
        Assert.assertEquals(result,"");

    }

    @Test
    public void findStringWithEndWithDP(){
        String seq1="abcd";
        String seq2="def";

        String result=this.longestCommonSubsequence.maxCommonSubSequenceStringWithDP(seq1,seq2);
        Assert.assertEquals(result,"d");

    }

    @Test
    public void findStringWithEndMiddleWithDP(){
        String seq1="abcd";
        String seq2="kdef";

        String result=this.longestCommonSubsequence.maxCommonSubSequenceStringWithDP(seq1,seq2);
        Assert.assertEquals(result,"d");

    }
    @Test
    public void findStringWithRandomMatchWithDP(){
        String seq1="ABCBDAB";
        String seq2="BDCABA";

        String result=this.longestCommonSubsequence.maxCommonSubSequenceStringWithDP(seq1,seq2);
        Assert.assertEquals(result,"BDAB");

    }

    @Test
    public void findLengthWithBottomUP(){
        String seq1="abc";
        String seq2="def";

        int maxCount=this.longestCommonSubsequence.getLCSLength(seq1,seq2);
        Assert.assertEquals(maxCount,0);

    }

    @Test
    public void findLengthWithEndWithBottomUP(){
        String seq1="abcd";
        String seq2="def";

        int maxCount=this.longestCommonSubsequence.getLCSLength(seq1,seq2);
        Assert.assertEquals(maxCount,1);

    }

    @Test
    public void findLengthWithEndMiddleWithBottomUP(){
        String seq1="abcd";
        String seq2="kdef";

        int maxCount=this.longestCommonSubsequence.getLCSLength(seq1,seq2);
        Assert.assertEquals(maxCount,1);

    }
    @Test
    public void findLengthWithRandomMatchWithBottomUP(){
        String seq1="ABCBDAB";
        String seq2="BDCABA";

        int maxCount=this.longestCommonSubsequence.getLCSLength(seq1,seq2);
        Assert.assertEquals(maxCount,4);

    }
    @Test
    public void findStringWithDPWithBottomUP(){
        String seq1="abc";
        String seq2="def";

        String result=this.longestCommonSubsequence.findLCS(seq1,seq2);
        Assert.assertEquals(result,"");

    }

    @Test
    public void findStringWithEndWithDPWithBottomUP(){
        String seq1="abcd";
        String seq2="def";

        String result=this.longestCommonSubsequence.findLCS(seq1,seq2);
        Assert.assertEquals(result,"d");

    }

    @Test
    public void findStringWithEndMiddleWithDPWithBottomUP(){
        String seq1="abcd";
        String seq2="kdef";

        String result=this.longestCommonSubsequence.findLCS(seq1,seq2);
        Assert.assertEquals("d",result);

    }
    @Test
    public void findStringWithRandomMatchWithDPWithBottomUP(){
        String seq1="ABCBDAB";
        String seq2="BDCABA";

        String result=this.longestCommonSubsequence.findLCS(seq1,seq2);
        Assert.assertEquals(result,"BDAB");

    }
}
