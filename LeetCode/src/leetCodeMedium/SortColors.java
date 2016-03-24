package leetCodeMedium;

public class SortColors {
    public void sortColors(int[] nums) { 
        int ones = 0;
        int twos = 0; 
        int onesBegin = 0;
        int twosBegin = 0;
        for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) { 
				if (twos > 0) {
					nums[twosBegin + twos] = 2;
					nums[twosBegin] =0;
				}
				if (ones > 0) {
					nums[onesBegin + ones] = 1; 
					nums[onesBegin] = 0;
				} 
				onesBegin++;
				twosBegin++;
			}else if (nums[i] == 1) {
				ones++;
				if (twos > 0) {
					nums[twosBegin + twos] = 2; 
					nums[twosBegin] =1;
				}
				twosBegin++;
			}else if (nums[i] == 2) {
				twos++; 
			} 
		}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortColors t = new SortColors();
		int[] test = {1,2,0,0,2,0,1};
		t.sortColors(test);
		for (int i = 0; i < test.length; i++) {
			System.out.println(test[i]);
		}
	}

}
