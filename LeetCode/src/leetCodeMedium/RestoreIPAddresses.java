/**
 * 2015Äê7ÔÂ1ÈÕ
 * CH
 */
package leetCodeMedium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CH
 *
 */
public class RestoreIPAddresses {
	List<String> result = new ArrayList<String>();
    public List<String> restoreIpAddresses(String s) { 
        if (s.equals(null)) {
			return result;
		}
        restore(s, 4, "");
        return result;
    }
    public void restore(String s, int rest,String temp){
    	if (s.length() > rest*3 || s.length() < rest) {
			return;
    	}  
    	if (rest == 1) {
    		if (s.equals("0")) {
    			result.add(temp+"."+s);
			}else if (s.indexOf('0') != 0 && Integer.parseInt(s)<= 255) {
				result.add(temp+"."+s);
//				System.out.println("test  "+ temp + "  " + s);  
			} 
			return;
		}
    	if (rest == s.length()) { 
//    		System.out.println("test  "+ temp + " " + rest);
			StringBuilder stringBuilder = new StringBuilder(temp); 
			if (temp == "") { 
				stringBuilder.append(s.charAt(0));
			}else {
				stringBuilder.append(".");
				stringBuilder.append(s.charAt(0));
			}
			for (int i = 1; i < rest; i++) { 
				stringBuilder.append(".");
				stringBuilder.append(s.charAt(i));  
			}
			result.add(stringBuilder.toString()); 
			return;
		}
    	if (s.indexOf('0') == 0) {
    		String restString = s.substring(1, s.length());
    		if (temp == "") {
				restore(restString, rest-1, temp+"0");
			}else {
				restore(restString, rest-1, temp+"."+"0");
			} 
		}else {
			for (int i = 0; i < 2; i++) {
				String restString = s.substring(i+1, s.length());
				if (temp == "") {
					restore(restString, rest-1, temp+s.substring(0, i+1));
				}else {
					restore(restString, rest-1, temp+"."+s.substring(0, i+1));
				}  
			}
			String restString = s.substring(3, s.length());
			if ( Integer.parseInt(s.substring(0, 3)) <= 255) {
				if (temp == "") {
					restore(restString, rest-1, temp+s.substring(0, 3));
				}else {
					restore(restString, rest-1, temp+"."+s.substring(0, 3));
				}
			} 
		}
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestoreIPAddresses t = new RestoreIPAddresses();
		List<String> result = t.restoreIpAddresses("10101010");
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}

}
