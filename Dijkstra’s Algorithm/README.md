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
