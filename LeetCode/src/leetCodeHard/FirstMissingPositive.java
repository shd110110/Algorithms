/**
 * 2015��6��23��
 * CH
 */
package leetCodeHard;

import java.util.HashSet;

/**
 * @author CH
 *
 */
public class FirstMissingPositive {
	
	//My first idea
//	public int firstMissingPositive(int[] nums) {
//		if (nums.length == 0) {
//			return 1;
//		} 
//        int[] temp = new int[nums.length+1];
//        for (int i = 0; i < nums.length; i++) {
//			if (nums[i] < temp.length && nums[i] >=1) {
//				temp[nums[i]] = 1;
//			}
//		}
//        for (int i = 1; i < temp.length; i++) {
//			if (temp[i] == 0) {
//				return i;
//			}
//		}
//        return temp.length;
//    }
	
	
	//My second idea	
//	public int firstMissingPositive(int[] nums) {
//		if (nums.length == 0) {
//			return 1;
//		} 
//		HashSet<Integer> set = new HashSet<Integer>();
//		for (int i = 0; i < nums.length; i++) {
//			set.add(nums[i]);
//		}
//		for (int i = 1; i <= nums.length; i++) {
//			if (set.add(i)) {
//				return i;
//			}
//		}
//		return nums.length+1;
//	}
	
	// Second Round O(n) time and O(1) space
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                int index = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;  
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirstMissingPositive t = new FirstMissingPositive();
		int[] nums = {1,3,4};
		System.out.println(t.firstMissingPositive(nums));
	}

}
