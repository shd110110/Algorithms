/**
 * 2015年11月27日
 * Poirot
 */
package leetCodeMedium;

/**
 * @author Poirot
 *
 */
public class ContainerWithMostWater {
    public int maxArea2(int[] height) {
        int left = 0, right = 0; 
    	int Maxarea = 0; 
    	right = height.length-1; 
    	while(left < right) { 
    		Maxarea = Math.max(Maxarea,(right-left)*Math.min(height[left],height[right])); 
    		if(height[left]<height[right]) 
    			left++; 
    		else 
    			right--; 
    	} 
    	return Maxarea;
    }
    /**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
