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
public class Subsets {
	//public List<List<Integer>> result = new ArrayList<>();
//	public Set<List<Integer>> tempSet = new HashSet<>();
//	public List<List<Integer>> subsets(int[] nums) {
//        Arrays.sort(nums);
//        ArrayList<Integer> temp0 = new ArrayList<>();
//        tempSet.add(temp0);
//        subsetsBycall(nums,1,nums.length -1, temp0);
//        ArrayList<Integer> temp1 = new ArrayList<>();
//        temp1.add(nums[0]);
//        tempSet.add(temp1);
//        subsetsBycall(nums, 1, nums.length-1, temp1);
//        
//        List<List<Integer>> result = new ArrayList<>(tempSet);
//        return result;
//    }
//	
//	public void subsetsBycall(int[] nums, int begin ,int end, ArrayList<Integer> temp){
//		if (begin > end) {
//			return;
//		}
//		
//		ArrayList<Integer> temp0 = new ArrayList<>(temp);
//		tempSet.add(temp0);
//        subsetsBycall(nums,begin+1, end, temp0);
//        ArrayList<Integer> temp1 = new ArrayList<>(temp);
//        temp1.add(nums[begin]);
//        tempSet.add(temp1);
//        subsetsBycall(nums, begin+1, end, temp1);
//	}
	
	// second round 
//    public List<List<Integer>> subsets(int[] nums) {
//        Arrays.sort(nums);
//        return dfs(nums, 0);
//    }
//    public List<List<Integer>> dfs(int[] nums, int begin) {
//        if (begin == nums.length) {
//            List<List<Integer>> res = new ArrayList<>();
//            res.add(new LinkedList<>());
//            return res;
//        }
//        List<List<Integer>> list = dfs(nums, begin + 1);
//        List<List<Integer>> cur = new ArrayList<>();
//        for (List<Integer> l : list) {
//            LinkedList<Integer> addBegin = new LinkedList<>(l);
//            addBegin.addFirst(nums[begin]);
//            cur.add(addBegin);
//        }
//        cur.addAll(list);
//        return cur;
//    }
	
	// Second round 2ms
//	List<List<Integer>> res = new ArrayList<>();
//    public List<List<Integer>> subsets(int[] nums) {
//        Arrays.sort(nums);
//        dfs(nums, 0, new ArrayList<>());
//        return res;
//    }
//    public void dfs(int[] nums, int begin, ArrayList<Integer> temp) {
//        if (begin == nums.length) {
//            res.add(temp);
//            return;
//        }  
//        ArrayList<Integer> addBegin = new ArrayList<>(temp);
//        addBegin.add(nums[begin]);
//        dfs(nums, begin + 1, addBegin);
//        ArrayList<Integer> notAddBegin = new ArrayList<>(temp);
//        dfs(nums, begin + 1, notAddBegin);
//        return;
//    }
	
	// 3ms 
	public List<List<Integer>> subsets(int[] nums) { 
		Arrays.sort(nums);
        int elem_num = nums.length;
        int subset_num = (int) Math.pow(2, elem_num);
        List<List<Integer>> subset_set = new ArrayList<>(subset_num);
        for (int j = 0; j < subset_num; j++) {
            subset_set.add(new ArrayList<>());
        }
        for (int i = 0; i < elem_num; i++) {
            for (int j = 0; j < subset_num; j++) {
                if (((j >> i) & 1) != 0) { 
                    subset_set.get(j).add(nums[i]);
                }
            }
        }
        return subset_set;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = {1,1,1,1};
		Subsets t = new Subsets();
		List<List<Integer>> r = t.subsets(test);
		for (int i = 0; i < r.size(); i++) {
			for (int j = 0; j < r.get(i).size(); j++) {
				System.out.print(r.get(i).get(j) + "  ");
			}
			System.out.println();
		}
		System.out.println("hello");
	}

}
