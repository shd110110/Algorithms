package leetCodeMedium;
//150523
public class MinimumSizeSubarraySum {

	// O(N)
	public static int minSubArrayLen(int s, int[] nums) {
		int front = 0;
        int end = 0;
        int sum = 0;
        int minSub = Integer.MAX_VALUE;
        while(end < nums.length) {
            while(sum < s && end < nums.length)
                sum += nums[end++];
            while(sum >= s && front < nums.length) {
                minSub = Math.min(minSub, end - front);
                sum -= nums[front++];
            }
        }
        return minSub==Integer.MAX_VALUE? 0: minSub;
    }
 
    // second round O(nlog(n))
//    public int minSubArrayLen(int s, int[] nums) {
//        if (nums.length == 0) {
//            return 0;
//        }
//        int minLength = Integer.MAX_VALUE;
//        int[] sum = new int[nums.length + 1];
//        sum[0] = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] >= s) {
//                return 1;
//            }
//            sum[i + 1] = sum[i] + nums[i];
//            if (sum[i+1] >= s) {
//            	int index = binaryFind(sum, i, sum[i + 1] - s);
//                if (index != -1) {
//                     minLength = Math.min(minLength, i + 1 - index);
//                } 
//            }
//        }  
//        
////      for (int i = 0; i <= nums.length; i++) { 
////    		System.out.print(sum[i] + " ");
////    	}
////    	System.out.println();
//        if (minLength == Integer.MAX_VALUE) {
//            return 0;
//        } 
//        return minLength;
//    }	
//    
//    public int binaryFind(int[] sum, int end, int value) {
////    	System.out.println(sum[end] + " " + value);
//        int begin = 0;
//        while (begin < end - 1) {
//            int mid = (begin + end) / 2;
//            if (sum[mid] <= value) {
//                begin = mid;
//            } else {
//                end = mid - 1;
//            }
//        }
//        if (sum[end] <= value) {
//            return end;
//        } else if (sum[begin] <= value) {
//            return begin;
//        }  else {
//            return -1;
//        }
//    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumSizeSubarraySum t = new MinimumSizeSubarraySum();
		int[] test = {2,3,1,2,4,3};
		System.out.println(t.minSubArrayLen(7, test));
	}

}
