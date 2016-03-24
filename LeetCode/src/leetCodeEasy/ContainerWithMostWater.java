package leetCodeEasy;


public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
    	
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = new int[14982];
		for (int i = 14981; i >= 0; i--) {
			test[i] = i+19 ;
		}
		
		System.out.println(maxArea(test));
	}

}
