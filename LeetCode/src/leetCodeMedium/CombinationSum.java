package leetCodeMedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//150617
public class CombinationSum {
	List<List<Integer>> result = new ArrayList<>();
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
        for (int i = 0; i < candidates.length; i++) {
        	ArrayList<Integer> temp = new ArrayList<>();
        	temp.add(candidates[i]);
			combinationSumForCall(candidates, i, target-candidates[i], temp);
		}
		return result;
    }
	public void combinationSumForCall(int[] candidates, int beginIndex,int target, ArrayList<Integer> temp){
		if (target == 0) {
			result.add(temp);
			return;
		}
		if (target < 0 || candidates[beginIndex] >target) {
			return;
		}
		for (int i = beginIndex; i < candidates.length; i++) {
			if (candidates[i] > target) {
				break;
			}
			ArrayList<Integer> list = new ArrayList<>(temp);
			list.add(candidates[i]);
			combinationSumForCall(candidates, i, target-candidates[i], list);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CombinationSum t = new CombinationSum();
		int[] candidates = {8,7,4,3};
		List<List<Integer>> resultList = t.combinationSum(candidates, 11);
		for (int i = 0; i < resultList.size(); i++) {
			for (int j = 0; j < resultList.get(i).size(); j++) {
				System.out.print(resultList.get(i).get(j) + "  ");
			}
			System.out.println();
		}
	}

}
