package com.ankur.interview.practice.arrays;

public class BlockPuzzle {
    /*
    /3. Block puzzle automation
Step 1: Understand the rules
The problem requires implementing a method solve(width, height, nbBlocks, grid) that returns the number of the next block to move out of a grid to the right.
Blocks are numbered 0-9 and can span multiple cells. The grid contains walls ('x') and empty spaces ('.').
Blocks move to the right until they are completely out of the grid or collide with another block.
Only one block is moved at a time, and if multiple can move, any can be chosen first.
Step 2: Determine which blocks can move
A block can move to the right if all cells immediately to its right (up to the exit) are either empty or part of the same block, and the exit path is clear of other blocks or walls.
Step 3: Implement the logic
The implementation should iterate through all present blocks (0 to nbBlocks-1) and check if each can move.
The method should return the number of any block that satisfies the movement criteria.
The problem statement indicates that if several blocks can exit, any valid block number can be returned.
Answer:
The solution requires implementing a function that identifies a block that can be moved to the right without collision and returning its number.
The core logic involves checking the path to the right of each block in the grid to ensure it's clear of other obstacles or blocks.
The problem is a programming challenge that requires the user to write code to solve the described puzzle. The specific number of the next block to move cannot be determined without the actual grid configuration.
     */
    public static int solve(int width, int height, int nbBlocks, String[] grid) {

        for (int block = 0; block < nbBlocks; block++) {
            if (canExit(block, width, height, grid)) {
                return block; // choose first possible block
            }
        }

        return -1; // logically unreachable for valid puzzles
    }

    private static boolean canExit(int block, int width, int height, String[] grid) {

        char target = (char) ('0' + block);

        for (int r = 0; r < height; r++) {
            int left = -1, right = -1;

            // find continuous segment of this block in this row
            for (int c = 0; c < width; c++) {
                if (grid[r].charAt(c) == target) {
                    if (left == -1) left = c;
                    right = c;
                }
            }

            if (left == -1) continue; // not in this row → skip

            // scan cells to the right of the block
            for (int c = right + 1; c < width; c++) {

                char cell = grid[r].charAt(c);

                if (cell == 'X') return false;          // wall blocks exit
                if (cell >= '0' && cell <= '9') return false; // another block blocks exit
            }
        }

        return true; // all rows clear → can exit
    }
}

