package com.engeto.example;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class Utility {

    public static HttpResponse<InputStream> obtainData() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://raw.githubusercontent.com/ENGETO-Java-Akademie/java2_lekce_04_projekt/main/B2BTUR01_07_2019.csv"))
                .GET()
                .build();

        HttpResponse<InputStream> response = httpClient
                .send(request, HttpResponse.BodyHandlers.ofInputStream());
        return response;
    }

    public static ArrayList<Day> prepareData(HttpResponse<InputStream> response) {
        // Reading the response line by line(day by day), splitting the lines to Arrays and saving them into an ArrayList
        Scanner scanner = new Scanner(response.body());
        ArrayList<String[]> lines = new ArrayList<>();
        scanner.next();
        String line = "";
        while (scanner.hasNext()) {
            line = scanner.next();
            lines.add(line.split(","));
        }
        // Creating list of Day classes
        ArrayList<Day> RecordedDays = new ArrayList<>();
        // Day(int year, int month, int day, float avgTemp, float maxTemp, float minTemp, float pressure, float windSpeed,
        //     byte humidity, float rainfall);
        lines.forEach((value) -> {
                    Day day = new Day(Integer.parseInt(value[0]), Integer.parseInt(value[1]), Integer.parseInt(value[2]),
                            Float.parseFloat(value[3]), Float.parseFloat(value[4]), Float.parseFloat(value[5]),
                            Float.parseFloat(value[6]), Float.parseFloat(value[7]), Byte.parseByte(value[8]),
                            Float.parseFloat(value[9]));
                    RecordedDays.add(day);
                }
        );
        return RecordedDays;
    }

    public final static void printWelcomingMessage() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Welcome to the application for Meteorological Data Analysis.");
        System.out.println("--------------------------------------------------------------------------------");
    }

}

