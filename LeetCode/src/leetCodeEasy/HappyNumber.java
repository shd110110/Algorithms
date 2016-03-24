package leetCodeEasy;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

//	public static boolean isHappy(int n) {
//		if(n == 1){
//			return true;
//		}else {
//			Set<Integer> temp = new HashSet<>(); 
//			while(n!=1 && temp.add(n) == true){
//				int digui = 0;
//				while(n!=0){
//					digui+= ((n%10)*(n%10));
//					n/=10;
//				}
//				n = digui;
//			}
//			if (n!=1) {
//				return false;
//			}else {
//				return true;
//			}
//		}
//    }
	
	
	// inspired by MV Solution
    public int digitSquareSum(int n) {
        int sum = 0, tmp;
        while (n != 0) {
            tmp = n % 10;
            sum += tmp * tmp;
            n /= 10;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        int slow, fast;
        slow = fast = n;
        do {
            slow = digitSquareSum(slow);
            fast = digitSquareSum(fast);
            fast = digitSquareSum(fast);
        } while(slow != fast);
        if (slow == 1) {
            return true;
        } else {
            return false;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HappyNumber t = new HappyNumber();
		for (int i = 2; i < 100; i++) {
			if (t.isHappy(i)) {
				System.out.println(i);
			}
		} 
	}
}
