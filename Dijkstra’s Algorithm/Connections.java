package Dijkstra;

import java.util.Arrays;

public class Connections {
    private Connection[] array;
    private int size; // Current number of elements

    public Connections() {
        this.array = new Connection[10]; // Start with an initial small array size
        this.size = 0;
    }

    public void add(Connection value) {
        if (size == array.length) {
            resize(); // Resize the array if it's full
        }
        array[size] = value; // Append the new element
        size++; // Increment the size
    }

    private void resize() {
        int newSize = array.length * 2; // Double the size
        array = Arrays.copyOf(array, newSize); // Create a new array and copy elements
    }

    public int size() {
        return size;
    }

    public Connection get(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid Index");
        }
        return array[index];
    }
}