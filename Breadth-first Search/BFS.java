package BFS;

public class BFS {
    // Function to perform BFS
    public void bfs(Node root) {
        // Create a custom queue to hold the nodes to be explored
        Queue<Node> queue = new Queue<Node>();

        // Start with the root node
        queue.enqueue(root);

        while (queue.size() > 0) {
            // Remove the first node from the queue
            Node currentNode = queue.dequeue();
            // Print the current node's value
            System.out.print(currentNode.value + " ");

            // Add the left child to the queue if it exists
            if (currentNode.left != null) {
                queue.enqueue(currentNode.left);
            }

            // Add the right child to the queue if it exists
            if (currentNode.right != null) {
                queue.enqueue(currentNode.right);
            }
        }
    }
}
