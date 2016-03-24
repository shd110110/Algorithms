/**
 * 2016年1月21日
 * Poirot
 * 上午10:11:45
 * LeetCode
 */
package leetCodeMedium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Poirot
 *
 */
public class LongestIncreasingPathinaMatrix {
//	public class Point{
//		int x;
//		int y;
//		int number;
//		public Point(int x, int y, int number) {
//			this.x = x;
//			this.y = y;
//			this.number = number;
//		}
//	}
//	
//	int res = Integer.MIN_VALUE;
//	
//    public int longestIncreasingPath(int[][] matrix) {
//        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
//        	return 0;
//        }
//        
//        int row = matrix.length;
//        int col = matrix[0].length;
//        int[][] beginWith = new int[row][col];
//       
//        for (int i = 0; i < row; i++) {
//        	for (int j = 0; j < col; j++) {
//        		boolean[][] mark = new boolean[row][col];
//        		travel(matrix, i, j, beginWith, mark);
//        	} 
//        }
//        return res;
//    }
//    
//    public int travel(int[][] matrix, int i, int j, int[][] beginWith, boolean[][] mark) {
//    	mark[i][j] = true; 
//    	beginWith[i][j] = 1;
//    	List<Point>  neighbour = new ArrayList<>();
//    	if (i > 0) {
//    		if (!mark[i - 1][j] && matrix[i][j] < matrix[i - 1][j]) { 
//    			neighbour.add(new Point(i - 1, j, matrix[i - 1][j]));
////    			beginWith[i][j] = Math.max(beginWith[i][j], 1 + travel(matrix, i - 1, j, beginWith, mark));
//    		}
//    	} 
//    	if (i < matrix.length - 1) {
//    		if (!mark[i + 1][j] && matrix[i][j] < matrix[i + 1][j]) { 
//    			neighbour.add(new Point(i + 1, j, matrix[i + 1][j]));
////    			beginWith[i][j] = Math.max(beginWith[i][j], 1 + travel(matrix, i + 1, j, beginWith, mark));
//    		}
//    	} 
//    	if (j > 0) {
//    		if (!mark[i][j - 1] && matrix[i][j] < matrix[i][j - 1]) { 
//    			neighbour.add(new Point(i, j - 1, matrix[i][j - 1]));
////    			beginWith[i][j] = Math.max(beginWith[i][j], 1 + travel(matrix, i, j - 1, beginWith, mark));
//    		}
//    	} 
//    	if (j < matrix[0].length - 1) {
//    		if (!mark[i][j + 1] && matrix[i][j] < matrix[i][j + 1]) { 
//    			neighbour.add(new Point(i, j + 1, matrix[i][j + 1]));
////    			beginWith[i][j] = Math.max(beginWith[i][j], 1 + travel(matrix, i, j + 1, beginWith, mark));
//    		}
//    	} 
//    	Collections.sort(neighbour, new Comparator<Point>() {
//
//			@Override
//			public int compare(Point o1, Point o2) {
//				// TODO Auto-generated method stub
//				return o1.number > o2.number ? 1 : -1;
//			}
//		});
//    	
////    	if (i == 2 && j == 1) {
////    		for (int k = 0; k < neighbour.size(); k++) {
////    			Point point = neighbour.get(k);
////        		System.out.println(point.x + " " + point.y + " " + point.number);
////    		}
////    	}
//    	for (Point point : neighbour) { 
//    		beginWith[i][j] = Math.max(beginWith[i][j], 1 + travel(matrix, point.x, point.y, beginWith, mark));
//		}
//    	res = Math.max(res, beginWith[i][j]);
//    	return beginWith[i][j]; 
//    }
    
    
    
    
    // other's solution
	int[][] dis = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public int longestIncreasingPath(int[][] matrix) {
		if (matrix.length == 0) {
			return 0;
		}
		int[][] state = new int[matrix.length][matrix[0].length];
		int res = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j =   0; j < matrix[0].length; j++) {
				res = Math.max(res, dfs(i, j, matrix, state));
			}
		}
		return res;
	}

	public int dfs(int i, int j, int[][] matrix, int[][] state) {
		if (state[i][j] > 0)
			return state[i][j];
		int max = 0;
		for (int m = 0; m < dis.length; m++) {
			if (i + dis[m][0] >= 0 && i + dis[m][0] < matrix.length && j + dis[m][1] >= 0
					&& j + dis[m][1] < matrix[0].length && matrix[i + dis[m][0]][j + dis[m][1]] > matrix[i][j]) {
				max = Math.max(max, dfs(i + dis[m][0], j + dis[m][1], matrix, state));
			}
		}
		state[i][j] = 1 + max;
		return state[i][j]; 
	}
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] matrix = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
//		int[][] matrix = {{3, 4, 5}, {3, 2, 6}, {2, 2, 1}};
//		int[][] matrix = {{7, 8, 9}, {9, 7, 6}, {7, 2, 3}};
		int[][] matrix = {{0,1,2,3,4,5,6,7,8,9},{19,18,17,16,15,14,13,12,11,10},{20,21,22,23,24,25,26,27,28,29},{39,38,37,36,35,34,33,32,31,30},{40,41,42,43,44,45,46,47,48,49},{59,58,57,56,55,54,53,52,51,50},{60,61,62,63,64,65,66,67,68,69},{79,78,77,76,75,74,73,72,71,70},{80,81,82,83,84,85,86,87,88,89},{99,98,97,96,95,94,93,92,91,90},{100,101,102,103,104,105,106,107,108,109},{119,118,117,116,115,114,113,112,111,110},{120,121,122,123,124,125,126,127,128,129},{139,138,137,136,135,134,133,132,131,130},{0,0,0,0,0,0,0,0,0,0}}; 
		LongestIncreasingPathinaMatrix t = new LongestIncreasingPathinaMatrix();
		System.out.println(t.longestIncreasingPath(matrix));
		System.out.println("test");
	}

}
