package leetCodeEasy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class FourSum {
	public List<List<Integer>> fourSum(int[] num, int target) {
		Set<List<Integer>> resultSetList = new HashSet<>();
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(num);
		int arraysLength = num.length;
		for (int i = 0; i <= arraysLength-4; i++) {
			for (int j = i+1; j <= arraysLength-3; j++) {
				int begin = j+1;
				int end = arraysLength-1;
				int twoSum = target - num[i]-num[j];
				while( begin<end){
					if (num[begin]+num[end] == twoSum) {
						List<Integer> t = new ArrayList<>();
						t.add(num[i]);
						t.add(num[j]);
						t.add(num[begin]);
						t.add(num[end]);
						resultSetList.add(t);
						begin++;
						end--;
					}else if (num[begin]+num[end] > twoSum) {
						end--;
					}else {
						begin++;
					}
				}
			}
		}
		Iterator<List<Integer>> iter = resultSetList.iterator();
		while (iter.hasNext()) {
			result.add(iter.next());
		}
		return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
