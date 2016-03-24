/**
 * 2015年11月29日
 * Poirot
 */
package leetCodeEasy;

import java.util.LinkedList;

/**
 * @author Poirot
 *
 */
public class ValidParentheses {
	public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
			return true;
		}
		LinkedList<Character> stack = new LinkedList<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '[' || s.charAt(i) == '(' || s.charAt(i) == '{') {
				stack.addFirst(s.charAt(i));
			} else {
				if (stack.isEmpty()) {
					return false;
				} else {
					char c = stack.removeFirst();
					if (s.charAt(i) == ')' && c != '(') {
						return false;
					} else if (s.charAt(i) == '}' && c != '{') {
						return false;
					} else if (s.charAt(i) == ']' && c != '[') {
						return false;
					} 
				}
			}
		}
		return stack.isEmpty();
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
