/**
 * 2015年11月19日
 * Poirot
 */
package leetCodeEasy;

import java.util.HashMap;

/**
 * @author Poirot
 *
 */
public class WordPattern {
	public boolean wordPattern(String pattern, String str) {
		if (pattern == null || pattern.length() == 0) {
			if (str == null || str.split(" ").length == 0) {
				return true;
			} else {
				return false;
			}
		}
		String[] strings = str.split(" ");
		if (strings.length != pattern.length()) {
			return false;
		}
		HashMap<Character, String> mapPattern = new HashMap<>();
		HashMap<String, Character> mapPattern2 = new HashMap<>();
		for (int i = 0; i < pattern.length(); i++) {
			char key = pattern.charAt(i);
			String string = strings[i];
			if (mapPattern.containsKey(key)) {
				if (!string.equals(mapPattern.get(key))) {
					return false;
				}
			}
			if (mapPattern2.containsKey(string)) {
				if (key != (mapPattern2.get(string))) {
					return false;
				}
			}

			mapPattern.put(key, string);
			mapPattern2.put(string, key);

		}

		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordPattern t = new WordPattern();
		System.out.println(t.wordPattern("abba","dog dog dog dog"));
	}

}
