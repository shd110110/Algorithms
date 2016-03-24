package leetCodeHard;

import java.util.HashSet;

/**
 * @author Poirot
 * 2015年6月23日
 */
public class JumpGameII {
	public int jump(int[] nums){
		if (nums.length==0) {
			return 0;
		}
        if (nums.length == 1) {
			return 0;
		} 
        HashSet<Integer> temp = new HashSet<Integer>();
        for (int i = 0; i < nums.length-1; i++) {
			if (i+ nums[i] >= nums.length-1) {
				temp.add(i);
			}
		}  
        if (temp.size() == 0) { 
			return -1;
		}
        if (temp.contains(0)) { 
			return 1;
		}
        int begin = 0;
        int currentMax  = begin+nums[begin]; 
        int steps = 1;
        while(currentMax < nums.length-1){
        	int tempMax = Integer.MIN_VALUE;
        	for (int i = begin; i <= currentMax; i++) {
    			if (i+nums[i] > tempMax) {
    				tempMax = i + nums[i];
    			}
    		}
        	if (tempMax == currentMax && tempMax < nums.length-1) {
				return 0;
			}
        	begin = currentMax +1;
        	steps++;
        	currentMax = tempMax;
        }
        return steps;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		JumpGameII t = new JumpGameII();
		int[] nums = {2,3,1,1,0,1};
		System.out.println(t.jump(nums));
	} 
}
