package leetCodeHard;

import java.util.Arrays;

/**
 * @author Poirot
 * 2015年9月30日
 */
public class FindtheDuplicateNumber {
	// O(nlog(n))
//	public int findDuplicate(int[] nums) {
//		Arrays.sort(nums);
//		for (int i = 0; i < nums.length-1; i++) {
//			if(nums[i] == nums[i+1])
//			{
//				return nums[i];
//			}
//		}
//		return 0;
//    }
	
	// O(N) Time O(1) space
//	public int findDuplicate(int[] nums) {
//        if (nums.length > 1)
//        {
//            int slow = nums[0];
//            int fast = nums[nums[0]];
//            while (slow != fast)
//            {
//                slow = nums[slow];
//                fast = nums[nums[fast]];
//            }
//
//            fast = 0;
//            while (fast != slow) {
//                fast = nums[fast];
//                slow = nums[slow];
//            }
//            return slow;
//        }
//        return -1;
//    }
	
	
	//Binary search O(nlog(n))
	public int findDuplicate(int[] nums) {
        return find(1, nums.length - 1, nums);
    }

    public int find(int begin, int end, int[] nums) {
        if (begin >= end) {
            return begin;
        }
        int medium = (begin + end) / 2;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= medium) {
                count++;
            }
        }
        if (count > medium) {
            return find(begin, medium, nums);
        } else {
            return find(medium + 1, end, nums);
        }
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindtheDuplicateNumber t = new FindtheDuplicateNumber();
		int[] nums = {1,3,4,2,1};
		System.out.println(t.findDuplicate(nums));
	}

}
