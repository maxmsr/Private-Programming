package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class hello2 {

    public static int[] getIntArrayFromFile(String dateiPfad) {
        ArrayList<Integer> list = new ArrayList<>(); // Temporäre Liste, um die Werte zu speichern
        try (BufferedReader reader = new BufferedReader(new FileReader(dateiPfad))) {
            String line;

            while ((line = reader.readLine()) != null) {
                // Splitte die Zeile bei Leerzeichen oder Tabulator
                String[] teile = line.split("\\s+");  // \\s+ steht für alle Leerzeichen/Tabs

                // Parsen der Werte und in die Liste hinzufügen
                int rechts = Integer.parseInt(teile[1]);
                list.add(rechts);  // Füge den Wert der Liste hinzu
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Konvertiere die Liste in ein Array und gib es zurück
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        String dateiPfad = "src/main/java/org/example/data"; // Pfad zu deiner TXT-Datei
        int[] resultArray = getIntArrayFromFile(dateiPfad);

        // Ausgabe des resultierenden Arrays
        for (int i : resultArray) {
            System.out.print(i + " ");
        }
    }

}
