/**
 * 2015��7��1��
 * CH
 */
package leetCodeHard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;  

/**
 * @author CH
 *
 */
public class LongestConsecutiveSequence {
	// MV Solution 19ms
//    public int longestConsecutive(int[] nums) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        int res = 0;
//        for (int num : nums) {
//            if (!map.containsKey(num)) {
//                int left = map.containsKey(num - 1) ? map.get(num - 1) : 0;
//                int right = map.containsKey(num + 1) ? map.get(num + 1) : 0;
//                int sum = left + right + 1;
//                map.put(num, sum);
//                map.put(num - left, sum);
//                map.put(num + right, sum);
//                res = Math.max(res, sum);
//            }
//        }
//        return res;
//    }

	
	// My Solution  11ms
	public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
        	set.add(num);
        }
        int res = 0;
        while (set.size() > res) {
        	int num = set.iterator().next();
            int left = num - 1;
            while (set.contains(left)) {
                set.remove(left);
                left--;
            }
            
            int right = num + 1;
            while (set.contains(right)) {
                set.remove(right);
                right++;
            }
            res = Math.max(res, right - left - 1);
            set.remove(num);    
        }
        return res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestConsecutiveSequence t = new LongestConsecutiveSequence();
		int[] nums = { 1, 2, 3, 4, 5 };
		System.out.println(t.longestConsecutive(nums));
	}

}
