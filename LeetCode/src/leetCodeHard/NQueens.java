package leetCodeHard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Poirot
 * 2015年6月21日
 */
public class NQueens {
//	List<String[]> result = new ArrayList<String[]>();
//    public List<String[]> solveNQueens(int n) {
//    	int[] board = new int[n];
//    	for (int i = 0; i < board.length; i++) {
//			board[i] = -1;
//		}
//    	forCall(board, 0);
//    	return result;
//    }
//    
//    public void forCall(int[] board,int k){
//    	if (k == board.length) {
//			String[] temp= new String[board.length];
//			for (int i = 0; i < board.length; i++) {
//				StringBuilder a = new StringBuilder(temp.length);
//				for (int j = 0; j < temp.length; j++) {
//					if (j == board[i]) {
//						a.append('Q');
//					}else {
//						a.append('.');
//					}
//					
//				}
//				temp[i] = a.toString();
//			}
//			result.add(temp);
//			return;
//		}
//    	for (int i = 0; i < board.length; i++) {
//    		board[k] = i;
//			if (isValid(board,k)) { 
//				forCall(board, k+1);
//			}
//			board[k] = -1;
//		}
//    }
//    public boolean isValid(int[] board,int k){
//    	for (int i = 0; i <= k ; i++) {
//			for (int j = i+1;j <= k ; j++) {
//				if (i+board[i] == j+board[j] || i+board[j] == j+board[i] || board[i] == board[j]) {
//					return false;
//				} 
//			}
//		}
//    	return true;
//    }
	
	
	
	
	
	
	
	
	// Second Round 2016/1/5 0:41 12ms
//	List<List<String>> res = new ArrayList<>();
//	public List<List<String>> solveNQueens(int n) {
//		char[][] matrix = new char[n][n];
//		for (int i = 0; i < matrix.length; i++) { 
//			for (int j = 0; j < matrix.length; j++) {
//				matrix[i][j] = '.';
//			}
//		}
//		solve(matrix, 0);
//		return res;
//	}
//
//	public void solve(char[][] matrix, int level) {
//		if (level >= matrix.length) {
//			List<String> list = new ArrayList<>();
//			for (int i = 0; i < matrix.length; i++) {
//				StringBuilder sb = new StringBuilder();
//				for (int j = 0; j < matrix.length; j++) {
//					sb.append(matrix[i][j]);
//				}
//				list.add(sb.toString());
//			}
//			res.add(list);
//			return;
//		}
//		for (int j = 0; j < matrix.length; j++) {
//			matrix[level][j] = 'Q';
//			int m = level - 1;
//			int n = j + 1;
//			boolean illegal = true;
//			while (m >= 0 && n < matrix.length) {
//				if (matrix[m][n] == 'Q') {
//					illegal = false;
//					break;
//				}
//				m--;
//				n++;
//			}
//			m = level - 1;
//			n = j - 1;
//			while (m >= 0 && n >=0) {
//				if (matrix[m][n] == 'Q') {
//					illegal = false;
//					break;
//				}
//				m--;
//				n--;
//			}
//			m = level - 1;
//			while (m >= 0) {
//				if (matrix[m][j] == 'Q') {
//					illegal = false;
//					break;
//				}
//				m--;
//			}
//			if (!illegal) {
//				matrix[level][j] = '.';
//				continue;
//			} else {
//				solve(matrix, level+1);
//				matrix[level][j] = '.';
//			}
//		}
//	}
	
	
	// 5ms
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> res = new ArrayList<>();
		char[][] nQueens = new char[n][n];
		for (int i = 0; i < nQueens.length; i++) {
			for (int j = 0; j < nQueens.length; j++) {
				nQueens[i][j] = '.';
			}
		}
		solveNQueens(res, nQueens, 0, n);
		return res;
	}

	void solveNQueens(List<List<String>> res, char[][] nQueens, int row, int n) {
		if (row == n) {
			List<String> resStrings = new ArrayList<>();
			for (int i = 0; i < nQueens.length; i++) {
				resStrings.add(new String(nQueens[i]));
			}
			res.add(resStrings);
			return;
		}
		for (int col = 0; col != n; ++col)
			if (isValid(nQueens, row, col, n)) {
				nQueens[row][col] = 'Q';
				solveNQueens(res, nQueens, row + 1, n);
				nQueens[row][col] = '.';
			}
	}

	boolean isValid(char[][] nQueens, int row, int col, int n) {
		// check if the column had a queen before.
		for (int i = 0; i != row; ++i)
			if (nQueens[i][col] == 'Q')
				return false;
		// check if the 45° diagonal had a queen before.
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; --i, --j)
			if (nQueens[i][j] == 'Q')
				return false;
		// check if the 135° diagonal had a queen before.
		for (int i = row - 1, j = col + 1; i >= 0 && j < n; --i, ++j)
			if (nQueens[i][j] == 'Q')
				return false;
		return true;
	}
		
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NQueens t = new NQueens();
		List<List<String>> res = t.solveNQueens(8);
		for (int i = 0; i < res.size(); i++) {
			for (int j = 0; j < res.get(i).size(); j++) {
				System.out.println(res.get(i).get(j));
			}
			System.out.println();
		}
	}

}
