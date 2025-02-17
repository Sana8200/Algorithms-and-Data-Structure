package BFS;

public class Queue<T> {
    Object[] queue;  // Use Object array for storage
    int front;
    int tail;
    int size;

    // Constructor to initialize the queue
    public Queue() {
        this.queue = new Object[2]; // Initial capacity of 2
        this.front = 0;
        this.tail = -1;
        this.size = 0;
    }

    // Method to add an element to the queue
    public void enqueue(T item) {
        if (size == queue.length) {
            sizeGrow(queue.length * 2); // Double the size if full
        }
        tail = (tail + 1) % queue.length; // Circular increment
        queue[tail] = item;
        size++;
    }

    // Method to remove and return the front element
    public T dequeue() {
        if (size == 0) {
            return null; // Alternatively, throw an exception
        }
        T item = (T) queue[front]; // Cast to T
        front = (front + 1) % queue.length; // Circular increment
        size--;
        return item;
    }

    // Method to get the current size of the queue
    public int size() {
        return size;
    }

    // Method to resize the queue
    private void sizeGrow(int newCapacity) {
        Object[] newQueue = new Object[newCapacity]; // Use Object array for new queue
        for (int i = 0; i < size; i++) {
            newQueue[i] = queue[(front + i) % queue.length];
        }
        queue = newQueue;
        front = 0;
        tail = size - 1; // Set the new tail index
    }
}
