
/**
* 2015年7月6日
* CH
*/
package leetCodeHard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author CH
 *
 */
public class SubstringwithConcatenationofAllWords {
	
	// 超时
//	public int hash(String string){
//		int res = 0;
//		for (int i = 0; i < string.length(); i++) {
//			res = res * string.charAt(i) + i;
//		}
//		return res;
//	}
//	public List<Integer> findSubstring2(String S, String[] L) {
//		int totalHash = 0;
//		for (int i = 0; i < L.length; i++) {
//			totalHash += hash(L[i]);
//		}
//		
//		List<Integer> res = new ArrayList<>();
//		for (int i = 0; i <= S.length() - L[0].length() * L.length; i++) {
//			int tempHash = 0;
//			for (int j = i; j < i + L[0].length() * L.length; j += L[0].length()) {
//				 
//				tempHash += hash(S.substring(j, j + L[0].length()));
//			}
//			if (tempHash == totalHash) {
//				res.add(i);
//			}
//		}
//		return res;
//	}
	
	
	
	
	

	// other's idea also use Trie
	static class TrieNode {
		int value = 0;
		Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
	}

	TrieNode trie;

	// build a trie tree
	public List<Integer> findSubstring(String S, String[] L) {
		trie = buildTrie(L);
		// System.out.println(trie.children.size() + " " + trie.value);
		int length = getTotalLength(L);
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i <= S.length() - length; i++) {
			if (isSubString(S, i, i + length))
				result.add(i); // space M * N, N = L.length * singleStringLength
		}
		return result;
	}

	private int getTotalLength(String[] L) {
		int sum = 0;
		for (String l : L)
			sum += l.length();
		return sum;
	}

	private TrieNode buildTrie(String[] L) {
		TrieNode root = new TrieNode();
		for (String l : L)
			addWord(root, l);
		return root;
	}

	private void addWord(TrieNode root, String s) {
		TrieNode node = root;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			TrieNode next = node.children.get(c);
			if (next == null) {
				next = new TrieNode();
				node.children.put(c, next);
			}
			node = next;
		}
		node.value++; // leaf
	}

	private boolean isSubString(String S, int start, int end) {
		if (start == end)
			return true;
		// search in the trie tree
		TrieNode node = trie;
		for (int i = start; i < end; i++) {
			char c = S.charAt(i);
			if (node.children.get(c) == null)
				return false;
			node = node.children.get(c);
			if (node.value > 0) { // leaf & can be used
				node.value--; // mark as used
//				System.out.println(S.substring(i + 1, end));
				if (isSubString(S, i + 1, end)) {
					node.value++; // mark as unused
					return true;
				}
				node.value++; // mark as unused
			}
		}
		return false;
	}

	// My first solution use Trie in the begin accept but after the speeding it
	// got a TLE
	// maybe it got some new tests, but the idea is not well ,so go optimising
	// it
	// class TrieNode {
	// TrieNode[] childen;
	// char ch;
	// boolean mark;
	//
	// public TrieNode() {
	// childen = new TrieNode[26];
	// }
	// }
	//
	// public class Trie {
	// private TrieNode root;
	//
	// public Trie() {
	// root = new TrieNode();
	// }
	//
	// // Inserts a word into the trie.
	// public void insert(String word) {
	// if (word == null || word.length() == 0) {
	// return;
	// }
	// if (search(word)) {
	// return;
	// } else {
	// TrieNode temp = root;
	// char first = word.charAt(0);
	// for (int i = 0; i < word.length(); i++) {
	// first = word.charAt(i);
	// if (temp.childen[first - 'a'] == null) {
	// temp.childen[first - 'a'] = new TrieNode();
	// temp.childen[first - 'a'].ch = first;
	// }
	// temp = temp.childen[first - 'a'];
	// }
	// temp.mark = true;
	// }
	// }
	//
	// // Returns if the word is in the trie.
	// public boolean search(String word) {
	// if (word.length() == 0 || word == null) {
	// return true;
	// }
	// TrieNode temp = root;
	// char first = word.charAt(0);
	// for (int i = 0; i < word.length(); i++) {
	// first = word.charAt(i);
	// if (temp.childen[first - 'a'] == null) {
	// return false;
	// }
	// temp = temp.childen[first - 'a'];
	// }
	// return temp.mark;
	// }
	//
	// // Returns if there is any word in the trie
	// // that starts with the given prefix.
	// public boolean startsWith(String prefix) {
	// if (prefix.length() == 0 || prefix == null) {
	// return true;
	// }
	// TrieNode temp = root;
	// for (int i = 0; i < prefix.length(); i++) {
	// char first = prefix.charAt(i);
	// if (temp.childen[first - 'a'] == null) {
	// return false;
	// }
	// temp = temp.childen[first - 'a'];
	// }
	// return true;
	// }
	//
	// }
	//
	// public List<Integer> findSubstring(String s, String[] words) {
	// List<Integer> result = new ArrayList<>();
	// if (words.length == 0) {
	// return result;
	// }
	// if (s.length() < words.length * words[0].length()) {
	// return result;
	// }
	// // HashMap<String, Integer> stringMap = new HashMap<String, Integer>();
	// Trie trie = new Trie();
	// HashMap<String, Integer> map = new HashMap<>();
	// for (String word : words) {
	// trie.insert(word);
	// map.put(word, map.containsKey(word) ? map.get(word) + 1 : 1);
	// }
	// int lengthOfWord = words[0].length();
	// int beign = 0;
	// while (beign <= s.length() - lengthOfWord * words.length) {
	// int tempBegin = beign;
	// HashMap<String, Integer> map2 = new HashMap<String, Integer>();
	// int count = 0;
	// while (tempBegin <= s.length() - lengthOfWord) {
	// String tempString = s.substring(tempBegin, tempBegin + lengthOfWord);
	// if (!trie.search(tempString)) {
	// break;
	// }
	// map2.put(tempString, map2.containsKey(tempString) ? map2.get(tempString)
	// + 1 : 1);
	// int number = map2.get(tempString);
	// if (number > map.get(tempString)) {
	// break;
	// }
	// count++;
	// if (count == words.length) {
	// result.add(beign);
	// break;
	// }
	// tempBegin += lengthOfWord;
	// }
	// beign++;
	// }
	// return result;
	// }

	
	
	
	
	// public List<Integer> findSubstring(String s, String[] words) {
	//
	// List<Integer> ans = new ArrayList<>();
	//
	// int n = s.length(), cnt = words.length;
	// if (n <= 0 || cnt <= 0)
	// return ans;
	//
	// // init word occurence
	// HashMap<String, Integer> dict = new HashMap<>();
	// for (int i = 0; i < cnt; ++i)
	// dict.put(words[i], dict.containsKey(words[i]) ? dict.get(words[i]) + 1 :
	// 1);
	//
	// // travel all sub string combinations
	// int wl = words[0].length();
	// for (int i = 0; i < wl; ++i) {
	// int left = i, count = 0;
	// // System.out.println("test");
	// HashMap<String, Integer> tdict = new HashMap<>();
	// for (int j = i; j <= n - wl; j += wl) {
	// String str = s.substring(j, j + wl);
	// // a valid word, accumulate results
	// if (dict.containsKey(str)) {
	// tdict.put(str, tdict.containsKey(str) ? tdict.get(str) + 1 : 1);
	// if (tdict.get(str) <= dict.get(str))
	// count++;
	// else {
	// // a more word, advance the window left side possiablly
	// while (tdict.get(str) > dict.get(str)) {
	// String str1 = s.substring(left, left + wl);
	// tdict.put(str1, tdict.get(str1) - 1);
	//
	// if (tdict.get(str1) < dict.get(str1))
	// count--;
	// left += wl;
	// }
	// }
	// // come to a result
	// if (count == cnt) {
	// ans.add(left);
	// // for (String key : tdict.keySet()) {
	// // System.out.println(key + " : " + tdict.get(key));
	// // }
	// // advance one word
	// tdict.put(s.substring(left, left + wl), tdict.get(s.substring(left, left
	// + wl)) - 1);
	// // System.out.println(tdict.get(s.substring(left, left +
	// // wl)));
	// count--;
	// left += wl;
	// }
	// }
	// // not a valid word, reset all vars
	// else {
	// tdict.clear();
	// count = 0;
	// left = j + wl;
	// }
	// }
	// }
	//
	// return ans;
	// }

	
	
	
	
	// public List<Integer> findSubstring(String s, String[] words) {
	// List<Integer> result = new ArrayList<>();
	// if (words.length == 0) {
	// return result;
	// }
	// if (s.length() < words.length * words[0].length()) {
	// return result;
	// }
	// // HashMap<String, Integer> stringMap = new HashMap<String, Integer>();
	//// Trie trie = new Trie();
	// HashMap<String, Integer> map = new HashMap<>();
	// for (String word : words) {
	//// trie.insert(word);
	// map.put(word, map.containsKey(word)?map.get(word)+1:1);
	// }
	// int singleLength = words[0].length();
	// int beign = 0;
	// while (beign <= (s.length() - singleLength * words.length)) {
	// HashMap<String, Integer> map2 = new HashMap<String, Integer>(map);
	// for (int i = 0; i < words.length; i++) {
	// String tempString = s.substring(beign+i*singleLength, beign +
	// (i+1)*singleLength);
	// if (map2.containsKey(tempString)) {
	// int number = map2.get(tempString);
	// if (number == 1) {
	// map2.remove(tempString);
	// }else {
	// map2.put(tempString, number-1);
	// }
	// if (map2.isEmpty()) {
	// result.add(beign);
	// break;
	// }
	// } else {
	// break;
	// }
	// }
	// beign++;
	// }
	// return result;
	// }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubstringwithConcatenationofAllWords t = new SubstringwithConcatenationofAllWords();
		// String s = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
		String s = "dbarfoofoobarthefoobarman";
//		s = "barfoo";
		// String s = "barfoothefoobarman";
		// String s = "barfoofoobarthefoobarman";
		// String[] words = { "bar", "foo", "the" };
		// String[] words = { "fooo", "barr", "wing", "ding", "wing" };
		String[] words = { "bar", "foo", "the" };
		// String[] words = {
		// "ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba"};
		List<Integer> result = t.findSubstring(s, words);
		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i) + "  ");
		}
	}

}