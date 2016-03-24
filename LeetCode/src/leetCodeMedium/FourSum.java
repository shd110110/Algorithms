/**
 * 2015年11月29日
 * Poirot
 */
package leetCodeMedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Poirot
 *
 */
public class FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length<4) {
        	return res;
        }
        Arrays.sort(nums);
        for(int i=0; i < nums.length-3; i++){
            if(i>0 && nums[i]==nums[i-1]) {
            	continue;
            }
            if (nums[i] > target / 4) {
				return res;
			}
            for(int j=i+1; j<nums.length-2; j++){
                if(j>i+1 && nums[j]==nums[j-1])
                	continue;
                int begin=j+1, end=nums.length-1;
                int sum=target - nums[i] - nums[j];
                while(begin<end){
                    if(nums[begin]+nums[end] == sum){
                        res.add(Arrays.asList(nums[i], nums[j], nums[begin], nums[end]));
                        while(begin<end && nums[begin]==nums[begin+1])
                        	begin++;
                        while(begin<end&&nums[end]==nums[end-1])
                        	end--;
                        begin++;
                        end--;
                    } else if(nums[begin]+nums[end] < sum) {
                    	begin++;
                    } else {
                    	end--;
                    }
                }
            }
        }
        return res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FourSum t = new FourSum();
		int[] nums = {1, 0, -1, 0, -2, 2};
		List<List<Integer>> res = t.fourSum(nums, 0);
		for (int i = 0; i < res.size(); i++) {
			for (int j = 0; j < res.get(i).size(); j++) {
				System.out.print(res.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

}
