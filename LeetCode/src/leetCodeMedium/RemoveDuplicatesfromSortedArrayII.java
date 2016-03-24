package leetCodeMedium;

/**
 * @author Poirot
 * 2015年6月21日
 */
public class RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] nums) {
    	if (nums.length <=2) {
			return nums.length;
		}
        int begin = 0; 
        int duplicate = 1;
        int replace = 0;
        int result = 0;
        while (begin < nums.length) {
        	int k = begin+1;
        	duplicate = 1;
			while (k < nums.length && nums[k] == nums[k-1] )
			{
				duplicate++;
				k++;
			}
			if (duplicate < 3) {
				for (int j = 0; j < duplicate; j++) {
					nums[replace++] = nums[begin++];
					result++;
				} 
			}else {
				for (int j = 0; j < 2; j++) {
					nums[replace++] = nums[begin++];
					result++;
				}
			}
			begin = k;
		}
        return result;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveDuplicatesfromSortedArrayII t = new RemoveDuplicatesfromSortedArrayII();
		int[] test = {1,1,1,11,2,2,2,3};
		int r = t.removeDuplicates(test);
		for (int i = 0; i < r; i++) {
			System.out.println(test[i]);
		}
	}

}
