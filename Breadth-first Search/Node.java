package BFS;

class Node<T> {
    T value; // Now can hold any type
    Node<T> left;
    Node<T> right;

    Node(T value) {
        this.value = value;
        left = null;
        right = null;
    }
}
