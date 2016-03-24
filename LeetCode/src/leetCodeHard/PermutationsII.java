/**
 * 2015Äê6ÔÂ19ÈÕ
 * CH
 */
package leetCodeHard;

import java.util.ArrayList; 
import java.util.HashSet;
import java.util.LinkedList;
//import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author CH
 *
 */
public class PermutationsII {
	
	public List<List<Integer>> permuteUnique(int[] num) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        res.add(new ArrayList<>());
        for (int i = 0; i < num.length; i++) {
            Set<String> cache = new HashSet<>();
            while (res.peekFirst().size() == i) {
                List<Integer> l = res.removeFirst();
                for (int j = 0; j <= l.size(); j++) {
                    List<Integer> newL = new ArrayList<>(l.subList(0,j));
                    newL.add(num[i]);
                    newL.addAll(l.subList(j,l.size()));
                    if (cache.add(newL.toString())) res.add(newL);
                }
            }
        }
        return res;
    }
	
	
	
//	List<List<Integer>> result = new ArrayList<List<Integer>>();
//
//	public List<List<Integer>> permuteUnique(int[] nums) {
//		Arrays.sort(nums);
//		permuteForCall(nums, new LinkedList<Integer>(), 0);
//		return result;
//	}
//
//	public void permuteForCall(int[] nums, LinkedList<Integer> tempList, int k) {
//		if (tempList.size() == nums.length) {
//			result.add(tempList);
//			return;
//		}
//
//		for (int j = 0; j <= tempList.size(); j++) {
//			
//			if (j == 0) {
//				LinkedList<Integer> temp = new LinkedList<Integer>();
//				temp.add(nums[k]);
//			    temp.addAll(tempList);
//				permuteForCall(nums, temp, k + 1);
//			} else if (j == tempList.size()) {
//				if (nums[k] != nums[j - 1]) {
//					LinkedList<Integer> temp = new LinkedList<Integer>(); 
//				    temp.addAll(tempList);
//					temp.add(nums[k]);
//					permuteForCall(nums, temp, k + 1);
//				}
//			} else {
//				if (nums[k] != nums[j - 1]) {
//					LinkedList<Integer> temp = new LinkedList<Integer>(); 
//				    temp.addAll(tempList.subList(0, j));
//					temp.add(j, nums[k]);
//					temp.addAll(tempList.subList(j, tempList.size()));
//					permuteForCall(nums, temp, k + 1);
//				}
//			}
//		}
//	}

	
	
//	public List<List<Integer>> permuteUnique(int[] nums) {
//		Arrays.sort(nums);
//		boolean[] isVisited = new boolean[nums.length];
//		List<List<Integer>> result = new ArrayList<>();
//		
//		dfs(nums, isVisited, new ArrayList<Integer>(), result);
//		return result;
//	}
//
//	public void dfs(int[] nums, boolean[] isVisited, List<Integer> path,
//			List<List<Integer>> result) {
//		if (path.size() == nums.length) {
//			result.add(path);
//			return;
//		}
//		for (int i = 0; i < nums.length; i++) {
//			if (i > 0 && !isVisited[i - 1] && nums[i] == nums[i - 1])
//				continue;
//			if (!isVisited[i]) {
//				List<Integer> nPath = new ArrayList<>(path);
//				nPath.add(nums[i]);
//				isVisited[i] = true;
//				dfs(nums, isVisited, nPath, result);
//				isVisited[i] = false;
//			}
//		}
//		  
//	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PermutationsII t = new PermutationsII();
		int[] test = { -1, 2, 0, -1, 1, 0, 1 };
		// int[] test = {3,3,0,0,2,3,2};
		List<List<Integer>> r = t.permuteUnique(test);
		int count = 0;
		for (int i = 0; i < r.size(); i++) {
			for (int j = 0; j < r.get(i).size(); j++) {

				System.out.print(r.get(i).get(j) + "  ");
			}
			count++;
			System.out.println();
		}
		System.out.println(count);
	}

}
