/**
 * 2015年11月27日
 * Poirot
 */
package leetCodeEasy;

/**
 * @author Poirot
 *
 */
public class LongestCommonPrefix {
	//most votes
//	public String longestCommonPrefix(String[] strs) {
//	    if(strs == null || strs.length == 0)    return "";
//	    String pre = strs[0];
//	    int i = 1;
//	    while(i < strs.length){
//	        while(strs[i].indexOf(pre) != 0)
//	            pre = pre.substring(0,pre.length()-1);
//	        i++;
//	    }
//	    return pre;
//	}
	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		int minLength = Integer.MAX_VALUE;
		for (int i = 0; i < strs.length; i++) {
			if (strs[i].length() < minLength) {
				minLength = strs[i].length();
			}
		}
		boolean mark = true;
		for (int i = minLength; i >= 0; i--) {
			mark = true;
			String potentialString = strs[0].substring(0, i);
			for (int j = 1; j < strs.length; j++) {
				if (!strs[j].startsWith(potentialString)) {
					mark = false;
					break;
				}
			}
			if (mark) {
				return potentialString;
			}
		}
		return "";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
