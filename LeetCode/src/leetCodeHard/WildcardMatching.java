package leetCodeHard;

/**
 * @author Poirot 2015年7月9日
 */
public class WildcardMatching {
	public boolean isMatch(String s, String p) {
        int sIndex = 0, pIndex = 0, matchIndex = 0, starIndex = -1;            
        while (sIndex < s.length()){
            // advancing both pointers
            if (pIndex < p.length()  && (p.charAt(pIndex) == '?' || s.charAt(sIndex) == p.charAt(pIndex))){
                sIndex++;
                pIndex++;
            }
            // * found, only advancing p pointer
            else if (pIndex < p.length() && p.charAt(pIndex) == '*'){
                starIndex = pIndex;
                matchIndex = sIndex;
                pIndex++;
            }
           // last p pointer was *, advancing string pointer
            else if (starIndex != -1){//此时*增加一个匹配字条 ： matchIndex++;
                pIndex = starIndex + 1;
                matchIndex++;
                sIndex = matchIndex;
            }
           //current p pointer is not star, last patter pointer was not *
          //characters do not match
            else return false;
        } 
        //check for remaining characters in p 剩余的都是*的情况
        while (pIndex < p.length() && p.charAt(pIndex) == '*')
            pIndex++; 
        return pIndex == p.length();
	} 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WildcardMatching t = new WildcardMatching();
//		String s = "aaa";
//		String p = "aaa";
		System.out.println(t.isMatch("ab", "?*"));
	}

}
