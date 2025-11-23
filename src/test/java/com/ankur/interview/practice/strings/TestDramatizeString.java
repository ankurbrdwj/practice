package com.ankur.interview.practice.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestDramatizeString {
    @Test
    public void testDramatizeString(){
        String input ="Roses are red. Oranges are orange! Yeah !!!";
        String expected = "Roses are red! Oranges are orange!! Yeah !!!!";
       String actual =  DramatizeString.processString(input);
       Assertions.assertEquals(expected,actual);
    }
}
