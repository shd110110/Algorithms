package leetCodeMedium;

import java.util.Stack;
//150609 
public class BasicCalculator {
	public static int calculate(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int result = 0;
		s = s.replaceAll(" ", "");
		Stack<String> tempStack = new Stack<String>();
		Stack<String> tempStack2 = new Stack<String>();
		int i = 0;
		tempStack.push(String.valueOf(s.charAt(i)));
		i++;
		while (!tempStack.isEmpty() && i < s.length()) {
			if (s.charAt(i) == ')') {
				String popString = tempStack.pop();
				while (!popString.equals("(")){
					tempStack2.push(popString);
					popString = tempStack.pop();
				}
				
				StringBuilder tempBuilder = new StringBuilder();
				while (!tempStack2.isEmpty()){
					tempBuilder.append(tempStack2.pop());
				}
				//System.out.println(tempBuilder);
				int tempValue = calculate2(tempBuilder.toString());
				//System.out.println(tempValue);
				tempStack.push(String.valueOf(tempValue)); 
				//System.out.println(tempStack.size());
			}else {
				tempStack.push(String.valueOf(s.charAt(i))); 
			}
			i++;
		}
		 
		while (!tempStack.isEmpty()){
			tempStack2.push(tempStack.pop()); 
		} 
		StringBuilder tempBuilder = new StringBuilder();
		while (!tempStack2.isEmpty()){
			tempBuilder.append(tempStack2.pop());
		}
		result = calculate2(tempBuilder.toString());
		  
        return result; 
    }
	public static int calculate2(String s) {
		int i = 0;
		int result = 0;
		int temp = 0;
//		
//		while(i < s.length() && Character.isDigit(s.charAt(i))){
//			temp = temp*10 + (s.charAt(i) - '0');
//			i++;
//		}
//		System.out.println(temp);
//		result += temp;
		while(i<s.length()){
			boolean plus = true;
			while(i < s.length() && !Character.isDigit(s.charAt(i))){
				if (s.charAt(i) == '-') {
					plus = !plus;
				}
				i++;
			}
			temp = 0;
			while(i < s.length() && Character.isDigit(s.charAt(i))){
				temp = temp*10 + (s.charAt(i) - '0');
				i++;
			}
			if (plus) {
				result += temp;
			}else {
				result -= temp;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s = "hel  o";
//		s = s.replaceAll(" ", "");
//		System.out.println(s);
//		System.out.println(s.length());
		System.out.println(calculate("(-1-2)-(5-6)")); 
	}

}
