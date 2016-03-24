package leetCodeMedium;

public class BitwiseANDofNumbersRange {
	public static int rangeBitwiseAnd(int m, int n) {
		int[] bitsM = new int[31];
		int[] bitsN = new int[31];
		for (int i = 0; i < bitsN.length; i++) {
			bitsM[i] = m%2;
			m /= 2;
			bitsN[i] = n%2;
			n /= 2;
		}
//		for (int i = 0; i < bitsM.length; i++) {
//			System.out.print(bitsM[i]+" ");
//		}
		int i = 30;
		while(i >= 0){
			if (bitsN[i] == 1 && bitsM[i] == 0) {
				break;
			}
			i--;
		}
		while(i >= 0){
			bitsN[i] = 0;
			i--;
		}
		
		int result = 0;
		for (int j = bitsN.length-1; j >= 0; j--) {
			result = result*2 + bitsN[j];
		}
		return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(rangeBitwiseAnd(1, Integer.MAX_VALUE));
	}

}
