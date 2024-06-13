package org.example;

import java.util.Collections;
import java.util.List;

import static org.example.CsvReader.parseCSV;

public class App
{
    public static void main( String[] args )
    {
        String csvData = "11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo\n" +
                "1,Jimmy Smiles,UK,29:15,xxoox,xooxo,xxxxo\n" +
                "27,Piotr Smitzer,CZ,30:10,xxxxx,xxxxx,xxxxx";

        List<Athlete> athletes = parseCSV(csvData);
        Collections.sort(athletes);

        System.out.println("Winner - " + athletes.get(0));
        System.out.println("Runner-up - " + athletes.get(1));
        System.out.println("Third Place - " + athletes.get(2));

    }
}
