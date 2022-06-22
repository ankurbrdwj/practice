package com.ankur.interview.adventofcode.Day8;


public class Accumulator extends Instruction {
    public Accumulator(String type, int value) {
        super( type,value);
    }

    @Override
    public void exec(Computer computer) {
    computer.accumulator += this.value;
    computer.position ++;
    }
}
