package com.ankur.interview.algexp.strings;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class TestContaining {
    @Test
    public void testContaining() {
        HashMap frequency = Containing.getCharCount( "$$abf");
        Assert.assertTrue(frequency.size() > 0);
    }

    @Test
    public void testHint2() {
        HashMap<Character,Integer> frequency = Containing.getCharCount( "$$abf");
        Assert.assertTrue(frequency.size() > 0);
        String subString = Containing.getSmallestSubstring2("abcd$ef$axb$c$","$$abf");
        Assert.assertTrue(subString.length() > 0);
    }
}

