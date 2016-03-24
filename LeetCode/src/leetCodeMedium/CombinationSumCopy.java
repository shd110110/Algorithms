package leetCodeMedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//150605
public class CombinationSumCopy {

	private List<List<Integer>> solution;

	private List<Integer> curSolution;

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		solution = new ArrayList<List<Integer>>();
		curSolution = new ArrayList<Integer>();
		Arrays.sort(candidates);
		backTrack(candidates, target, 0);
		return solution;
	}

	private void backTrack(int[] candidates, int target, int lastIdx) {
		if (target == 0) {
			solution.add(new ArrayList<>(curSolution));
		} else if (target < 0) {
			return;
		} else {
			int i = lastIdx;
			while (i < candidates.length) {
				int candidate = candidates[i];
				curSolution.add(candidate);
				backTrack(candidates, target - candidate, i);
				curSolution.remove(curSolution.size() - 1);
				while (i < candidates.length && candidates[i] == candidate) {
					i++;
				}
			}
		}
	}

	// List<List<Integer>> resultList = new ArrayList<>();
	//
	// public static int searchInsert(int[] nums, int target) {
	// if (nums.length == 0) {
	// return 0;
	// }
	// if (nums.length == 1) {
	// if (nums[0] == target)
	// return 0;
	// return nums[0] > target ? 0 : 1;
	// }
	// int begin = 0;
	// int end = nums.length - 1;
	// int medium = (begin + end) / 2;
	// while (begin < end) {
	// if (nums[medium] > target) {
	// end = medium;
	// medium = (begin + end) / 2;
	// if (medium == begin) {
	// return nums[begin] >= target ? begin : begin + 1;
	// }
	// } else if (nums[medium] < target) {
	// begin = medium;
	// medium = (begin + end) / 2;
	// if (medium == begin) {
	// return nums[end] >= target ? end : end + 1;
	// }
	// } else {
	// return medium;
	// }
	// }
	// return begin + 1;
	// }
	//
	// public List<List<Integer>> combinationSum(int[] candidates, int target) {
	//
	// // Set<List<Integer>> tempSet = new HashSet<List<Integer>>();
	// Arrays.sort(candidates);
	// int index = searchInsert(candidates, target);
	//
	// if (index < candidates.length && candidates[index] == target) {
	// List<Integer> temp = new ArrayList<Integer>();
	// temp.add(target);
	// resultList.add(temp);
	// }
	// int[] useable = new int[index];
	//
	// for (int i = 0; i < useable.length; i++) {
	// useable[i] = candidates[i];
	// System.out.print(useable[i] + "  ");
	// }
	// System.out.println();
	// for (int i = 0; i < useable.length; i++) {
	// ArrayList<Integer> temp = new ArrayList<Integer>();
	// temp.add(useable[i]);
	// findOne(useable, i, useable.length - 1, target - useable[i], temp);
	// }
	// return resultList;
	// }
	//
	// public void findOne(int[] useabel, int begin, int end, int target,
	// ArrayList<Integer> temp) {
	// if (target == 0) {
	// resultList.add(temp);
	// return;
	// }
	// if (target < 0) {
	// return;
	// }
	// int s = searchInsert(useabel, target);
	// System.out.println("s is: " +s +"  "+useabel[s]);
	// if (s < begin || s > end) {
	// return;
	// }
	// if (useabel[s] == target) {
	// temp.add(useabel[s]);
	// resultList.add(temp);
	// temp.remove(temp.size() - 1);
	// }
	// for (int i = begin; i < s; i++) {
	// temp.add(useabel[i]);
	// findOne(useabel, i, s - 1, target - useabel[i], temp);
	// temp.remove(temp.size() - 1);
	// }
	// }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = { 2, 3, 6, 7 };
		CombinationSumCopy t = new CombinationSumCopy();
		List<List<Integer>> r = t.combinationSum(test, 7);
		System.out.println();
		System.out.println();
		for (int i = 0; i < r.size(); i++) {
			for (int j = 0; j < r.get(i).size(); j++) {
				System.out.print(r.get(i).get(j) + "  ");
			}
			System.out.println();
		}
	}

}
