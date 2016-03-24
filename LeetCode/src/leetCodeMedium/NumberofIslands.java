package leetCodeMedium;

public class NumberofIslands {
	public static void dfs(char[][] grid, int row, int col, int m, int n) {
		if (row < 0 || row >= m || col < 0 || col >= n) {
			return;
		}
		if (grid[row][col] != '1') {
			return;
		}
		grid[row][col] = 'C';
		dfs(grid, row, col - 1, m, n);
		dfs(grid, row, col + 1, m, n);
		dfs(grid, row + 1, col, m, n);
		dfs(grid, row - 1, col, m, n);

	}

	public static int numIslands(char[][] grid) {
		int result = 0;
		if (grid == null || grid.length == 0) {
			result = 0;
		} else {
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[0].length; j++) {
					if (grid[i][j] == '1') {
						dfs(grid, i, j, grid.length, grid[0].length);
						result++;
					}
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] test = { { '1', '1', '0', '0', '0' },
				{ '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
				{ '0', '0', '0', '1', '1' } };
		for (int i = 0; i < test.length; i++) {
			for (int j = 0; j < test[0].length; j++) {
				System.out.print(test[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println(numIslands(test));
	}

}
