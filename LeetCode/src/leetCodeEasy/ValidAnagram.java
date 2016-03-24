package leetCodeEasy;

//import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Poirot
 * 2015年8月17日
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
    	//solutions 1, sort
//        if (s == null && t != null || s != null && t == null) {
//			return false;
//		} 
//        if (s.equals(t)) {
//			return true;
//		}
//        if (s.length() != t.length()) {
//			return false;
//		}
//        char[] sArray = s.toCharArray();
//        Arrays.sort(sArray);
//        char[] tArray = t.toCharArray();
//        Arrays.sort(tArray);
//        for (int i = 0; i < tArray.length; i++) {
//			if (sArray[i] != tArray[i]) {
//				return false;
//			}
//		}
//        return true;
    	
    	//solution 2
    	if (s == null && t != null || s != null && t == null) {
			return false;
		} 
    	if (s.equals(t)) {
			return true;
		}
    	if (s.length() != t.length()) {
			return false;
		}
    	HashMap<Character, Integer> sMap = new HashMap<>();
    	for (int i = 0; i < s.length(); i++) {
			sMap.put(s.charAt(i), sMap.containsKey(s.charAt(i)) ? sMap.get(s.charAt(i)) + 1 : 1);
		}
    	for (int i = 0; i < t.length(); i++) {
    		if (!sMap.containsKey(t.charAt(i))) {
				return false;
			}
			if (sMap.containsKey(t.charAt(i)) && sMap.get(t.charAt(i)) == 1) {
				sMap.remove(t.charAt(i));
			} else {
				sMap.put(t.charAt(i), sMap.get(t.charAt(i)) - 1);
			}
		}
    	return sMap.isEmpty();
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
