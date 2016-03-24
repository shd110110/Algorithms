package leetCodeEasy;

/**
 * @author Poirot
 * 2015年7月16日
 */
public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int countZeros = 0;
        int totalProduct = 1;
        for (int i = 0; i < nums.length; i++) {
			
			if (nums[i] == 0) {
				countZeros ++;
			} else {
				totalProduct *= nums[i];
			}
		}
        for (int i = 0; i < nums.length; i++) {
			if (countZeros > 1) {
				nums[i] = 0;
			} else if (countZeros == 1) {
				if (nums[i] == 0) {
					nums[i] = totalProduct;
				}else {
					nums[i] = 0;
				}
			} else {
				nums[i] = totalProduct/nums[i];
			}
		}
        return nums;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
