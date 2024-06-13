package org.example;

import org.junit.jupiter.api.Test;
import java.util.Collections;
import java.util.List;

import static org.example.CsvReader.parseCSV;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    @Test
    public void testStandingCalculation() {
        String csvData = "11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo\n" +
                "1,Jimmy Smiles,UK,29:15,xxoox,xooxo,xxxxo\n" +
                "27,Piotr Smitzer,CZ,30:10,xxxxx,xxxxx,xxxxx";

        List<Athlete> athletes = parseCSV(csvData);
        Collections.sort(athletes);

        assertEquals("Piotr Smitzer", athletes.get(0).getName());
        assertEquals("Jimmy Smiles", athletes.get(1).getName());
        assertEquals("Umar Jorgson", athletes.get(2).getName());
    }

}
