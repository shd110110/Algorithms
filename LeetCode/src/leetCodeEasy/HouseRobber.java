package leetCodeEasy;

public class HouseRobber {

	public static int rob(int[] num) {
        return robCall(num, 0, num.length-1);
    }
	public static int robCall(int[] num,int begin,int end){
		if (end < begin)
			return 0;
		if (end == begin) {
			return num[begin];
		}
		int medium = (begin+end)/2;
		return Math.max(num[medium]+robCall(num, begin, medium-2)+robCall(num, medium+2, end),
				robCall(num, begin, medium-1)+robCall(num, medium+1, end));
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = {2,1,1,2,3};
		System.out.println(rob(test));
	}

}
