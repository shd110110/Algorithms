package leetCodeMedium;
//150607
public class UniqueBinarySearchTrees {
	public static int numTrees(int n) {
		int[] nums = new int[n+1];
        nums[0] = 1;
        for(int i = 1; i<= n;i++){
            int sum = 0;
            for(int j=0;j<=i-1; j++){
                sum = sum + nums[j] * nums[i-1-j];
            }
            nums[i] = sum;
        }
        return nums[n];
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numTrees(1));
		System.out.println(numTrees(2));
		System.out.println(numTrees(3));
		System.out.println(numTrees(4));
	}

}
