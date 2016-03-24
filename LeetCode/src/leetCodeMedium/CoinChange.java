/**
 * 2015年12月28日
 * Poirot
 * 下午10:24:47
 * LeetCode
 */
package leetCodeMedium;

/**
 * @author Poirot
 *
 */
public class CoinChange { 

	// First Solution
//	public int coinChange(int[] coins, int amount) {
//        int[] dp = new int[amount + 1];
//        for (int i = 0; i < dp.length; i++) {
//			dp[i] = amount;
//		}
//        dp[0] = 0;
//        for (int i = 1; i <= amount; i++) {
//            for (int j = 0; j < coins.length; j++) {
//                if (coins[j] <= i) {
//                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
//                }
//            }
//        }
//        if (dp[amount] > amount) {
//        	return -1 ;
//        } else {
//        	return dp[amount];
//        }
//    }
	
	// other's solution
	public int coinChange(int[] coins, int amount) {
	    if(amount<1) return 0;
	    return helper(coins, amount, new int[amount]);
	}

	private int helper(int[] coins, int rem, int[] count) { // rem: remaining coins after the last step; count[rem]: minimum number of coins to sum up to rem
	    if(rem<0) 
	    	return -1;  
	    if(rem==0) // completed
	    	return 0; 
	    if(count[rem-1] != 0) // already computed, so reuse
	    	return count[rem-1];
	    int min = Integer.MAX_VALUE;
	    for(int coin : coins) {
	        int res = helper(coins, rem-coin, count);
	        if(res>=0 && res < min)
	            min = 1+res;
	    }
	    count[rem-1] = (min==Integer.MAX_VALUE) ? -1 : min;
	    return count[rem-1];
	}
	
	// other's solution
//	public int coinChange(int[] coins, int amount) {
//		if (amount < 1)
//			return 0;
//		int L = coins.length;
//		int[] dp = new int[amount + 1];
//		int sum = 0;
//
//		while (++sum <= amount) {
//			int min = -1;
//			for (int coin : coins) {
//				if (sum >= coin && dp[sum - coin] != -1) {
//					int temp = dp[sum - coin] + 1;
//					min = min < 0 ? temp : (temp < min ? temp : min);
//				}
//			}
//			dp[sum] = min;
//		}
//		return dp[amount];
//	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CoinChange t = new CoinChange();
		int[] coins = {1, 2, 5};
		int amount = 11;
		System.out.println(t.coinChange(coins, amount));
	}

}
