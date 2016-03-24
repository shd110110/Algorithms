/**
 * 2015年11月19日
 * Poirot
 */
package leetCodeMedium;

/**
 * @author Poirot
 *
 */
public class GameofLife {
	// public void gameOfLife(int[][] board) {
	// if(board == null || board.length == 0) return;
	// int m = board.length, n = board[0].length;
	//
	// for(int i = 0; i < m; i++) {
	// for(int j = 0; j < n; j++) {
	// int lives = liveNeighbors(board, m, n, i, j);
	//
	// // In the beginning, every 2nd bit is 0;
	// // So we only need to care about when 2nd bit will become 1.
	// if((board[i][j] & 1) == 1 && (lives >= 2 && lives <= 3)) {
	// board[i][j] = 3; // Make the 2nd bit 1: 01 ---> 11
	// }
	// if((board[i][j] & 1) == 0 && lives == 3) {
	// board[i][j] = 2; // Make the 2nd bit 1: 00 ---> 10
	// }
	// }
	// }
	//
	// for(int i = 0; i < m; i++) {
	// for(int j = 0; j < n; j++) {
	// board[i][j] >>= 1; // Get the 2nd state.
	// }
	// }
	// }
	//
	// public int liveNeighbors(int[][] board, int m, int n, int i, int j) {
	// int lives = 0;
	// for(int p = Math.max(i - 1, 0); p <= Math.min(i + 1, m - 1); p++) {
	// for(int q = Math.max(j - 1, 0); q <= Math.min(j + 1, n - 1); q++) {
	// lives += board[p][q] & 1;
	// }
	// }
	// lives -= board[i][j] & 1;
	// return lives;
	// }

	public void gameOfLife(int[][] board) {
		int m = board.length;
		int n = board[0].length;
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				int count = 0;
				for (int I = Math.max(i - 1, 0); I < Math.min(i + 2, m); ++I)
					for (int J = Math.max(j - 1, 0); J < Math.min(j + 2, n); ++J)
						count += board[I][J] & 1;
				if (count == 3 || count - board[i][j] == 3) //count itself
					board[i][j] |= 2;
			}
		}
		for (int i = 0; i < m; ++i)
			for (int j = 0; j < n; ++j)
				board[i][j] >>= 1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
