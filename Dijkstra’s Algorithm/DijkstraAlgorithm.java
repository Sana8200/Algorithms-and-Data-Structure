package Dijkstra;

import java.util.Arrays;

public class DijkstraAlgorithm {
    private CityHashTable cities;
    private PriorityQueue queue;
    private Path[] done;
    private int maxCities;

    public DijkstraAlgorithm(CityHashTable cities, int maxCities) {
        this.cities = cities;
        this.queue = new PriorityQueue();
        this.done = new Path[maxCities];
        this.maxCities = maxCities;
    }

    public void findShortestPath(String startCity, String destinationCity) {
        City strtCity = cities.findCity(startCity);
        City dstCity = cities.findCity(destinationCity);

        if (strtCity == null || dstCity == null) {
            System.out.println("The specified cities do not exist.");
            return;
        }

        queue.enqueue(new Path(strtCity, null, 0));

        while (!queue.isEmpty()) {
            Path currentPath = queue.dequeue();
            City currentCity = currentPath.getCity();

            if (currentCity.equals(dstCity)) {
                System.out.println("Shortest path to " + dstCity.getName() + ": " + currentPath.getDist() + " minutes");
                printPath(currentPath);
                return;
            }

            if (done[currentCity.id] == null) {
                done[currentCity.id] = currentPath;

                Connections neighbors = currentCity.getNeighbors();
                for (int i = 0; i < neighbors.size(); i++) {
                    Connection connection = neighbors.get(i);
                    City neighbor = connection.getNeighbor();
                    int newDist = currentPath.getDist() + connection.getDistance();

                    if (done[neighbor.id] == null) {
                        queue.enqueue(new Path(neighbor, currentCity, newDist));
                    }
                }
            }
        }

        System.out.println("No path found from " + startCity + " to " + destinationCity);
    }

    private void printPath(Path path) {
        if (path.getPrev() != null) {
            printPath(done[path.getPrev().id]);
        }
        System.out.print(path.getCity().getName() + " -> ");
    }

    public void resetDoneArray() {
        Arrays.fill(done, null); // Resets the 'done' array to null for a fresh start
    }

    public int countDoneEntries() {
        int count = 0;
        for (Path path : done) {
            if (path != null) count++;
        }
        return count;
    }
}