package leetCodeMedium;
//150603
public class HouseRobberII {
	public static int rob(int[] num) {
		if (num.length == 1) {
			return num[0];
		}
		else if (num.length == 2) {
			return Math.max(num[0], num[1]);
		}
        return Math.max(robCall(num, 0, num.length-2),robCall(num, 1, num.length-1));
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

	}

}
