package leetCodeEasy;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {

	public static List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        int n = rowIndex;
        int m = 0;
        long temp = 1;
        result.add((int)temp);
        while (m<n){
        	temp = temp*(n-m)/(m+1);
        	result.add((int)temp);
        	m++;
        }
        
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getRow(3));
	}

}
