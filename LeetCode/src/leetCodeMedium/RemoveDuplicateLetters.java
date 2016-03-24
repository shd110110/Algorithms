/**
 * Dec 9, 2015
 * Poirot
 * 10:31:51 AM
 * LeetCode
 */
package leetCodeMedium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Poirot
 *
 */
public class RemoveDuplicateLetters {
	// my first solution - 31ms
//	public String removeDuplicateLetters(String s) {
//		Set<Character> toAppearInResult = new HashSet<>();
//		for (int i = 0; i < s.length(); i++) {
//			toAppearInResult.add(s.charAt(i));
//		}
//		StringBuilder sBuilder = new StringBuilder();
//		int beginIndex = 0;
//		Set<Character> alreadyAppeared = new HashSet<>();
//		while (alreadyAppeared.size() < toAppearInResult.size()) {
//			int theEndIndex = s.length() - 1;
//			Set<Character> unAppear = new HashSet<>();
//			for (int j = s.length() - 1; j >= beginIndex; j--) {
//				if (!alreadyAppeared.contains(s.charAt(j))) {
//					unAppear.add(s.charAt(j));
//					if (unAppear.size() == toAppearInResult.size() - alreadyAppeared.size()) {
//						theEndIndex = j;
//						break;
//					}
//				}
//			}
//			char minChar = 128;
//			int minIndex = -1;
//			for (int j = beginIndex; j <= theEndIndex; j++) {
//				if (minChar > s.charAt(j) && !alreadyAppeared.contains(s.charAt(j))) {
//					minChar = s.charAt(j);
//					minIndex = j;
//				}
//
//			}
//			beginIndex = minIndex + 1;
//			sBuilder.append(minChar);
//
//			alreadyAppeared.add(minChar);
//		}
//		return sBuilder.toString();
//	}

	// my second solution -- 18ms inspired by other's solution
	public String removeDuplicateLetters(String s) {
		HashMap<Character, Integer> toAppearInResult = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			toAppearInResult.put(s.charAt(i), i);

		}
		StringBuilder sBuilder = new StringBuilder();
		int beginIndex = 0;
		 
		while (toAppearInResult.size() > 0) {
			int theEndIndex = s.length() - 1;

			for (Character key : toAppearInResult.keySet()) {
				if (toAppearInResult.get(key) < theEndIndex) {
					theEndIndex = toAppearInResult.get(key);
				}
			}
			char minChar = 128;
			int minIndex = -1;
			for (int j = beginIndex; j <= theEndIndex; j++) {
				if (minChar > s.charAt(j) && toAppearInResult.containsKey(s.charAt(j))) {
					minChar = s.charAt(j);
					minIndex = j;
				}

			}
			beginIndex = minIndex + 1;
			sBuilder.append(minChar);
			toAppearInResult.remove(minChar);
		}
		return sBuilder.toString();
	}

	// most votes -- 36ms
	// public String removeDuplicateLetters(String s) {
	// int[] cnt = new int[26];
	// int pos = 0; // the position for the smallest s[i]
	// for (int i = 0; i < s.length(); i++)
	// cnt[s.charAt(i) - 'a']++;
	// for (int i = 0; i < s.length(); i++) {
	// if (s.charAt(i) < s.charAt(pos))
	// pos = i;
	// if (--cnt[s.charAt(i) - 'a'] == 0)
	// break;
	// }
	// return s.length() == 0 ? "" : s.charAt(pos) +
	// removeDuplicateLetters(s.substring(pos + 1).replaceAll("" +
	// s.charAt(pos), ""));
	// }

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveDuplicateLetters t = new RemoveDuplicateLetters();
		System.out.println(t.removeDuplicateLetters("cbacdcbc"));
	}

}
