/**
 * 2015 9月11日
 * Poirot
 */
package leetCodeHard;

/**
 * @author Poirot
 *
 */
public class RegularExpressionMatching {
//	public boolean isSame(char c, char p) {
//        return p == '.' || c == p;
//    } 
//     
//    public boolean isMatch(String s, String p) {
//        // write your code here
//        if (s == null || p == null) {
//            return false;
//        }
//        
//        // bug 2: should use boolean instead of int.
//        boolean[][] D = new boolean[s.length() + 1][p.length() + 1];
//        
//        // D[i][j]: i, j, the length of String s and String p.        
//        for (int i = 0; i <= s.length(); i++) {
//            for (int j = 0; j <= p.length(); j++) {
//                if (j == 0) {
//                    // when p is empth, the s should be empty.
//                    D[i][j] = i == 0;
//                } else if (p.charAt(j - 1) == '*') {
//                    /*
//                        P has at least one node.
//                    */
//                    
//                    // The last node in p is '*'
//                    if (j < 2) {
//                        // a error: there should be a character before *.
//                        //return false;
//                    }
//                    
//                    // we can match 0 characters or match more characters.
//                    for (int k = 0; k <= i; k++) {
//                        // BUG 3: severe! Forget to deal with the empty string!!
//                        if (k != 0 && !isSame(s.charAt(i - k), p.charAt(j - 2))) {
//                            D[i][j] = false;
//                            break;
//                        }
//                        
//                        if (D[i - k][j - 2]) {
//                            D[i][j] = true;
//                            break;
//                        }
//                    }
//                } else {
//                    D[i][j] = i >= 1 
//                         && isSame(s.charAt(i - 1), p.charAt(j - 1))
//                         && D[i - 1][j - 1];
//                }
//            }
//        }
//        
//        return D[s.length()][p.length()];
//    }
	
	public boolean isMatch(String s, String p) {
        // write your code here
        boolean opt[][] = new boolean[s.length()+1][p.length()+1];
        // base case
        opt[0][0] = true;
        boolean valid = false;
        for(int j = 2;j <= p.length();j+=2){
            if(p.charAt(j-1)=='*'){ 
            	valid = true; 
            	opt[0][j] = true;
            }else
            	valid = false;
            if(!valid) 
            	break;
        }
        // iteration
        for(int i = 1;i <= s.length();i++){
            for(int j = 1;j <= p.length();j++){
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.') 
                	opt[i][j] = opt[i-1][j-1];
                else if(p.charAt(j-1)=='*'){
                	if (j < 2) {
						opt[i][j] = false;
					} else {
						if(s.charAt(i-1)==p.charAt(j-2) || p.charAt(j-2)=='.')
	                        opt[i][j] = opt[i-1][j] || opt[i][j-2];
						// opt[i-1][j] do take s[i] to match p[j-1],p[j]
						 
	                        // opt[i][j-2] don't take s[i] to match p[j-1],p[j]  
	                    else
	                        opt[i][j] = opt[i][j-2];
	                        // opt[i][j-2] cannot take s[i] to match p[j-1],p[j]
					}
                }
            }
        }
        return opt[s.length()][p.length()];
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) { 
		RegularExpressionMatching t = new RegularExpressionMatching();
		System.out.println(t.isMatch("bbabacccbcbbcaaab", "b*a*bac*bcb*ca*b"));
	}

}
