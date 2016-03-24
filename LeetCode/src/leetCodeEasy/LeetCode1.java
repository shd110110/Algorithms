package leetCodeEasy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class LeetCode1 {
	public static int[] twoSum(int[] numbers, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			Integer index1 = map.get(target - numbers[i]);
			if (index1 != null) {
				return new int[] { index1, i + 1 };
			}
			map.put(numbers[i], i + 1);
		}
		return null;
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0);
		ListNode p = result;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				p.next = l1;
				l1 = l1.next;
			} else {
				p.next = l2;
				l2 = l2.next;
			}
			p = p.next;
		}
		if (l1 == null) {
			p.next = l2;
		} else {
			p.next = l1;
		}
		return result.next;
	}

	public static int lengthOfLastWord(String s) {
		if (s.length() == 0)
			return 0;
		int i = s.length() - 1, j;
		while (i >= 0 && s.charAt(i) == ' ')
			i--;
		for (j = i; j >= 0; j--) {
			if (s.charAt(j) == ' ')
				break;
		}
		return i - j;
	}

	public static int removeElement(int[] A, int elem) {
		int distance = 0;
		int initialLength = A.length;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == elem) {
				distance++;
				continue;
			}
			A[i - distance] = A[i];
		}
		return initialLength - distance;
	}

	public static int removeDuplicates(int[] A) {
		int result = 0;
		TreeSet<Integer> temp = new TreeSet<>();
		for (int i = 0; i < A.length; i++) {
			temp.add(A[i]);
		}
		result = temp.size();
		for (int i = 0; i < result; i++) {
			A[i] = temp.pollFirst();
		}
		return result;

	}

	public static boolean isValid(String s) {

		if (s == null)
			return true;
		if (s.length() % 2 != 0)
			return false;
		Stack<Character> temp = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
				temp.push(s.charAt(i));
			else if (s.charAt(i) == ')' || s.charAt(i) == ']'
					|| s.charAt(i) == '}') {
				if ((s.charAt(i) == ')' && temp.peek() == '(')
						|| (s.charAt(i) == ']' && temp.peek() == '[')
						|| (s.charAt(i) == '}' && temp.peek() == '{')
						&& !temp.isEmpty())
					temp.pop();
				else {
					return false;
				}
			}
		}
		return true;
	}

	public static List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> result = new ArrayList<>();
		if (num.length < 3) {
			return result;
		}
		Arrays.sort(num);

		int key = 0, findResult = 0;

		for (int i = 0; i < num.length - 2; i++) {
			if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
				for (int j = i + 1; j < num.length - 1; j++) {
					if (j == i + 1 || (j > i + 1) && num[j] != num[j - 1]) {
						key = num[i] + num[j];

						if (key > 0) {
							break;
						}
						key = -key;

						findResult = Arrays.binarySearch(num, j + 1,
								num.length, key);

						if (findResult >= 0) {
							ArrayList<Integer> temp = new ArrayList<>();
							temp.add(num[i]);
							temp.add(num[j]);
							temp.add(num[findResult]);
							result.add(temp);
						}
					}
				}
			}
		}
		return result;

	}

	public static int ladderLength(String start, String end, Set<String> dict) {
		return 0;
	}

	public static int trailingZeroes(int n) {
		return n < 5 ? 0 : n / 5 + trailingZeroes(n / 5);
	}

	public static int titleToNumber(String s) {
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			result = result * 26 + s.charAt(i) - 64;
		}
		return result;
	}

	public static int findMin(int[] num) {
		int left = 0;
		int right = num.length - 1;
		int mid = (left + right) / 2;
		boolean mark = false;
		while (left < right) {
			if (num[left] < num[right])
				return num[left];
			if (right - left == 1)
				return num[right];
			if (num[mid] > num[left]) {
				left = mid + 1;
			} else if (num[mid] < num[left]) {
				right = mid;
			} else {
				for (int i = left; i < mid; i++) {
					if (num[i] != num[mid]) {
						right = mid;
						left = i;
						mark = false;
						break;
					}
				}
				if (mark)
					left = mid;
			}
			mid = (left + right) / 2;
		}
		return num[mid];
	}

	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		int lengthOfA = 0;
		int lengthOfB = 0;

		ListNode temp = headA;
		while (headA != null) {
			lengthOfA++;
			headA = headA.next;
		}
		headA = temp;
		temp = headB;
		while (headB != null) {
			lengthOfB++;
			headB = headB.next;
		}
		headB = temp;
		if (lengthOfA > lengthOfB) {
			for (int j = 0; j < lengthOfA - lengthOfB; j++) {
				headA = headA.next;
			}
		} else {
			for (int i = 0; i < lengthOfB - lengthOfA; i++) {
				headB = headB.next;
			}
		}
		while (headA != null) {

			if (headA == headB) {
				return headA;
			}
			headA = headA.next;
			headB = headB.next;
		}
		return null;
	}

	public static int strStr(String haystack, String needle) {
		for (int i = 0;; i++) {
			for (int j = 0;; j++) {
				if (j == needle.length())
					return i;
				if (i + j == haystack.length())
					return -1;
				if (needle.charAt(j) != haystack.charAt(i + j))
					break;
			}
		}
	}

	public static int findPeakElement(int[] num) {
		if (num.length == 1) {
			return 0;
		}
		int left = 0;
		int right = num.length - 1;
		int mid = (left + right) / 2;

		while (left < right - 1) {
			if (num[mid] > num[mid - 1] && num[mid] > num[mid + 1]) {
				return mid;
			} else if (num[mid] <= num[left]) {
				right = mid;
			} else if (num[mid] <= num[right]) {
				left = mid;
			} else {
				if (num[mid] < num[mid - 1]) {
					right = mid;
				} else {
					left = mid;
				}
			}
			mid = (left + right) / 2;
		}
		if (num[left] < num[right]) {
			return right;
		} else {
			return left;
		}
	}

	public static int lengthOfLongestSubstring(String s) {
		int[] charMap = new int[256];
		Arrays.fill(charMap, -1);
		int i = 0;
		int maxLength = 0;
		for (int j = 0; j < s.length(); j++) {
			if (charMap[s.charAt(j)] >= i) {
				i = charMap[s.charAt(j)] + 1;
			}
			charMap[s.charAt(j)] = j;
			maxLength = Math.max(j - i + 1, maxLength);
		}
		return maxLength;
	}

	public static int _findOfCH(int A[], int m, int B[], int n, int k) {
		if (k == 0) {
			return A[0] <= B[0] ? A[0] : B[0];
		}
		int l = 0, h = m - 1;
		int mid = l + (h - l) / 2;
		while (l <= h) {
			mid = l + (h - l) / 2; // A[mid], mid elements at the left side
									// in A.
			// k-mid elements at the left side in B.
			if (k - mid < 0) {
				h = mid - 1;
			} else if (k - mid == 0) {
				if (B[0] >= A[mid]) {

					return A[mid];
				} else {
					h = mid - 1;
				}
			} else if (k - mid > n) {
				l = mid + 1;
			} else if (k - mid == n) {
				if (A[mid] >= B[n - 1]) {

					return A[mid];
				} else {
					l = mid + 1;
				}
			} else {
				if (A[mid] >= B[k - mid - 1] && A[mid] <= B[k - mid]) {

					return A[mid];
				} else if (A[mid] < B[k - mid - 1]) {
					l = mid + 1;
				} else {
					h = mid - 1;
				}
			}
		}

		return Integer.MIN_VALUE;
	}

	public static int findOfCH(int A[], int m, int B[], int n, int k) {

		int v = _findOfCH(A, m, B, n, k); // Try to search in A.
		return (v > Integer.MIN_VALUE) ? v : _findOfCH(B, n, A, m, k); // Search
																		// in B.
	}

	public static double findMedianSortedArrays(int A[], int B[]) {

		int m = A.length;
		int n = B.length;
		if (n == 0)
			return m % 2 == 1 ? A[m / 2] : (A[m / 2 - 1] + A[m / 2]) / 2.0;
		if (m == 0)
			return n % 2 == 1 ? B[n / 2] : (B[n / 2] + B[n / 2 - 1]) / 2.0;
		if ((m + n) % 2 == 1) {
			return findOfCH(A, m, B, n, (m + n) / 2);
		} else {
			return (findOfCH(A, m, B, n, (m + n) / 2) + findOfCH(A, m, B, n,
					(m + n) / 2 - 1)) / 2.0;
		}

	}

	public static String largestNumber(int[] num) {
		boolean m = false;
		for (int i = 0; i < num.length; i++) {
			if (num[i] != 0) {
				m = true;
			}
		}
		if (!m)
			return "0";
		String[] tempStrings = new String[num.length];
		for (int i = 0; i < num.length; i++) {
			tempStrings[i] = String.valueOf(num[i]);
		}
		Arrays.sort(tempStrings);
		for (int i = 0; i < tempStrings.length; i++) {
			System.out.print(tempStrings[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < tempStrings.length; i++) {
			for (int j = 0; j < tempStrings.length - i - 1; j++) {
				String temp1 = tempStrings[j] + tempStrings[j + 1];
				String temp2 = tempStrings[j + 1] + tempStrings[j];

				if (temp1.compareTo(temp2) > 0) {
					String temp = tempStrings[j];
					tempStrings[j] = tempStrings[j + 1];
					tempStrings[j + 1] = temp;
				}
			}
		}
		StringBuilder builder = new StringBuilder();
		for (int n = tempStrings.length - 1; n >= 0; n--) {
			builder.append(tempStrings[n]);
		}
		return builder.toString();
	}

	public static int calculateMinimumHP(int[][] dungeon) {
		int m = dungeon.length;
		int n = dungeon[0].length;
		int[][] minInitHealth = new int[m][n];
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (i == m - 1 && j == n - 1) {
					minInitHealth[i][j] = Math.max(1, 1 - dungeon[i][j]);
				} else if (i == m - 1) {
					minInitHealth[i][j] = Math.max(1, minInitHealth[i][j + 1]
							- dungeon[i][j]);
				} else if (j == n - 1) {
					minInitHealth[i][j] = Math.max(1, minInitHealth[i + 1][j]
							- dungeon[i][j]);
				} else {
					minInitHealth[i][j] = Math.max(
							1,
							Math.min(minInitHealth[i + 1][j],
									minInitHealth[i][j + 1]) - dungeon[i][j]);
				}
			}
		}
		return minInitHealth[0][0];
	}

	public static int compareVersion(String version1, String version2) {

		version1 = version1.replaceAll("^(0+)", "");
		version2 = version2.replaceAll("^(0+)", "");

		String[] v1 = version1.split("\\.");

		String[] v2 = version2.split("\\.");

		int minLength = Math.min(v1.length, v2.length);
		for (int i = 0; i < minLength; i++) {
			String tempString1 = v1[i].replaceAll("^(0+)", "");
			String tempString2 = v2[i].replaceAll("^(0+)", "");
			int tempLength1 = tempString1.length();
			int tempLength2 = tempString2.length();
			if (tempLength1 > 0 && tempLength2 > 0) {
				int temp1 = Integer.parseInt(tempString1);
				int temp2 = Integer.parseInt(tempString2);
				if (temp1 > temp2) {
					return 1;
				} else if (temp1 < temp2) {
					return -1;
				}
			} else if (tempLength1 > 0 && tempLength2 == 0) {
				return 1;
			} else if (tempLength1 == 0 && tempLength2 > 0) {
				return -1;
			}
		}
		if (v1.length > v2.length) {
			for (int i = minLength; i < v1.length; i++) {
				if (v1[i].replaceAll("^(0+)", "").length() != 0) {
					return 1;
				}
			}
			return 0;
		} else if (v1.length < v2.length) {
			for (int i = minLength; i < v2.length; i++) {
				if (v2[i].replaceAll("^(0+)", "").length() != 0) {
					return -1;
				}
			}
			return 0;
		} else {
			return 0;
		}
	}

	public static String convertToTitle(int n) {
		StringBuilder temp = new StringBuilder();
		while(n!=0){
			if (n%26>0) {
				temp.append(String.valueOf((char)(n%26-1+'A')));
				n/=26;
			}else{
				temp.append(String.valueOf('Z'));
				n= (n-26)/26;
			}

		}
		return temp.reverse().toString();
	}

	public static void main(String[] args) {

		/*
		 * List<String> a =
		 * findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"); for
		 * (int i = 0; i < a.size(); i++) { System.out.println(a.get(i)); }
		 * System.out.println("helloworld"); int[] temp = { 1, 6, 5, 4, 3, 2, 1
		 * }; System.out.println(findPeakElement(temp));
		 */
		// System.out.println(lengthOfLongestSubstring("abba"));
		// int[] a = { 93, 51, 65, 84, 91, 78, 99, 71, 97, 9 };
		// System.out.println(largestNumber(a));
		//
		// int[][] b = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };
		// System.out.println(calculateMinimumHP(b));

		System.out.println(compareVersion("1", "1.0"));
		System.out.println(convertToTitle(27));
	}
}
