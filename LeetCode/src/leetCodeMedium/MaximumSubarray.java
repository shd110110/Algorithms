package leetCodeMedium;

/**
 * @author Poirot
 * 2015年6月11日
 */
public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		return maxSubArrayInSection(nums, 0, nums.length-1);
	}
	
	public int maxSubArrayInSection(int[] nums,int begin, int end){
		if (begin > end) {
			return Integer.MIN_VALUE;
		}
		int medium = (begin + end)/2;
		//包括medium
		int max1 = 0;
		int temp = 0;
		//向左右扩张
		for (int i = medium +1; i <= end; i++) {
			temp += nums[i];
			if (temp > max1) {
				max1 = temp;
			}
		}
		int max2 = 0;
		temp = 0;
		for (int i = medium - 1; i >= begin; i--) {
			temp += nums[i];
			if (temp > max2) {
				max2 = temp;
			}
		}
//		System.out.println(max1);
//		System.out.println(max2);
//		System.out.println(nums[medium]);
		max1 = max1 + max2 + nums[medium];
		//System.out.println(max1);
	
		//不包括
		return Math.max(max1, Math.max(maxSubArrayInSection(nums, begin, medium-1), maxSubArrayInSection(nums, medium+1, end)));
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumSubarray t = new MaximumSubarray();
		int[] test ={-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(t.maxSubArray(test));
	}

}
