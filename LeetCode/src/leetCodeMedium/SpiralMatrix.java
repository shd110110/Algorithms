package leetCodeMedium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Poirot 2015年6月10日
 */
public class SpiralMatrix {
	public static List<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> result = new ArrayList<>();
		int m = matrix.length;
		if(m == 0)
		    return result;
		int n = matrix[0].length;
		int begin = 0;

		while (m>begin && n>begin){
			for (int j = begin; j < n; j++) {
				result.add(matrix[begin][j]);
				
			}
			for (int j = begin+1; j < m; j++) {
				result.add(matrix[j][n-1]);
				
			}
			if (m == begin+1 || n== begin+1) {
				break;
			}
			for (int j = n-2; j >= begin; j--) {
				result.add(matrix[m-1][j]);
			}
			for (int j = m-2; j >= begin+1; j--) {
				result.add(matrix[j][begin]);
			}
			m--;
			n--;
			begin++;
		}
		return result;
	}
	public static void main(String[] args){
		int[][] test = {{ 1, 2, 3 ,4},{5, 6, 7, 8},{9, 10, 11, 12}};
		List<Integer> r = spiralOrder(test);
		for (int i = 0; i < r.size(); i++) {
			System.out.print(r.get(i) + "  ");
		}
		
		System.out.println();
		int[][] test2 = {{2,3}};
		r = spiralOrder(test2);
		for (int i = 0; i < r.size(); i++) {
			System.out.print(r.get(i)+"  ");
		}
		          
	}
}
