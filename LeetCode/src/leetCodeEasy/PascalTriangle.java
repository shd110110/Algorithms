package leetCodeEasy;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
	public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resultList = new ArrayList<>();
        
        for (int i = 0; i < numRows; i++) {
        	List<Integer> tempList = new ArrayList<>();
        	tempList.add(1);
        	int n = i;
        	int j = 0;
        	int temp = 1;
        	while (j<n){
        		temp=temp*(n-j)/(j+1);
        		tempList.add(temp);
        		j++;
        	}
        	resultList.add(tempList);
		}
        return resultList;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
