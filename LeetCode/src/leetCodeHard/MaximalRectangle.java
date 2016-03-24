package leetCodeHard;

import java.util.LinkedList;

//150616
public class MaximalRectangle {
	//other's think
//	public int maximalRectangle(char[][] matrix) {
//
//        int h = matrix.length;
//        if (h == 0) {
//            return 0;
//        }
//        int w = matrix[0].length;
//        if (w == 0) {
//            return 0;
//        }
//
//        int[][] x = getX(matrix, h, w);
//        int[][] y = getY(matrix, h, w);
//
//        int maxArea = 0;
//
//        for (int i = 0; i < h; i++) {
//            for (int j = 0; j < w; j++) {
//
//                int xIdx = x[i][j];
//                int yIdx = y[i][j];
//
//                int k = 0;
//                while (k <= Math.min((xIdx - j), (yIdx - i))
//                        && matrix[i + k][j + k] == '1') {
//
//                    xIdx = Math.min(xIdx, x[i+k][j+k]);
//                    yIdx = Math.min(yIdx, y[i+k][j+k]);
//
//                    if ((xIdx - j + 1) * (yIdx - i + 1) <= maxArea) {
//                        break;
//                    }
//
//                    int wArea = (k + 1) * (xIdx - j + 1);
//                    int hArea = (k + 1) * (yIdx - i + 1);
//                    if (wArea > maxArea) {
//                        maxArea = wArea;
//                    }
//                    if (hArea > maxArea) {
//                        maxArea = hArea;
//                    }
//
//                    k++;
//                }
//
//            }
//        }
//
//        return maxArea;
//    }
//
//    private int[][] getX(char[][] matrix, int h, int w) {
//
//        int[][] res = new int[h][w];
//
//        for (int i = h - 1; i >= 0; i--) {
//            int curr = -1;
//            for (int j = w - 1; j >= 0; j--) {
//                if (matrix[i][j] == '1') {
//                    if (curr == -1) {
//                        curr = j;
//                    }
//
//                } else {
//                    curr = -1;
//                }
//                res[i][j] = curr;
//            }
//        }
//        return res;
//    }
//
//    private int[][] getY(char[][] matrix, int h, int w) {
//
//        int[][] res = new int[h][w];
//
//        for (int j = w - 1; j >= 0; j--) {
//            int curr = -1;
//            for (int i = h - 1; i >= 0; i--) {
//                if (matrix[i][j] == '1') {
//                    if (curr == -1) {
//                        curr = i;
//                    }
//
//                } else {
//                    curr = -1;
//                }
//                res[i][j] = curr;
//            }
//        }
//        return res;
//    }
	 
//	public int maximalRectangle(char[][] matrix) {
//        if (matrix.length == 0) {
//			return 0;
//		}
//        int m = matrix.length;
//        int n = matrix[0].length;
//        
//        int[] left = new int[n];
//        int[] right = new int[n];
//        for (int i = 0; i < right.length; i++) {
//			right[i] = n;
//		}
//        int[] height = new int[n]; 
//        int maxA = 0;
//        for(int i=0; i<m; i++) {
//            int cur_left=0, cur_right=n; 
//            for(int j=0; j<n; j++) { // compute height (can do this from either side)
//                if(matrix[i][j]=='1') 
//                	height[j]++; 
//                else 
//                	height[j]=0;
//            }
//            for(int j=0; j<n; j++) { // compute left (from left to right)
//                if(matrix[i][j]=='1') 
//                	left[j]=Math.max(left[j],cur_left);
//                else{
//                	left[j]=0; 
//                	cur_left=j+1;
//                }
//            }
//            
//            // compute right (from right to left)
//            for(int j=n-1; j>=0; j--) {
//                if(matrix[i][j]=='1') 
//                	right[j]=Math.min(right[j],cur_right);
//                else{
//                	right[j]=n; 
//                	cur_right=j;
//                }    
//            }
//            
//            // compute the area of rectangle (can do this from either side)
//            for(int j=0; j<n; j++)
//                maxA = Math.max(maxA,(right[j]-left[j])*height[j]);
//        }
//        return maxA;  
//    }
	
	
	// seconde time the same problem, wrong idea
//	public int maximalRectangle(char[][] matrix) {
//		if (matrix == null || matrix.length == 0) {
//            return 0;
//        }
//        int[][] row = new int[matrix.length][matrix[0].length];
//		int[][] col = new int[matrix.length][matrix[0].length];
//		row[0][0] = matrix[0][0] == '1' ? 1 : 0;
//		col[0][0] = matrix[0][0] == '1' ? 1 : 0;
//		for (int i = 1; i < matrix.length; i++) {
//			if (matrix[i][0] == '0') {
//				row[i][0] = 0;
//				col[i][0] = 0;
//			} else {
//				row[i][0] = row[i-1][0] + 1;
//				col[i][0] = 1;
//			}
//		}
//
//		for (int j = 1; j < matrix[0].length; j++) {
//			if (matrix[0][j] == '0') {
//				row[0][j] = 0;
//				col[0][j] = 0;
//			} else {
//				row[0][j] = 1;
//				col[0][j] = row[0][j - 1] + 1;
//			}
//		}
//		
//		for (int i = 1; i < matrix.length; i++) {
//			for (int j = 1; j < matrix[0].length; j++) {
//				if (matrix[i][j] == '0') {
//					row[i][j] = 0;
//					col[i][j] = 0;
//				} else {
//					if(row[i][j-1] == 0) {
//						row[i][j] = row[i-1][j] + 1;
//						col[i][j] = 1;
//					} else if (row[i-1][j] == 0) {
//						row[i][j] = 1;
//						col[i][j] = col[i][j-1] + 1;
//					} else {
//						row[i][j] = Math.min(row[i][j-1], row[i-1][j]+1);
//						col[i][j] =  Math.min(col[i][j-1]+1, col[i-1][j]);
//					}
//					
//				} 
//			} 
//		}
//		int max = 0;
//
//		for (int i = 0; i < matrix.length; i++) {
//			for (int j = 0; j < matrix[0].length; j++) {
//				 max = Math.max(max, row[i][j] * col[i][j]);
//			} 
//		}
//		for (int i = 0; i < matrix.length; i++) {
//			for (int j = 0; j < matrix[0].length; j++) {
//				 
//				System.out.print(row[i][j]+":"+col[i][j] + " ");
//			}
//			System.out.println();
//		} 
//		return max;
//    }
	
	
	public int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return 0;
		}
		int[] height = new int[matrix[0].length];
		int result = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				height[j] = matrix[i][j] == '0' ? 0 : height[j] + 1;
			}
			result = Math.max(result, getMax(height));
		}
		return result;
    }

	public int getMax(int[] height) {
		LinkedList<Integer> stack = new LinkedList<>();
		int max = 0;
		for (int i = 0; i < height.length; i++) {
			while (!stack.isEmpty() && height[i] <= height[stack.peek()]) {
				int j = stack.pop();
				int k = stack.isEmpty() ? -1 : stack.peek();
				max = Math.max((i - k - 1) * height[j], max);
			}
			stack.push(i);
		}

		while (!stack.isEmpty()) {
			int j = stack.pop();
			int k = stack.isEmpty() ? -1 : stack.peek();
			max = Math.max((height.length - k - 1) * height[j], max);
		}
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] test = {{'1','1','0'},{'1','1','1'}};
//		char[][] test = {{'0','1'},{'0','1'}};
		MaximalRectangle t  = new MaximalRectangle();
		System.out.println(t.maximalRectangle(test));
	}

}
