/**
 * 2016年1月8日
 * Poirot
 * 上午9:24:50
 * LeetCode
 */
package leetCodeHard;

/**
 * @author Poirot
 *
 */
public class DungeonGame {
	
	//second round
	public int calculateMinimumHP(int[][] dungeon) {
		if (dungeon.length == 0) {
			return 1;
		}
		int row = dungeon.length;
		int col = dungeon[0].length;
		dungeon[row - 1][col - 1] = Math.max(1 - dungeon[row - 1][col - 1], 1);
		for (int i = row - 2; i >= 0; i--) {
			dungeon[i][col - 1] = Math.max(dungeon[i + 1][col - 1] - dungeon[i][col - 1], 1);
		}
		for (int j = col - 2; j >= 0; j--) {
			dungeon[row - 1][j] = Math.max(dungeon[row - 1][j + 1] - dungeon[row - 1][j], 1);
		}
		for (int i = row - 2; i >= 0; i--) {
			for (int j = col - 2; j >= 0; j--) {
				dungeon[i][j] = Math.max(Math.min(dungeon[i+1][j], dungeon[i][j+1]) - dungeon[i][j], 1);
			}
		}
		return dungeon[0][0];
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
