package org.example;

public enum Countries {
    UK("United Kingdom"),
    SK("Slovakia"),
    CZ("Czech Republic");

    private final String countryName;

    Countries(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public String toString() {
        return countryName;
    }
}
