package leetCodeMedium;

/**
 * @author Poirot 2015年7月2日
 */
public class WordDictionary {
	private TrieNode root;

	public WordDictionary() {
		root = new TrieNode();
	}

	// Inserts a word into the trie.
	public void addWord(String word) {
		if (word == null || word.length() == 0) {
			return;
		}
		if (search(word)) {
			return;
		} else {
			TrieNode temp = root;
			char first = word.charAt(0);
			for (int i = 0; i < word.length(); i++) {
				first = word.charAt(i);
				if (temp.childen[first - 'a'] == null) {
					temp.childen[first - 'a'] = new TrieNode();
					temp.childen[first - 'a'].ch = first;
				}
				temp = temp.childen[first - 'a'];
			}
			temp.mark = true;
		}
	}

	// Returns if the word is in the trie.
	public boolean search(String word) {
		return search2(root, word);
	}

	public boolean search2(TrieNode node, String word) {
		if (word.length() == 0 || word == null) {
			if (node.mark == true) {
				return true;
			}
			else {
				return false;
			}
		}
		TrieNode temp = node;
		char first = word.charAt(0);
		for (int i = 0; i < word.length(); i++) {
			first = word.charAt(i);
			if (first == '.') {
				for (int j = 0; j < temp.childen.length; j++) {
					if (temp.childen[j] != null) { 
//						System.out.println(word.substring(i, word.length()));
//						if (word.length() == 1 && temp.childen[j].mark == true) {
//							return true;
//						}
						if (search2(temp.childen[j], word.substring(i+1, word.length()))) { 
							return true;
						}
					}
				}
				return false;
			} else if (temp.childen[first - 'a'] == null) {
				return false;
			}
			temp = temp.childen[first - 'a'];
		}
		return temp.mark;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordDictionary t = new WordDictionary();
		t.addWord("hello");
		System.out.println(t.search("....."));
	}

}
