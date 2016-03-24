package leetCodeHard;

import java.util.LinkedList;

/**
 * @author Poirot
 * 2015年6月30日
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
    	if (s== null || s.equals("")) {
			return 0;
		}
        int maxLength = 0;
        int i = 0;
        while ( i < s.length()){
        	int j = i;  
        	LinkedList<Character> stack = new LinkedList<>();
        	while (j < s.length()){
        		if (s.charAt(j) == ')' && stack.isEmpty()) {
					break;
				}else if (s.charAt(j) == '(') {
					stack.add('('); 
				}else if (s.charAt(j) == ')') {
					stack.pop(); 
				}
        		j++;
        	} 
        	if (j >= s.length()) { 
        		int end = j;
				int k =  end-1;  
				while(k >=i){ 
					int m = k;
					LinkedList<Character> tempStack = new LinkedList<>();
					int tempLength = 0;
					while (m >= i){
						if (s.charAt(m) == '(' && tempStack.isEmpty()) { 
							break;
						}else if (s.charAt(m) == ')') {
							tempLength++;
							tempStack.add(')'); 
						}else if (s.charAt(m) == '(') {
							tempStack.pop(); 
							tempLength++;
						}  
						m--;
					}
					if (tempLength > maxLength) {
						maxLength = tempLength;
					}
					k = m-1;
				} 
				return maxLength;
			}else{
				int end = j; 
				int k =  end-1;  
				while(k >=i){ 
					int m = k;
					LinkedList<Character> tempStack = new LinkedList<>();
					int tempLength = 0;
					while (m >= i){
						if (s.charAt(m) == '(' && tempStack.isEmpty()) { 
							break;
						}else if (s.charAt(m) == ')') {
							tempLength++;
							tempStack.add(')'); 
						}else if (s.charAt(m) == '(') {
							tempStack.pop(); 
							tempLength++;
						}  
						m--;
					}
					if (tempLength > maxLength) {
						maxLength = tempLength;
					}
					k = m-1;
				} 
				i = end+1;
			} 
        }
        return maxLength;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestValidParentheses t = new LongestValidParentheses();
//		System.out.println(t.longestValidParentheses(")(((((()())()()))()(()))("));
		System.out.println(t.longestValidParentheses("(()())"));
	}

}
