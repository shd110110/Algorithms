package leetCodeEasy;

public class StringtoInteger {
	public int myAtoi(String str) {
		if (str.length()<1) {
			return 0;
		}
		int i = 0;
		while (i<str.length() && str.charAt(i) ==' '){
			i++;
		}
		str = str.substring(i, str.length());
		
		boolean sign = true;
		i= 0;
		if (str.charAt(0) =='+') {
			i++;
			sign = true;
		}else if (str.charAt(0) == '-') {
			i++;
			sign = false;
		}else if (!Character.isDigit(str.charAt(0))) {
			return 0;
		}
		long tempResult = 0;
		
		while (i<str.length() && i<12 && Character.isDigit(str.charAt(i))){
			
			tempResult = tempResult*10 +(str.charAt(i)-48);
			i++;
		}
		
		if (sign) {
			if (tempResult >Integer.MAX_VALUE) {
				return Integer.MAX_VALUE;
			}else {
				return (int)tempResult;
			}
		}else {
			if (tempResult*(-1) <= Integer.MIN_VALUE) {
				return Integer.MIN_VALUE;
			} else {
				return (int)(tempResult*(-1));
			}
		}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new StringtoInteger().myAtoi("         2147483646"));
	} 
}
