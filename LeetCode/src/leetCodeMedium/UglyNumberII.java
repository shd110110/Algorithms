package leetCodeMedium;

/**
 * @author Poirot
 * 2015年8月19日
 */
public class UglyNumberII {
    public int nthUglyNumber(int n) {
    	int[] data = new int[n + 1];   
        data[0] = 1;  
        int pMul_5 = 0;  
        int pMul_2 = 0;  
        int pMul_3 = 0;  
        int index = 0;  
        while (index < n) {  
            index++;  
            int d = Math.min(Math.min(data[pMul_2] * 2, data[pMul_3] * 3), data[pMul_5] * 5);  
            data[index] = d;  
            if (data[pMul_2] * 2 == d) {  
                pMul_2++;  
            }  
            if (data[pMul_3] * 3 == d) {  
                pMul_3++;  
            }  
            if (data[pMul_5] * 5 == d) {  
                pMul_5++;  
            }  
  
        }   
        return data[n-1];
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
