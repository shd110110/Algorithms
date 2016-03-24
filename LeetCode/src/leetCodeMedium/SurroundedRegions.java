/**
 * 2015Äê6ÔÂ24ÈÕ
 * CH
 */
package leetCodeMedium; 
 

/**
 * @author CH
 *
 */
public class SurroundedRegions {   
	// my idea
	public void solve(char[][] board) {
		if (board.length == 0) {
			return;
		}
		int m = board.length;
		int n = board[0].length;
		boolean[][] temp = new boolean[m][n]; 
		for (int i = 0; i < m; i++) {
			temp[i][0] = (board[i][0] == 'O');
			temp[i][n-1] = (board[i][n-1] == 'O');
		}
		for (int i = 0; i < n; i++) {
			temp[0][i] = (board[0][i] == 'O');
			temp[m-1][i] = (board[m-1][i] == 'O');
		}
		for (int i = 1; i < m-1; i++) {
			for (int j = 1; j < n-1; j++) {
				if (board[i][j] == 'X' || temp[i][j] == true) {
					continue;
				}
				if (board[i][j-1] == 'O' && (temp[i+1][j] == true||temp[i][j-1]==true ||temp[i-1][j] == true||temp[i][j+1]==true ) ) {
					temp[i][j] = true;
				}
			}
		}

		for (int j = 1; j < n-1; j++) {
			for (int i = 1; i < m-1; i++) {
				if (board[i][j] == 'X' || temp[i][j] == true) {
					continue;
				}else if (board[i-1][j]== 'O' && (temp[i+1][j] == true||temp[i][j-1]==true ||temp[i-1][j] == true||temp[i][j+1]==true )) {
					temp[i][j] = true;
				}
			}
		}
		
		for (int i = 1; i < m; i++) {
			for ( int j = n-2; j>=1 ; j--){
				if (board[i][j] == 'X' || temp[i][j] == true) {
					continue;
				}else if (board[i][j+1] == 'O' && (temp[i+1][j] == true||temp[i][j-1]==true ||temp[i-1][j] == true||temp[i][j+1]==true )) {
					temp[i][j] = true;
				}
			}
		}
		
		for (int j = 1; j < n-1; j++) {
			for (int i = m-2; i >= 1; i--) {
				if (board[i][j] == 'X' || temp[i][j] == true) {
					continue;
				}else if (board[i+1][j]== 'O' && (temp[i+1][j] == true||temp[i][j-1]==true ||temp[i-1][j] == true||temp[i][j+1]==true )) {
					temp[i][j] = true;
				}
			}
		}
		
		// 

		for (int j = 1; j < n-1; j++) {
			for (int i = 1; i < m-1; i++) {
				if (board[i][j] == 'X' || temp[i][j] == true) {
					continue;
				}else if (board[i-1][j]== 'O' && (temp[i+1][j] == true||temp[i][j-1]==true ||temp[i-1][j] == true||temp[i][j+1]==true )) {
					temp[i][j] = true;
				}
			}
		}
		
		for (int i = 1; i < m; i++) {
			for ( int j = n-2; j>=1 ; j--){
				if (board[i][j] == 'X' || temp[i][j] == true) {
					continue;
				}else if (board[i][j+1] == 'O' && (temp[i+1][j] == true||temp[i][j-1]==true ||temp[i-1][j] == true||temp[i][j+1]==true )) {
					temp[i][j] = true;
				}
			}
		}
		
		for (int j = 1; j < n-1; j++) {
			for (int i = m-2; i >= 1; i--) {
				if (board[i][j] == 'X' || temp[i][j] == true) {
					continue;
				}else if (board[i+1][j]== 'O' && (temp[i+1][j] == true||temp[i][j-1]==true ||temp[i-1][j] == true||temp[i][j+1]==true )) {
					temp[i][j] = true;
				}
			}
		}
		
		for (int i = 1; i < m-1; i++) {
			for (int j = 1; j < n-1; j++) {
				if (board[i][j] == 'X' || temp[i][j] == true) {
					continue;
				}
				if (board[i][j-1] == 'O' && (temp[i+1][j] == true||temp[i][j-1]==true ||temp[i-1][j] == true||temp[i][j+1]==true )) {
					temp[i][j] = true;
				}
			}
		}
		
		//
		
		
		for (int i = 1; i < m; i++) {
			for ( int j = n-2; j>=1 ; j--){
				if (board[i][j] == 'X' || temp[i][j] == true) {
					continue;
				}else if (board[i][j+1] == 'O' && (temp[i+1][j] == true||temp[i][j-1]==true ||temp[i-1][j] == true||temp[i][j+1]==true ) ) {
					temp[i][j] = true;
				}
			}
		}
		
		for (int j = 1; j < n-1; j++) {
			for (int i = m-2; i >= 1; i--) {
				if (board[i][j] == 'X' || temp[i][j] == true) {
					continue;
				}else if (board[i+1][j]== 'O' && (temp[i+1][j] == true||temp[i][j-1]==true ||temp[i-1][j] == true||temp[i][j+1]==true )) {
					temp[i][j] = true;
				}
			}
		}
		for (int i = 1; i < m-1; i++) {
			for (int j = 1; j < n-1; j++) {
				if (board[i][j] == 'X' || temp[i][j] == true) {
					continue;
				}
				if (board[i][j-1] == 'O' && (temp[i+1][j] == true||temp[i][j-1]==true ||temp[i-1][j] == true||temp[i][j+1]==true )) {
					temp[i][j] = true;
				}
			}
		}

		for (int j = 1; j < n-1; j++) {
			for (int i = 1; i < m-1; i++) {
				if (board[i][j] == 'X' || temp[i][j] == true) {
					continue;
				}else if (board[i-1][j]== 'O' && (temp[i+1][j] == true||temp[i][j-1]==true ||temp[i-1][j] == true||temp[i][j+1]==true )) {
					temp[i][j] = true;
				}
			}
		}
		// 
		
		for (int j = 1; j < n-1; j++) {
			for (int i = m-2; i >= 1; i--) {
				if (board[i][j] == 'X' || temp[i][j] == true) {
					continue;
				}else if (board[i+1][j]== 'O' && (temp[i+1][j] == true||temp[i][j-1]==true ||temp[i-1][j] == true||temp[i][j+1]==true )) {
					temp[i][j] = true;
				}
			}
		}

		for (int i = 1; i < m-1; i++) {
			for (int j = 1; j < n-1; j++) {
				if (board[i][j] == 'X' || temp[i][j] == true) {
					continue;
				}
				if (board[i][j-1] == 'O' && (temp[i+1][j] == true||temp[i][j-1]==true ||temp[i-1][j] == true||temp[i][j+1]==true ) ) {
					temp[i][j] = true;
				}
			}
		}

		for (int j = 1; j < n-1; j++) {
			for (int i = 1; i < m-1; i++) {
				if (board[i][j] == 'X' || temp[i][j] == true) {
					continue;
				}else if (board[i-1][j]== 'O' && (temp[i+1][j] == true||temp[i][j-1]==true ||temp[i-1][j] == true||temp[i][j+1]==true )) {
					temp[i][j] = true;
				}
			}
		}
		
		for (int i = 1; i < m; i++) {
			for ( int j = n-2; j>=1 ; j--){
				if (board[i][j] == 'X' || temp[i][j] == true) {
					continue;
				}else if (board[i][j+1] == 'O' && (temp[i+1][j] == true||temp[i][j-1]==true ||temp[i-1][j] == true||temp[i][j+1]==true )) {
					temp[i][j] = true;
				}
			}
		}
		
		
		for (int i = 1; i < m-1; i++) {
			for (int j = 1; j < n-1; j++) {
				if (temp[i][j] == false && board[i][j] == 'O' && temp[i-1][j]!=true && temp[i+1][j]!=true
						&& temp[i][j-1]!=true && temp[i][j+1]!=true) {
					board[i][j] = 'X';
				}
			}
		}
		
	}
	
