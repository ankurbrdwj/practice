package com.ankur.interview.practice.strings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
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

        assertFalse(testObject.isExtension("hello","hhhhheeelooo"));
    }

    @Test
    public void testEncodeString(){
        String ans0 =testObject.encodeString("hhhhhh").toString();
        assertTrue("h6".equalsIgnoreCase(ans0));
        String ans1 =testObject.encodeString("hello").toString();
        assertTrue("h1e1l2o1".equalsIgnoreCase(ans1));
        String ans2 =testObject.encodeString("hhhhheeellllooo").toString();
        assertTrue("h5e3l4o3".equalsIgnoreCase(ans2));
        String ans3 =testObject.encodeString("hhhhheeellloollloooeeehhh").toString();
        assertTrue("h5e3l3o2l3o3e3h3".equalsIgnoreCase(ans3));
        String ans4 =testObject.encodeString("helo").toString();
        assertTrue("h1e1l1o1".equalsIgnoreCase(ans4));
        String ans5 =testObject.encodeString("h").toString();
        assertTrue("h1".equalsIgnoreCase(ans5));
    }


}
