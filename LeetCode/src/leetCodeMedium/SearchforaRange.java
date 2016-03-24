package leetCodeMedium;
//150605
public class SearchforaRange {
	public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0 || target <nums[0] || target > nums[nums.length-1]) {
			return new int[]{-1, -1};
		}
        int[] result = new int[2];
        int begin = 0;
        int end = nums.length-1;
        int startIndex = (begin + end)/2;
        while (begin < end){
        	if (nums[startIndex] > target) {
				end = startIndex-1;
				startIndex = (begin + end)/2;
        	}else if(nums[startIndex] < target){
				begin = startIndex+1;
				startIndex = (begin + end)/2;
			}else {
				end = startIndex;
				startIndex = (begin + end)/2;
				
			}
        } 
        
        begin = 0;
        end = nums.length-1;
        int endIndex = (begin + end)/2;
        while (begin < end){
        	if (nums[endIndex] < target) {
				begin = endIndex+1;
				endIndex = (begin + end)/2;
        	}else if(nums[endIndex] > target){
				end = endIndex-1; 
				endIndex = (begin + end)/2;
			}else {
				begin = endIndex;
				endIndex = (begin+end)/2;
				if (nums[end] == target) {
					endIndex = end;
					break;
				}else {
					end --;
				}
			}
        }
        if (nums[startIndex] != target) {
        	 result[0] = -1;
             result[1] = -1;
		}else {
			 result[0] = startIndex;
		     result[1] = endIndex;
		} 
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] t = {5, 7, 7, 8, 8, 10};
		int[] test = searchRange(t, 8);
		for (int i = 0; i < test.length; i++) {
			System.out.println(test[i]);
		}	
	}

}
