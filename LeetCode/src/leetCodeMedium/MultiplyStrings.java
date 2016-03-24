/**
 * 2015Äê7ÔÂ1ÈÕ
 * CH
 */
package leetCodeMedium;

/**
 * @author CH
 *
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
    	if (num1.equals("0")) {
			return "0";
		}else if (num2.equals("0")) {
			return "0";
		}
    	int[] numA = new int[num1.length()];
    	for (int i = 0; i < numA.length; i++) {
			numA[i] = num1.charAt(num1.length()-i-1) - '0';
		}
    	int[] numB = new int[num2.length()];
    	for (int i = 0; i < numB.length; i++) {
			numB[i] = num2.charAt(num2.length()-i-1) - '0';
		}
//    	for (int i = 0; i < numA.length; i++) {
//			System.out.print(numA[i]+ " ");
//		}
//    	System.out.println();
//    	for (int i = 0; i < numB.length; i++) {
//			System.out.print(numB[i]+ " ");
//		}
//    	System.out.println();
        int[] digits = new int[num1.length()+num2.length()];
        int carry = 0;
        for (int i = 0; i < digits.length; i++) {
        	int temp = carry;
			for (int j = 0; j <=i && j <num1.length(); j++) {
				if (i-j < num2.length()) {
					temp += (numA[j] * numB[i-j]);
				}
			}
			carry = temp/10;
			digits[i] = temp%10;
//			System.out.println(i + "  " + digits[i] +"  " + carry);
		}
        StringBuilder stringBuilder = new StringBuilder();
        if (digits[digits.length-1] !=0) {
        	stringBuilder.append(digits[digits.length-1]);
		}
        for (int j = digits.length-2; j >= 0 ; j--) {
			stringBuilder.append(digits[j]);
        }
        return stringBuilder.toString();
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MultiplyStrings t = new MultiplyStrings();
		String a = "11132143414234";
		String b = "222432141242134321412432";
		System.out.println(t.multiply(a, b));
	}

}
