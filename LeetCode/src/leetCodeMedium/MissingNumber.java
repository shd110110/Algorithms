package leetCodeMedium;

/**
 * @author Poirot
 * 2015年8月24日
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int temp = 0;
        for (int i = 0; i <= n; i++) {
			temp ^= i;
		}
        for (int i = 0; i < nums.length; i++) {
			temp ^= nums[i];
		}
        return temp;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
