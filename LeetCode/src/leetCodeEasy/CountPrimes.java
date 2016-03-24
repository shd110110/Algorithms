package leetCodeEasy;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar; 
import java.util.List; 
//150521
public class CountPrimes {
	/** 
     * �ж� n �Ƿ��ܱ���� 
     * 
     * @param n      Ҫ�жϵ����� 
     * @param primes ��������б� 
     * 
     * @return ��� n �ܱ� primes ���κ�һ������򷵻� true�� 
     */  
    private static boolean divisible(int n, List<Integer> primes) {  
        for (Integer prime : primes) {  
            if (n % prime == 0) {  
                return true;  
            }  
        }  
        return false;  
    }
    public static int countPrimes1(int n) {
        List<Integer> result = new ArrayList<Integer>();  
        result.add(2);  
   
        for (int i = 3; i <= n; i += 2) {  
            if (!divisible(i, result)) {  
                result.add(i);  
            }  
        }  
        return result.size();
    }  
     
    public static int countPrimes(int n){
    	if (n<=2) {
			return 0;
		}
    	BitSet bs = new BitSet(n+1);
    	
    	int i =0;
    	int j = 2*2;
    	while (j<=n){
    		bs.set(j);
    		j+=2;
    	}
    	int result = 1;
    	for (i = 3; i < n; i+=2) {
			if (!bs.get(i)) {
				result ++;//i������
				j = 2*i;
				while(j<=n){
					bs.set(j);
					j+=i;
				}
			}
		}
    	
    	return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(String.format("%03d", Calendar.getInstance().get(Calendar.MILLISECOND)));
		System.out.println(countPrimes(10000000));
		System.out.println(String.format("%03d", Calendar.getInstance().get(Calendar.MILLISECOND)));
		
	}

}
