package com.ankur.interview.practice.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestLongestRepeatingKChracters {
    @Test
    public void testlongestRepeatingWithK(){
        int expected = 15;
        int actual =LongestRepeatingKCharacters.getLongestStringWithMinKFrequency("bbaaacddcaabdbd",2);
        Assertions.assertEquals(actual,expected);
    }
}
