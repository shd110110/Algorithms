package leetCodeHard;

/**
 * @author Poirot
 * 2015年7月9日
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
    	if (word1 == null && word2 == null) {
    		return 0;
    	}
        if (word1 == null && word2 !=null) {
    		return word2.length();
        }
        if (word1 != null && word2 ==null) {
    		return word1.length();
    	}
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for (int i = 0; i <= word1.length(); i++) {
			dp[i][0] = i;
		}
        for (int i = 0; i <= word2.length(); i++) {
			dp[0][i] = i;
		}
        for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (word1.charAt(i-1) == word2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1];
				}else {
					dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1])+1;
				}
			}
		}
        return dp[word1.length()][word2.length()];
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EditDistance t = new EditDistance();
		String word1 = "zoologicoarchaeologist";
		String word2 = "zoogeologist";
		System.out.println(t.minDistance(word1, word2));
	}

}
