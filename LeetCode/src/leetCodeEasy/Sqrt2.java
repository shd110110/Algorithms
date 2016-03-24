package leetCodeEasy;

public class Sqrt2 {
	public static int sqrt(int x) {
		if(x==0)
            return 0;
		long end = x;
		long begin = 1;
		
		
		while (begin<end-1) {
			long medium = (begin+end)/2;
			
			if (medium*medium == x) {
				return (int)medium;
			}
			if (medium*medium < x  ) {
				begin = medium;
			}else {
				end = medium;
			}
		}
		return (int)begin;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Math.sqrt(9));
	}

}
