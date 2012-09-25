Trie interface: Trie.java
Implementation: words.java

This is a very basic (but working) implementation.

This trie basically only supports adding strings and checking if they exist.

A trie is a tree-based data structure designed to store sequences of characters.
Each node stores an array of other nodes, one for each letter in the alphabet.
Each node has a single parent (except for the root of the trie).
A string is stored as a path in the trie from the root.
Each node also stores a count. Nodes that contain the last character in a string
have one added to their count.

Note that strings themselves are never actually stored in the structure -- they 
are implicitly stored in the paths from node to node.