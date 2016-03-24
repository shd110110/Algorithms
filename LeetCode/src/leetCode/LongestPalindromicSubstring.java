package leetCode;

public class LongestPalindromicSubstring {

	public static String longestPalindrome(String s) {
		
		if (s.length()<=1) {
			return s;
		}
		int length = s.length();
		int resultIndex = 0;
		int resultLength = 1;
		for (int i = 0; i < length; i++) {	
			
			//odd
			int tempLength1 =1;
			int j = i-1;
			int k = i+1;
			while(j>=0 && k<length){
				if (s.charAt(j) == s.charAt(k)) {
					j--;
					k++;
					tempLength1 += 2;
				}else {
					break;
				}
			}
			if (tempLength1>resultLength) {
				resultIndex = i ;
				resultLength = tempLength1;
			}
			
			//even
			j=i;
			k = i+1;
			int tempLength2 = 0;
			while ( j>=0 && k < length ){
				if (s.charAt(j) == s.charAt(k)) {
					tempLength2 += 2;
					j--;
					k++;
				}else {
					break;
				}
			}
			if (tempLength2>resultLength) {
				resultIndex = i;
				resultLength = tempLength2;
			}
		}
		
		if (resultLength%2 != 0) {
			return s.substring(resultIndex-resultLength/2, resultIndex+resultLength/2+1);
		}else {
			return s.substring(resultIndex-resultLength/2+1, resultIndex+resultLength/2+1);
		}
		
	}

	public static String preProcess(String s) {
	    int n = s.length();
	    if (n == 0)
	        return "^$";
	    StringBuilder ret = new StringBuilder("^");
	    for (int i = 0; i < n; i++) {
	        ret.append("#");
	        ret.append(s.charAt(i));
	    }
	    ret.append("#$");
	    return ret.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(preProcess("abccbabc"));
		System.out.println(longestPalindrome("bb"));
	}

}
