package leetCodeMedium;
//150604
public class MaximalSquare {
	
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0){
            return 0;
        }
        int result = 0;

        int[][] intMatrix = new int[matrix.length][matrix[0].length];
        for (int i=0;i<matrix.length;i++){
        	intMatrix[i][0] = matrix[i][0] - '0';
        	if (intMatrix[i][0] == 1) {
				result = 1;
			}
        }
        for (int j=0;j<matrix[0].length;j++){
            intMatrix[0][j] = matrix[0][j] - '0';
            if (intMatrix[0][j] == 1) {
				result = 1;
			}
        }
        for (int i = 1; i<intMatrix.length;i++){
            for (int j=1; j<intMatrix[0].length;j++){
                if (matrix[i][j] != '0'){
                    int val1 = intMatrix[i][j-1];
                    int val2 = intMatrix[i-1][j];
                    int val3 = intMatrix[i-1][j-1];
                    int min1 = Math.min(val1, val2);
                    int min = Math.min(min1, val3);
                    if (min!=0){
                        int index = (int)Math.sqrt(min);
                        intMatrix[i][j] = (index+1)*(index+1);
                        if (intMatrix[i][j]>result){
                            result = intMatrix[i][j];
                        }
                    }else {
						intMatrix[i][j] = matrix[i][j] - '0';
					}
                }
            }
        }
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
