package com.ankur.interview.adventofcode.Day8;


public class Jumper extends Instruction {
    public Jumper(String type, int value) {
        super(type, value);
    }

    @Override
    public void exec(Computer computer) {
        computer.position += this.value;
    }

}
