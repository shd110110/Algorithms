package leetCodeMedium;

/**
 * @author Poirot
 * 2015年6月21日
 */
public class TrappingRainWater {
	public int trap(int[] height) {
		if (height.length < 2) {
			return 0;
		}
		int maxHeightIndex = 0;
		for (int i = 0; i < height.length; i++) {
			if (height[i] > height[maxHeightIndex]) {
				maxHeightIndex = i;
			}
		}
		
		int result = 0;
		int begin = 0;
		int end = 0;
		while (begin <= maxHeightIndex-2) {
			while (begin < maxHeightIndex-2 && height[begin]==0)
			{
				begin++;
			}
			end = begin+1;
			
			while(end < maxHeightIndex && height[end] < height[begin]){
				end++;
			}
			//System.out.println("begin  :"+begin+"  end:  "+end );
			result += height[begin]*(end-begin-1);
			for (int i = begin+1; i <= end-1; i++) {
				result -= (height[i] > height[begin]? height[begin]:height[i]);
			}
			begin = end;
		}
		begin = height.length-1;
		while (begin >= maxHeightIndex+2) {
			while (begin > maxHeightIndex+2 && height[begin]==0)
			{
				begin--;
			}
			end = begin-1;
			while(end > maxHeightIndex && height[end] < height[begin]){
				end--;
			}
			//System.out.println("end:  "+end+"  begin  :"+begin );
			result += height[begin]*(begin-end-1);
			for (int i = begin-1; i >= end+1; i--) {
				result -= (height[i] > height[begin]? height[begin]:height[i]);
			}
			begin = end;
		}
		return result;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrappingRainWater t = new TrappingRainWater();
		int[] test= {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(t.trap(test));
	}

}
