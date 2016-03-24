/**
 * 2015年12月31日
 * Poirot
 * 下午3:55:33
 * LeetCode
 */
package leetCodeMedium;

import java.util.Arrays;

/**
 * @author Poirot
 *
 */
public class WiggleSortII {
    public void wiggleSort(int[] nums) { 
        if (nums.length <= 1) {
        	return;
        }
        Arrays.sort(nums);
         
        int[] copy = new int[nums.length];
        int j = 0;
        for (int i = (nums.length - 1) / 2; i >= 0; i--) {
        	copy[j] = nums[i];
        	j += 2;
        }
        j = 1;
        for (int i = nums.length - 1; i > (nums.length - 1) / 2; i--) {
        	copy[j] = nums[i];
        	j += 2;
        }
        for (int i = 0; i < copy.length; i++) {
			nums[i] = copy[i];
		}
    }
    
     // MV Solution
//	public void wiggleSort(int[] nums) {
//    	int n = nums.length;
//
//        // Find a median.
//        int midptr = nums[0] + n / 2;
//        nth_element(nums.begin(), midptr, nums.end());
//        int mid = midptr;
//
//        // Index-rewiring.
//        #define A(i) nums[(1+2*(i)) % (n|1)]
//
//        // 3-way-partition-to-wiggly in O(n) time with O(1) space.
//        int i = 0, j = 0, k = n - 1;
//        while (j <= k) {
//            if (A(j) > mid)
//                swap(A(i++), A(j++));
//            else if (A(j) < mid)
//                swap(A(j), A(k--));
//            else
//                j++;
//        }
//	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WiggleSortII t = new WiggleSortII();
//		int[] nums = {1,3,2,2,3,1};
		int[] nums = {1,1,2,1,2,2,1};
		t.wiggleSort(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}

}
