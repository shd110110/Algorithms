package leetCodeEasy;
   
//150602
public class AddBinary {
	public static String addBinary(String a, String b) {
        if (a == null) {
			return b;
		}
        if (b == null) {
			return a;
		}
        StringBuilder aBuilder = new StringBuilder(a).reverse();
        StringBuilder bBuilder = new StringBuilder(b).reverse();
        if (a.length() > b.length()) {
			for (int i = 0; i < a.length() - b.length(); i++) {
				bBuilder.append('0');
			}
		}else {
			for (int i = 0; i < b.length() - a.length(); i++) {
				aBuilder.append('0');
			} 
		}
        
        Boolean mark = false;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < aBuilder.length(); i++) {
			if (mark) {
				if ((aBuilder.charAt(i) == '0' && bBuilder.charAt(i) == '0' )) {
					result.append('1');
					mark = false;
				}else if (aBuilder.charAt(i) == '1' && bBuilder.charAt(i) == '1') {
					result.append('1');
					mark = true;
				}else {
					result.append('0');
					mark = true;
				}
				
			}else {
				if ((aBuilder.charAt(i) == '0' && bBuilder.charAt(i) == '0' )) {
					result.append('0');
					mark = false;
				}else if (aBuilder.charAt(i) == '1' && bBuilder.charAt(i) == '1') {
					result.append('0');
					mark = true;
				}else {
					result.append('1');
					mark = false;
				}
			}
		}
        if (mark) {
			result.append('1');
		}
        return result.reverse().toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.out.println(addBinary("111", "1"));
	 
	}

}