	// other's idea
//	public void solve(char[][] board) {
//		int rowS = board.length;
//        if (rowS==0) return;
//        int colS = board[0].length;
//        
//        
//        
//        for (int row=0; row<rowS; ++row) {
//            int col = 0;
//            if (board[row][col]=='O') {
//                Queue<Integer> q = new LinkedList<>();
//                board[row][col]='1';
//                q.add(row*colS+col);
//                while (!q.isEmpty()) {
//                    int cur = q.poll();
//                    int x = cur/colS;
//                    int y = cur%colS;
//                    if (y+1<colS && board[x][y+1]=='O') {
//                        q.add(cur+1);
//                        board[x][y+1] = '1';
//                    }
//                    if (x+1<rowS && board[x+1][y]=='O') {
//                        q.add(cur+colS);
//                        board[x+1][y] = '1';
//                    }
//                    if (y-1>=0 && board[x][y-1]=='O') {
//                        q.add(cur-1);
//                        board[x][y-1] = '1';
//                    }
//                    if (x-1>=0 && board[x-1][y]=='O') {
//                        q.add(cur-colS);
//                        board[x-1][y] = '1';
//                    }
//                }
//            }
//            
//            col = colS -1; 
//            if (board[row][col]=='O') {
//                Queue<Integer> q = new LinkedList<>();
//                board[row][col]='1';
//                q.add(row*colS+col);
//                while (!q.isEmpty()) {
//                    int cur = q.poll();
//                    int x = cur/colS;
//                    int y = cur%colS;
//                    if (y+1<colS && board[x][y+1]=='O') {
//                        q.add(cur+1);
//                        board[x][y+1] = '1';
//                    }
//                    if (x+1<rowS && board[x+1][y]=='O') {
//                        q.add(cur+colS);
//                        board[x+1][y] = '1';
//                    }
//                    if (y-1>=0 && board[x][y-1]=='O') {
//                        q.add(cur-1);
//                        board[x][y-1] = '1';
//                    }
//                    if (x-1>=0 && board[x-1][y]=='O') {
//                        q.add(cur-colS);
//                        board[x-1][y] = '1';
//                    }
//                }
//            }
//        }
//		for (int col=0; col<colS; ++col) {
//			int row = 0;
//            if (board[row][col]=='O') {
//                Queue<Integer> q = new LinkedList<>();
//                board[row][col]='1';
//                q.add(row*colS+col);
//                while (!q.isEmpty()) {
//                    int cur = q.poll();
//                    int x = cur/colS;
//                    int y = cur%colS;
//                    if (y+1<colS && board[x][y+1]=='O') {
//                        q.add(cur+1);
//                        board[x][y+1] = '1';
//                    }
//                    if (x+1<rowS && board[x+1][y]=='O') {
//                        q.add(cur+colS);
//                        board[x+1][y] = '1';
//                    }
//                    if (y-1>=0 && board[x][y-1]=='O') {
//                        q.add(cur-1);
//                        board[x][y-1] = '1';
//                    }
//                    if (x-1>=0 && board[x-1][y]=='O') {
//                        q.add(cur-colS);
//                        board[x-1][y] = '1';
//                    }
//                }
//            }
//            
//            row = rowS -1; 
//            if (board[row][col]=='O') {
//                Queue<Integer> q = new LinkedList<>();
//                board[row][col]='1';
//                q.add(row*colS+col);
//                while (!q.isEmpty()) {
//                    int cur = q.poll();
//                    int x = cur/colS;
//                    int y = cur%colS;
//                    if (y+1<colS && board[x][y+1]=='O') {
//                        q.add(cur+1);
//                        board[x][y+1] = '1';
//                    }
//                    if (x+1<rowS && board[x+1][y]=='O') {
//                        q.add(cur+colS);
//                        board[x+1][y] = '1';
//                    }
//                    if (y-1>=0 && board[x][y-1]=='O') {
//                        q.add(cur-1);
//                        board[x][y-1] = '1';
//                    }
//                    if (x-1>=0 && board[x-1][y]=='O') {
//                        q.add(cur-colS);
//                        board[x-1][y] = '1';
//                    }
//                }
//            }
//		}
//        
//        
//        
//        for (int i=0; i<rowS; ++i) {
//            for (int j=0; j<colS; ++j) {
//                if (board[i][j]=='O') {
//                    board[i][j]='X';
//                } else if (board[i][j]=='1') {
//                    board[i][j]='O';
//                }
//            }
//        }
//	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] test = {{'X', 'X', 'X', 'X'},{ 'X', 'O', 'O', 'X'},{ 'X', 'X', 'O', 'X'},{ 'X', 'O', 'X', 'X'}};
		SurroundedRegions t = new SurroundedRegions();
		t.solve(test);
		for (int i = 0; i < test.length; i++) {
			for (int j = 0; j < test[0].length; j++) {
				System.out.print(test[i][j] + " ");
			}
			System.out.println();
		}
	}

}
