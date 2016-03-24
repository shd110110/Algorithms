/**
 * 2015Äê6ÔÂ19ÈÕ
 * CH
 */
package leetCodeMedium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author CH
 *
 */
public class GrayCode {
	public List<Integer> grayCode(int n) {
		HashSet<Integer> tempSet = new HashSet<Integer>(); 
        tempSet.add(0);  
        int[] divide = new int[n];
        int p = 1; 
        for (int i = 0; i < divide.length; i++) {
			divide[i] = p; 
			p *= 2;
		} 
        int begin = 0;
        int numbers = 1;
        for (int i = 0; i < n; i++) {
			numbers*=2;
		} 
        ArrayList<Integer> result = new ArrayList<Integer>(); 
        result.add(0);
        while(tempSet.size() < numbers)
        {
        	for (int i = 0; i < n; i++) {  
        		int a = begin^divide[i];
				if (a < numbers && !tempSet.contains(a)) {
					begin = a; 
					result.add(a);
					tempSet.add(a); 
					break;
				}
			}
        }
        return result; 
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GrayCode t = new GrayCode();
		List<Integer> test = t.grayCode(7);
		for (int i = 0; i < test.size(); i++) {
			System.out.println(test.get(i));
		}
	}

}
