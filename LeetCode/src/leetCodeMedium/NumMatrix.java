/**
 * 2015年11月18日
 * Poirot
 */
package leetCodeMedium;

/**
 * @author Poirot
 *
 */
public class NumMatrix {
	int[][] matrixSums;
	boolean isNull = false;
    public NumMatrix(int[][] matrix) {
    	if (matrix == null || matrix.length == 0) {
			isNull = true;
		} else {
			matrixSums = new int[matrix.length][matrix[0].length];
	        int tempSum = 0;
	        for (int j = 0; j < matrix[0].length; j++) {
	        	tempSum += matrix[0][j];
	        	matrixSums[0][j] = tempSum;
	        } 
	        
	        for (int i = 1; i < matrix.length; i++) {
	        	tempSum = 0;
				for (int j = 0; j < matrix[0].length; j++) {
					tempSum += matrix[i][j];
					matrixSums[i][j] = tempSum + matrixSums[i-1][j];
				}
			}
//	        for (int i = 0; i < matrix.length; i++) { 
//				for (int j = 0; j < matrix[0].length; j++) {
//					System.out.print(matrixSums[i][j] + " ");
//				}
//				System.out.println();
//			}
		}
        
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
    	if (isNull) {
			return 0;
		}
    	if (row1 == 0 || col1 == 0) {
			if (row1 == 0 && col1 == 0) {
				return matrixSums[row2][col2];
			}
			if (row1 == 0) {
				return matrixSums[row2][col2] - matrixSums[row2][col1-1];
			}
			return matrixSums[row2][col2] - matrixSums[row1-1][col2];
		}
        return matrixSums[row1-1][col1-1] + matrixSums[row2][col2] - matrixSums[row1-1][col2] - matrixSums[row2][col1-1];
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
		NumMatrix t = new NumMatrix(matrix);
		System.out.println(t.sumRegion(2,1,4,3));
		System.out.println(t.sumRegion(1,1,2,2));
		System.out.println(t.sumRegion(1,2,2,4));
	}

}
