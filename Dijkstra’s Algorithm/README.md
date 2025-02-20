Shortest Path Finder Using Dijkstra’s Algorithm


This project implements Dijkstra’s algorithm to efficiently determine the shortest path between cities in a weighted graph. Building on a previous graph-based assignment, where Depth-First Search (DFS) was used to explore paths, this implementation significantly improves efficiency by leveraging Dijkstra’s greedy approach to always expand the shortest known paths first.

Features
- Graph Representation: Cities and connections are modeled as a weighted graph.
- Dijkstra’s Algorithm: Computes the shortest route between two cities based on path distances.
- Performance Benchmarking: Compares the efficiency of Dijkstra’s algorithm against the previous DFS approach.
- Optimized Data Structures: Uses a priority queue to ensure efficient node expansion.

Implementation Details
- Graph and Node Classes: Represent cities and their connections, reusing and optimizing structures from the previous Graph assignment.
- Priority Queue: Ensures efficient selection of the next shortest path.
- Path Reconstruction: Stores and retrieves the optimal route once Dijkstra’s algorithm completes.



Structure of the implemented algorithm 

`City.java` : Represents each city, storing its name, a unique identifier (id), and a dynamic array of neighboring cities. This array is managed by the Connections class, which acts as a dynamic array.

`Connection.java` : Represents a link to a neighboring city, storing the distance required to reach it. Each Connection object has two main attributes: the neighboring City and the distance.

`Path.java` class: Represents a step in the route from the origin city to the current city. It stores the current city, the previous city, and the total distance traveled from the origin.

`PriorityQueue.java` : A basic priority queue that uses a linked list to keep Path objects in order based on their distance. Each item in the queue has a Path, and the list is arranged so that the path with the smallest distance is always at the front.

`Connections.java` : A simple dynamic array used to store Connection objects, representing links between cities.

`CityHashTable.java` : Stores cities by name for quick lookups. It uses an array of linked lists to handle collisions when multiple cities have the same hash value.

`Map` : Reads city data from a file and creates a map of cities connected by distances. Each line in the file represents a connection between two cities with a specified distance, which the class uses to build this city graph.

`DijkstraAlgorithm.java` : Finds the shortest path between two cities using Dijkstra’s algorithm.
