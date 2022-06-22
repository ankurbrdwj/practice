package com.ankur.interview.adventofcode.Day8;

public class Computer {
    int position;
    int accumulator;

    Instruction[] instructions;

    public Computer(Instruction[] instructions) {
        this.instructions = instructions;
    }

    public boolean execute() {
        if (this.position < 0 || this.position > instructions.length)
            return false;
        this.instructions[this.position].exec(this);
        return true;
    }

    public void reset() {
        this.position = 0;
        this.accumulator = 0;
    }
}
