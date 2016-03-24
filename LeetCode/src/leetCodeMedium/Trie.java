/**
 * 2015Äê7ÔÂ1ÈÕ
 * CH
 */
package leetCodeMedium;

/**
 * @author CH
 *
 */

public class Trie {
	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	// Inserts a word into the trie.
	public void insert(String word) {
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
		if (word.length() == 0 || word == null) {
			return true;
		}
		TrieNode temp = root;
		char first = word.charAt(0);
		for (int i = 0; i < word.length(); i++) {
			first = word.charAt(i);
			if (temp.childen[first - 'a'] == null) {
				return false;
			}
			temp = temp.childen[first - 'a'];
		}
		return temp.mark;
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix) {
		if (prefix.length() == 0 || prefix == null) {
			return true;
		}
		TrieNode temp = root;
		for (int i = 0; i < prefix.length(); i++) {
			char first = prefix.charAt(i);
			if (temp.childen[first - 'a'] == null) {
				return false;
			}
			temp = temp.childen[first - 'a'];
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie trie = new Trie();
		trie.insert("somestring");
		System.out.println(trie.search("somestring"));
		System.out.println(trie.startsWith("soam"));
		trie.insert("a");
		System.out.println(trie.search("a"));
		System.out.println(trie.startsWith("a"));
	}
	/**
	 * @param args
	 */

}
