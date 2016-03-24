package leetCodeMedium;  
import java.util.HashSet; 
 
//150617
public class JumpGame {
	 
	public boolean canJump(int[] nums) {
        if (nums.length==0) {
			return false;
		}
        if (nums.length == 1) {
			return nums[0]>=0;
		} 
        HashSet<Integer> temp = new HashSet<Integer>();
        for (int i = 0; i < nums.length-1; i++) {
			if (i+ nums[i] >= nums.length-1) {
				temp.add(i);
			}
		}  
        if (temp.size() == 0) { 
			return false;
		}
        if (temp.contains(0)) { 
			return true;
		}
        int begin = 0;
        int currentMax  = begin+nums[begin]; 
        while(currentMax < nums.length-1){
        	int tempMax = Integer.MIN_VALUE;
        	for (int i = begin; i <= currentMax; i++) {
    			if (i+nums[i] > tempMax) {
    				tempMax = i + nums[i];
    			}
    		}
        	if (tempMax == currentMax && tempMax < nums.length-1) {
				return false;
			}
        	begin = currentMax +1;
        	currentMax = tempMax;
        }
        return true;
	} 
	public static void main(String[] args) { 
		JumpGame t = new JumpGame();
		int[] test = new int[25003];
		for (int i = 0; i < 25000; i++) {
			test[i] = 25000-i;
		}
		test[25000] = 1;
		test[25001] = 0;
		test[25002] = 0; 
		int[] test2 ={1,1,1,0};
		System.out.println(t.canJump(test2));
	} 
}
