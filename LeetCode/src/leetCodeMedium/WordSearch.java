package leetCodeMedium;

import java.util.ArrayList;
//150605
public class WordSearch {
	// public static Map<Character, ArrayList<Coordinate>> charIndexesMap;
	public class Coordinate {
		int x;
		int y;

		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}
	}

	public boolean exist(char[][] board, String word) {
		// for (int i = 0; i < board.length; i++) {
		// for (int j = 0; j < board[0].length; j++) {
		// System.out.print(board[i][j]+ " ");
		// }
		// System.out.println();
		// }
		if (word == null) {
			return true;
		}
		ArrayList<Coordinate> indexesOfChar = new ArrayList<Coordinate>();
		char first = word.charAt(0);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] != '.' && board[i][j] == first) {
					indexesOfChar.add(new Coordinate(i, j));
				}
			}
		}

		for (int i = 0; i < indexesOfChar.size(); i++) {

			Coordinate a = indexesOfChar.get(i);
			// System.out.println(a.x+"   "+a.y+ "   "+word.substring(1,
			// word.length()));
			board[a.x][a.y] = '.';// �ӵ�ǰ��ݹ�;
			if (existDigui(board, a, word.substring(1, word.length()))) {
				return true;
			}
			board[a.x][a.y] = first;
		}
		return false;
	}

	public boolean existDigui(char[][] board, Coordinate begin, String word) {

		if (word == null || word.length() == 0) {
			return true;
		}
		char c = word.charAt(0);
		int x = begin.x;
		int y = begin.y;
		// if (word.length() == 1) {
		// if (x - 1 >= 0 && board[x-1][y] == c) {
		// return true;
		// }
		// if (y + 1 <= board[0].length-1 && board[x][y+1] == c) {
		// return true;
		// }
		// if (x + 1 <= board.length-1 && board[x+1][y] == c) {
		// return true;
		// }
		// if (y - 1 >= 0 && board[x][y-1] == c) {
		// return true;
		// }
		// }

		if (x - 1 >= 0 && board[x - 1][y] == c) {
			board[x - 1][y] = '.';
			if (existDigui(board, new Coordinate(x - 1, y),
					word.substring(1, word.length()))) {
				return true;
			}
			board[x - 1][y] = c;
		}
		if (y + 1 <= board[0].length - 1 && board[x][y + 1] == c) {
			board[x][y + 1] = '.';
			if (existDigui(board, new Coordinate(x, y + 1),
					word.substring(1, word.length()))) {
				return true;
			}
			board[x][y + 1] = c;
		}
		if (x + 1 <= board.length - 1 && board[x + 1][y] == c) {
			board[x + 1][y] = '.';
			if (existDigui(board, new Coordinate(x + 1, y),
					word.substring(1, word.length()))) {
				return true;
			}
			board[x + 1][y] = c;
		}
		if (y - 1 >= 0 && board[x][y - 1] == c) {
			board[x][y - 1] = '.';
			if (existDigui(board, new Coordinate(x, y - 1),
					word.substring(1, word.length()))) {
				return true;
			}
			board[x][y - 1] = c;
		}
		return false;
	}

	public static void main(String[] args) {
		char[][] test = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' },
				{ 'A', 'D', 'E', 'E' } };
		char[][] test2 = { { 'a', 'b' }, { 'c', 'd' } };
		WordSearch t = new WordSearch();
		System.out.println(t.exist(test, "ABCB"));
		System.out.println(t.exist(test2, "acdb"));
		
		for (int i = 0; i < test2.length; i++) {
			for (int j = 0; j < test2[0].length; j++) {
				System.out.print(test2[i][j] + " ");
			}
			System.out.println();
		}
	}

}
