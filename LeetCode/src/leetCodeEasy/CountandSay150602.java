package leetCodeEasy;

public class CountandSay150602 {
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countAndSay(5)); 
		
	}

}
