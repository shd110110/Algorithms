package leetCodeMedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//150617
public class CombinationSumII {
//	Set<List<Integer>> result = new HashSet<>();
//
//	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//		Arrays.sort(candidates);
//		for (int i = 0; i < candidates.length; i++) {
//			ArrayList<Integer> temp = new ArrayList<>();
//			temp.add(candidates[i]);
//			combinationSumForCall(candidates, i + 1, target - candidates[i], temp);
//		}
//		List<List<Integer>> resultList = new ArrayList<>(result);
//
//		return resultList;
//	}
//
//	public void combinationSumForCall(int[] candidates, int beginIndex, int target, ArrayList<Integer> temp) {
//		if (target == 0) {
//			result.add(temp);
//			return;
//		}
//		if (beginIndex >= candidates.length || candidates[beginIndex] > target) {
//			return;
//		}
//		for (int i = beginIndex; i < candidates.length; i++) {
//			if (candidates[i] > target) {
//				break;
//			}
//			ArrayList<Integer> list = new ArrayList<>(temp);
//			list.add(candidates[i]);
//			combinationSumForCall(candidates, i + 1, target - candidates[i], list);
//		}
//	}

	// second round
	List<List<Integer>> res = new ArrayList<>();
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		forCall(candidates, 0, target, new ArrayList<>());
		return res;
	}

	public void forCall(int[] candidates, int begin, int target, List<Integer> temp) {
		if (target == 0) {
			res.add(temp);
			return;
		}
		if (begin >= candidates.length) {
			return;
		}
		for (int i = begin; i < candidates.length && target >= candidates[i]; i++) {
			if (i > begin && candidates[i] == candidates[i - 1]) {
				continue;
			}
			List<Integer> next = new ArrayList<Integer>(temp);
			next.add(candidates[i]);
			forCall(candidates, i + 1, target - candidates[i], next);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CombinationSumII t = new CombinationSumII();
		// int[] candidates = {10,1,2,7,6,1,5};
		int[] candidates = { 9, 21, 25, 14, 12, 12, 33, 34, 23, 31, 25, 7, 11, 20, 30, 13, 22, 25, 13, 27, 31, 15, 12,
				26, 11, 20, 25, 6, 15, 5, 5, 11, 22, 17, 20, 29, 25, 10, 20, 5, 6, 32, 29, 5, 17, 17, 13, 5, 29, 13, 19,
				25, 15, 26, 8, 14, 33, 28, 15, 5, 21, 7, 12, 8, 19, 27, 24, 31, 25 };

		List<List<Integer>> resultList = t.combinationSum2(candidates, 24);
		for (int i = 0; i < resultList.size(); i++) {
			for (int j = 0; j < resultList.get(i).size(); j++) {
				System.out.print(resultList.get(i).get(j) + "  ");
			}
			System.out.println();
		}
	}

}
