package leetCodeMedium;
//150605
public class SearchInsertPosition {
	public static int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
			return 0;
		}
        if (nums.length == 1) {
        	if(nums[0] == target)
                return 0;
			return nums[0] >target?0:1;
		}
        int begin = 0;
        int end = nums.length-1;
        int medium = (begin + end)/2;
        while (begin < end){
        	if (nums[medium] > target) {
				end = medium;
				medium = (begin + end)/2;
				if (medium == begin) {
					return nums[begin] >= target? begin:begin+1;
				}
			}else if (nums[medium] < target) {
				begin = medium;
				medium = (begin + end)/2;
				if (medium == begin) {
					return nums[end] >= target?end:end+1;
				}
			}else {
				return medium;
			} 
        }
        return begin+1;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = {1,3,5,6};
		System.out.println(searchInsert(test, 5));
		System.out.println(searchInsert(test, 2));
		System.out.println(searchInsert(test, 7));
		System.out.println(searchInsert(test, 0));
		
	}

}
