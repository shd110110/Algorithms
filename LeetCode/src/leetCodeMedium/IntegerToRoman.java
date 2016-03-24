/**
 * 2015年11月27日
 * Poirot
 */
package leetCodeMedium;

/**
 * @author Poirot
 *
 */
public class IntegerToRoman {
	// most votes
	// public static String intToRoman(int num) {
	// String M[] = { "", "M", "MM", "MMM" };
	// String C[] = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"
	// };
	// String X[] = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"
	// };
	// String I[] = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"
	// };
	// return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] +
	// I[num % 10];
	// }
	
	//another idea
//	public String intToRoman(int num) {
//		int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
//		String[] strs = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
//
//		StringBuilder sb = new StringBuilder();
//
//		for (int i = 0; i < values.length; i++) {
//			while (num >= values[i]) {
//				num -= values[i];
//				sb.append(strs[i]);
//			}
//		}
//		return sb.toString();
//	}

	public String intToRoman(int num) {
		String str = "";
		String[] romans = { "I", "V", "X", "L", "C", "D", "M" };
		int cur = 1000;
		int i = 6;
		while (cur > 0) {
			int tmp = num / cur;
			if (tmp < 4) {
				while (tmp > 0) {
					str += romans[i];
					tmp--;
				}
			} else if (tmp == 4) {
				str += romans[i] + romans[i + 1];
			} else if (tmp == 9) {
				str += romans[i] + romans[i + 2];
			} else {
				str += romans[i + 1];
				tmp -= 5;
				while (tmp > 0) {
					str += romans[i];
					tmp--;
				}
			}
			num %= cur;
			cur /= 10;
			i -= 2;
		}
		return str;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntegerToRoman t = new IntegerToRoman();
		System.out.println(t.intToRoman(3451));
	}

}
