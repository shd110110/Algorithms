/**
 * 2015年11月18日
 * Poirot
 */
package leetCodeMedium;
 

/**
 * @author Poirot
 *
 */
public class AdditiveNumber {
//	public boolean isAdditiveNumber(String num) {
//		if (num == null || num.length() < 3) {
//			return false;
//		}
//		
//		return true;
//	}
	
	//runtime 8ms
//	public boolean isAdditiveNumber(String num) {
//        int n = num.length();
//        for (int i = 1; i <= n / 2; ++i) {
//            BigInteger x1 = new BigInteger(num.substring(0, i));
//            for (int j = 1; Math.max(j, i) <= n - i - j; ++j) {
//                if (num.charAt(i) == '0' && j > 1) break;
//
//                BigInteger x2 = new BigInteger(num.substring(i, i + j));
//
//                if (isValid(x1, x2, j + i, num)) return true;
//            }
//        }
//        return false;
//    }
//    private boolean isValid(BigInteger x1, BigInteger x2, int start, String num) {
//        if (start == num.length()) return true;
//
//        BigInteger x3 = x1.add(x2);
//        String expected = x3.toString();
//
//        int end = start + expected.length();
//        if (end > num.length()) return false;
//
//        String actual = num.substring(start, end);
//        return expected.equals(actual) && isValid(x2, x3, end, num);
//    }

	//runtime 3ms
	public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int i = 1; i <= n / 2; ++i) {
            Long x1 = Long.parseLong(num.substring(0, i));
            for (int j = 1; Math.max(j, i) <= n - i - j; ++j) {
                if (num.charAt(i) == '0' && j > 1) break;
                Long x2 = Long.parseLong(num.substring(i, i + j));
                if (isValid(x1, x2, j + i, num)) return true;
            }
        }
        return false;
    }

    private boolean isValid(Long x1, Long x2, int start, String num) {
        while (true) {
            Long x3 = x1 + x2;
            String expected = x3.toString();
            int end = start + expected.length();
            if (end > num.length()) return false;
            String actual = num.substring(start, end);
            if (!expected.equals(actual)) return false;
            if (end == num.length()) return true;
            x1 = x2; x2 = x3; start = end;
        }
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdditiveNumber t = new AdditiveNumber();
		System.out.println(t.isAdditiveNumber("199100199"));
	}

}
