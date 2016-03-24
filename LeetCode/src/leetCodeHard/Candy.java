/**
 * 2015��6��24��
 * CH
 */
package leetCodeHard;
 
import java.util.LinkedList;

/**
 * @author CH
 *
 */
public class Candy {
	
	public int candy(int[] ratings) { 
        if (ratings.length == 0) {
			return 0;
		}
        if (ratings.length == 1) {
			return 1;
		}
        int total = 0;
        LinkedList<Integer> indexesOfBottom = new  LinkedList<Integer>();
        if (ratings[0] <= ratings[1]) {
			indexesOfBottom.add(0);
		}
        for (int i = 1; i < ratings.length-1; i++) {
			if (ratings[i] <= ratings[i-1] && ratings[i] <= ratings[i+1]){
				indexesOfBottom.add(i);
			}
		}
        if (ratings[ratings.length-1] <= ratings[ratings.length-2]) {
			indexesOfBottom.add(ratings.length-1);
		}
        int[] tempTotal = new int[ratings.length];
        int begin = indexesOfBottom.pollFirst();
        if (begin>0) {
			for (int i = begin; i >= 0 ; i--) {
				tempTotal[i] = begin-i+1;
			}
		}
        int end = -1;
        while(!indexesOfBottom.isEmpty()) {
        	end = indexesOfBottom.peekFirst();
        	
        	tempTotal[begin] = 1;
        	tempTotal[end] = 1;
        	if (begin == end -1) {
        		begin = indexesOfBottom.pollFirst();
        		continue;
			}
        	int max =  ratings[begin];
        	int maxIndex = begin;
        	for (int i = begin+1; i < end; i++) {
				if (ratings[i] > max) {
					max = ratings[i];
					maxIndex = i; 
				}else if (ratings[i] == max) {
					maxIndex = (end-i) * (i-begin) > (end-maxIndex)*(maxIndex-begin) ? i:maxIndex;
				}
			}
        	for (int i = begin+1; i < end; i++) {
        		if (i>maxIndex) {
        			tempTotal[i] = end-i+1;
				}else if (i < maxIndex) {
					tempTotal[i] = i-begin+1;
				}else {
					if(ratings[i] == ratings[i+1]){
						tempTotal[i] = Math.max(maxIndex-begin+1, tempTotal[i+1]);
					}
					else 
						tempTotal[i] = Math.max(end-maxIndex+1, maxIndex-begin+1);
				}
				
			} 
//        	System.out.println(begin +"  "+ end);
//        	System.out.println(maxIndex +"  "+ tempTotal[maxIndex]);
        	begin = indexesOfBottom.pollFirst();
		}   
//        System.out.println(begin);
        if (begin< ratings.length-1) {
        	int a = 1;
			for (int i = begin; i < tempTotal.length; i++) {
				tempTotal[i] = a;
				a++;
			}
		}
 
        for (int i = 0; i < tempTotal.length; i++) {
//        	System.out.print(tempTotal[i] + " ");
			total += tempTotal[i];
		}
//        System.out.println();
        
//        indexesOfBottom = new  LinkedList<Integer>();
//        if (ratings[0] <= ratings[1]) {
//			indexesOfBottom.add(0);
//		}
//        for (int i = 1; i < ratings.length-1; i++) {
//			if (ratings[i] <= ratings[i-1] && ratings[i] <= ratings[i+1]){
//				indexesOfBottom.add(i);
//			}
//		}
//        if (ratings[ratings.length-1] <= ratings[ratings.length-2]) {
//			indexesOfBottom.add(ratings.length-1);
//		}
//        while(!indexesOfBottom.isEmpty()){
//        	System.out.println(tempTotal[indexesOfBottom.pollFirst()]);
//        }
        
        return total;
    } 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Candy t = new Candy();
		int[] ratings = {1,2};
//		int[] ratings = {58,21,72,77,48,9,38,71,68,77,82,47,25,94,89,54,26,54,54,99,64,71,76,63,81,82,60,64,29,51,87,87,72,12,16,20,21,54,43,41,83,77,41,61,72,82,15,50,36,69,49,53,92,77,16,73,12,28,37,41,79,25,80,3,37,48,23,10,55,19,51,38,96,92,99,68,75,14,18,63,35,19,68,28,49,36,53,61,64,91,2,43,68,34,46,57,82,22,67,89};
		System.out.println(t.candy(ratings));
		
		
		double double1 = 2;
//		System.out.println((long)double1);
//		System.out.println(((long)double1) == 0x0000000000000002L);
//		System.out.println(0x000000000000000fD);
//		
//		long bits =0x0000000000000002L; 
//		System.out.println((int)(bits ^ (bits >>> 32)));
//		Double double2 = double1;
//		System.out.println(double2.hashCode());
//		System.out.println(Double.doubleToLongBits(double2))                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               .MAX_VALUE);
	} 
}
