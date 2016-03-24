/**
 * 2015Äê7ÔÂ8ÈÕ
 * CH
 */
package leetCodeMedium;

import java.util.ArrayList;

/**
 * @author CH
 *
 */
public class NumberofDigitOne {
    public int countDigitOne(int n) {
        if (n <= 0) {
			return 0;
		}
        if (n <=9) {
			return 1;
		} 
    	int temp = n;
    	ArrayList<Integer> digits = new ArrayList<>();
    	while (temp > 0){ 
    		digits.add(temp%10);
    		temp/=10;
    	} 
    	int high = digits.get(digits.size()-1);
    	temp = 0;
    	int counter = 1;
    	for (int i = digits.size()-2; i >=0; i--) {
			temp = temp*10 + digits.get(i);
			counter*=10;
		}  
    	if (high > 1) {
    		return high*(counter/10*(digits.size()-1))+counter +countDigitOne(temp);
		}else {
			return high*(counter/10*(digits.size()-1))+ temp+1 + countDigitOne(temp);
		}
    	
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberofDigitOne t = new NumberofDigitOne();  
		System.out.println(t.countDigitOne(1410065408));
	}

}
