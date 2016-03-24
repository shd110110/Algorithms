package leetCodeEasy;
//150602
public class CountandSay {
	public static String countAndSay(int n) {
		String temp = "1";
		if (n == 1) {
			return temp;
		}
        for (int i = 0; i < n-1; i++) {
        	Character tempChar = (char) temp.charAt(0); 
			int count = 0;
			StringBuilder tempBuilder = new StringBuilder(); 
			for (int j = 0; j < temp.length(); j++) {
				if (temp.charAt(j) == tempChar) {
					count++;
				}else {
					tempBuilder.append((char)(count + 48));
					tempBuilder.append(tempChar.toString());
					tempChar = (char) temp.charAt(j);
					count = 1;
				}
				 
			}
			tempBuilder.append((char)(count + 48));
			tempBuilder.append(tempChar);
			temp = tempBuilder.toString();
			 
		}
        return temp;
    }
	
	
	public static String countAndSay2(int n) {
        String first = "1";
        if (n == 1) {
            return first;
        }
        
        String preString = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
       
        int begin = 0;
        int end = begin;  
        while (begin < preString.length()) {
            while (end < preString.length() && preString.charAt(end) == preString.charAt(begin)) {
                end++;
            } 
            sb.append(String.valueOf(end - begin)).append(preString.charAt(begin));
            begin = end;
        }
        return sb.toString();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countAndSay2(3));
	}

}
