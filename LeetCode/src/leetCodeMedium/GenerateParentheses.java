/**
 * 2015年11月29日
 * Poirot
 */
package leetCodeMedium;

import java.util.ArrayList; 
import java.util.Date; 
import java.util.List;

/**
 * @author Poirot
 *
 */
public class GenerateParentheses {
	int count = 0;
//    public List<String> generateParenthesis(int n) {
//        List<String> res = new LinkedList<>();
//		StringBuilder sb = new StringBuilder();
//		operation(res, n * 2, 0, sb);
//		System.out.println(count);
//		return res;
//    }
//	
//	public void operation(List<String> res, int length, int leftParentheses, StringBuilder sb) {
//		count ++;
//		if (leftParentheses < 0 || length - sb.length() < leftParentheses)
//		{
//			return ;
//		} 
//		if (length - sb.length() == leftParentheses) {
//			
//		}
//		if (length == sb.length()) {
//			if (leftParentheses == 0) {
//				res.add(sb.toString());
//			}
//			return;
//		}
//		StringBuilder sbAddLeftParenthese = new StringBuilder(sb.toString());
//		StringBuilder sbAddRightParenthese = new StringBuilder(sb.toString());
//		operation(res, length, leftParentheses + 1, sbAddLeftParenthese.append('('));
//		operation(res, length, leftParentheses - 1, sbAddRightParenthese.append(')'));
//	}
	
	//DP most votes
//	public List<String> generateParenthesis(int n)
//    {
//        List<List<String>> lists = new ArrayList<>();
//        lists.add(Collections.singletonList(""));
//
//        for (int i = 1; i <= n; ++i)
//        {
//            final List<String> list = new ArrayList<>();
//
//            for (int j = 0; j < i; ++j)
//            {
//                for (final String first : lists.get(j))
//                {
//                    for (final String second : lists.get(i - 1 - j))
//                    {
//                        list.add("(" + first + ")" + second);
//                    }
//                }
//            }
//
//            lists.add(list);
//        }
//
//        return lists.get(lists.size() - 1);
//    }
	
	//fastest space optimized
	public List<String> generateParenthesis(int n) {
	    List<String> res = new ArrayList<>();
	    char[] perm = new char[n*2];
	    perms(n, n, perm, 0, res);
//	    System.out.println(count);
	    return res;
	}

	private void perms(int open, int close, char[] perm, int i, List<String> res) {
//		count++;
	    if (i >= perm.length) {
	        if (!(open == 0 && close == 0)) return;
	        res.add(new String(perm));
	        return;
	    }
	    if (open > 0 && close >= open) {
	        perm[i] = '(';
	        perms(open - 1, close, perm, i+1, res);
	    }
	    if (close > 0) {
	        perm[i] = ')';
	        perms(open, close - 1, perm, i+1, res);
	    }
	}
	
	//other's idea
//	public List<String> generateParenthesis(int n) {
//        List<String> list = new ArrayList<String>();
//        backtrack(list, "", 0, 0, n);
//        return list;
//    }
//
//    public void backtrack(List<String> list, String str, int open, int close, int max){
//
//        if(str.length() == max*2){
//            list.add(str);
//            return;
//        }
//
//        if(open < max)
//            backtrack(list, str+"(", open+1, close, max);
//        if(close < open)
//            backtrack(list, str+")", open, close+1, max);
//    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GenerateParentheses t = new GenerateParentheses();
		Date start = new Date();
		List<String> res = t.generateParenthesis(14);
		Date end = new Date();
		System.out.println((end.getTime() - start.getTime()));
		System.out.println(res.size());
//		for (int i = 0; i < res.size(); i++) {
//			System.out.println(res.get(i));
//		}
	}

}
