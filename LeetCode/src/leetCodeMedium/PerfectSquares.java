/**
 * 2015Äê9ÔÂ10ÈÕ
 * Poirot
 */
package leetCodeMedium;

/**
 * @author Poirot
 *
 */
public class PerfectSquares {
    public int numSquares(int n) {
//    	int[] dp = new int[n + 1];
//        Arrays.fill(dp, Integer.MAX_VALUE);
//        dp[0] = 0;
//        for(int i = 0; i <= n; i++){
//            for(int j = 1; i + j * j <= n; j++){
//                dp[i  + j * j] = Math.min(dp[i + j * j], dp[i] + 1);
//             }
//        }
//        return dp[n];
    	while (n % 4 == 0)
            n /= 4;
        if (n % 8 == 7)
            return 4;
        int r = (int) Math.sqrt(n);
        if (r * r == n) {
			return 1;
		}
        for (int a=1; a*a<=n; ++a) {
            int b = (int) Math.sqrt(n - a*a);
            if (a*a + b*b == n)
                return 2;
        }
        return 3;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
