package leetCodeEasy;

import java.util.ArrayList; 
import java.util.List;

public class testByCH2 {
	public static int test(int[][] input) {
		int[] scores = new int[input[0].length];
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[0].length; j++) {
				scores[input[i][j]] += (input[0].length-j);
			}
		}
		int index=0;
		int maxScores = scores[0];
		for (int i = 1; i < scores.length; i++) {
			if (scores[i] >maxScores) {
				index = i;
				maxScores = scores[i];
			}
		}
		return index;
	}
	
	public static List<String> test2(String s){
		String temp = "aabcehmu";
		List<String> result = new ArrayList<>();
		for(int i=temp.length();i>=1;i--){
			String t = temp.substring(0, i);
			if (s.indexOf(t) != -1) {
				for (int j = 1; j <= t.length(); j++) {
					result.add(t.substring(0, j));
				}
				break;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] t = {{2,0,1},{2,1,0},{0,1,2},{1,2,0}};
		System.out.println(test(t));
		
		String teString = "aabcd";
		System.out.println(test2(teString));
	}

}
