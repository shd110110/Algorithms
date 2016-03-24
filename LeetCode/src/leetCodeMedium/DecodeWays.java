/**
 * 2015Äê6ÔÂ23ÈÕ
 * CH
 */
package leetCodeMedium;

/**
 * @author CH
 *
 */
public class DecodeWays { 
	public int numDecodings(String s) { 
		int n = s.length();
        if (n == 0) 
        	return 0;

        int[] dp = new int[n+1];
        dp[n]  = 1;
        dp[n-1] = s.charAt(n-1) != '0' ? 1 : 0;

        for (int i = n - 2; i >= 0; i--){
            if (s.charAt(i) == '0') 
            	continue;
            else 
            	dp[i] = (Integer.parseInt(s.substring(i,i+2))<=26) ? dp[i+1]+dp[i+2] : dp[i+1];
        }
        return dp[0];
    }
	 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecodeWays t = new DecodeWays();
		System.out.println(t.numDecodings("9371597631128776948387197132267188677349946742344217846154932859125134924241649584251978418763151253"));
	}

}
