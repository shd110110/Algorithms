/**
 * 2015年12月23日
 * Poirot
 * 下午3:00:53
 * LeetCode
 */
package leetCodeHard;

/**
 * @author Poirot
 *
 */
public class CreateMaximumNumber {
	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        for (int i = Math.max(0, k - nums2.length); i <= Math.min(k, nums1.length); i++) {
            int[] getFromNums1 = maxSubArray(nums1, i);
            int[] getFromNums2 = maxSubArray(nums2, k - i);
            int[] temp = merge(getFromNums1, getFromNums2);
            if (compare(res, 0, temp, 0)) {
                res = temp;
            }
        }
        return res;
    }	
    
    public int[] maxSubArray(int[] nums, int k) {
        if (nums.length == k) {
            return nums;
        }
        
        int[] res = new int[k];
        for (int i = 0, j = 0; i < nums.length; i++) {
            while (nums.length - i + j > k && j >0 && res[j - 1] < nums[i]) {
                j--;
            }
            if (j < k) {
                res[j++] = nums[i];
            }
        }
        return res;
    }
    
    public int[] merge(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length + nums2.length];
        int i = 0, j = 0;
        for (int k = 0; k < res.length; k++) {
            res[k] = compare(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        }
        return res;
    }
    
    public boolean compare(int[] nums1, int i, int[] nums2, int j) {
	    while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
	        i++;
	        j++;
	    }
	    return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
	}
	
	
	// Greedy Solution
//	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
//	    int n = nums1.length;
//	    int m = nums2.length;
//	    int[] ans = new int[k];
//	    for (int i = Math.max(0, k - m); i <= k && i <= n; ++i) {
//	        int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
//	        if (compare(candidate, 0, ans, 0)) {
//	        	ans = candidate;
//	        }
//	    }
//	    return ans;
//	}
//	private int[] merge(int[] nums1, int[] nums2, int k) {
//	    int[] ans = new int[k];
//	    for (int i = 0, j = 0, r = 0; r < k; ++r) {
//	        ans[r] = compare(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
//	    }
//	    return ans;
//	}
//	
//	public boolean compare(int[] nums1, int i, int[] nums2, int j) {
//	    while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
//	        i++;
//	        j++;
//	    }
//	    return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
//	}
	// wrong idea can't use the next element to determine whether is i or j to shift
	// should still use the idea above
//	private int[] merge(int[] nums1, int[] nums2, int k) {
//	    int[] ans = new int[k];
//	    for (int i = 0, j = 0, r = 0; r < k; ++r) {
////	        ans[r] = compare(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
//	    	ans[r] = (j == nums2.length -1 || (i < nums1.length && nums1[i] > nums2[j])) ? nums1[i++] : nums2[j++];
//	    	if (i == nums1.length) {
//	    		ans[r] = nums2[j++];
//	    	} else if (j == nums2.length) {
//	    		ans[r] = nums1[i++];
//	    	} else {
//	    		if (nums1[i] > nums2[j]) {
//	    			ans[r] = nums1[i++];
//	    		} else if (nums1[i] < nums2[j]) {
//	    			ans[r] = nums2[j++];
//	    		} else {
//	    			if (j == nums2.length) {
//	    				ans[r] = nums1[i++];
//	    			} else if (i == nums1.length ) {
//	    				ans[r] = nums2[j++];
//	    			} else {
//	    				ans[r] = nums1[i + 1] > nums2[j + 1] ? nums1[i++] : nums2[j++];
//	    			}
//	    		}
//	    	}
//	    }
//	    return ans;
//	}
	
	
	public int[] maxArray(int[] nums, int k) { // amazing it is O（n) it looks like the 
											   // algorithms is 0(n*k) but actually it is 
											   // 0(n)
	    int n = nums.length;
	    int[] ans = new int[k];
//	    System.out.println(n);
//	    int count = 0;
	    for (int i = 0, j = 0; i < n; ++i) {
	        while (n - i + j > k && j > 0 && ans[j - 1] < nums[i]){
	        	j--;// 
//	        	count++;
	        } 
	        if (j < k) 
	        	ans[j++] = nums[i];
	    }
//	    System.out.println(count);
	    return ans;
	}
	
	
	// MV Solution
