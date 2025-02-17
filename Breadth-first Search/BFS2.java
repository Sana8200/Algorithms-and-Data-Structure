package BFS;

public class BFS2<T> {

    // Method to create a new sequence from the root node of the tree
    public Sequence sequence(Node<T> root) {
        return new Sequence(root);
    }

    // Class that represents the sequence (paused BFS traversal)
    public class Sequence {
        Queue<Node<T>> queue;

        // Initialize the sequence with the root node
        public Sequence(Node<T> root) {
            queue = new Queue<Node<T>>();
            if (root != null) {
                queue.enqueue(root); // Start with the root node
            }
        }

        // Method to return the next node's value in the sequence
        public T next() {
            if (queue.size() == 0) {
                return null; // Alternatively, throw an exception if no more elements
            }
            Node<T> currentNode = queue.dequeue();

            // Enqueue the left and right children, if they exist
            if (currentNode.left != null) {
                queue.enqueue(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.enqueue(currentNode.right);
            }

            // Return the value of the current node
            return currentNode.value;
        }

        // Method to check if there are more elements in the sequence
        public boolean hasNext() {
            return queue.size() > 0;
        }
    }
}