package Dijkstra;

public class PriorityQueue {
    private Node head; // The head of the linked list
    private int size;  // Current number of elements in the queue

    private static class Node {
        Path path;
        Node next;

        Node(Path path) {
            this.path = path;
            this.next = null;
        }
    }

    public PriorityQueue() {
        head = null;
        size = 0;
    }

    public void enqueue(Path path) {
        Node newNode = new Node(path);
        if (head == null || head.path.getDist() > path.getDist()) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                if (current.next.path.getDist() > path.getDist()) {
                    break;
                }
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    public Path dequeue() {
        if (head == null) {
            System.out.println("Priority queue is empty.");
            return null;
        }
        Path result = head.path;
        head = head.next;
        size--;
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}