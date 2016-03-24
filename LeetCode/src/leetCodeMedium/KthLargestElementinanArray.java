package leetCodeMedium;

/**
 * @author Poirot
 * 2015年7月5日
 */
public class KthLargestElementinanArray {
//	public int findKthLargest(int[] nums, int k) {
//		k = nums.length - k + 1; //转换成求第 length-k +1 小的数
////		System.out.println(k);
//		return findKthLargestDigui(nums, 0, nums.length-1, k);		
//	}
//	public int findKthLargestDigui(int[] nums, int p, int r, int i){
//		if (p == r) {
//			return nums[p];
//		}
//		int q = partition(nums, p, r); 
//		int k = q - p + 1;
//		if (i == k) {
//			return nums[q];
//		}else if (i < k) {
//			return findKthLargestDigui(nums, p, q-1, i);
//		}else {
////			System.out.println("hello");
//			return findKthLargestDigui(nums, q+1, r, i-k);
//		}
//	}
//	public int partition(int[] nums, int begin, int end){
//		int x = nums[end];
//		int i = begin-1;
//		for (int j = begin; j < end; j++) {
//			if (nums[j] <= x) {
//				i ++;
//				int temp = nums[j];
//				nums[j] = nums[i];
//				nums[i] = temp;
//			}
//		}
//		int temp = nums[end];
//		nums[end] = nums[i+1];
//		nums[i+1] = temp;
//		return i+1;
//	}
	
	public int findKthLargest(int[] nums, int k) {
        return findKthLargestInSection(nums, 0, nums.length - 1, k);
    }
    
    public int findKthLargestInSection(int[] nums, int begin, int end, int k) {
        if (begin == end) {
            return nums[begin];
        }
        int q = partition(nums, begin, end);
        int x = end - q + 1;
        if (k == x) {
            return nums[q];
        } else if (x < k) {
            return findKthLargestInSection(nums, begin, q - 1, k - x);
        } else {
            return findKthLargestInSection(nums, q + 1, end, k);
        }
    }
    
    public int partition(int[] nums, int begin, int end) {
        int x = nums[end];
        int left = begin - 1;
        for (int i = begin; i < end; i++) {
            if (nums[i] < x) {
                left++;
                int temp = nums[i];
                nums[i] = nums[left];
                nums[left] = temp;
            } 
        }
        int temp = nums[left+1];
        nums[left+1] = nums[end];
        nums[end] = temp;
        return left + 1;
    }	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KthLargestElementinanArray t = new KthLargestElementinanArray();
//		int[] nums = {-1,2,0,2};
		int[] nums = {3,2,3,1,2,4,5,5,6};
		System.out.println(t.findKthLargest(nums, 9));
	}

}