//	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
//        int get_from_nums1 = Math.min(nums1.length, k);
//        int[] ans = new int[k];
//        for (int i = Math.max(k - nums2.length, 0); i <= get_from_nums1; i++) {
//            int[] res1 = new int[i];
//            if (i > 0)
//                res1 = solve(nums1, i);
//            int[] res2 = new int[k - i];
//            if (k - i > 0)
//                res2 = solve(nums2, k - i);
//            int pos1 = 0, pos2 = 0, tpos = 0;
//            int[] res = new int[k];
//            while (res1.length > 0 && res2.length > 0 && pos1 < res1.length && pos2 < res2.length) {
//                if (res1[pos1] > res2[pos2])
//                    res[tpos++] = res1[pos1++];
//                else if (res1[pos1] < res2[pos2])
//                    res[tpos++] = res2[pos2++];
//                else {
//                    int x = pos1;
//                    int y = pos2;
//                    while (x < res1.length && y < res2.length && res1[x] == res2[y]) {
//                        x++;
//                        y++;
//                    }
//                    if (x < res1.length && y < res2.length) {
//                        if (res1[x] < res2[y]) {
//                            res[tpos++] = res2[pos2++];
//                        } else {
//                            res[tpos++] = res1[pos1++];
//                        }
//                    } else if (x < res1.length) {
//                        res[tpos++] = res1[pos1++];
//                    } else {
//                        res[tpos++] = res2[pos2++];
//                    }
//                }
//            }
//            while (pos1 < res1.length)
//                res[tpos++] = res1[pos1++];
//            while (pos2 < res2.length)
//                res[tpos++] = res2[pos2++];
//
//            if (updateAns(ans, res))
//                ans = res;
//        }
//        return ans;
//    }
//
//    public boolean updateAns(int[] ans, int[] res) {
//        for (int i = 0; i < ans.length; i++) {
//            if (ans[i] > res[i])
//                return false;
//            if (ans[i] < res[i])
//                return true;
//        }
//        return false;
//    }
//
//    public int[] solve(int[] nums, int k) {
//        int[] res = new int[k];
//        int len = 0;
//        for (int i = 0; i < nums.length; i++) {
//            while (len > 0 && len + nums.length - i > k && res[len - 1] < nums[i]) {
//                len--;
//            }
//            if (len < k)
//                res[len++] = nums[i];
//        }
//        return res;
//    }
	 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CreateMaximumNumber t = new CreateMaximumNumber();
//		int[] nums1 = {3, 4, 6, 5};
//		int[] nums2 = {9, 1, 2, 5, 8, 3};
//		int[] res = t.maxNumber(nums1, nums2, 5);
//		for (int i = 0; i < res.length; i++) {
//			System.out.print(res[i] + " ");
//		}
		
//		int[] nums1 = {6, 7};
//		int[] nums2 = {6, 0, 4};
//		int[] res = t.maxNumber(nums1, nums2, 5);
//		for (int i = 0; i < res.length; i++) {
//			System.out.print(res[i] + " ");
//		}
		
		int[] nums1 = {3, 9};
		int[] nums2 = {8, 9};
		int[] res = t.maxNumber(nums1, nums2, 3);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
		
//		System.out.println();
//		int[] test = {1,2,3,4,5,6,7,8,9,10};
//		int[] test = {3,2,5,1,21,6,2,90,32,21,5,6,7,2,21,288,2,5,32,543,121};
//		int[] test = {10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1};
//		int[] res2 = t.maxArray(test, 10);
//		for (int i = 0; i < res2.length; i++) {
//			System.out.print(res2[i] + " ");
//		}
		
	}
}
