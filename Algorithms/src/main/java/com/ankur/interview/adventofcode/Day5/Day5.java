package com.ankur.interview.adventofcode.Day5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class Day5 {
    public static void main(String[] args) throws IOException {
//		copy and paste the input data into a file and read from it
        System.out.println(System.getProperty("user.dir"));
        List<String> data = Files.readAllLines(Paths.get("src/main/java/com/ankur/interview/adventofcode/Day5/input.txt"));
        solvedPart1(data);
        solvedPart2(data);
    }

    private static void solvedPart2(List<String> data) {
        var seatIds = data.stream()
                .map(Day5::seatId)
                .sorted()
                .collect(Collectors.toList());
        for (var i = 0; i < seatIds.size() - 1; i++) {
            var seatId1 = seatIds.get(i);
            var seatId2 = seatIds.get(i + 1);
            if (seatId1 + 1 != seatId2) {
                System.out.println(String.valueOf(seatId1 + 1));
            }
        }
    }

    private static void solvedPart1(List<String> data) {
        final List<Integer> list = new ArrayList<>();
        OptionalInt result = data.stream()
                .mapToInt(Day5::seatId)
                .max();
    }

    private static int seatId(String s) {
        var seat_id = 0;
        for (char c : s.toCharArray()) {
            seat_id <<= 1;
            if (c == 'B' || c == 'R') {
                seat_id |= 1;
            }
        }
        return seat_id;

    }
}
