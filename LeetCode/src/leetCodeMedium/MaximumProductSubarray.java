package leetCodeMedium;
 

/**
 * @author Poirot 2015年6月12日
 */
public class MaximumProductSubarray {
//	public int maxProduct(int[] nums) {
//		int max = Integer.MIN_VALUE;
//		int begin = 0;
//		boolean hasZero = false;
//		while (begin < nums.length){
//			while (begin < nums.length && nums[begin] == 0){
//				hasZero = true;
//				begin++;
//			}
//			int end = begin;
//			while (end < nums.length && nums[end] != 0){
//				end++;
//			}
//			int productInSection = maxProduct2(nums, begin, end-1);
//			if (productInSection > max) {
//				max = productInSection;
//			}
//			begin = end;
//		}
//		if (max < 0 && hasZero ) {
//			return 0;
//		}else {
//			return max;
//		}
//	}
//	public int maxProduct2(int[] nums, int begin, int end) {
//		if (begin > end) {
//			return 0;
//		}
//		if (begin == end) {
//			return nums[begin];
//		} 
//		int total = 1;
//		int numberOfNegative = 0;
//		for (int i = begin; i <= end; i++) {
//			if (nums[i] < 0) {
//				numberOfNegative++;
//			}
//			total *= nums[i];
//		} 
//		if (numberOfNegative%2 == 0) {
//			return total;
//		}else if (numberOfNegative == 1) {
//			int firstNegative = 1;
//			int temp = 1;
//			for (int j = begin; j <= end; j++) {
//				if (nums[j] < 0) {
//					firstNegative = nums[j];
//					break;
//				}
//				temp *= nums[j];
//			}
//			int secondPart = total / temp / firstNegative;
//			return Math.max(temp, secondPart);
//		}else {
//			int lastNegative = 1;
//			int temp = 1;
//			for (int j = end; j >= begin; j--) {
//				if (nums[j] < 0) {
//					lastNegative = nums[j];
//					break;
//				}
//				temp *= nums[j];
//			}
//			int firstPart = total / temp / lastNegative;
//
//			int firstNegative = 1;
//			temp = 1;
//			for (int j = begin; j <= end; j++) {
//				if (nums[j] < 0) {
//					firstNegative = nums[j];
//					break;
//				}
//				temp *= nums[j];
//			}
//			int secondPart = total / temp / firstNegative;
//			return Math.max(firstPart, secondPart);
//		}
//	} 
	
	public int maxProduct(int[] nums) {
		int temp = 1;
        int partBeforeNegative = 1;
        int firstNegative = -1;
        int res = Integer.MIN_VALUE;
        boolean hasNegative = false;
        boolean hasZero = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                hasZero = true;
                temp = 1;
                hasNegative = false;
                partBeforeNegative = 1;
            } else {
                temp *= nums[i];
                res = Math.max(res, temp); 
                if (temp < 0) {
                	if (nums[i] < 0) {
                		if (hasNegative) {
                            res = Math.max(res, temp / partBeforeNegative / firstNegative);
                        } else { 
                            partBeforeNegative = temp / nums[i]; 
                            hasNegative = true;
                            firstNegative = nums[i];
                        }
					} else {
						res = Math.max(res, temp / partBeforeNegative / firstNegative); 
					} 
                }
            }
        }
        if (hasZero) {
            res = Math.max(res, 0);
        }
        return res;
   }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] test = {-1, 0, -1, 0, 0, -1 };
//		int[] test = {11,0,-1,-12};
//		int[] test = {11,0,-1,-12};
//		int[] test = { -12};
		int[] test = {3,-1,4};
		MaximumProductSubarray t = new MaximumProductSubarray();
		System.out.println(t.maxProduct(test));
	}
}
