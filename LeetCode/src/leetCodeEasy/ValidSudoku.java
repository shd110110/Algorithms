package leetCodeEasy;

import java.util.HashSet;

/**
 * @author Poirot
 * 2015年6月2日
 */
public class ValidSudoku {

	public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
			HashSet<Character> temp = new HashSet<>();
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.' && !temp.add(board[i][j])) {
					return false;
				}
			}
		}
		
		for (int j = 0; j < 9; j++) {
			HashSet<Character> temp = new HashSet<>();
			for (int i = 0; i < 9; i++) {
				if (board[i][j] != '.' && !temp.add(board[i][j])) {
					return false;
				}
			}
		}
		
		for (int begin = 0; begin < 9; begin +=3) {
			for (int column = 0; column < 9; column+=3) {
				HashSet<Character> temp = new HashSet<>();
				for (int i = begin; i < begin+3; i++) {
					for (int j = column; j < begin+3; j++) {
						if (board[i][j] != '.' && !temp.add(board[i][j])) {
							return false;
						}
					}
				}
			}
		}
		return true;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
