package leetCodeEasy;

/**
 * @author Poirot
 * 2015年7月3日
 */
public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		if (x < 10) {
			return true;
		}
		int reverse = 0;
		int temp = x;
		while (temp > 0) {
			reverse = reverse * 10 + temp % 10;
			temp /= 10;
		}
		return reverse == x;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromeNumber t = new PalindromeNumber();
		System.out.println(t.isPalindrome(123321));
	}

}
