package Dijkstra;

public class City {
    private String name;
    public Integer id;   // The integer identifier of the city as index
    public Connections neighbors; // Dynamic array for connections

    public City(String name, Integer id) {
        this.name = name;
        this.id = id;
        this.neighbors = new Connections();
    }

    public String getName() {
        return name;
    }

    // Connect this city to another city with a distance
    public void connect(City destination, int distance) {
        neighbors.add(new Connection(destination, distance));
    }

    public Connections getNeighbors() {
        return neighbors;
    }
}