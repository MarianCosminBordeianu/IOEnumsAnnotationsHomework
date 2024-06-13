package org.example;

import java.time.Duration;

public class Athlete implements Comparable<Athlete> {
    private final int number;
    private final String name;
    private final Countries countryCode;
    private final Duration skiTime;
    private final String firstShooting;
    private final String secondShooting;
    private final String thirdShooting;

    public Athlete(int number, String name, String countryCode, String skiTime, String firstShooting, String secondShooting, String thirdShooting) {
        this.number = number;
        this.name = name;
        this.countryCode = Countries.valueOf(countryCode);
        this.skiTime = parseTime(skiTime);
        this.firstShooting = firstShooting;
        this.secondShooting = secondShooting;
        this.thirdShooting = thirdShooting;
    }

    public Duration getTotalTime() {
        int penalties = calculatePenalties(firstShooting) + calculatePenalties(secondShooting) + calculatePenalties(thirdShooting);
        return skiTime.plusSeconds(penalties * 10L);
    }

    int calculatePenalties(String shootingResult) {
        int misses = 0;
        for (char c : shootingResult.toCharArray()) {
            if (c == 'o') {
                misses++;
            }
        }
        return misses;
    }

    private Duration parseTime(String time) {
        String[] parts = time.split(":");
        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);
        return Duration.ofMinutes(minutes).plusSeconds(seconds);
    }

    @Override
    public int compareTo(Athlete other) {
        return this.getTotalTime().compareTo(other.getTotalTime());
    }

    @Override
    public String toString() {
        return "Athlete{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", skiTime=" + formatDuration(getTotalTime()) +
                ", firstShooting='" + firstShooting + '\'' +
                ", secondShooting='" + secondShooting + '\'' +
                ", thirdShooting='" + thirdShooting + '\'' +
                '}';
    }

    protected String formatDuration(Duration duration) {
        long minutes = duration.toMinutes();
        long seconds = duration.minusMinutes(minutes).getSeconds();
        return String.format("%d:%02d", minutes, seconds);
    }

    public String getName() {
        return name;
    }
}
