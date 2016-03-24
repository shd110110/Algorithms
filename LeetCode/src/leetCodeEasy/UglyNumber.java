package leetCodeEasy;

/**
 * @author Poirot
 * 2015年8月19日
 */
public class UglyNumber {
	public boolean isUgly(int num) {
		if (num < 1) {
			return false;
		} 
		if (num == 1) {
		    return true;
		}
        while (num > 1) {
        	if (num % 2 == 0) {
				num /= 2;
			} else if (num % 3 == 0) {
				num /= 3;
			} else if (num % 5 == 0) {
				num /= 5;
			} else {
				return false;
			}
        }
        return true;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
