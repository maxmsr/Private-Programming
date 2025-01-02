package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tag4 {
    public static void main(String[] args) {
        char[][] matrix = new char[0][];

        // Datei einlesen und Matrix erstellen
        try (Scanner sc = new Scanner(new BufferedReader(new FileReader("src/main/java/org/example/Dateien/Day 4")))) {
            List<char[]> array = new ArrayList<>();
            while (sc.hasNextLine()) {
                array.add(sc.nextLine().trim().toCharArray());
            }
            matrix = array.toArray(new char[0][]);
        } catch (Exception e) {
            e.printStackTrace();
            return; // Bei einem Fehler abbrechen
        }

        int sum = 0;

        // Matrix durchsuchen
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                // Horizontal nach rechts
                if (j + 3 < matrix[i].length &&
                        matrix[i][j] == 'X' &&
                        matrix[i][j + 1] == 'M' &&
                        matrix[i][j + 2] == 'A' &&
                        matrix[i][j + 3] == 'S') {
                    sum++;
                }

                // Horizontal nach links
                if (j - 3 >= 0 &&
                        matrix[i][j] == 'X' &&
                        matrix[i][j - 1] == 'M' &&
                        matrix[i][j - 2] == 'A' &&
                        matrix[i][j - 3] == 'S') {
                    sum++;
                }

                // Vertikal nach unten
                if (i + 3 < matrix.length &&
                        matrix[i][j] == 'X' &&
                        matrix[i + 1][j] == 'M' &&
                        matrix[i + 2][j] == 'A' &&
                        matrix[i + 3][j] == 'S') {
                    sum++;
                }

                // Vertikal nach oben
                if (i - 3 >= 0 &&
                        matrix[i][j] == 'X' &&
                        matrix[i - 1][j] == 'M' &&
                        matrix[i - 2][j] == 'A' &&
                        matrix[i - 3][j] == 'S') {
                    sum++;
                }

                // Diagonal nach unten rechts
                if (i + 3 < matrix.length && j + 3 < matrix[i].length &&
                        matrix[i][j] == 'X' &&
                        matrix[i + 1][j + 1] == 'M' &&
                        matrix[i + 2][j + 2] == 'A' &&
                        matrix[i + 3][j + 3] == 'S') {
                    sum++;
                }

                // Diagonal nach oben rechts
                if (i - 3 >= 0 && j + 3 < matrix[i].length &&
                        matrix[i][j] == 'X' &&
                        matrix[i - 1][j + 1] == 'M' &&
                        matrix[i - 2][j + 2] == 'A' &&
                        matrix[i - 3][j + 3] == 'S') {
                    sum++;
                }

                // Diagonal nach oben links
                if (i - 3 >= 0 && j - 3 >= 0 &&
                        matrix[i][j] == 'X' &&
                        matrix[i - 1][j - 1] == 'M' &&
                        matrix[i - 2][j - 2] == 'A' &&
                        matrix[i - 3][j - 3] == 'S') {
                    sum++;
                }

                // Diagonal nach unten links
                if (i + 3 < matrix.length && j - 3 >= 0 &&
                        matrix[i][j] == 'X' &&
                        matrix[i + 1][j - 1] == 'M' &&
                        matrix[i + 2][j - 2] == 'A' &&
                        matrix[i + 3][j - 3] == 'S') {
                    sum++;
                }
            }
        }
        // Matrix durchsuchen
        int sum2 = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                // Berechne Nachbarn
                int r1 = row - 1;
                int r2 = row + 1;
                int c1 = col - 1;
                int c2 = col + 1;

                // Prüfen, ob alle Nachbarn existieren
                if (r1 >= 0 && r2 < matrix.length && c1 >= 0 && c2 < matrix[row].length) {
                    // Muster 1
                    if (matrix[row][col] == 'A' &&
                            matrix[r1][c1] == 'M' &&
                            matrix[r1][c2] == 'S' &&
                            matrix[r2][c1] == 'M' &&
                            matrix[r2][c2] == 'S') {
                        sum2++;
                    }

                    // Muster 2
                    if (matrix[row][col] == 'A' &&
                            matrix[r1][c1] == 'S' &&
                            matrix[r1][c2] == 'S' &&
                            matrix[r2][c1] == 'M' &&
                            matrix[r2][c2] == 'M') {
                        sum2++;
                    }

                    // Muster 3
                    if (matrix[row][col] == 'A' &&
                            matrix[r1][c1] == 'M' &&
                            matrix[r1][c2] == 'M' &&
                            matrix[r2][c1] == 'S' &&
                            matrix[r2][c2] == 'S') {
                        sum2++;
                    }

                    // Muster 4
                    if (matrix[row][col] == 'A' &&
                            matrix[r1][c1] == 'S' &&
                            matrix[r1][c2] == 'M' &&
                            matrix[r2][c1] == 'S' &&
                            matrix[r2][c2] == 'S') {
                        sum2++;
                    }
                }
            }
        }

        // Ergebnis ausgeben
        System.out.println("Gefundene 'XMAS'-Muster: " + sum);
        System.out.println("Gefundene 'X-MAS'-Muster: " + sum2);
    }
}