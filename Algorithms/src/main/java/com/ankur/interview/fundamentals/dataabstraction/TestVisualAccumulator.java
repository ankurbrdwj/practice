package com.ankur.interview.fundamentals.dataabstraction;

import com.ankur.interview.stdlib.StdOut;
import com.ankur.interview.stdlib.StdRandom;

public class TestVisualAccumulator
{
    public static void main(String[] args)
    {
        int t = Integer.parseInt(args[0]);
        com.ankur.interview.fundamentals.dataabstraction.VisualAccumulator a = new com.ankur.interview.fundamentals.dataabstraction.VisualAccumulator(t, 1.0);
        for (int i = 0; i < t; i++)
            a.addDataValue(StdRandom.random());
        StdOut.println(a);
    }
}
