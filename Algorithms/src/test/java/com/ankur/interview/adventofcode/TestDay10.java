package com.ankur.interview.adventofcode;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class TestDay10 {
    @Test
    public void testDay10_part2() throws IOException {
        Day10 day10= new Day10();
        List<String> data = Files.readAllLines(Paths.get("src/test/java/com/ankur/interview/adventofcode/input10.txt"));
        List<Integer> intList = data.stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        day10.solvePart2(intList);
    }
}
