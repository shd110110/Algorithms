/**
 * 2015Äê6ÔÂ23ÈÕ
 * CH
 */
package leetCodeMedium;
 
import java.util.Iterator;
import java.util.LinkedHashSet; 
/**
 * @author CH
 *
 */
public class FractiontoRecurringDecimal {
	public String fractionToDecimal(int numerator, int denominator) {
		long numerator1 = numerator;
		long denominator1 = denominator;
		if (numerator1 == 0) {
			return "0";
		} 
		boolean mark = true;
		if (numerator1 < 0 && denominator1 >0 ) {
			mark = false;
			numerator1 = numerator1 * (-1);
		}else if (numerator1 > 0 && denominator1 < 0 ) {
			mark = false;
			denominator1 = denominator1 * (-1);
		}else if (numerator1 < 0 && denominator1 < 0) {
			numerator1 = numerator1 * (-1);
			denominator1 = denominator1 * (-1);
		}
		StringBuilder stringBuilder = new StringBuilder(); 
		LinkedHashSet<Long> restNumerators = new LinkedHashSet<Long>();
		long a = numerator1 / denominator1;
		numerator1 = numerator1 % denominator1;  
		if (numerator1 == 0) {
			
			if (mark) {
				return  String.valueOf(a);
			}else {
				return "-"+String.valueOf(a);
			} 
		} 
		int index = -1; 
		restNumerators.add(numerator1); 
		numerator1 *= 10;
		
		long quotient = numerator1 / denominator1;
		while (quotient == 0){
			restNumerators.add(numerator1);
			stringBuilder.append(String.valueOf(quotient)); 
			numerator1 *= 10;
			quotient = numerator1 / denominator1;
		}
		
		while (numerator1 != 0) { 
			if(!restNumerators.add(numerator1))
			{	 
				Iterator<Long> itr = restNumerators.iterator();
				while (itr.next() != numerator1) {
					index++;
				}
				break;
			}  
			stringBuilder.append(String.valueOf(quotient)); 
			numerator1 = numerator1 % denominator1; 
			numerator1 *= 10;
			quotient = numerator1 / denominator1;
		}
		String result = "";
		if (numerator1 != 0) { 
			result = String.valueOf(a) +"." + stringBuilder.substring(0, index) + "("+ stringBuilder.substring(index, stringBuilder.length()) + ")";
		} else {
			if (stringBuilder.length() == 0) {
				result = String.valueOf(a);
			}else {
				result = String.valueOf(a) + "." + stringBuilder;
			}
		} 
		if (mark) {
			return result;
		}else {
			return "-"+result;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FractiontoRecurringDecimal t = new FractiontoRecurringDecimal();
		System.out.println(t.fractionToDecimal(-1, -2147483648));
	}

}
