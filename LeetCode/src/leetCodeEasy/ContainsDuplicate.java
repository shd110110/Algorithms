package leetCodeEasy;

import java.util.HashSet;
import java.util.Set;
//150531
public class ContainsDuplicate {
	public boolean containsDuplicate(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return false;
		}
        Set<Integer> tmp = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
			if (!tmp.add(nums[i])) {
				return true;
			}
		}
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
