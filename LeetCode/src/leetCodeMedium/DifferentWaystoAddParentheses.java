package leetCodeMedium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Poirot
 * 2015年8月17日
 */
public class DifferentWaystoAddParentheses {
	
    public List<Integer> diffWaysToCompute(String input) {
        if (input == null || input.length() == 0) {
			return new ArrayList<>();
		} 
        if (input.length() == 1 && Character.isDigit(input.charAt(0))) {
        	List<Integer> res = new ArrayList<>(); 
        	res.add(input.charAt(0) - '0');
        	return res;
		}
        
        List<Integer> res = new ArrayList<>();
        boolean isNumber = true;
        for (int i = 0; i < input.length(); i++) {
			if (!Character.isDigit(input.charAt(i))) {
				isNumber = false;
				List<Integer> left = diffWaysToCompute(input.substring(0, i));
				List<Integer> right = diffWaysToCompute(input.substring(i+1));
				if (input.charAt(i) == '-') {
					for (int j = 0; j < left.size(); j++) {
						for (int j2 = 0; j2 < right.size(); j2++) {
							res.add(left.get(j) - right.get(j2));
						}
					}
				} else if (input.charAt(i) == '+') {
					for (int j = 0; j < left.size(); j++) {
						for (int j2 = 0; j2 < right.size(); j2++) {
							res.add(left.get(j) + right.get(j2));
						}
					}
				} else {
					for (int j = 0; j < left.size(); j++) {
						for (int j2 = 0; j2 < right.size(); j2++) {
							res.add(left.get(j) * right.get(j2));
						}
					}
				}
				
			} 
		}
        if (isNumber) {
			res.add(Integer.valueOf(input));
		}
        return res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DifferentWaystoAddParentheses t = new DifferentWaystoAddParentheses();
		List<Integer> res = t.diffWaysToCompute("2*3-4*5");
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}
		
	}

}
