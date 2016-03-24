package leetCodeMedium;

/**
 * @author Poirot
 * 2015年6月11日
 */
public class SearchA2DMatrix {
	public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length-1;
        int column = matrix[0].length-1;
        int begin = 0;
        int end = row;
        int medium = (begin + end)/2;
        while (begin < end){
        	if (matrix[medium][column] < target) {
				begin = medium+1;
			}else {
				end = medium;
			}
        	medium = (begin + end)/2;
        }
        int theRow = (begin + end)/2;
        begin = 0;
        end = column;
        medium = (begin + end)/2;
        
        while (begin < end){
        	if (matrix[theRow][medium] == target) {
				return true;
			}
        	if (matrix[theRow][medium] < target) {
				begin = medium+1;
			}else {
				end = medium;
			}
        	medium = (begin + end)/2;
        }
        if (matrix[theRow][end] == target) {
			return true;
		}else {
			return false;
		}
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] test= {{1,   3,  5,  7},{10, 11, 16, 20},{23, 30, 34, 50}};
		System.out.println(searchMatrix(test, 2));
		
	}

}
