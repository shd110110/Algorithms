package leetCodeMedium;

import java.util.Stack;

/**
 * @author Poirot 2015年6月22日
 */
public class BasicCalculatorII {
	public int calculate(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		} 
		s = s.replaceAll(" ", "");
		int i = 0;
		while(i < s.length()){
			if (s.charAt(i) == '*' || s.charAt(i) == '/') {
				int indexBegin = i-1;
				while(indexBegin >= 0 && Character.isDigit(s.charAt(indexBegin))){
					indexBegin--;
				}
				
				int indexEnd = i+1;
				while ( indexEnd < s.length() && Character.isDigit(s.charAt(indexEnd)))
				{
					indexEnd++;
				}
				int a = Integer.parseInt(s.substring(indexBegin+1, i));
				int b = Integer.parseInt(s.substring(i+1, indexEnd));
				int temp = s.charAt(i) == '*'?a*b:a/b;
				s = s.substring(0, indexBegin+1) + String.valueOf(temp)+s.substring(indexEnd, s.length());
				i = indexBegin+String.valueOf(temp).length()+1;
			}else {
				i++;
			}
		}
		return calculate1(s);
	}
	public int calculate1(String s) {
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
				while (!popString.equals("(")) {
					tempStack2.push(popString);
					popString = tempStack.pop();
				}

				StringBuilder tempBuilder = new StringBuilder();
				while (!tempStack2.isEmpty()) {
					tempBuilder.append(tempStack2.pop());
				}
				int tempValue = calculate2(tempBuilder.toString()); 
				tempStack.push(String.valueOf(tempValue));
				// System.out.println(tempStack.size());
			} else {
				tempStack.push(String.valueOf(s.charAt(i)));
			}
			i++;
		} 
		while (!tempStack.isEmpty()) {
			tempStack2.push(tempStack.pop());
		}
		StringBuilder tempBuilder = new StringBuilder();
		while (!tempStack2.isEmpty()) {
			tempBuilder.append(tempStack2.pop());
		}
		result = calculate2(tempBuilder.toString());

		return result;
	}

	public int calculate2(String s) {
		int i = 0;
		int result = 0;
		int temp = 0; 
		while (i < s.length()) {
			boolean plus = true;
			while (i < s.length() && !Character.isDigit(s.charAt(i))) {
				if (s.charAt(i) == '-') {
					plus = !plus;
				}
				i++;
			}
			temp = 0;
			while (i < s.length() && Character.isDigit(s.charAt(i))) {
				temp = temp * 10 + (s.charAt(i) - '0');
				i++;
			}
			if (plus) {
				result += temp;
			} else {
				result -= temp;
			}
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BasicCalculatorII t = new BasicCalculatorII();
		System.out.println(t.calculate("1+2*3"));
	}

}
