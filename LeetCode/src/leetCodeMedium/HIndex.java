/**
 * 2015Äê9ÔÂ9ÈÕ
 * Poirot
 */
package leetCodeMedium;

import java.util.Arrays;

/**
 * @author Poirot
 *
 */
public class HIndex {
	public int hIndex(int[] citations) {
		if (citations.length == 0) {
			return 0;
		}
		if (citations.length == 1) {
			return citations[0] > 0 ? 1 : 0;
		}
		Arrays.sort(citations);
		int result = 0;
		for (int i = citations.length - 1; i >=0 ; i--) {
			if (citations.length - i <= citations[i]) {
				result ++;
			} else {
				return result;
			}
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] citations = {3, 0, 6, 1, 5};
		HIndex t = new HIndex();
		System.out.println(t.hIndex(citations));
	}

}
