package leetCodeMedium;
//150610 
public class GasStation {
	public int[] maxSubArray(int[] nums) {
		int[] result = new int[3];
		if (nums.length == 0) {
			result[0] = Integer.MIN_VALUE;
			return result;
		}
		if (nums.length == 1) {
		    result[0] = nums[0];
			return result;
		}
		return maxSubArrayInSection(nums, 0, nums.length - 1);
	}

	public int[] maxSubArrayInSection(int[] nums, int begin, int end) {
		int[] result = new int[3];
		if (begin > end) {
			result[0] = Integer.MIN_VALUE;
			return result;
		}
		int medium = (begin + end) / 2;
		// ����medium
		int max1 = 0;
		int temp = 0;
		// ��������
		int right = medium;
		
		for (int i = medium + 1; i <= end; i++) {
			temp += nums[i];
			if (temp > max1) {
				max1 = temp;
				right = i;
			}
		}
		// ��������
		int left = medium;
		int max2 = 0;
		temp = 0;
		
		for (int i = medium - 1; i >= begin; i--) {
			temp += nums[i];
			if (temp > max2) {
				max2 = temp;
				left = i;
			}
		} 
		max1 = max1 + max2 + nums[medium]; 

		// ������
		int[] subLeft = maxSubArrayInSection(nums, begin, medium - 1);
		int[] subRight = maxSubArrayInSection(nums, medium + 1, end);
		if (max1 >= subLeft[0] && max1 >= subRight[0]) {
			result[0] = max1;
			result[1] = left;
			result[2] = right;
			return result;
		} 
		if (subLeft[0] >= max1 && subLeft[0] >= subRight[0]) {
			return subLeft;
		}
		if (subRight[0] >= max1 && subRight[0] >= subLeft[0]) {
			return subRight;
		}
		return result;
	}

	public int canCompleteCircuit(int[] gas, int[] cost) {
		System.out.println(gas.length);
        for (int i = 0; i < gas.length; i++) {
			gas[i] = gas[i] - cost[i]; 
		}
        for (int i = 0; i < gas.length; i++) {
        	System.out.print(gas[i]+ "   ");
		}
        System.out.println();
        int[] maxSubarray = maxSubArray(gas);
        for (int i = 0; i < maxSubarray.length; i++) {
			System.out.print(maxSubarray[i]+ "   ");
		}
        System.out.println();
        int max  = maxSubarray[0];
        int i = maxSubarray[2]+1;
        for (int j = 0; j < gas.length - (maxSubarray[2] - maxSubarray[1] + 1); j++) {
			if (i == gas.length) {
				i = 0;
			}
			max += gas[i];
			if (max < 0) {
				return -1;
			}
			i++;
		}
        if (max < 0) {
			return -1;
		}
//        System.out.println();
        return maxSubarray[1];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] gas = {67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66};
		int[] cost = {27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26};
		GasStation t = new GasStation();
		System.out.println(t.canCompleteCircuit(gas, cost));
	}

}
