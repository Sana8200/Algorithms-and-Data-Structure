package Trie;

public class Node {
    public Node[] next;
    public boolean valid;

    public Node(){
        next = new Node[27];
        valid = false;
    }
}
