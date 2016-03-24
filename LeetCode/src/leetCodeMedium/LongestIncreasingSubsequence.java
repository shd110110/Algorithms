/**
 * 2015Äê11ÔÂ20ÈÕ
 * Poirot
 */
package leetCodeMedium;

/**
 * @author Poirot
 *
 */
public class LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
    	if (nums.length <= 1) {
			return nums.length;
		}
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < dp.length; i++) {
			int temp = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (nums[i] > nums[j] && dp[j] + 1 > temp) {
					temp = dp[j] + 1;
				}
			}
			dp[i] = temp;
			if (temp > max) {
				max = temp;
			}
		}
//        for (int i = 0; i < dp.length; i++) {
//			System.out.print(dp[i]+" ");
//		}
//        System.out.println();
        return max;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,3,6,7,9,4,10,5,6};
		System.out.println(lengthOfLIS(nums));
	}

}
