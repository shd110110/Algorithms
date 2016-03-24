/**
 * 2015年12月1日
 * Poirot
 */
package leetCodeMedium;

/**
 * @author Poirot
 *
 */
public class BurstBalloons {

	// other's idea test time complexity
	// public int maxCoins(int[] iNums) {
	// int[] nums = new int[iNums.length + 2];
	// int n = 1;
	// for (int x : iNums)
	// if (x > 0)
	// nums[n++] = x;
	// nums[0] = nums[n++] = 1;
	//
	// int[][] memo = new int[n][n];
	// return burst(memo, nums, 0, n - 1);
	// }
	//
	// public int burst(int[][] memo, int[] nums, int left, int right) {
	// if (left + 1 == right)
	// {
	// System.out.println("test");
	// return 0;
	// }
	//
	// if (memo[left][right] > 0)
	// return memo[left][right];
	// int ans = 0;
	// for (int i = left + 1; i < right; ++i)
	// ans = Math.max(ans,
	// nums[left] * nums[i] * nums[right] + burst(memo, nums, left, i) +
	// burst(memo, nums, i, right));
	// memo[left][right] = ans;
	// return ans;
	// }
	public int maxCoins(int[] iNums) {
		int[] nums = new int[iNums.length + 2];
		int n = 1;
		for (int x : iNums)
			if (x > 0)
				nums[n++] = x;
		nums[0] = nums[n++] = 1;

		int[][] dp = new int[n][n];
		for (int k = 2; k < n; ++k) {
			for (int left = 0; left < n - k; ++left) {
				int right = left + k;
				for (int i = left + 1; i < right; ++i)
					dp[left][right] = Math.max(dp[left][right],
							nums[left] * nums[i] * nums[right] + dp[left][i] + dp[i][right]);
			}
		}
//		for (int i = 0; i < dp.length; i++) {
//			for (int j = 0; j < dp[0].length; j++) {
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println();
//		}
		return dp[0][n - 1];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BurstBalloons t = new BurstBalloons();
//		int[] nums = { 3, 1 };
		 int[] nums = { 2, 3, 7, 9, 1, 8, 2 };
//		 int[] nums = {9,76,64,21,97,60};
		System.out.println(t.maxCoins(nums));
	}

}
