import java.io.*;
import java.util.*;

public class tag6 {
    public static int main(String[] args) {
        String filePath = "/Users/maxmoser/Progamming/AdventOfCode/src/main/java/org/example/Dateien/Day 6";
        char[][] grid = readGridFromFile(filePath);
        final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        int sum = 0;
        int StartX = 0, StartY = 0, directions = 0;
        for (int row = 0; row < grid.length; row++){
            for (int col = 0; col < grid[row].length; col++){
                if (grid[row][col] == '^'){
                    StartX = row;
                    StartY = col;
                }

            }
        }


        // Track visited positions
        Set<String> visited = new HashSet<>();
        visited.add(StartX + "," + StartY);

        // Simulate guard movement
        int x = StartX, y = StartY;
        while (true) {
            int direction = 0;
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
    }


    public static char[][] readGridFromFile(String filePath) {
        List<char[]> rows = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Convert the line into a char array and add it to the list
                rows.add(line.toCharArray());
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        // Convert the list to a 2D array
        return rows.toArray(new char[0][]);
    }


public void main() {
}
