package leetCodeHard;
 
/**
 * @author Poirot
 * 2015年6月21日
 */
public class SearchinRotatedSortedArray {
	// O(N)
//	public int search(int[] nums, int target) {
//		int index = 0;
//        for (int i = 0; i < nums.length-1; i++) {
//			if (nums[i] > nums[i+1] ) {
//				index = i;
//				break;
//			}
//		}
//        int result = -1;
//        if ((result = forCall(nums, target, 0, index)) !=-1) {
//        	return result;
//		}
//        if ((result = forCall(nums, target, index+1, nums.length-1)) !=-1) {
//        	return result;
//		}
//        return -1;
//    }
//	
//	public int forCall(int[] nums, int target,int begin, int end) { 
//		int medium = (begin+end)/2;
//		while (begin <= end){
//			if (nums[medium] > target) {
//				end = medium-1;
//				medium = (begin+end)/2;
//			}else if (nums[medium] < target) {
//				begin = medium +1;
//				medium = (begin+end)/2;
//			}else {
//				return medium;
//			}
//		}
//		return -1;
//	}
	
	
	// second round   O(log(N))  1ms 
	public int search(int[] nums, int target) {
        int begin = 0;
        int end = nums.length - 1;
        while (begin < end) {
            int medium = (begin + end) / 2;
            if (nums[medium] >= nums[begin] && nums[medium] > nums[end]) {
                if (nums[medium] < target) {
                    begin = medium + 1;
                } else if (nums[medium] > target) {
                    if (nums[begin] > target) {
                        begin = medium + 1; 
                    } else if (nums[begin] < target) {
                        end = medium - 1; 
                    } else {
                        return begin;
                    }
                } else {
                    return medium;
                }
            } else if (nums[medium] < nums[begin] && nums[medium] < nums[end]) {
                if (nums[medium] > target) {
                    end = medium - 1; 
                } else if (nums[medium] < target) {
                    if (nums[end] > target) {
                        begin = medium + 1; 
                    } else if (nums[end] < target) {
                        end = medium - 1; 
                    } else {
                        return end;
                    }
                } else {
                    return medium;
                }
            } else {
                return binaryFind(nums, begin, end, target);
            }
        }
        if (nums[begin] == target) {
            return begin;
        } else {
            return -1;
        }
    }
    
    public int binaryFind(int[] nums, int begin, int end, int target) {
        while (begin < end) {
            int medium = (begin + end) / 2;
            if (nums[medium] < target) {
                begin = medium + 1;
            } else if (nums[medium] > target) {
                end = medium - 1;
            } else {
                return medium;
            }
        }
        return nums[begin] == target ? begin : -1;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchinRotatedSortedArray t = new SearchinRotatedSortedArray();
		int[] test = {4, 5, 6, 7, 0, 1, 2};
		System.out.println(t.search(test, 6));
	}

}
