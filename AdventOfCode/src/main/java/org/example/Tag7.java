
/*
package org.example;

import java.io.*;
import java.util.*;

public class Tag7 {
    public static void main(String[] args) {
        // Datei einlesen
        String fileName = "src/main/java/org/example/Dateien/Day 7"; // Name der Datei
        List<long[]> equationsList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Zeile parsen: "190: 10 19" -> [190, 10, 19]
                String[] parts = line.split(":");
                long target = Long.parseLong(parts[0].trim());
                String[] numbersStr = parts[1].trim().split(" ");
                long[] equation = new long[numbersStr.length + 1];
                equation[0] = target;
                for (int i = 0; i < numbersStr.length; i++) {
                    equation[i + 1] = Long.parseLong(numbersStr[i]);
                }
                equationsList.add(equation);
            }
        } catch (IOException e) {
            System.err.println("Fehler beim Lesen der Datei: " + e.getMessage());
            return;
        }

        // Konvertiere List<long[]> in ein 2D-Array
        long[][] equations = equationsList.toArray(new long[0][]);

        // Logik anwenden
        processEquations(equations);
    }

    public static void processEquations(long[][] equations) {
        long totalCalibration = 0;

        for (long[] equation : equations) {
            long target = equation[0]; // Zielwert
            long[] numbers = new long[equation.length - 1];
            System.arraycopy(equation, 1, numbers, 0, numbers.length);

            System.out.println("Prüfe Gleichung: Ziel = " + target + ", Zahlen = " + arrayToString(numbers));

            // Anzahl der Operatoren
            int operatorCount = numbers.length - 1;
            List<String> operators = List.of("+", "*", "||");

            // Alle Kombinationen der Operatoren durchgehen
            long combinations = (long) Math.pow(operators.size(), operatorCount);
            boolean valid = false;

            for (long i = 0; i < combinations; i++) {
                String[] currentOperators = new String[operatorCount];
                long temp = i;

                // Generiere die aktuelle Kombination
                for (int j = 0; j < operatorCount; j++) {
                    currentOperators[j] = operators.get((int) (temp % operators.size()));
                    temp /= operators.size();
                }

                // Berechne das Ergebnis der Gleichung
                long result = evaluateExpression(numbers, currentOperators);

                // Prüfe, ob das Ergebnis dem Ziel entspricht
                if (result == target) {
                    valid = true;
                    System.out.println("Gültige Kombination gefunden: " + arrayToString(numbers, currentOperators));
                }
            }

            if (valid) {
                totalCalibration += target;
            }
        }

        System.out.println("Gesamtes Kalibrierungsergebnis: " + totalCalibration);
    }

    public static long evaluateExpression(long[] numbers, String[] operators) {
        long result = numbers[0];
        for (int i = 0; i < operators.length; i++) {
            switch (operators[i]) {
                case "+" -> result += numbers[i + 1];
                case "*" -> result *= numbers[i + 1];
                case "||" -> {
                    String resultString = String.valueOf(numbers[i]) + String.valueOf(numbers[i + 1]);
                    result += Long.parseUnsignedLong(resultString);
                }
            }
        }
        return result;
    }

    public static String arrayToString(long[] numbers) {
        StringBuilder sb = new StringBuilder();
        for (long number : numbers) {
            sb.append(number).append(" ");
        }
        return sb.toString().trim();
    }

    public static String arrayToString(long[] numbers, String[] operators) {
        StringBuilder sb = new StringBuilder();
        sb.append(numbers[0]);
        for (int i = 0; i < operators.length; i++) {
            sb.append(" ").append(operators[i]).append(" ").append(numbers[i + 1]);
        }
        return sb.toString();
    }

    public static int concatenateNumbers(int a, int b) {
        // Methode 1: String-Konkatenation
        String concatenated = String.valueOf(a) + String.valueOf(b);
        return Integer.parseInt(concatenated);
    }
} +/
 */

package org.example;

import java.io.*;
import java.util.*;

public class Tag7 {

    // === 1. Funktion zum Berechnen der Operation (+, *, ||) für Zahlen und Strings ===
    public static String calculate(String a, String b, String operator) {
        switch (operator) {
            case "+":
                // Addition ist nur möglich, wenn beide Inputs Zahlen sind
                try {
                    long num1 = Long.parseLong(a);
                    long num2 = Long.parseLong(b);
                    return String.valueOf(num1 + num2);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Addition ist nur für Zahlen möglich: " + a + ", " + b);
                }

            case "*":
                // Multiplikation ist nur möglich, wenn beide Inputs Zahlen sind
                try {
                    long num1 = Long.parseLong(a);
                    long num2 = Long.parseLong(b);
                    return String.valueOf(num1 * num2);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Multiplikation ist nur für Zahlen möglich: " + a + ", " + b);
                }

            case "||":
                // Aneinanderhängen von Strings – funktioniert für alles
                return a + b;

            default:
                throw new IllegalArgumentException("Ungültiger Operator: " + operator);
        }
    }

    // === 2. Methode zum Einlesen einer 2D-Liste aus der Datei (mit Unterstützung für Strings) ===
    public static ArrayList<String[]> read2DArrayFromFile(String filePath) throws IOException {
        ArrayList<String[]> result = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] parts = line.split(":");
                String firstPart = parts[0].trim();

                String[] remainingParts = parts[1].trim().split("\\s+");
                String[] row = new String[remainingParts.length + 1];
                row[0] = firstPart;

                for (int i = 0; i < remainingParts.length; i++) {
                    row[i + 1] = remainingParts[i];
                }
                result.add(row);
            }
        }

        return result;
    }

    // === 3. Main-Methode ===
    public static void main(String[] args) {
        String filePath = "/Users/maxmoser/Progamming/AdventOfCode/src/main/java/org/example/Dateien/Day 7";

        try {
            // Einlesen der Datei
            ArrayList<String[]> input = read2DArrayFromFile(filePath);

            // Beispiel: ArrayList in 2D-Array konvertieren
            String[][] inputArray = input.toArray(new String[0][]);

            // Teste alle drei Operationen (mit Zahlen und Zeichen)
            System.out.println("=== Berechnungsbeispiele ===");
            System.out.println("Addition (15 + 6): " + calculate("15", "6", "+"));
            System.out.println("Multiplikation (15 * 6): " + calculate("15", "6", "*"));
            System.out.println("Aneinanderhängen (15 || 6): " + calculate("15", "6", "||"));
            System.out.println("Aneinanderhängen (A || B): " + calculate("A", "B", "||"));

            // Durchlaufe das Array und führe Berechnungen durch
            System.out.println("\n=== Berechnungen über Dateiinhalte ===");
            for (String[] row : inputArray) {
                if (row.length > 1) {
                    // Beispiele für Berechnungen mit den ersten zwei Werten in jeder Zeile
                    String a = row[0];
                    String b = row[1];

                    System.out.println("Zeile: " + Arrays.toString(row));
                    System.out.println("  Addition (falls möglich): ");
                    try {
                        System.out.println("    " + calculate(a, b, "+"));
                    } catch (IllegalArgumentException e) {
                        System.out.println("    Nicht möglich: " + e.getMessage());
                    }

                    System.out.println("  Multiplikation (falls möglich): ");
                    try {
                        System.out.println("    " + calculate(a, b, "*"));
                    } catch (IllegalArgumentException e) {
                        System.out.println("    Nicht möglich: " + e.getMessage());
                    }

                    System.out.println("  Aneinanderhängen: " + calculate(a, b, "||"));
                }
            }

        } catch (IOException e) {
            throw new RuntimeException("Dateifehler: " + e.getMessage());
        }
    }
}