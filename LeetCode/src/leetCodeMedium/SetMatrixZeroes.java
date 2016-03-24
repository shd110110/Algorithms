package leetCodeMedium;

/**
 * @author Poirot
 * 2015年6月11日
 */
public class SetMatrixZeroes {
	public static void setZeroes(int[][] matrix) {
		boolean row = false,column = false;
	    for(int i = 0; i < matrix.length; i++) {
	        for(int j = 0; j < matrix[0].length; j++) {
	            if(matrix[i][j] == 0) {
	                if(i == 0) 
	                    row = true;
	                if(j == 0) 
	                    column = true;
	                matrix[0][j] = 0;
	                matrix[i][0] = 0;
	            }
	        }
	    }
	    for(int i = 1; i < matrix.length; i++) {
	        for(int j = 1; j < matrix[0].length; j++) {
	            if(matrix[i][0] == 0 || matrix[0][j] == 0) {
	                matrix[i][j] = 0;
	            }
	        }
	    }
	    if(row) {
	        for(int j = 0; j < matrix[0].length; j++) {
	            matrix[0][j] = 0;
	        }
	    }
	    if(column) {
	        for(int i = 0; i < matrix.length; i++) {
	            matrix[i][0] = 0;
	        }
	    }
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] test = {{0,1},{1,1}};
		setZeroes(test);
		for (int i = 0; i < test.length; i++) {
			for (int j = 0; j < test[0].length; j++) {
				System.out.print(test[i][j]);
			}
			System.out.println();
		}
	}

}
