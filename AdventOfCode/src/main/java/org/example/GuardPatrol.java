package org.example;

import java.io.*;
import java.util.*;

public class GuardPatrol {
    // Directions represented as (dx, dy): up, right, down, left
    private static final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    // Method to predict patrol path
    public static int predictPatrolPath(char[][] grid) {
        int startX = 0, startY = 0, direction = 0;

        // Find initial position and facing direction of the guard
        outer:
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '^') {
                    startX = i;
                    startY = j;
                    direction = 0; // Facing up
                    break outer;
                }
            }
        }

        // Track visited positions
        Set<String> visited = new HashSet<>();
        visited.add(startX + "," + startY);

        // Simulate guard movement
        int x = startX, y = startY;
        while (true) {
            int nextX = x + DIRECTIONS[direction][0];
            int nextY = y + DIRECTIONS[direction][1];

            // Check if guard moves out of bounds
            if (nextX < 0 || nextY < 0 || nextX >= grid.length || nextY >= grid[0].length) {
                break;
            }

            // Check if there's an obstacle
            if (grid[nextX][nextY] == '#') {
                // Turn right (change direction clockwise)
                direction = (direction + 1) % 4;
            } else {
                // Move forward
                x = nextX;
                y = nextY;
                visited.add(x + "," + y); // Mark the position as visited
            }
        }

        return visited.size();
    }

    // Method to read grid from file
    public static char[][] readGridFromFile(String filePath) {
        List<char[]> rows = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                rows.add(line.toCharArray());
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return rows.toArray(new char[0][]);
    }

    public static void main(String[] args) {
        String filePath = "src/main/java/org/example/Dateien/Day 6";
        char[][] grid = readGridFromFile(filePath);

        if (grid == null) {
            System.out.println("Failed to read grid from file.");
            return;
        }

        int result = predictPatrolPath(grid);
        System.out.println("Distinct positions visited: " + result);
    }
}