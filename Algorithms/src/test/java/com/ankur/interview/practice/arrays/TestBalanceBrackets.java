package com.ankur.interview.practice.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestBalanceBrackets {

    @Test
    public void TestCase1() {
        Assertions.assertTrue(BalancedBrackets.balancedBrackets("" ) == true);
    }

    @Test
    public void TestCase2() {
        Assertions.assertTrue(BalancedBrackets.balancedBrackets("((((") == false);
    }

    @Test
    public void TestCase3() {
        Assertions.assertTrue(BalancedBrackets.balancedBrackets("()") == true);
    }

    @Test
    public void TestCase4() {
        Assertions.assertTrue(
                BalancedBrackets.balancedBrackets("{{[])}}") ==false);
    }

}
