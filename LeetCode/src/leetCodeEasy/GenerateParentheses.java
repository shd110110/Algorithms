package leetCodeEasy;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	public static List<String> generateParenthesis(int n) {
		 List<String>  resultList = new ArrayList<String>();
		StringBuilder t = new StringBuilder();
        oper(resultList,n*2,0,t);
        return resultList;
    }
	public static void oper(List<String> resultList, int doubleN,int par,StringBuilder stringBuilder) {
		
		if (par < 0 || (doubleN-stringBuilder.length()<par)) {
			return ;
		}
		if (stringBuilder.length()== doubleN){
			if (par==0) {
				resultList.add(stringBuilder.toString());
			}
			return;
		}else {
			
			StringBuilder temp1 = new StringBuilder(stringBuilder.toString());
			StringBuilder temp2 = new StringBuilder(stringBuilder.toString());
			oper(resultList,doubleN, par+1, temp1.append('('));
			oper(resultList,doubleN, par-1, temp2.append(')'));
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(generateParenthesis(1));
	}

}
