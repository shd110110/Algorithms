package leetCodeMedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Poirot
 * 2015年6月13日
 */
public class SubsetsII {
	
	//other's answer
//	public List<List<Integer>> subsetsWithDup(int[] nums) {
//        List<List<Integer>> res = new ArrayList<List<Integer>>();
//        List<Integer> subsets = new ArrayList<Integer>();
//        res.add(new ArrayList());
//        Arrays.sort(nums);
//        doSubsets(nums,res,subsets,0);
//        return res;
//    }
//
//    private void doSubsets(int[] nums, List res, List subsets, int start){
//        for(int i=start; i<nums.length; i++){
//            if(i!= start && nums[i] == nums[i-1])
//                continue;
//            subsets.add(nums[i]);
//            res.add(new ArrayList(subsets));
//            doSubsets(nums,res,subsets,i+1);
//            subsets.remove(subsets.size()-1);
//        }
//    }
	
	
	public Set<List<Integer>> tempSet = new HashSet<>();
	public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> temp0 = new ArrayList<>();
        tempSet.add(temp0);
        subsetsBycall(nums,1,nums.length -1, temp0);
        ArrayList<Integer> temp1 = new ArrayList<>();
        temp1.add(nums[0]);
        tempSet.add(temp1);
        subsetsBycall(nums, 1, nums.length-1, temp1);
        
        List<List<Integer>> result = new ArrayList<>(tempSet);
        return result;
    }
	
	public void subsetsBycall(int[] nums, int begin ,int end, ArrayList<Integer> temp){
		if (begin > end) {
			return;
		}
		ArrayList<Integer> temp0 = new ArrayList<>(temp);
		tempSet.add(temp0);
        subsetsBycall(nums,begin+1, end, temp0);
        ArrayList<Integer> temp1 = new ArrayList<>(temp);
        temp1.add(nums[begin]);
        tempSet.add(temp1);
        subsetsBycall(nums, begin+1, end, temp1);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
