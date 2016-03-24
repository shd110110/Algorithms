package leetCodeMedium;

import java.util.Arrays;
//150604
public class NextPermutation {
	public static void nextPermutation(int[] nums) {
		if (digui(nums, 0, nums.length - 1))
			Arrays.sort(nums);
		return;
	}
	public static Boolean digui(int[] nums, int begin, int end) {
		if (begin >= end) {
			return true;
		}
		int[] b = find(nums, begin, end);
		if (b[0] == -1) {
			return true;
		}
		int from = b[0];
		int to = b[1];
		if (find(nums, from+1, to-1)[0] == -1) {
			swap(nums, from, to);
			Arrays.sort(nums, from+1, nums.length);
			return false;
		} else {
			return digui(nums, from+1, to-1);
		}
	}

	public static void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
		return;
	}

	public static int[] find(int[] nums, int begin, int end) {
		int[] result = new int[2];
		result[0] = -1;
		result[1] = -1;
		if (begin >= end) {
			return result;
		}
		while (end > begin) {
			int i = end - 1;
			while (i >= begin && nums[i] >= nums[end]) {
				i--;
			}
			if (i >= begin) {
				result[0] = i;
				result[1] = end;
				return result;
			}
			end--;
		}
		
		return result;
	}
//	public void nextPermutation(int[] nums) {
//		if (findArea(nums, 0, nums.length - 1))
//			Arrays.sort(nums);
//		return;
//	}
//	public Boolean findArea(int[] nums, int begin, int end) {
//		if (begin >= end) {
//			return true;
//		}
//		int[] b = find(nums, begin, end);
//		if (b[0] == -1) {
//			return true;
//		}
//		int from = b[0];
//		int to = b[1];
//		if (find(nums, from+1, to-1)[0] == -1) {
//			swap(nums, from, to);
//			Arrays.sort(nums, from+1, nums.length);
//			return false;
//		} else {
//			return findArea(nums, from+1, to-1);
//		}
//	}
//
//	public void swap(int[] nums, int a, int b) {
//		int temp = nums[a];
//		nums[a] = nums[b];
//		nums[b] = temp;
//		return;
//	} 
//	public int[] find(int[] nums, int begin, int end) {
//		int[] result = new int[2];
//		result[0] = -1;
//		result[1] = -1;
//		if (begin >= end) {
//			return result;
//		}
//		while (end > begin) {
//			int i = end - 1;
//			while (i >= begin && nums[i] >= nums[end]) {
//				i--;
//			}
//			if (i >= begin) {
//				result[0] = i;
//				result[1] = end;
//				return result;
//			}
//			end--;
//		}
//		return result;
//	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = { 4, 2, 0, 2, 3, 2, 0 };
		nextPermutation(test);
		for (int i = 0; i < test.length; i++) {
			System.out.print(test[i] + " ");
		}

	}

}
