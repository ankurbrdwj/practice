package com.ankur.interview.practice.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestJointPoint {
        @Test
        public void testSumJoin () {
            int expected = 519;
            int jointPoint= JointPoint.computeJoinPoint(471,480);
            Assertions.assertEquals(jointPoint,expected);
        }

    }
