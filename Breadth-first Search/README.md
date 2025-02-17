Breadth-First Search (BFS) Implementation in Java

This repository contains a Java implementation of the Breadth-First Search (BFS) algorithm for traversing a binary tree level by level. BFS ensures that all nodes at a given depth are visited before moving on to the next level, using a queue to manage the traversal order.

The implementation consists of several core classes:
1.	Node<T> – A generic node class representing each tree node with left and right child references. 
2.	Queue<T> – A custom dynamic queue implementation for managing nodes during BFS traversal. 
3.	BFS – The main class implementing the BFS algorithm using a queue. 
4.	Main – A test class that builds a sample tree and executes BFS to demonstrate traversal.
5.	BFS2<T> – A variation of BFS that includes the Sequence class to track node positions dynamically during traversal.
 

How It Works
1.	BFS Traversal:
   
- The search starts at the root node, which is enqueued.

- The algorithm dequeues a node, processes it, and enqueues its left and right children.

- This continues level by level until all nodes are visited.

2.	Queue Implementation:
   
- Uses an array-based dynamic queue to efficiently manage traversal order.

- Supports resizing when the queue reaches full capacity.

3.	Sequence Tracking (Optional in BFS2):
   
- Maintains a queue of nodes and extracts elements sequentially.

- Allows tracking traversal position dynamically.
