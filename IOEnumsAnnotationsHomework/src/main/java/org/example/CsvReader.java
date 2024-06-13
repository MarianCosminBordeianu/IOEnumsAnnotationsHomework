package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
    public static List<Athlete> parseCSV(String csvData) {
        List<Athlete> athletes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new StringReader(csvData))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(",");
                int number = Integer.parseInt(words[0]);
                String name = words[1];
                String countryCode = words[2];
                String skiTime = words[3];
                String firstShooting = words[4];
                String secondShooting = words[5];
                String thirdShooting = words[6];

                Athlete athlete = new Athlete(number, name, countryCode, skiTime, firstShooting, secondShooting, thirdShooting);
                athletes.add(athlete);
            }
        } catch (IOException e) {
            System.out.println("Error occurred.");
        }
        return athletes;
    }
}
