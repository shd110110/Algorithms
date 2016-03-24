package leetCodeEasy;

public class PlusOne150602 {
	public static int[] plusOne(int[] digits) {
		int[] result = new int[digits.length+1];
		result[0] = 0;
		for (int i = 0; i < digits.length; i++) {
			result[i+1] = digits[i];
		}
        for (int i = result.length-1; i >= 0; i--){
        	if (result[i] == 9) {
				result[i] = 0;
			}else {
				result[i]++;
				break;
			}
        }
        if (result[0] == 0) {
        	for (int i = 0; i < digits.length; i++) {
        		digits[i] = result[i+1] ;
    		}
        	return digits;
		}
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
