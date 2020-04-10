package com.ankur.interview.algoexpert.strings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestStringExtension {

    private StringExtension testObject;
    @BeforeEach
    public void setUp(){
        this.testObject= new StringExtension();
    }

    @Test
    public void testIsExtension(){
        assertTrue(testObject.isExtension("hello","hhhhheeellllooo"));
    }
}
