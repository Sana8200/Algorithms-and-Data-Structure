package Dijkstra;

public class Path {
    private City city;     // Current city in this path step
    private City prev;     // Previous city in the path leading to this city
    private int dist;      // Total distance from the origin city to this city

    public Path(City city, City prev, int dist) {
        this.city = city;
        this.prev = prev;
        this.dist = dist;
    }

    public City getCity() {
        return city;
    }

    public City getPrev() {
        return prev;
    }

    public int getDist() {
        return dist;
    }
}