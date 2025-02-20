package Dijkstra;

public class Connection {
    public City neighbor;
    public int distance; // Distance to the neighbor city

    public Connection(City neighbor, int distance) {
        this.neighbor = neighbor;
        this.distance = distance;
    }

    public City getNeighbor() {
        return neighbor;
    }

    public int getDistance() {
        return distance;
    }
}