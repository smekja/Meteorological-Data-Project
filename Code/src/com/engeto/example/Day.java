package com.engeto.example;

import java.time.LocalDate;

public class Day {
    private LocalDate date;
    private float avgTemp;
    private float maxTemp;
    private float minTemp;
    private float pressure;
    private float windSpeed;
    private byte humidity;
    private float precipitation ;

    Day(int year, int month, int day, float avgTemp, float maxTemp, float minTemp, float pressure, float windSpeed,
        byte humidity, float precipitation) {
        date = LocalDate.of(year, month, day);
        this.avgTemp = avgTemp;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.pressure = pressure;
        this.windSpeed = windSpeed;
        this.humidity = humidity;
        this.precipitation = precipitation;
    }

    public LocalDate getDate() {
        return date;
    }

    public float getAvgTemp() {
        return avgTemp;
    }

    public float getMaxTemp() {
        return maxTemp;
    }

    public float getMinTemp() {
        return minTemp;
    }

    public float getPressure() {
        return pressure;
    }

    public float getWindSpeed() {
        return windSpeed;
    }

    public byte getHumidity() {
        return humidity;
    }

    public float getPrecipitation() {
        return precipitation;
    }
}
