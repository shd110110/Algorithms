package leetCodeEasy;

public class ClimbingStairs {
	public int climbStairs(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		int a = 1;
		int b = 2;
		for (int i = 3; i <= n; i++) {
			a = a+b;
			a = a+b;
			b = a-b;
			a = a-b;
		}
		return b;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
