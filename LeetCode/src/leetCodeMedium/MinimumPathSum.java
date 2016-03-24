package leetCodeMedium;

/**
 * @author Poirot
 * 2015年6月6日
 */
public class MinimumPathSum {
	public static int minPathSum(int[][] grid) {
		if (grid.length == 0) {
			return 0;
		}
		if (grid.length == 1) {
			int result = 0;
			for (int i = 0; i < grid[0].length; i++) {
				result += grid[0][i];
			}
			return result;
		}
		if (grid[0].length == 1) {
			int result = 0;
			for (int i = 0; i < grid.length; i++) {
				result += grid[i][0];
			}
			return result;
		}
		int m = grid.length;
		int n = grid[0].length;
        for (int i = m-2; i >= 0; i--) {
			grid[i][n-1] += grid[i+1][n-1]; 
		}
        for (int i = n-2; i >= 0; i--) {
			grid[m-1][i] += grid[m-1][i+1];  
		}
        for (int i = m-2; i >= 0; i--) {
        	for (int j = n-2; j >=0; j--) {
				grid[i][j] += (grid[i+1][j] > grid[i][j+1] ? grid[i][j+1]:grid[i+1][j]);
			}
        }
        return grid[0][0];
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] test = {{1,2},{1,1}};
		System.out.println(minPathSum(test));
	}

}
