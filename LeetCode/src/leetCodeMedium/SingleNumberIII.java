package leetCodeMedium;

/**
 * @author Poirot
 * 2015年8月18日
 */
public class SingleNumberIII {
	public int[] singleNumber(int[] nums) {
        int result = 0;
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
			result ^= nums[i];
		}
        int temp = result;
        int index = 0;
        while (temp%2 == 0) {
        	temp /= 2;
        	index++;
        }
        int distance = 1 << index;
        int result1 = 0;
        int result2 = 0;
        for (int i = 0; i < nums.length; i++) {
			if ((distance & nums[i]) == 0) {
				result1 ^= nums[i];
			} else {
				result2 ^= nums[i];
			}
		}
        res[0] = result1;
        res[1] = result2;
        return res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = {1,2,3,1,2,3,4,4,6,5,9,5};
		SingleNumberIII t = new SingleNumberIII();
		int[] res = t.singleNumber(test);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
	}

}
