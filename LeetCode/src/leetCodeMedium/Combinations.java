package leetCodeMedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
//150617
public class Combinations {
	List<List<Integer>> result = new ArrayList<>();
	public List<List<Integer>> combine(int n, int k) {
		combin2(n, k, 1, new ArrayList<>());
		return result;
    }
	public void combin2(int n,int k,int begin,ArrayList<Integer> temp){
		if (temp.size() == k || begin > n || n-begin+1 < k-temp.size()) {
			if (temp.size() == k) {
				result.add(temp);
			} 
			return;
		}
		ArrayList<Integer> temp1 = new ArrayList<>(temp);
		ArrayList<Integer> temp2 = new ArrayList<>(temp);
		temp1.add(begin);
		combin2(n, k, begin+1, temp1);
		combin2(n, k, begin+1, temp2);
	}
	
//	public List<List<Integer>> combine(int n, int k) {
//        return dfs(n, 1, k);
//    }	
//    
//    public List<List<Integer>> dfs(int n, int begin, int k) {
//        if (k == 0) {
//            List<List<Integer>> next = new ArrayList<>();
//            next.add(new LinkedList<>());
//            return next;
//        }
//        List<List<Integer>> res = new ArrayList<>();
//        for (int i = begin; i <= n - k + 1; i++) {
//            List<List<Integer>> next = dfs(n, i + 1, k -  1);
//            for (int j = 0; j < next.size(); j++) {
//            	((LinkedList<Integer>)next.get(j)).addFirst(i);
//            }
//            res.addAll(next);
//        }
//        return res;
//    }
    
    //MV Solution
//    public List<List<Integer>> combine(int n, int k) {
//        if (k == n || k == 0) {
//            List<Integer> row = new LinkedList<>();
//            for (int i = 1; i <= k; ++i) {
//                row.add(i);
//            }
//            return new LinkedList<>(Arrays.asList(row));
//        }
//        List<List<Integer>> result = this.combine(n - 1, k - 1);
//        result.forEach(e -> e.add(n));
//        result.addAll(this.combine(n - 1, k));
//        return result;
//    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
