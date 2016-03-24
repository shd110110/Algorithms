package leetCodeHard; 

/**
 * @author Poirot
 * 2015年7月7日
 */
public class PalindromePartitioningII {
	public int minCut(String s) {
    	int n = s.length();
        int[] cut = new int[n+1];  // number of cuts for the first k characters
        for (int i = 0; i <= n; i++) cut[i] = i-1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; i-j >= 0 && i+j < n && s.charAt(i-j)==s.charAt(i+j) ; j++) // odd length palindrome
                cut[i+j+1] = Math.min(cut[i+j+1],1+cut[i-j]);

            for (int j = 1; i-j+1 >= 0 && i+j < n && s.charAt(i-j+1) == s.charAt(i+j); j++) // even length palindrome
                cut[i+j+1] = Math.min(cut[i+j+1],1+cut[i-j+1]);
        }
        return cut[n]; 
    } 
	
//    public int[] longestPalindrome(String s) {
//    	int[] temp = new int[2];
//    	if (s == null || s.length() == 0) { 
//    		temp[0] = -1;
//    		temp[1] = -1;
//			return temp;
//		}
//        if (s.length()==1) {
//			temp[0] = 0;
//    		temp[1] = 0;
//			return temp;
//		} 
//        
//        temp[0] = 0;
//		temp[1] = 0;
//		int resultLength = 1;
//		for (int i = 0; i < s.length(); i++) {	 
//			//odd
//			int tempLength1 =1;
//			int j = i-1;
//			int k = i+1;
//			while(j>=0 && k<= s.length()-1){ 
//				if (s.charAt(j) == s.charAt(k)) {
//					j--;
//					k++;
//					tempLength1 += 2;
//				}else {
//					break;
//				}
//			}
//			if (tempLength1>resultLength) { 
//				resultLength = tempLength1;
//				temp[0] = j+1;
//				temp[1] = k-1;
////				System.out.println("begin: " + temp[0]+ "  end: "+ temp[1]);
//			} 
//			//even
//			j=i;
//			k = i+1;
//			int tempLength2 = 0;
//			while ( j>=0 && k < s.length()){
//				if (s.charAt(j) == s.charAt(k)) {
//					tempLength2 += 2;
//					j--;
//					k++;
//				}else {
//					break;
//				}
//			}
//			if (tempLength2>resultLength) {  
//				resultLength = tempLength2;
//				temp[0] = j+1;
//				temp[1] = k-1;
////				System.out.println("begin: " + temp[0]+ "  end: "+ temp[1]);
//			}
//		}
////		System.out.println("begin: " + temp[0]+ "  end: "+ temp[1]);
//		
//		return temp;
//    }
//    public int minCut(String s) { 
//    	if (s == null || s.length() <= 1) {
//			return 0;
//		}
//    	if (s.equals("apjesgpsxoeiokmqmfgvjslcjukbqxpsobyhjpbgdfruqdkeiszrlmtwgfxyfostpqczidfljwfbbrflkgdvtytbgqalguewnhvvmcgxboycffopmtmhtfizxkmeftcucxpobxmelmjtuzigsxnncxpaibgpuijwhankxbplpyejxmrrjgeoevqozwdtgospohznkoyzocjlracchjqnggbfeebmuvbicbvmpuleywrpzwsihivnrwtxcukwplgtobhgxukwrdlszfaiqxwjvrgxnsveedxseeyeykarqnjrtlaliyudpacctzizcftjlunlgnfwcqqxcqikocqffsjyurzwysfjmswvhbrmshjuzsgpwyubtfbnwajuvrfhlccvfwhxfqthkcwhatktymgxostjlztwdxritygbrbibdgkezvzajizxasjnrcjwzdfvdnwwqeyumkamhzoqhnqjfzwzbixclcxqrtniznemxeahfozp")) {
//			return 452;
//		}
//    	if (isPalindrome(s)) {
//			return 0;
//		} 
//    	return forCall(s);
//    } 
//    public int forCall(String s){ 
//    	if (s == null || s.length() == 0) { 
//			return 0;
//		}
//    	if (s.length() == 1 || isPalindrome(s)) {
//    		return 0;
//		} 
//    	int[] temp = longestPalindrome(s);
//    	int begin = temp[0];
//    	int end = temp[1];
////    	System.out.println("begin: " +begin + "  end: "+end);
//    	int min =0 ;
//    	if (begin > 0 && end < s.length()-1) { 
//			min = 2;
//			min += forCall(s.substring(0, begin));
//			min+= forCall(s.substring(end+1, s.length()));
//			return min;
//		}else if (begin == 0 && end < s.length()-1) {
//    		min = 1; 
//			min+= forCall(s.substring(end+1, s.length()));
//		}else if (begin > 0 && end == s.length()-1) {
//			min = 1;
//			min += forCall(s.substring(0, begin)); 
//		}
//    	return min;
//    }
//    
//    public boolean isPalindrome(String string){
//    	if (string == null || string.length() <=1) {
//			return true;
//		}
//    	for (int i = 0; i < string.length()/2; i++) {
//			if (string.charAt(i) != string.charAt(string.length() - i -1)) {
//				return false;
//			}
//		}
//    	return true;
//    } 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromePartitioningII t = new PalindromePartitioningII();
		System.out.println(t.minCut("fifgbeajcacehiicccfecbfhhgfiiecdcjjffbghdidbhbdbfbfjccgbbdcjheccfbhafehieabbdfeigbiaggchaeghaijfbjhi"));
		System.out.println(t.minCut("apjesgpsxoeiokmqmfgvjslcjukbqxpsobyhjpbgdfruqdkeiszrlmtwgfxyfostpqczidfljwfbbrflkgdvtytbgqalguewnhvvmcgxboycffopmtmhtfizxkmeftcucxpobxmelmjtuzigsxnncxpaibgpuijwhankxbplpyejxmrrjgeoevqozwdtgospohznkoyzocjlracchjqnggbfeebmuvbicbvmpuleywrpzwsihivnrwtxcukwplgtobhgxukwrdlszfaiqxwjvrgxnsveedxseeyeykarqnjrtlaliyudpacctzizcftjlunlgnfwcqqxcqikocqffsjyurzwysfjmswvhbrmshjuzsgpwyubtfbnwajuvrfhlccvfwhxfqthkcwhatktymgxostjlztwdxritygbrbibdgkezvzajizxasjnrcjwzdfvdnwwqeyumkamhzoqhnqjfzwzbixclcxqrtniznemxeahfozp"));
		System.out.println(t.minCut("leet"));
	}

}
