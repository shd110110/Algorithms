/**
 * 2015年11月18日
 * Poirot
 */
package leetCodeEasy;

/**
 * @author Poirot
 *
 */
public class NumArray {
	int[] sums ;
	public NumArray(int[] nums) {
		sums = new int[nums.length];
		int tempSum = 0;
		for (int i = 0; i < sums.length; i++) {
			tempSum += nums[i];
			sums[i] = tempSum;
		} 
	}

	public int sumRange(int i, int j) {
		if (i == 0) {
			return sums[j];
		}
		return sums[j]-sums[i];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
