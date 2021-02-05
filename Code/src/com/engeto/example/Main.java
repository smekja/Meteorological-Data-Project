package com.engeto.example;


import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        try {
            Utility.printWelcomingMessage();
            // The data is saved as an ArrayList of Day classes in the DailyRecords class
            Statistic dailyRecords = new Statistic(Utility.prepareData(Utility.obtainData()));

            dailyRecords.displayNumberOfRecordedDays();
            dailyRecords.displayAvgTemp();
            dailyRecords.displayMaxTemp();
            dailyRecords.displayMinTemp();
            dailyRecords.displayWindyDays();
            dailyRecords.displayCalmDays();
            dailyRecords.displayPrecipitationOverview();

            dailyRecords.displayGraph();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
