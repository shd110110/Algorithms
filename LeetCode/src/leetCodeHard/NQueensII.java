package leetCodeHard;

/**
 * @author Poirot
 * 2015年6月21日
 */
public class NQueensII {
	int result = 0;
    public int totalNQueens(int n) {
    	int[] board = new int[n];
    	for (int i = 0; i < board.length; i++) {
			board[i] = -1;
		}
    	forCall(board, 0);
    	return result;
    }
    
    public void forCall(int[] board,int k){
    	if (k == board.length) {
			result++;
			return;
		}
    	for (int i = 0; i < board.length; i++) {
    		board[k] = i;
			if (isValid(board,k)) { 
				forCall(board, k+1);
			}
			board[k] = -1;
		}
    }
    public boolean isValid(int[] board,int k){
    	for (int i = 0; i <= k ; i++) {
			for (int j = i+1;j <= k ; j++) {
				if (i+board[i] == j+board[j] || i+board[j] == j+board[i] || board[i] == board[j]) {
					return false;
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
		NQueensII t = new NQueensII();
		System.out.println(t.totalNQueens(8));
		int[] test = {3,2,-1,-1,-1,-1,-1,-1};
		System.out.println(t.isValid(test,1));
	}

}
