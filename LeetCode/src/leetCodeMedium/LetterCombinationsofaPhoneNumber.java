/**
 * 2016年3月14日
 * Poirot
 * 上午11:04:29
 * LeetCode
 */
package leetCodeMedium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Poirot
 *
 */
public class LetterCombinationsofaPhoneNumber {
	String[] strs = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
        	return new ArrayList<>();
        } 
        char[] chars = strs[digits.charAt(0) - '0'].toCharArray();  
        
        List<String> res = new ArrayList<>(); 
        if (digits.length() == 1) {
       	 	for (char c : chars) {
       	 		res.add(String.valueOf(c));
       	 	}
       	 	return res;
        }
        List<String> next = letterCombinations(digits.substring(1));
        for (String string : next) {
        	for (char c : chars) {
        		res.add(c + string);
        	}
        }
        return res;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
