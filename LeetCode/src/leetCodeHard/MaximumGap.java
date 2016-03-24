package leetCodeHard; 

/**
 * @author Poirot 2015年6月15日
 */
public class MaximumGap {
	public int maximumGap(int[] nums) {
		// other's solution
		int sSize = nums.length;
		int i;
		int minV, maxV;
		int bucket_size, bucket_num, bucket_id;
		int maxGap = Integer.MIN_VALUE;
		int last_max;
		if (sSize > 1) {
			minV = maxV = nums[0];
			for (i = 1; i < sSize; i++) {
				if (minV > nums[i])
					minV = nums[i];
				else if (maxV < nums[i])
					maxV = nums[i];
			}

			bucket_size = Math.max(1, (maxV - minV) / (sSize - 1));
			bucket_num = (maxV - minV) / bucket_size + 1;

			if (bucket_num <= 1)
				return (maxV - minV);
			
			int[] bucket_max = new int[bucket_num];
			for (int j = 0; j < bucket_max.length; j++) {
				bucket_max[j] = Integer.MIN_VALUE;
			}
			int[] bucket_min = new int[bucket_num];
			for (int j = 0; j < bucket_min.length; j++) {
				bucket_min[j] = Integer.MAX_VALUE;
			}
			int[] bucket_count = new int[bucket_num];

			for (i = 0; i < sSize; i++) {
				bucket_id = (nums[i] - minV) / bucket_size;
				bucket_count[bucket_id]++;
				bucket_min[bucket_id] = bucket_min[bucket_id] > nums[i] ? nums[i]
						: bucket_min[bucket_id];
				bucket_max[bucket_id] = bucket_max[bucket_id] < nums[i] ? nums[i]
						: bucket_max[bucket_id];
			}

			last_max = minV;
			for (i = 0; i < bucket_num; i++) {
				if (bucket_count[i] > 0) {
					maxGap = Math.max(maxGap, bucket_min[i] - last_max);
					last_max = bucket_max[i];
				}
			}
			return maxGap;
		}
		return 0;

		// if (nums.length < 2) {
		// return 0;
		// }
		// Arrays.sort(nums);
		// int max = 0;
		// for (int i = 0; i < nums.length-1; i++) {
		// if (nums[i+1] - nums[i] > max) {
		// max = nums[i+1] - nums[i];
		// }
		// }
		// return max;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = { 0,1,9 };
		MaximumGap t = new MaximumGap();
		System.out.println(t.maximumGap(test));
	}

}
