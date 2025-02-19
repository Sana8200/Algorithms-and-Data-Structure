package Trie;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Main{
    public static void main(String[] args) {
        T9 t9 = new T9();

        String filePath = "/Users/sana/Desktop/Assignment 8-B/src/Trie/kelly.txt";


        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String word;
            while ((word = br.readLine()) != null) {
                t9.add(word.toLowerCase()); // Add each word to the Trie
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            return;
        }

        String testWord = "cla";

        ArrayList<String> decodedWords = t9.decode(testWord);
        System.out.println("Decoded words for sequence '" + testWord + "': " + decodedWords);
    }
}