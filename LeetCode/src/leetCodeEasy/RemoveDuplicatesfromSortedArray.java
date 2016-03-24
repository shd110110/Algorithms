/**
 * 2015年11月29日
 * Poirot
 */
package leetCodeEasy;

/**
 * @author Poirot
 *
 */
public class RemoveDuplicatesfromSortedArray {
	public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int endIndex = 0;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                continue;
            } else {
                nums[endIndex+1] = nums[i];
                endIndex++;
            }
        }
        return endIndex + 1;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
