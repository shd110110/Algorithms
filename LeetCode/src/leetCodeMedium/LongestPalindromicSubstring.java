package leetCodeMedium;

/**
 * @author Poirot 2015年11月24日
 */
public class LongestPalindromicSubstring {
	// 20160320  54ms 
//	public String longestPalindrome(String s) {
//		if (s == null || s.length() == 0) {
//			return s;
//		}
//		int start = 0;
//		int maxLength = 1;
//		for (int i = 0; i < s.length(); i++) {
//			if (i >= maxLength + 1 && s.substring(i - maxLength - 1, i + 1)
//					.equals(new StringBuilder(s.substring(i - maxLength - 1, i + 1)).reverse().toString())) {
//				start = i - maxLength - 1;
//				maxLength += 2;
//			}
//			if (i >= maxLength && s.substring(i - maxLength, i + 1)
//					.equals(new StringBuilder(s.substring(i - maxLength, i + 1)).reverse().toString())) {
//				start = i - maxLength;
//				maxLength += 1;
//			}
//		}
//		return s.substring(start, start + maxLength);
//	}
	
	// 20160320  18ms 
//	public String longestPalindrome(String s) {
//		if (s == null || s.length() <= 1) {
//			return s;
//		}
//		StringBuilder sb = new StringBuilder();
//		sb.append("$");
//		for (int i = 0; i < s.length(); i++) {
//			sb.append("#");
//			sb.append(s.charAt(i));
//		}
//		sb.append("#");
//		s = sb.toString();
//		int[] p = new int[s.length() + 1];
//		
//		int mx = 0, id = 0;
//		for (int i = 1; mx < s.length(); i++) {
//			
//			if (mx > i) {
//				p[i] = (p[2 * id - i] < (mx - i) ? p[2 * id - i] : (mx - i));
//			} else {
//				p[i] = 1;
//			}
//
//			while (i - p[i] >= 1 && i + p[i] < s.length() && s.charAt(i - p[i]) == s.charAt(i + p[i]))
//				p[i]++;
//
//			if (i + p[i] > mx) {
//				mx = i + p[i];
//				id = i;
//			}
//		}
//		int max = 0, medium = 0;
//		for (int i = 1; i < s.length(); i++) {
//			if (p[i] > max) {
//				medium = i;
//				max = p[i];
//			}
//		}
//
//		max--;
//
//		StringBuilder stringBuilder = new StringBuilder();
//		int start = medium - max;
//		int end = medium + max;
//		for (int i = start; i <= end; i++) {
//			if (s.charAt(i) != '#') {
//				stringBuilder.append(s.charAt(i));
//			}
//		}
//
//		return stringBuilder.toString();
//	}

	// DP Solution  20160320  117ms 
//	public String longestPalindrome(String s) {
//		int n = s.length();
//		String res = null;
//
//		boolean[][] dp = new boolean[n][n];
//
//		for (int i = n - 1; i >= 0; i--) {
//			for (int j = i; j < n; j++) {
//				dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
//
//				if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
//					res = s.substring(i, j + 1);
//				}
//			}
//		}
//
//		return res;
//	}
	
	// Favorite
	public String longestPalindrome(String s) {
		int i = 0;
	    int l = 0;
	    int n = s.length();
	    for(int j=0;j<n;j++){
	        if(isPalindrome(s, j-l, j)){
	            i = j-l;
	            l = l+1;
	        }else if(j-l-1>=0 && isPalindrome(s, j-l-1, j)){
	            i = j-l-1;
	            l = l+2;
	        }
	    }
	    return new String(s.getBytes(), i, l);
	}
	
	public boolean isPalindrome(String s, int left, int end) {
		while (left < end) {
			if (s.charAt(left++) != s.charAt(end--)) {
				return false;
			}
		}
		return true;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestPalindromicSubstring t = new LongestPalindromicSubstring();
		System.out.println(t.longestPalindrome("abccbdbc"));
	}

}
