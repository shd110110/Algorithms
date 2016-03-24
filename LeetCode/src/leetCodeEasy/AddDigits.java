package leetCodeEasy;

/**
 * @author Poirot
 * 2015年8月17日
 */
public class AddDigits {
	public int addDigits(int num) {
		if (num == 0) {
			return 0;
		}
        return num % 9 == 0 ? 9 : num % 9;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
