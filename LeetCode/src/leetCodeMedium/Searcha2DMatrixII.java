package leetCodeMedium;

/**
 * @author Poirot
 * 2015年8月19日
 */
public class Searcha2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int xIndex = matrix.length-1;
        int yIndex = 0;
        while (xIndex >= 0 && yIndex < matrix[0].length) {
        	if (matrix[xIndex][yIndex] == target) {
				return true;
			} else if (matrix[xIndex][yIndex] > target) {
				xIndex --;
			} else {
				yIndex ++;
			}
        }
        return false;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
