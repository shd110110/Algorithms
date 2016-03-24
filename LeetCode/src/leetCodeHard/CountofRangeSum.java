/**
 * 2016年1月22日
 * Poirot
 * 上午9:22:34
 * LeetCode
 */
package leetCodeHard;

/**
 * @author Poirot
 *
 */
public class CountofRangeSum {
	// MV Solution O(nlog(n))
	public int countRangeSum(int[] nums, int lower, int upper) {
		int n = nums.length;
		long[] sums = new long[n + 1];
		for (int i = 0; i < n; ++i)
			sums[i + 1] = sums[i] + nums[i];
		return countWhileMergeSort(sums, 0, n + 1, lower, upper);
	}

	private int countWhileMergeSort(long[] sums, int start, int end, int lower, int upper) {
		if (end - start <= 1) {
			return 0;
		}
		int mid = (start + end) / 2;
		int count = countWhileMergeSort(sums, start, mid, lower, upper)
				+ countWhileMergeSort(sums, mid, end, lower, upper);
		int j = mid, k = mid, t = mid;
		long[] cache = new long[end - start];
		for (int i = start, r = 0; i < mid; ++i, ++r) {
			while (k < end && sums[k] - sums[i] < lower) {
				k++;
			}
			while (j < end && sums[j] - sums[i] <= upper) {
				j++;
			}
			while (t < end && sums[t] < sums[i]) {
				cache[r++] = sums[t++];
			}
			cache[r] = sums[i];
			count += j - k;
		}
		for (int i = 0; i < cache.length; i++) {
			System.out.print(cache[i] + " ");
		}
		System.out.println();
		for (int i = start; i < end; i++) {
			System.out.print(sums[i] + " ");
		}
		System.out.println();
		System.arraycopy(cache, 0, sums, start, t - start);
		for (int i = start; i < end; i++) {
			System.out.print(sums[i] + " ");
		}
		System.out.println();
		System.out.println();
		return count;
	}
 

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountofRangeSum t = new CountofRangeSum();
		// int[] nums = { -2, 5, -1 };
		// System.out.println(t.countRangeSum(nums, -2, 2));
		int[] nums = { -2147483647, 0, -2147483647, 2147483647 };
		System.out.println(t.countRangeSum(nums, -564, 3864));

		// int[] nums = {0};
		// System.out.println(t.countRangeSum(nums, 0, 0));
	}

}
