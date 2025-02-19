T9 Text Prediction using Trie

This repository contains a Java implementation of a simple T9 text prediction system using a Trie data structure. The goal of the project is to efficiently map words to their corresponding T9 key sequences and decode those sequences back into possible words.

📌 Project Overview

The T9 system was used in older mobile phones with numeric keypads, allowing users to type words by pressing number keys. This program replicates that behavior by:
1. Storing words in a Trie.
2. Converting words into T9 key sequences.
3. Decoding key sequences back into possible words.

📂 Project Structure

The project consists of three main Java classes:
- T9: The core class containing methods to insert words, generate T9 sequences, and decode sequences.
- Node: Represents each node in the Trie with an array for child nodes and a flag indicating if a word ends at that node.
- Main: A test class to verify the implementation.

🛠️ How It Works
1. A dictionary of words is stored in a Trie.
2. Each letter is mapped to a corresponding T9 key (e.g., ‘a’, ‘b’, ‘c’ → 2).
3. The system allows:
- Word to T9 conversion: Converts words into numeric key sequences.
- T9 to word prediction: Finds valid words matching a given numeric sequence.
