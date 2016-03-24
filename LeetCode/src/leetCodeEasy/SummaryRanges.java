package leetCodeEasy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Poirot
 * 2015年6月26日
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
			return result;
		}
        int begin = 0; 
        while (begin < nums.length){
        	int end = begin; 
            StringBuilder tempString = new StringBuilder();
        	while (end < nums.length-1 && nums[end] == nums[end+1]-1) {  
        		end++;
			} 
        	if (end == begin) {
        		tempString.append(nums[begin]);
			}else {
				tempString.append(nums[begin]+"->"+nums[end]);
			}
        	result.add(tempString.toString());
        	begin = end+1;
        }
        return result;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0,1,2,4,5,7};
		SummaryRanges t = new SummaryRanges();
		List<String> result = t.summaryRanges(nums);
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}

}
