package com.engeto.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Statistic extends DailyRecords{
    Statistic(ArrayList<Day> dailyRecords) {
        super(dailyRecords);
    }

    public void displayNumberOfRecordedDays() {
        System.out.println("We have " + dailyRecords.size() +" meteorological daily records to analyze.");
    }
    public void displayAvgTemp() {
        Stream<Day> stream = dailyRecords.stream();
        Optional<Float> combinedValue = stream.map(Day::getAvgTemp)
                .reduce(Float::sum);
        float result = combinedValue.get() / dailyRecords.size();
        result = (float) (Math.round(result * 10) /10.0);
        System.out.println("Average temperature for the reporting period: " + result + " °C");
    }
    public void displayMaxTemp() {
        Stream<Day> stream = dailyRecords.stream();
        Optional<Float> result = stream.map(Day::getMaxTemp).max(Comparator.naturalOrder());
        Stream<Day> stream1 = dailyRecords.stream();
        Day date = (stream1.filter(((value) -> value.getMaxTemp() == result.get())).findFirst()).get();
        System.out.println("Maximum temperature for the reporting period: " + date.getDate() + " was " + result.get() + " °C");
    }
    public void displayMinTemp() {
        Stream<Day> stream = dailyRecords.stream();
        Optional<Float> result = stream.map(Day::getMinTemp).min(Comparator.naturalOrder());
        Stream<Day> stream1 = dailyRecords.stream();
        Day date = (stream1.filter(((value) -> value.getMinTemp() == result.get())).findFirst()).get();
        System.out.println("Minimum temperature for the reporting period: " + date.getDate() + " was " + result.get() + " °C");
    }
    // Wind speed has to be more than 4.2 m/s
    public void displayWindyDays() {
        Stream<Day> stream = dailyRecords.stream();
        List<Float> windyDaysValues = stream.map(Day::getWindSpeed).filter((value) -> value >= 4.2).collect(Collectors.toList());
        int result = windyDaysValues.size();
        System.out.println("Number of windy days: " + result);
    }
    // Wind speed has to be less than 1.8 m/s
    public void displayCalmDays() {
        Stream<Day> stream = dailyRecords.stream();
        List<Float> windyDaysValues = stream.map(Day::getWindSpeed).filter((value) -> value <= 1.8).collect(Collectors.toList());
        int result = windyDaysValues.size();
        System.out.println("Number of calm days: " + result);
    }
    // Monthly precipitation in the first 10 days, next 10 days and the rest
    public void displayPrecipitationOverview() {
        Stream<Day> stream = dailyRecords.stream();
        float firstDecade = stream.limit(10).map(Day::getPrecipitation).reduce(Float::sum).get();
        stream = dailyRecords.stream();
        float secondDecade = stream.skip(10).limit(10).map(Day::getPrecipitation).reduce(Float::sum).get();
        stream = dailyRecords.stream();
        float theRest = stream.skip(20).map(Day::getPrecipitation).reduce(Float::sum).get();

        System.out.println("Precipitation summary in month decades: " + firstDecade + "mm - " + secondDecade + "mm - " +theRest + "mm");
        System.out.println("--------------------------------------------------------------------------------");
    }
    // Graph
    public void displayGraph() {
        displayGraphTop();
        dispayGraphLines();
        displayGraphBottom();
    }
    private void displayGraphTop() {
        System.out.println("Graph");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("   | 00--------10--------20--------30--------40");
    }
    private void dispayGraphLines() {
        Day day;
        for(int i = 0; i < dailyRecords.size(); i++) {
            day = dailyRecords.get(i);
            String lineSection = getSpaceString(day.getMinTemp()) + getFilledString(day.getMaxTemp() - day.getMinTemp());
            displayGraphLine(i+1, lineSection);
        }
    }
    // To display a single graph line
    private void displayGraphLine(int dayNumber, String lineSection) {
        if(dayNumber < 10) System.out.println("0"+ dayNumber + " | " + lineSection);
        else System.out.println(dayNumber + " |  " + lineSection);
    }
    // Returns a String filled with num spaces
    private String getSpaceString(float num) {
        String result = "";
        num = Math.round(num);
        for(int i = 0; i < num; i++) {
            result += " ";
        }
        return result;
    }
    // Returns a String filled with num * symbols
    private String getFilledString(float num) {
        String result = "";
        num = Math.round(num);
        for(int i = 0; i < num; i++) {
            result += "*";
        }
        return result;
    }
    private void displayGraphBottom() {
        System.out.println("   | 00--------10--------20--------30--------40");
        System.out.println("--------------------------------------------------------------------------------");
    }
}
