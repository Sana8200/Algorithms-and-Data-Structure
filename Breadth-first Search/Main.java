package BFS;

public class Main {
    public static void main(String[] args) {
        // Create a sample tree with letters from A to O
        Node root = new Node("A"); // A
        root.left = new Node("B"); // B
        root.right = new Node("C"); // C
        root.left.left = new Node("D"); // D
        root.left.right = new Node("E"); // E
        root.right.left = new Node("F"); // F
        root.right.right = new Node("G"); // G
        root.left.left.left = new Node("H"); // H
        root.left.left.right = new Node("I"); // I
        root.left.right.left = new Node("J"); // J
        root.left.right.right = new Node("K"); // K
        root.right.left.left = new Node("L"); // L
        root.right.left.right = new Node("M"); // M
        root.right.right.left = new Node("N"); // N
        root.right.right.right = new Node("O"); // O

        // Create BFS object and perform BFS
        BFS bfsExample = new BFS();
        System.out.println("Breadth-First Search Traversal:");
        bfsExample.bfs(root); // Expected Output: A B C D E F G H I J K L M N O
    }
}