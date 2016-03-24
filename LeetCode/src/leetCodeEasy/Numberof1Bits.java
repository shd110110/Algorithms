/**
 * Dec 19, 2015
 * Poirot
 * 4:50:45 PM
 * LeetCode
 */
package leetCodeEasy;

/**
 * @author Poirot
 *
 */
public class Numberof1Bits {
	public int hammingWeight(int n) {
		int res = 0; 
        while (n != 0) {
            res += (n & 1);
            n = n>>>1;
        }
        return res;
    }
	
	public static void main(String[] args) {
		Numberof1Bits t = new Numberof1Bits();
		System.out.println(t.hammingWeight(Integer.MIN_VALUE)); //   补码  10000000 00000000 00000000 00000000
		System.out.println(t.hammingWeight(Integer.MIN_VALUE) + 1);//补码  10000000 00000000 00000000 00000001 
	}
}
