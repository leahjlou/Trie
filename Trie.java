
public interface Trie {

	/**
	 * Adds the specified word to the trie (if necessary) and increments the word's frequency count
	 * 
	 * @param word The word being added to the trie
	 */
	void add(String word);
	
	/**
	 * Searches the trie for the specified word
	 * 
	 * @param word The word being searched for
	 * 
	 * @return A reference to the trie node that represents the word,
	 * 			or null if the word is not in the trie
	 */
	
	Node find(String word);
	
	/**
	 * Returns the number of unique words in the trie
	 * 
	 * @return The number of unique words in the trie
	 */
	
	int getWordCount();
	
	/**
	 * Returns the number of nodes in the trie
	 * 
	 * @return The number of nodes in the trie
	 */
	
	int getNodeCount();

	interface Node {
	
		/**
		 * Returns the frequency count for the word represented by the node
		 * 
		 * @return The frequency count for the word represented by the node
		 */
		int getValue();
	}
	
	
}
