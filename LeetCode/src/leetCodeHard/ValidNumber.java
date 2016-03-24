package leetCodeHard;
//150616
public class ValidNumber {
	//other's idea
//	public boolean isNumber(String s) {
//	    s = s.trim();
//
//	    boolean pointSeen = false;
//	    boolean eSeen = false;
//	    boolean numberSeen = false;
//	    boolean numberAfterE = true;
//	    for(int i=0; i<s.length(); i++) {
//	        if('0' <= s.charAt(i) && s.charAt(i) <= '9') {
//	            numberSeen = true;
//	            numberAfterE = true; // assume there isn't  'e'
//	        } else if(s.charAt(i) == '.') {
//	            if(eSeen || pointSeen) { // e后面的数不能有小数点
//	                return false;
//	            }
//	            pointSeen = true;
//	        } else if(s.charAt(i) == 'e') {
//	            if(eSeen || !numberSeen) { // 只能有一个 'e'出现且e前面也必须有数
//	                return false;
//	            }
//	            numberAfterE = false;  // key point
//	            eSeen = true;
//	        } else if(s.charAt(i) == '-' || s.charAt(i) == '+') {
//	            if(i != 0 && s.charAt(i-1) != 'e') {
//	                return false;
//	            }
//	        } else {
//	            return false;
//	        }
//	    }
//
//	    return numberSeen && numberAfterE;
//	}
	
	public boolean isNumber(String s) {
		s = s.trim();
        if (s.length()<1) { //if no digits
            return false; 
        }
        if (s.charAt(s.length()-1) == 'f' || s.charAt(s.length()-1) == 'D'){ //last digit check
            return false;   //if last digit is f or D, fail
        }
        try{
        	Double.parseDouble(s);   //parse as a double
        	return true; 
        } catch (Exception e1){
            return false;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidNumber t = new ValidNumber();
		System.out.println(t.isNumber("2e10"));
		System.out.println(t.isNumber("  ....1   .e6"));
	}

}
