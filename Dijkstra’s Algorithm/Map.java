package Dijkstra;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Map {
    private CityHashTable cities;
    private int mod = 101;
    private int cityIdCounter = 0;

    public Map(String file) {
        cities = new CityHashTable(mod);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                if (row.length != 3) {
                    System.out.println("Skipping line: " + line);
                    continue;
                }

                String city1Name = row[0].trim();
                String city2Name = row[1].trim();
                int dist;
                try {
                    dist = Integer.parseInt(row[2].trim());
                } catch (NumberFormatException e) {
                    System.out.println("Skipping line, invalid distance.");
                    continue;
                }

                City city1 = lookup(city1Name);
                City city2 = lookup(city2Name);

                city1.connect(city2, dist);
                city2.connect(city1, dist);
            }
        } catch (IOException e) {
            System.out.println("File " + file + " not found.");
        }
    }

    public City lookup(String name) {
        City city = cities.findCity(name);
        if (city == null) {
            city = new City(name, cityIdCounter++);
            cities.updateCity(name, city);
        }
        return city;
    }


    public CityHashTable getCityHashTable() {
        return cities;
    }
}