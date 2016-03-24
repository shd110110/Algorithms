package leetCodeMedium;
//150604
public class DivideTwoIntegers {
//	public static int divide(int dividend, int divisor) {
//		long a = dividend;
//		long b = divisor;
//		if (a == 0) {
//			return 0;
//		}
//		if (b == 0) {
//			return Integer.MAX_VALUE;
//		}
//		Boolean mark = true;
//		if (a > 0 && b < 0) {
//			b  = 0 - b;
//			mark = false;
//		}else if (a < 0 && b > 0) {
//			a  = 0 - a;
//			mark = false;
//		}else if (a < 0 && b < 0) {
//			b  = 0 - b;
//			a  = 0 - a;
//		}
//		if (a < b) {
//			return 0;
//		}
//        long tempResult = 1;
//        long tempB = b; 
//        while (a > (tempB+tempB)){
//        	tempResult = tempResult + tempResult;
//        	tempB = tempB + tempB;
//        }
//        long result = 0;
//        if (mark) {
//        	result = tempResult + divide((int)(a - tempB),(int)b);
//		}else {
//			result = 0-(tempResult + divide((int)(a - tempB), (int)b));
//		}
//        if (result > Integer.MAX_VALUE) {
//			return Integer.MAX_VALUE;
//		}
//        return (int) result;
//    }
	
	
	public static int divide(int dividend, int divisor) {
		
		if (divisor == 0) {
			return Integer.MAX_VALUE;
		}
		if (dividend == Integer.MIN_VALUE && divisor == -1) {
			return Integer.MAX_VALUE;
		} 
		boolean mark = true;
		if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
			mark = false;
		}
		Long dividendCopy = (long)dividend;
		Long divisorCopy = (long) divisor;
		dividendCopy = Math.abs(dividendCopy);
		divisorCopy = Math.abs(divisorCopy);
		int res = 0;
		if (dividendCopy < divisorCopy) {
			return 0;
		} 
//		System.out.println(dividendCopy + " : " + divisorCopy);
		while (divisorCopy <= dividendCopy) {
			int shift = 0;
			while (divisorCopy << (shift + 1) < dividendCopy) {
				shift++;
			}
			res += (1 << shift);
			dividendCopy -= (divisorCopy << (shift));
		}
		if (!mark) { 
			return -res;
		}
		return res;
    }	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(divide(1,1));
	}

}
