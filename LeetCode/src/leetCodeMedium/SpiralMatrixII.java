package leetCodeMedium;

/**
 * @author Poirot
 * 2015年6月11日
 */
public class SpiralMatrixII {
    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
		int begin = 0;
		int i = 1;
		while (n>begin){
			for (int j = begin; j < n; j++) {
				result[begin][j] = i++; 
			}
			for (int j = begin+1; j < n; j++) {
				result[j][n-1] = i++; ;
				
			}
			if (n== begin+1) {
				break;
			}
			for (int j = n-2; j >= begin; j--) {
				result[n-1][j] = i++;
			}
			for (int j = n-2; j >= begin+1; j--) {
				result[j][begin] = i++;
			}
			n--;
			begin++;
		}
        return result;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] test = generateMatrix(3);
		for (int i = 0; i < test.length; i++) {
			for (int j = 0; j < test[0].length; j++) {
				System.out.print(test[i][j]);
			}
			System.out.println();
		}
	}

}
