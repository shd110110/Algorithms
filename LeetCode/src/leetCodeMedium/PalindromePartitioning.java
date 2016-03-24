package leetCodeMedium;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Poirot 2015年7月2日
 */
public class PalindromePartitioning {
	// List<List<String>> result = new ArrayList<>();
	// public List<List<String>> partition(String s) {
	// return forCall(s);
	// }
	//
	// public List<List<String>> forCall(String s) {
	// List<List<String>> result = new ArrayList<>();
	// if (s == null || s.length() == 0) {
	// List<String> list = new LinkedList<>();
	// result.add(list);
	// return result;
	// }
	// if (s.length() == 1) {
	// List<String> list = new LinkedList<>();
	// list.add(s);
	// result.add(list);
	// return result;
	// }
	// for (int i = 1; i <= s.length(); i++) {
	// String headString = s.substring(0, i);
	// if (isPalindrome(headString)) {
	// for (List<String> list : forCall(s.substring(i, s.length()))) {
	// ((LinkedList<String>) list).addFirst(headString);
	// result.add(list);
	// }
	// }
	// }
	// return result;
	// }
	//
	// public boolean isPalindrome(String string) {
	// if (string == null) {
	// return true;
	// }
	// int begin = 0;
	// int end = string.length() - 1;
	// while (begin < end) {
	// if (string.charAt(begin) != string.charAt(end)) {
	// return false;
	// }
	// begin++;
	// end--;
	// }
	// return true;
	// }

	// MV'S Solution
	List<List<String>> resultLst = new ArrayList<List<String>>();;
	LinkedList<String> currLst = new LinkedList<String>();

	public List<List<String>> partition(String s) {
		dfs(s, 0);
		return resultLst;
	}

	public void dfs(String s, int l) {
		if (currLst.size() > 0 // the initial str could be palindrome
				&& l >= s.length()) {
			List<String> r = (LinkedList<String>) currLst.clone();
			resultLst.add(r);
		}
		for (int i = l; i < s.length(); i++) {
			if (isPalindrome(s, l, i)) {
				if (l == i)
					currLst.add(Character.toString(s.charAt(i)));
				else
					currLst.add(s.substring(l, i + 1));
				dfs(s, i + 1);
				currLst.remove(currLst.size() - 1);
			}
		}
	}

	public boolean isPalindrome(String str, int left, int right) {
		if (left == right) {
			return true;
		}
		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
	public class Solution {
		List<List<String>> resultLst;
		ArrayList<String> currLst;

		public List<List<String>> partition(String s) {
			resultLst = new ArrayList<List<String>>();
			currLst = new ArrayList<String>();
			backTrack(s, 0);
			return resultLst;
		}

		public void backTrack(String s, int l) {
			if (currLst.size() > 0 // the initial str could be palindrome
					&& l >= s.length()) {
				List<String> r = (ArrayList<String>) currLst.clone();
				resultLst.add(r);
			}
			for (int i = l; i < s.length(); i++) {
				if (isPalindrome(s, l, i)) {
					if (l == i)
						currLst.add(Character.toString(s.charAt(i)));
					else
						currLst.add(s.substring(l, i + 1));
					backTrack(s, i + 1);
					currLst.remove(currLst.size() - 1);
				}
			}
		}

		public boolean isPalindrome(String str, int l, int r) {
			if (l == r)
				return true;
			while (l < r) {
				if (str.charAt(l) != str.charAt(r))
					return false;
				l++;
				r--;
			}
			return true;
		}
	}

	// 动态规划
//	public static List<List<String>> partition(String s) {
//		int len = s.length();
//		List<List<String>>[] result = new List[len + 1];
//		result[0] = new ArrayList<List<String>>();
//		result[0].add(new ArrayList<String>());
//
//		boolean[][] pair = new boolean[len][len];
//		for (int i = 0; i < s.length(); i++) {
//			result[i + 1] = new ArrayList<List<String>>();
//			for (int left = 0; left <= i; left++) {
//				if (s.charAt(left) == s.charAt(i) && (i - left <= 1 || pair[left + 1][i - 1])) {
//					pair[left][i] = true;
//					String str = s.substring(left, i + 1);
//					for (List<String> r : result[left]) {
//						List<String> ri = new ArrayList<String>(r);
//						ri.add(str);
//						result[i + 1].add(ri);
//					}
//				}
//			}
//		}
//		return result[len];
//	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromePartitioning t = new PalindromePartitioning();
		System.out.println(Calendar.getInstance().getTime());
		List<List<String>> result = t.partition("aaaaaaaaaaaaaaaaaaaaaa");
		System.out.println(Calendar.getInstance().getTime());
		System.out.println(Math.pow(2, 22));
//		System.out.println(t.a);
		// System.out.println(t.isPalindrome("aa"));
		System.out.println(result.size());
		// for (int i = 0; i < result.size(); i++) {
		// for (int j = 0; j < result.get(i).size(); j++) {
		// System.out.print(result.get(i).get(j) + " ");
		// }
		// System.out.println();
		// }
		//
		// List<List<String>> result = new ArrayList<>();
		// List<String> temp = new ArrayList<>();
		// temp.add("hello");
		// result.add(temp);
		// for (List<String> list : result ) {
		// list.add("world");
		// }
		// System.out.println(temp.size());
	}

}
