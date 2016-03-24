/**
 * 2015年11月19日
 * Poirot
 */
package leetCodeEasy;

/**
 * @author Poirot
 *
 */
public class NimGame {
    public boolean canWinNim(int n) {
        if (n <= 3) {
			return true;
		}
        if (n % 4 == 0) {
			return false;
		} else {
			return true;
		}
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
