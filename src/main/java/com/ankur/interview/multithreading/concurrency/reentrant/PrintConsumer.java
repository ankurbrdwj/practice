package com.ankur.interview.multithreading.concurrency.reentrant;

import java.util.function.IntConsumer;

public class PrintConsumer implements IntConsumer {
    @Override
    public void accept(int value) {
        System.out.println(value+ " ");
    }
}
