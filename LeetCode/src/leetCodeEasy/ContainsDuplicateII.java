package leetCodeEasy;

import java.util.HashSet;
//150531
public class ContainsDuplicateII {
	
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		if(nums == null || nums.length <= 1)
            return false;
		if (k <= 0) {
			return false;
		}
		HashSet<Integer> temp = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
			if (temp.size() == k+1) {
				temp.remove(nums[i-k-1]);
				
			}
			
			if (!temp.add(nums[i])) {
				return true; 
			}
		}
		return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
