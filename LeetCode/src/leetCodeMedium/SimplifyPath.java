package leetCodeMedium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;
//150606
public class SimplifyPath {
	public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
			return path;
		}
//        StringBuilder resultBuilder = new StringBuilder(path);
//        int index = 0;
//        while ((index = resultBuilder.indexOf("//")) != -1){
//        	resultBuilder.delete(index, index+1);
//        }
//        if (resultBuilder.lastIndexOf("/") == resultBuilder.length()-1) {
//        	resultBuilder.delete(resultBuilder.length()-1, resultBuilder.length());
//		} 
        Set<String> isSkip = new HashSet<>(Arrays.asList("", ".", ".."));
        Deque<String> stack = new ArrayDeque<>();
        for (String token : path.split("/")) {
            if (token.equals("..") && !stack.isEmpty()) 
            	stack.pop();
            if (isSkip.contains(token)) 
            	continue;
            stack.push(token);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append("/" + stack.pollLast());
        }
        return sb.length() == 0 ? "/" : sb.toString();

    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
