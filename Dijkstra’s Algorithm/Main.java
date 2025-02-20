package Dijkstra;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String filePath = "/Users/sana/Desktop/Assignment 9 - A/src/Dijkstra/europe.csv"; // Update with the actual file path

        Map map = new Map(filePath);

        // Maximum number of cities in the data file
        int maxCities = 200; // Adjust if needed based on your dataset

        // Initialize DijkstraAlgorithm with the city hash table from the map
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(map.getCityHashTable(), maxCities);

        // Define the starting city and target cities for benchmarking
        String startCity = "Paris";
        String[] targetCities = {"Berlin", "Madrid", "Montpellier", "Amsterdam", "Milano", "Stockholm",
                "Frankfurt", "Zürich", "Fredrikshamn", "Rom", "Oslo", "Sundsvall"};

        // Run benchmarks for each target city
        System.out.println("Benchmark Results:");
        for (String destinationCity : targetCities) {
            // Reset the 'done' array in DijkstraAlgorithm for each run
            dijkstra.resetDoneArray();

            // Measure the execution time
            long startTime = System.nanoTime();
            dijkstra.findShortestPath(startCity, destinationCity);
            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1_000_000; // Convert to milliseconds

            // Count the entries in the 'done' array
            int doneEntries = dijkstra.countDoneEntries();

            // Output the results for this target city
            System.out.println("Shortest path to " + destinationCity + ":");
            System.out.println("Time taken: " + duration + " ms");
            System.out.println("Entries in 'done' array: " + doneEntries);
            System.out.println();
        }
    }
}