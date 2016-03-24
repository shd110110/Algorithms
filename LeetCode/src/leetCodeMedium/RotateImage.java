package leetCodeMedium;

/**
 * @author Poirot
 * 2015年6月19日
 */
public class RotateImage {
	public void rotate(int[][] matrix) {
		if (matrix.length <= 1) {
			return;
		}
		int n = matrix.length-1;
        for (int i = 0; i < (n+1)/2; i++) {
			for (int j = 0; j < n/2+1; j++) {
				int t = matrix[i][j];
				matrix[i][j] = matrix[n-j][i];
				matrix[n-j][i] = matrix[n-i][n-j];
				matrix[n-i][n-j] = matrix[j][n-i];
				matrix[j][n-i] = t; 
			}
		}
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RotateImage t = new RotateImage();
		int[][] test = {{1,2},{3,4}};
		t.rotate(test);
		for (int i = 0; i < test.length; i++) {
			for (int j = 0; j < test[0].length; j++) {
				System.out.print(test[i][j]+"  ");
			}
			System.out.println();
		}
	}

}
