package leetCodeHard;

/**
 * @author Poirot 2015年7月8日
 */
public class InterleavingString {
//	public boolean isInterleave(String s1, String s2, String s3) {
//		if (s3.length() != s1.length() + s2.length()) {
//			return false;
//		}
//		if (s2.length() == 0) {
//			return s3.equals(s1);
//		}
//		if (s1.length() == 0) {
//			return s3.equals(s2);
//		}
//		if (s3.equals(s2 + s1) || s3.equals(s1 + s2)) {
//			return true;
//		}
//
//		boolean[][] dpMatrix = new boolean[s1.length() + 1][s2.length() + 1];
//
//		dpMatrix[0][0] = true;
//
//		for (int i = 1; i < dpMatrix[0].length; i++) {
//			dpMatrix[0][i] = dpMatrix[0][i - 1] && (s2.charAt(i - 1) == s3.charAt(i - 1));
//		}
//
//		for (int i = 1; i < dpMatrix.length; i++) {
//			dpMatrix[i][0] = dpMatrix[i - 1][0] && (s1.charAt(i - 1) == s3.charAt(i - 1));
//		}
//
//		for (int i = 1; i < dpMatrix.length; i++) {
//			for (int j = 1; j < dpMatrix[0].length; j++) {
//				dpMatrix[i][j] = (dpMatrix[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(i + j - 1)))
//						|| (dpMatrix[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(i + j - 1)));
//			}
//		}
//		return dpMatrix[s1.length()][s2.length()];
//	}

	// second round
	public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null) {
			return s2.equals(s3);
		} else if (s2 == null) {
			return s1.equals(s3);
		}
		int m = s1.length();
		int n = s2.length();
		if (m + n != s3.length()) {
			return false;
		}
		boolean[][] dp = new boolean[m + 1][n + 1];
		dp[0][0] = true;
		for (int i = 1; i <= m; i++) {
			dp[i][0] = s1.charAt(i - 1) == s3.charAt(i - 1) ? dp[i - 1][0] : false;
		}
		for (int j = 1; j <= n; j++) {
			dp[0][j] = s2.charAt(j - 1) == s3.charAt(j - 1) ? dp[0][j - 1] : false;
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				
				if (s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
					if (dp[i - 1][j]) {
						dp[i][j] = true;
					}
				}
				if (s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
					if (dp[i][j - 1]) {
						dp[i][j] = true;
					}
				} 
			}
		}
		return dp[m][n];
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterleavingString t = new InterleavingString();
//		 String s1 =
//		 "bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa";
//		 String s2 =
//		 "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab";
//		 String s3 =
//		 "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab";
		String s1 = "aabc";
		String s2 = "abad";
		String s3 = "aabadabc";// "aadbbcbcac";
//		System.out.println(s1 + s2 == s3);
		System.out.println(t.isInterleave(s1, s2, s3));
	}

}
