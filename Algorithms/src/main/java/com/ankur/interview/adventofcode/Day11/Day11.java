package com.ankur.interview.adventofcode.Day11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;


public class Day11 {
    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("user.dir"));
        List<String> data = Files.readAllLines(Paths.get("src/main/java/com/ankur/interview/adventofcode/Day11/input.txt"));
        solvePart1(data);
        solvePart2(data);
    }

    private static void solvePart1(List<String> list) {
        char[][] seats = new char[list.size()][];
        boolean[][] visited = new boolean[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            seats[i] = list.get(i).toCharArray();
            visited[i] = new boolean[list.get(i).length()];
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < visited[i].length; j++) {
                visited[i][j] = false;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < visited[i].length; j++) {
                if (seats[i][j] == 'L') {
                    // rule1
                    if ((j < visited[i].length && seats[i][j + 1] == 'L') &&
                            (i < visited[0].length && j < visited[i].length && seats[i + 1][j + 1] == 'L') &&
                            (i < visited.length && seats[i + 1][j] == 'L') &&
                            (i > 0 && j > 0 && seats[i - 1][j - 1] == 'L') &&
                            (i > 0 && seats[i - 1][j] == 'L') &&
                            (j > 0 && seats[i][j - 1] == 'L') &&
                            (i < visited.length && j > 0 && seats[i - 1][j + 1] == 'L') &&
                            (j < visited.length && i > 0 && seats[i + 1][j - 1] == 'L')) {
                        seats[i][j] = '#';
                    }
                } else if (seats[i][j] == '#') {
                    int count = 0;
                    if (j < visited[i].length && seats[i][j + 1] == '#') {
                        count++;
                    }
                    if (i < visited[0].length && j < visited[i].length && seats[i + 1][j + 1] == '#') {
                        count++;
                    }
                    if (i < visited.length && seats[i + 1][j] == '#') {
                        count++;
                    }
                    if (i > 0 && j > 0 && seats[i - 1][j - 1] == '#') {
                        count++;
                    }
                    if (i > 0 && seats[i - 1][j] == '#') {
                        count++;
                    }
                    if (j > 0 && seats[i][j - 1] == '#') {
                        count++;
                    }
                    if (i < visited.length && j > 0 && seats[i - 1][j + 1] == '#') {
                        count++;
                    }
                    if (j < visited.length && i > 0 && seats[i + 1][j - 1] == '#') {
                        count++;
                    }
                    if (count >= 4) {
                        seats[i][j] = '#';
                    }
                }
            }
        }


    }

    private static void solvePart2(List<String> list) {

    }


}
