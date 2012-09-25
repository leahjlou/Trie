


public class Words implements Trie 
{
	private int wordCount;
	private int nodeCount;
	private MyTrieNode rootNode;
	private int totalWordCount;

	Words()
	{
		wordCount = 0;
		totalWordCount = 0;
		nodeCount = 1;
		rootNode = new MyTrieNode();
	}

	public void print()
	{
		rootNode.print("");
	}
	
	public String toString()
	{
		//return String.format("Word count: %d\nNode count: %d\n", wordCount, nodeCount);
		return rootNode.toString("", new StringBuilder());
	}
	
	public void add(String word)
	{
		if (this.find(word) == null)
		{
			wordCount++;
		}
		totalWordCount++;
		rootNode.add(word);
	}

	public MyTrieNode find (String word) 
	{
		return rootNode.find(word);
	}

	public int getWordCount() 
	{ 
		return wordCount;
	}

	public int getNodeCount() 
	{
		return nodeCount;
	}

	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (getClass() != o.getClass())
			return false;
		Words other = (Words)o;
		if (nodeCount != other.nodeCount || wordCount != other.wordCount)
			return false;
		else
			return rootNode.equals(other.rootNode, true);
	}
	
	public int hashCode()
	{
		int result = (wordCount*nodeCount*totalWordCount);
		return result;
	}
	
	public class MyTrieNode implements Trie.Node 
	{
		//private String 
		//char letter;
		private int count;
		MyTrieNode[] arr;
		//'a' - 97 = 0
		//'z' - 97 = 25

		MyTrieNode ()
		{
			//letter = c;
			count = 0;
			arr = new MyTrieNode[26];
		}

		public void print(String prefix) 
		{
			if (this.count > 0)
			{
				System.out.println(prefix);
			}
			for (int i = 0; i<26; i++)
			{
				if (arr[i] != null)
				{
					arr[i].print(prefix + ((char)(i+97)));
				}
			}
		}
		
		//TESTED: minimally
		public MyTrieNode find(String word) 
		{
			//System.out.println("finding " + word);
			//System.out.println("current node's count is " + count);
			if (word.length()==0)
			{
				if (count > 0)
					return this;
				else
					return null;
			}
			int letterIndex = word.charAt(0)-97;
			
			if (arr[letterIndex] != null && word.length()>1)
			{
				return arr[letterIndex].find(word.substring(1));
			}
			else if (arr[letterIndex] != null && word.length()==1)
			{
				return arr[letterIndex].find("");
			}
			return null;
		}
		
		//TESTED[x]
		public void add(String word) 
		{
			int letterIndex = word.charAt(0)-97;
			//System.out.println("BEGIN: adding " + word + " to spot " + letterIndex);
			if (arr[letterIndex] == null)
			{
				//System.out.println("creating a new node for " + word.charAt(0));
				arr[letterIndex] = new MyTrieNode();
				nodeCount++;
			}
			
			if (word.length() == 1)
			{
				//the last letter of the word: means it is actually a word
				//System.out.println("end of word! adding to count of node: " + this.getChar());
				
				//i need to add to the count of the NEXT node, but it's not letting me
				arr[letterIndex].incCount();
				return;
			}
			else
			{
				//calls it on the substring without the first letter
				//System.out.println("recursing on  " + word.substring(1) + " calling node " + arr[letterIndex].getChar());
				arr[letterIndex].add(word.substring(1));
			}
			
		}

		public int getValue() 
		{
			return count;
		}
		
		//TESTED: minimally
		public boolean equals(Object o, boolean result)
		{
			//System.out.println("CALLED EQUALS ON NODE WITH COUNT " + count);
			if (this == o)
				return true;
			if (o == null)
				return false;
			if (getClass() != o.getClass())
				return false;
			//boolean result = true;
			MyTrieNode other = (MyTrieNode)o;
			if (count != other.count)
			{
				//System.out.println("Count: " + count + ", otherCount: " + other.count + ". returning false");
				return false;
			}
			
			for (int i = 0; i < 26; i++)
			{
				//System.out.println("checking letter: " + (char)(i+97));
				if (arr[i] == null && other.arr[i] != null)
				{
					//System.out.println("node at spot " + (char)(i+97) + " of first node == null; of second node had something");
					result = false;
				}
				if (arr[i] != null && other.arr[i] == null)
				{
					//System.out.println("node at spot " + (char)(i+97) + " of first node had something; of second node == null");
					result = false;
				}
				if (arr[i] != null && other.arr[i] != null)
				{
					//System.out.println("node at spot " + (char)(i+97) + " of both nodes had something; recursing");
					result = arr[i].equals(other.arr[i], result);
					//if (result == false)
					//{
					//	return false;
					//}
				}
				//return true;
			}
			//System.out.println("returning result");
			return result;
		}
		
		public String toString(String prefix, StringBuilder sb)
		{
			//StringBuilder sb = new StringBuilder();
			if (this.count > 0)
			{
				sb.append(prefix + " " + count + "\n");
			}
			for (int i = 0; i<26; i++)
			{
				if (arr[i] != null)
				{
					arr[i].toString(prefix + ((char)(i+97)), sb);
				}
			}
			return sb.toString();
		}
		
		//public char getChar()
		//{
		//	return letter;
		//}
		public void incCount()
		{
			//System.out.println("Incrementing count of node: " + this.getChar());
			count++;
		}
	}


}


