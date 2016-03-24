/**
 * 2016年1月8日
 * Poirot
 * 下午5:13:59
 * LeetCode
 */
package leetCodeEasy;

/**
 * @author Poirot
 *
 */
public class PowerofThree {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
			return false;
		}
        double r = Math.log10(n) / Math.log10(3);
//        System.out.println(r + " " + Math.floor(r));
        return r == Math.floor(r);
    }
//    public boolean isPowerOfThree(int n) {
//    	return n > 0 && (1162261467 % n == 0);
//    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PowerofThree t = new PowerofThree();
		System.out.println(t.isPowerOfThree(45));
	}

}
