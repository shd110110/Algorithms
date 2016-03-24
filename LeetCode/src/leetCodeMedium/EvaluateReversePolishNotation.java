package leetCodeMedium;

import java.util.Stack;
//150617
public class EvaluateReversePolishNotation {
	public static int evalRPN(String[] tokens) {
        if (null == tokens || tokens.length == 0) {
			return 0;
        } 
        Stack<Integer> temp = new Stack<Integer>();
        for (int i = 0; i < tokens.length; i++) {
			if (!isOperator(tokens[i])) {
				temp.push(Integer.valueOf(tokens[i]));
			}else {
				if (temp.size() >=2) {
					int b = temp.pop();
					int a = temp.pop();
					if (tokens[i].equals("+")) {
						temp.push(a + b);
					}else if (tokens[i].equals("-")) {
						temp.push(a - b);
					}else if (tokens[i].equals("*")) {
						temp.push(a * b);
					}else if (tokens[i].equals("/")) {
						temp.push(a / b);
					}
				}else {
					return 0;
				}
				
			}
		} 
        if (temp.isEmpty()) {
			return 0;
		}
        return temp.pop();
    }
	public static boolean isOperator(String s){
		return s.equals("*") || s.equals("/") || s.equals("+") || s.equals("-");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] test = {"3", "-4","+"};
		System.out.println(evalRPN(test));
	}

}
