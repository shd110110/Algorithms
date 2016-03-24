package leetCodeMedium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Poirot 2015年6月29日
 */
public class MajorityElementII {
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> result=new ArrayList<Integer>();
	    if(nums.length==0) 
	        return result;
	    int a=nums[0], b=0, ac=0, bc=0;
	    for(int i=0; i<nums.length; i++){
	        if(nums[i]!=a){
	            b=nums[i];
	            break;
	        }
	    }
	    for(int i=0; i<nums.length; i++){
	        if(nums[i]==a){
	            ac++;
	        }else if(nums[i]==b){
	            bc++;
	        }else{ 
	            ac--;
	            bc--;
//	            System.out.println(ac+ "  "+ bc);
	        }
	        if(ac<0){
	            a=nums[i];
	            ac=1;
	        }else if(bc<0){
	            b=nums[i];
	            bc=1;
	        }
	        if (i == 8) {
	        	System.out.println(a+ "  "+ b);
			}
	    }
//	    System.out.println(ac+ "  "+ bc);
	    ac=bc=0;
	    for(int i=0; i<nums.length; i++){
	        if(nums[i]==a)
	            ac++;
	        if(nums[i]==b)
	            bc++;
	    }
	    if(ac>nums.length/3)
	        result.add(a);
	    if(bc>nums.length/3&&b!=a)
	        result.add(b);
	    return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MajorityElementII t = new MajorityElementII();
		int[] nums = {1,1,1,4,4,4,2,2,2,};
		List<Integer> r = t.majorityElement(nums);
		for (int i = 0; i < r.size(); i++) {
			System.out.println(r.get(i));
		}
	}

}
