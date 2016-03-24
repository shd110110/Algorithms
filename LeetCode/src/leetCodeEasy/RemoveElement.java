/**
 * 2015年11月29日
 * Poirot
 */
package leetCodeEasy;

/**
 * @author Poirot
 *
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int endIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                continue;
            } else {
                endIndex++;
                nums[endIndex] = nums[i];
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
