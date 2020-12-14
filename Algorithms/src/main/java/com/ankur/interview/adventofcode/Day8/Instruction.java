package com.ankur.interview.adventofcode.Day8;


public abstract class Instruction {
    private final String type;
    final int value;

    public Instruction(String type, int value) {
        this.type = type;
        this.value = value;
    }

    public abstract void exec(Computer computer);
}
