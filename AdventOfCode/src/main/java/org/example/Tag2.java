package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Tag2 {
    public static void main(String[] args) {
        String filePath = "src/main/java/org/example/data"; // Pfad zur Datei
        try {
            int[][] data = readFileTo2DArray(filePath);

            // Ausgabe des Arrays
            for (int[] row : data) {
                for (int value : row) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.err.println("Fehler beim Einlesen der Datei: " + e.getMessage());
        }
    }

    public static int[][] readFileTo2DArray(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Zuerst die Anzahl der Zeilen bestimmen
            int rows = 0;
            while (br.readLine() != null) {
                rows++;
            }

            // Datei erneut öffnen, um Daten einzulesen
            br.close();
            try (BufferedReader br2 = new BufferedReader(new FileReader(filePath))) {
                int[][] array = new int[rows][];
                String line;
                int rowIndex = 0;

                while ((line = br2.readLine()) != null) {
                    // Werte in der Zeile parsen (durch Leerzeichen getrennt)
                    String[] parts = line.trim().split("\\s+"); // Trennung durch Leerzeichen
                    int[] row = new int[parts.length];
                    for (int i = 0; i < parts.length; i++) {
                        row[i] = Integer.parseInt(parts[i]); // String zu Integer konvertieren
                    }
                    array[rowIndex] = row;
                    rowIndex++;
                }
                return array;
            }
        }
    }
    public static boolean isStrictlyIncreasing(int[] row) {
        for (int i = 1; i < row.length; i++) {
            if (row[i] <= row[i - 1] || (row[i] - row[i - 1]) > 3) {
                return false; // Nicht stetig größer oder Differenz > 3
            }
        }

        return true;
    }

    public static boolean isStrictlyDecreasing(int[] row) {
        for (int i = 1; i < row.length; i++) {
            if (row[i] >= row[i - 1] || (row[i - 1] - row[i]) > 3) {
                return false; // Nicht stetig kleiner oder Differenz > 3
            }
        }
        return true;
    }

    public static boolean canBeSafeWithOneRemoval(int[] row) {
        for (int i = 0; i < row.length; i++) {
            if (isSafeAfterRemovingIndex(row, i)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSafeAfterRemovingIndex(int[] row, int removeIndex) {
        int[] modifiedRow = new int[row.length - 1];
        int index = 0;

        for (int i = 0; i < row.length; i++) {
            if (i != removeIndex) {
                modifiedRow[index++] = row[i];
            }
        }

        return isStrictlyIncreasing(modifiedRow) || isStrictlyDecreasing(modifiedRow);
    }
}