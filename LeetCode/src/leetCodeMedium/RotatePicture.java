package leetCodeMedium;

/**
 * @author Poirot
 * 2015年9月17日
 */
public class RotatePicture {
	public int[][] rotatePictureMethod(int[][] matrix ,int flag) {
		//if (matrix.length <= 1) {
//		return matrix;
	//}
	//if (flag == 1) {
//		int n = matrix.length-1;
//	    for (int i = 0; i < (n+1)/2; i++) {
//			for (int j = 0; j < n/2+1; j++) {
//				int t = matrix[i][j];
//				matrix[i][j] = matrix[n-j][i];
//				matrix[n-j][i] = matrix[n-i][n-j];
//				matrix[n-i][n-j] = matrix[j][n-i];
//				matrix[j][n-i] = t; 
//			}
//		}
	//} else {
//		int n = matrix.length-1;
//	    for (int i = 0; i < (n+1)/2; i++) {
//			for (int j = 0; j < n/2+1; j++) {
//				int t = matrix[i][j];
//				matrix[i][j] = matrix[j][n-i];
//				matrix[j][n-i] = matrix[n-i][n-j];
//				matrix[n-i][n-j] = matrix[n-j][i];
//				matrix[n-j][i] = t; 
//			}
//		}
	//}
	//return matrix;
		if (matrix.length <= 1) {
			return matrix;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] result = new int[n][m];
		if (flag == 1) {
	        for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					result[j][m-i-1]= matrix[i][j];
				}
			}
		} else {
	        for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					result[n-j-1][i] = matrix[i][j];
				}
			}
		}
		return result;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] test= {{1,2},{4,5},{7,8}};
		RotatePicture t = new RotatePicture();
		int[][] r = t.rotatePictureMethod(test, 1);
		for (int i = 0; i < r.length; i++) {
			for (int j = 0; j < r[0].length; j++) {
				System.out.print(r[i][j] + " ");
			}
			System.out.println();
		}
	}

}
