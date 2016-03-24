/**
 * 2015Äê7ÔÂ6ÈÕ
 * CH
 */
package leetCodeHard;

/**
 * @author CH
 *
 */
public class LargestRectangleinHistogram {
    public int largestRectangleArea(int[] height) {
        if (height.length == 0) {
			return 0;
		}else if (height.length == 1) {
			return height[0];
		} 
    	if (isSorted(height, 0, height.length-1)) {
			return maxOfSorted(height, 0, height.length-1);
		}
        return largestRectangleAreaForCall(height, 0, height.length -1);
    }
    public int largestRectangleAreaForCall(int[] height, int begin, int end){
    	if (begin > end) {
			return 0;
		}
    	if (begin == end) {
			return height[begin];
		}
    	if (isSorted(height, begin, end)) {
			return maxOfSorted(height, begin, end);
		}
    	int minHeight = height[begin];
    	int minIndex = begin;
    	for (int i = begin; i <= end; i++) {
			if (height[i] < minHeight) {
				minHeight = height[i];
				minIndex = i;
			}
		}
    	int mintotalHeight = minHeight * (end-begin+1);
    	int subMax = Math.max(largestRectangleAreaForCall(height, begin, minIndex-1), largestRectangleAreaForCall(height, minIndex+1, end));
    	return Math.max(mintotalHeight, subMax);
    }
    public int maxOfSorted(int[] height, int begin, int end){
    	int tempMax = height[begin] * (end-begin+1);
    	for (int i = begin+1; i <= end; i++) {
			if (height[i] * (end -i+1) > tempMax) {
				tempMax = height[i] *(end -i+1);
			}
		}
    	return tempMax;
    }
    public boolean isSorted(int[] height, int begin, int end){
    	if (begin == end) {
			return true;
		}
    	for (int i = begin; i <end; i++) {
			if (height[i] > height[i+1]) {
				return false;
			}
		}
    	return true;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LargestRectangleinHistogram t = new LargestRectangleinHistogram();
		int[] height = new int[20000];
		for (int i = 0; i < height.length; i++) {
			height[i] = i+1;
		}
		height[19999] = 0;
		System.out.println(t.largestRectangleArea(height));
	}

}
