package leetCodeHard;

/**
 * @author Poirot
 * 2015年7月7日
 */
public class DistinctSubsequences {
//    public int numDistinct(String s, String t) {
//    	if (s.length() < t.length()) {
//			return 0;
//		}
//        int[][] dp = new int[s.length()+1][t.length()+1];
//        for (int i = 0; i < dp.length; i++) {
//			dp[i][0] = 1;
//		}
//        for (int i = 1; i <= s.length(); i++) {
//			for (int j = 1; j <= i && j<= t.length(); j++) {
//				dp[i][j] = (s.charAt(i-1) == t.charAt(j-1) ? dp[i-1][j-1]+dp[i-1][j]:dp[i-1][j])  ;
//			}
//		}
//        return dp[s.length()][t.length()];
//    }
    
	
	// Second Round First Time O(m*n), O(m*n) space 20ms 
//    public int numDistinct(String s, String t) {
//    	if (s.length() < t.length()) {
//            return 0;
//        }
//        int[][] dp = new int[s.length() + 1][t.length() + 1];
//        for (int i = 0; i < dp.length; i++) {
//            dp[i][0] = 1;
//        }
//        for (int i = 1; i < dp.length; i++) {
//            for (int j = 1; j <= i && j < dp[0].length; j++) {
//                if (s.charAt(i - 1) != t.charAt(j - 1)) {
//                    dp[i][j] = dp[i - 1][j];
//                } else {
//                    dp[i][j] += (dp[i - 1][j - 1] + dp[i -1][j]);
//                }
//            }
//        }
//        return dp[s.length()][t.length()];
//    } 
    
    // Second Round First Time O(m*n), O(n)space 19ms
	public int numDistinct(String s, String t) {
    	if (s.length() < t.length()) {
            return 0;
        }
        int[] dp = new int[t.length() + 1];
        dp[0] = 1;
        
        for (int i = 1; i <= s.length(); i++) {
        	int pre = 1;
        	int j = 1;
            for (j = 1; j <= i && j <= t.length(); j++) {
            	int cur = dp[j];
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    cur += dp[j - 1];
                    
                }
                dp[j - 1] = pre;
                pre = cur;
            }
            dp[j - 1] = pre;
        }
        return dp[t.length()];
    } 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DistinctSubsequences distinctSubsequences = new DistinctSubsequences();
		String s = "rabbbit";
		String t = "rabbit";
		System.out.println(distinctSubsequences.numDistinct(s, t));
		
	}

}
