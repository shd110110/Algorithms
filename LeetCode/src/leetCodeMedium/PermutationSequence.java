/**
 * 2015Äê6ÔÂ19ÈÕ
 * CH
 */
package leetCodeMedium;

import java.util.ArrayList; 

/**
 * @author CH
 *
 */
public class PermutationSequence {
	// PriorityQueue<String> result = new PriorityQueue<String>();
	// int k = 0;
	// public String getPermutation(int n, int k) {
	// int nums[] = new int[n];
	// for (int i = 0; i < nums.length; i++) {
	// nums[i] = i+1;
	// }
	// this.k = k;
	// return permuteForCall(nums, new String(), new HashSet<Integer>());
	//
	// }
	// public String permuteForCall(int[] nums, String
	// tempString,HashSet<Integer> indexSet) {
	// if (tempString.length() == nums.length) {
	// result.add(tempString);
	// if (result.size() == this.k) {
	// return tempString;
	// }
	// return null;
	// }
	// for (int i = 0; i < nums.length; i++) {
	// if (!indexSet.contains(i)) {
	// String string= tempString+nums[i];
	// HashSet<Integer> set = new HashSet<Integer>(indexSet);
	// set.add(i);
	// String r = permuteForCall(nums, string, set);
	// if (r != null) {
	// return r;
	// }
	// }
	// }
	// return null;
	// }

	public String getPermutation(int n, int k) { 
		
		int[] temp = new int[n+1];
		int cardinal = 1;
		for (int i = 1; i < temp.length; i++) {
			cardinal *= i;
			temp[i] = cardinal; 
		} 
		if (k == 0 || k > temp[n]) {
			return null;
		}
		ArrayList<Character> characters = new ArrayList<Character>(); 
		for (int i = 1; i <= n; i++) {
			characters.add((char)(i+48));
		} 
		StringBuilder stringBuilder = new StringBuilder(); 
		k--;
		for (int i = temp.length-2 ; i >= 1; i--) {
			stringBuilder.append(characters.get(k/temp[i]));
			characters.remove(k/temp[i]);
			k%=temp[i];
		} 
		stringBuilder.append(characters.get(0));
		return stringBuilder.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PermutationSequence t = new PermutationSequence();
		System.out.println(t.getPermutation(3, 0));
	}

}
