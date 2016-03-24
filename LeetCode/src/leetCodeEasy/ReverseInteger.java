/**
 * 2015��11��26��
 * Poirot
 */
package leetCodeEasy;
 

/**
 * @author Poirot
 *
 */
public class ReverseInteger {
	//most votes
//	public int reverse(int x)
//	{
//	    int result = 0;
//
//	    while (x != 0)
//	    {
//	        int tail = x % 10;
//	        int newResult = result * 10 + tail;
//	        if ((newResult - tail) / 10 != result)
//	        { return 0; }
//	        result = newResult;
//	        x = x / 10;
//	    }
//
//	    return result;
//	}
	
	// by CH
//    public int reverse(int x) {
//        boolean sign = (x>0);
//        if(!sign)
//        	x*=(-1);
//        int result = 0;
//        if(x>1000000000 && x%10>2 )
//            return 0;
//        if(x>1000000000 && ((x%10 ==2 && x/10%10>1) || (x%100==12 && x/100%10>4 )||(x%1000==412 && x/1000%10>7) || (x%10000 == 7412 && x/10000%10>4) || (x%100000 ==47412&& x/100000%10>8) || (x%1000000 ==847412&&x/1000000%10>3) || (x%10000000 ==3847412&&x/10000000%10>6) || (x%100000000 ==63847412&&x/100000000%10>4)))
//        	return 0;
//        while(x>0)
//        {
//            result =result*10+x%10;
//            x/=10;
//        }
//        if(sign)
//        	return result;
//        else {
//			return result*(-1);
//		}
//    }
	
	//by CH
	public int reverse(int x) {
		boolean sign = (x > 0);
		long xCopy = x;
		if (!sign)
			xCopy *= (-1);
		 
		long result = 0;
        while(xCopy > 0)
        {
            result =result*10+xCopy%10;
            xCopy/=10;
        }
		xCopy = result;
		
		if (!sign) {
			xCopy = xCopy * (-1);
		} else {
			
		}
		if (xCopy > Integer.MAX_VALUE || xCopy < Integer.MIN_VALUE) {
			return 0;
		}
		return (int) xCopy;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseInteger t = new ReverseInteger();
		System.out.println(t.reverse(Integer.MAX_VALUE));
	}

}
