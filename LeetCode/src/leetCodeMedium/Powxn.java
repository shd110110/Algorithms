package leetCodeMedium;
//150605
public class Powxn {
	public static double myPow(double x, int n) {
        double result = 1;
        boolean mark = true;
        boolean sign = true;
        if (x == 0) {
			return 0;
		}
        if (n == 0) {
			return 1;
		}else {
			if(n < 0){
				n = (-1) * n;
				mark = false;
			}
			if (x < 0) {
				sign = false;
				x = (-1)*x;
			}
			result = x;
			for (int i = 1; i < n; i++) {
				result *= x;
				if (result >= Double.MAX_VALUE) {
					if (!mark) {
						if (!sign && n%2==1) {
							return (-1)*Double.MIN_VALUE;		
						}else {
							return Double.MIN_VALUE;
						}	
					}
					if (!sign && n%2==1) {
						return (-1)*Double.MAX_VALUE;		
					}else {
						return Double.MAX_VALUE;
					} 
				}
				if (result <= Double.MIN_VALUE) {
					if (!mark) {
						if (!sign && n%2==1) {
							return (-1)*Double.MAX_VALUE;		
						}else {
							return Double.MAX_VALUE;
						}	
					}
					if (!sign && n%2==1) {
						return (-1)*Double.MAX_VALUE;		
					}else {
						return Double.MIN_VALUE;
					} 
				}
				if (result == x) {
					if (!mark) {
						if (!sign && n%2 == 1) {
							return (-1)/result;
						}
						return 1/result;
					}
					 
					if (!sign && n%2 == 1) {
						return (-1)*result;
					}
					return result;
				}
			} 
		}
        if (!mark) {
			if (!sign && n%2 == 1) {
				return (-1)/result;
			}
			return 1/result;
		}
		 
		if (!sign && n%2 == 1) {
			return (-1)*result;
		}
		return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(myPow(-5, 3));
		System.out.println(Math.pow(-2, 3));
	}

}
