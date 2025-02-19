package Trie;


import java.util.ArrayList;


public class T9 {
    Node root;

    public T9() {
        root = new Node();
    }

    // Add a word to the Trie
    public void add(String word) {
        Node current = root;
        word = word.toLowerCase();
        for (char c : word.toCharArray()) {
            int index = charToIndex(c);
            if (index == -1) continue;  // Skip invalid characters

            if (current.next[index] == null) {
                current.next[index] = new Node();
            }
            current = current.next[index];
        }
        current.valid = true;  // Mark the end of the word as valid
    }

    // Encode a word into a T9 key sequence
    private String encode(String word) {
        StringBuilder keySequence = new StringBuilder();
        for (char c : word.toCharArray()) {
            int key = charToKey(c);
            if (key != -1) {
                keySequence.append(key);
            }
        }
        return keySequence.toString();
    }



    // Decode a key sequence to find all possible words
    public ArrayList<String> decode(String input) {
        String sequence = encode(input.toLowerCase());
        return collect(input.toLowerCase(), root, sequence, "");
    }

    private ArrayList<String> collect(String inputStr, Node node, String keys, String topword) {
        ArrayList<String> result = new ArrayList<String>();
        if(node == null) {
            return result;
        }

        if(node.valid == true  && keys.length() == 0) {
            result.add(topword);
        }

        if(keys.length() == 0) {
            for(int node_idx = 0; node_idx < node.next.length; node_idx++ ) {
                result.addAll(collect("", node.next[node_idx],"",topword+decodeChar(node_idx)));
            }
            return result;
        }


        for(int index : keyToIndexes(keys.charAt(0))) {
            if(decodeChar(index) == inputStr.charAt(0)) {
                result.addAll(collect(inputStr.substring(1), node.next[index], keys.substring(1),topword+decodeChar(index)));
                break;
            }
        }
        return result;
    }


    private int charToIndex(char c) {
        switch (c) {
            case 'a': return 0;
            case 'b': return 1;
            case 'c': return 2;
            case 'd': return 3;
            case 'e': return 4;
            case 'f': return 5;
            case 'g': return 6;
            case 'h': return 7;
            case 'i': return 8;
            case 'j': return 9;
            case 'k': return 10;
            case 'l': return 11;
            case 'm': return 12;
            case 'n': return 13;
            case 'o': return 14;
            case 'p': return 15;
            case 'r': return 16;
            case 's': return 17;
            case 't': return 18;
            case 'u': return 19;
            case 'v': return 20;
            case 'x': return 21;
            case 'y': return 22;
            case 'z': return 23;
            case 'å': return 24;
            case 'ä': return 25;
            case 'ö': return 26;
            default: return -1;  // Invalid character
        }
    }

    // Helper method to convert character to T9 key (2-9)
    private int charToKey(char c) {
        switch (c) {
            case 'a': case 'b': case 'c': return 2;
            case 'd': case 'e': case 'f': return 3;
            case 'g': case 'h': case 'i': return 4;
            case 'j': case 'k': case 'l': return 5;
            case 'm': case 'n': case 'o': return 6;
            case 'p': case 'r': case 's': return 7;
            case 't': case 'u': case 'v': return 8;
            case 'x': case 'y': case 'z': return 9;
            case 'å': case 'ä': case 'ö': return 9;  // Swedish characters map to 9
            default: return -1;  // Invalid character
        }
    }

    // Map T9 key to indexes in the Trie
    private Integer[] keyToIndexes(char key) {
        switch (key) {
            case '2':
                return new Integer[] {charToIndex('a'), charToIndex('b'), charToIndex('c')};
            case '3':
                return new Integer[] {charToIndex('d'), charToIndex('e'), charToIndex('f')};
            case '4':
                return new Integer[] {charToIndex('g'), charToIndex('h'), charToIndex('i')};
            case '5':
                return new Integer[] {charToIndex('j'), charToIndex('k'), charToIndex('l')};
            case '6':
                return new Integer[] {charToIndex('m'), charToIndex('n'), charToIndex('o')};
            case '7':
                return new Integer[] {charToIndex('p'), charToIndex('r'), charToIndex('s')};
            case '8':
                return new Integer[] {charToIndex('t'), charToIndex('u'), charToIndex('v')};
            case '9':
                return new Integer[] {charToIndex('x'), charToIndex('y'), charToIndex('z'),
                    charToIndex('å'), charToIndex('ä'), charToIndex('ö')};
            default:
                return null;
        }
    }

    // Helper method to decode an index into a character
    private char decodeChar(int index) {
        switch (index) {
            case 0: return 'a';
            case 1: return 'b';
            case 2: return 'c';
            case 3: return 'd';
            case 4: return 'e';
            case 5: return 'f';
            case 6: return 'g';
            case 7: return 'h';
            case 8: return 'i';
            case 9: return 'j';
            case 10: return 'k';
            case 11: return 'l';
            case 12: return 'm';
            case 13: return 'n';
            case 14: return 'o';
            case 15: return 'p';
            case 16: return 'r';
            case 17: return 's';
            case 18: return 't';
            case 19: return 'u';
            case 20: return 'v';
            case 21: return 'x';
            case 22: return 'y';
            case 23: return 'z';
            case 24: return 'å';
            case 25: return 'ä';
            case 26: return 'ö';
            default: return ' ';  // Invalid index
        }
    }
}
