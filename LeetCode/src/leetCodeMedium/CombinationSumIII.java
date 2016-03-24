package leetCodeMedium;

import java.util.ArrayList;
import java.util.List;
//150531
public class CombinationSumIII {
//	List<List<Integer>> result = new ArrayList<>();
//	public List<List<Integer>> combinationSum3(int k, int n) {
//		if (n > 45) {
//			return result;
//		}
//		for (int i = 1; i <= 9-k+1; i++) {
//			List<Integer> temp = new ArrayList<>();
//			temp.add(i);
//			Digui(temp,i+1,k-1, n-i);
//		}
//		
//		return result;
//    }
//	
//	public void Digui(List<Integer> temp,int begin,int k, int n){
//		if (k == 0 && n == 0) {
//			result.add(temp);
//			return;
//		}else if (begin > n || n < 0) {
//			return;
//		}
//		if (k == 0 && n > 0) {
//			return;
//		}else{
//			for (int i = begin; i <= 9; i++) {
//				List<Integer> temp1 = new ArrayList<>();
//				temp1.addAll(temp);
//				temp1.add(i);
//				Digui(temp1, i+1, k-1, n-i);
//			}
//		}
//		
//		
//	}
	
	// second round
//	List<List<Integer>> res = new ArrayList<>();
//    public List<List<Integer>> combinationSum3(int k, int n) {   
//        if (n > k * 9) {
//            return res;
//        }
//        forCall(1, k, n, new ArrayList<>());
//        return res;
//    }	
//    public void forCall(int begin, int k, int n, List<Integer> temp) {
//        if (n == 0) {
//            if (k == 0) {
//                res.add(temp);
//            }
//            return;
//        }  
//        if (begin > 9 || n < begin) {
//            return;
//        }
////        System.out.println("test");
//        for (int i = begin; i <= 9 && n >= i * k; i++) {
//            List<Integer> next = new ArrayList<>(temp);
//            next.add(i);
//            forCall(i + 1, k - 1, n - i, next);
//        }
//    }
	
	public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        combination(ans, new ArrayList<Integer>(), k, 1, n);
        return ans;
    }
    
    private void combination(List<List<Integer>> ans, List<Integer> comb, int k,  int start, int n) {
        if (comb.size() == k && n == 0) {
            List<Integer> li = new ArrayList<Integer>(comb);
            ans.add(li);
            return;
        }
        for (int i = start; i <= 9 && n >= i * (k - comb.size()); i++) {
            comb.add(i);
            combination(ans, comb, k, i+1, n-i);
            comb.remove(comb.size() - 1);
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CombinationSumIII test = new CombinationSumIII();
//		List<List<Integer>> result = test.combinationSum3(3, 9);
		List<List<Integer>> result = test.combinationSum3(2, 6);
		for (int i = 0; i < result.size(); i++) {
			for (int j = 0; j < result.get(i).size(); j++) {
				System.out.print(result.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

}
