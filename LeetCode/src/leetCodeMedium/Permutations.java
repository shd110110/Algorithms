/**
 * 2015��6��19��
 * CH
 */
package leetCodeMedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List; 

/**
 * @author CH
 *
 */
public class Permutations {
//	List<List<Integer>> result = new ArrayList<List<Integer>>();
//	public List<List<Integer>> permute(int[] nums) { 
//		permuteForCall(nums, new ArrayList<Integer>(), new HashSet<Integer>()); 
//        return result;
//    }
//	public void permuteForCall(int[] nums, ArrayList<Integer> tempList,HashSet<Integer> indexSet) {
//		if (tempList.size() == nums.length) {
//			result.add(tempList);
//			return;
//		}
//		for (int i = 0; i < nums.length; i++) {
//			if (!indexSet.contains(i)) {
//				ArrayList<Integer> list = new ArrayList<Integer>(tempList);
//				list.add(nums[i]);
//				HashSet<Integer> set = new HashSet<Integer>(indexSet);
//				set.add(i);
//				permuteForCall(nums, list, set);
//			}
//		}
//	}
	
	
	// MV Solution
	public List<List<Integer>> permute(int[] num) {
		List<List<Integer>> result = new ArrayList<>();
        permuteRecursive(num, 0, result);
        return result;
    }

    // permute num[begin..end]
    // invariant: num[0..begin-1] have been fixed/permuted
    public void permuteRecursive(int[] num, int begin, List<List<Integer>> result)    {
        if (begin >= num.length) {
            // one permutation instance
        	
        	List<Integer> list = new ArrayList<>();
        	for (int i = 0; i < num.length; i++) {
        		list.add(num[i]);
        	}
            result.add(list);
            return;
        }

        for (int i = begin; i < num.length; i++) {
            swap(num ,begin, i);
            permuteRecursive(num, begin + 1, result);
            // reset
            swap(num ,begin, i);
        }
    }
    
    public void swap(int[] num, int i, int j) {
    	int temp = num[i];
    	num[i] = num[j];
    	num[j] = temp;
    }
	
	// MV Solution of Java
//	public List<List<Integer>> permute(int[] num) {
//	    List<List<Integer>> ans = new ArrayList<List<Integer>>();
//	    if (num.length ==0) return ans;
//	    List<Integer> l0 = new ArrayList<Integer>();
//	    l0.add(num[0]);
//	    ans.add(l0);
//	    for (int i = 1; i< num.length; ++i){
//	        List<List<Integer>> new_ans = new ArrayList<List<Integer>>(); 
//	        for (int j = 0; j<=i; ++j){            
//	           for (List<Integer> l : ans){
//	               List<Integer> new_l = new ArrayList<Integer>(l);
//	               new_l.add(j,num[i]);
//	               new_ans.add(new_l);
//	           }
//	        }
//	        ans = new_ans;
//	    }
//	    return ans;
//	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Permutations t = new Permutations();
		int[] test = {1,2,3};
		List<List<Integer>> r = t.permute(test);
		for (int i = 0; i < r.size(); i++) {
			for (int j = 0; j < r.get(i).size(); j++) {
				System.out.print(r.get(i).get(j));
			}
			System.out.println();
		}
		
		
		
		String[] array=new String[3];  
        array[0]="王利虎";  
        array[1]="张三";  
        array[2]="李四";  
        List<String> list=Arrays.asList(array);  
        for(int i=0;i<list.size();i++){  
            System.out.println(list.get(i));  
        }  
	}

}
