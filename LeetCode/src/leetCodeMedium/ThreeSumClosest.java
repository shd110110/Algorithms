/**
 * 2015年11月27日
 * Poirot
 */
package leetCodeMedium;

import java.util.Arrays;

/**
 * @author Poirot
 *
 */
public class ThreeSumClosest {

	// My first Solution 0(N*N)
	public int threeSumClosest(int[] nums, int target) {
		int closestRes = nums[0] + nums[1] + nums[2];
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if (i == 0 || nums[i] != nums[i - 1]) {
				int left = i + 1;
				int right = nums.length - 1;
				int sum = target - nums[i];
				while (left < right) {
					if (nums[left] + nums[right] == sum) {
						return target;
					} else if (nums[left] + nums[right] < sum) {
						if (Math.abs(sum - nums[left] - nums[right]) < Math.abs(target - closestRes)) {
							closestRes = nums[i] + nums[left] + nums[right];
						}
						left++;
					} else {
						if (Math.abs(sum - nums[left] - nums[right]) < Math.abs(target - closestRes)) {
							closestRes = nums[i] + nums[left] + nums[right];
						}
						right--;
					}
				}
			}
		}
		return closestRes;
	}

	// public int threeSumClosest(int[] nums, int target) {
	// int closestRes = nums[0] + nums[1] + nums[2];
	// Arrays.sort(nums);
	// int begin = 0;
	// int end = nums.length - 1;
	//
	// //use two pointer
	// while (begin < end - 1) {
	//
	// // use binary research to find the value
	// int val = binaryFindMinimalDistance(nums, begin + 1, end - 1, target -
	// nums[begin] - nums[end]);
	//
	// if (val == target - nums[begin] - nums[end]) {
	// return target;
	// }
	// if (Math.abs(target - nums[begin] - nums[end] - val) < Math.abs(target -
	// closestRes)) {
	// closestRes = nums[begin] + nums[end] + val;
	// }
	// if (val > 0) {
	//
	// }
	// }
	// return closestRes;
	// }
	//
	//
	// //use binary research to find the closest
	// public int binaryFindMinimalDistance(int[] nums, int begin, int end, int
	// value){
	// if (begin == end) {
	// return nums[begin];
	// }
	// int medium = (begin + end) / 2;
	// while (begin < end - 1) {
	// if (nums[medium] < value) {
	// begin = medium;
	// } else if (nums[medium] > value) {
	// end = medium;
	// } else {
	// return value;
	// }
	// medium = (begin + end) / 2;
	// }
	// if (Math.abs(value-nums[begin]) < Math.abs(value-nums[end])) {
	// return nums[begin];
	// } else {
	// return nums[end];
	// }
	// }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreeSumClosest t = new ThreeSumClosest();
		// int[] nums = {1,2,4,8,16,32,64,128};
		// int[] nums = {1,3,2,4,6,7};
		int[] nums = { -5, -4, -3, -2, 3 };
		System.out.println(t.threeSumClosest(nums, -1));
	}

}
