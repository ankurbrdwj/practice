package com.ankur.interview.adventofcode.Day8;


public class NoOperation extends Instruction {
    public NoOperation(String type, int value) {
        super(type,value );
    }

    @Override
    public void exec(Computer computer) {
        computer.position++;
    }
}
