package com.ankur.interview.algexp.strings;

import com.ankur.interview.algexp.strings.Containing;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.HashMap;

public class TestContaining {
    @Test
    public void testContaining() {
        HashMap frequency = Containing.getCharCount( "$$abf");
        Assertions.assertTrue(frequency.size() > 0);
    }

    @Test
    public void testHint2() {
        HashMap<Character,Integer> frequency = Containing.getCharCount( "$$abf");
        Assertions.assertTrue(frequency.size() > 0);
        String subString = Containing.getSmallestSubstring2("abcd$ef$axb$c$","$$abf");
        Assertions.assertTrue(subString.length() > 0);
    }
}

