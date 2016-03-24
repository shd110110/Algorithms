package leetCodeMedium;

/**
 * @author Poirot
 * 2015年6月20日
 */
public class SearchinRotatedSortedArray {
	public boolean search(int[] nums, int target) {
		int index = 0;
        for (int i = 0; i < nums.length-1; i++) {
			if (nums[i] > nums[i+1] ) {
				index = i;
				break;
			}
		}
        if (forCall(nums, target, 0, index) !=-1) {
        	return true;
		}
        if (forCall(nums, target, index+1, nums.length-1) !=-1) {
        	return true;
		}
        return false;
    }
	 
	
	public int forCall(int[] nums, int target,int begin, int end) { 
		int medium = (begin+end)/2;
		while (begin <= end){
			if (nums[medium] > target) {
				end = medium-1;
				medium = (begin+end)/2;
			}else if (nums[medium] < target) {
				begin = medium +1;
				medium = (begin+end)/2;
			}else {
				return medium;
			}
		}
		return -1;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
