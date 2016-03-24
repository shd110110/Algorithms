package leetCodeMedium;

import java.util.ArrayList; 
import java.util.List;

//150617
public class Triangle { 
	public int minimumTotal(List<List<Integer>> triangle) { 
		if (triangle.size() == 0) {
			return 0;
		}
		List<List<Integer>> tempTriangle = new ArrayList<List<Integer>>(); 
		
        for (int i = 0; i < triangle.size(); i++) {
        	List<Integer> temp = new ArrayList<Integer>(); 
			for (int j = 0; j < triangle.get(i).size(); j++) {
				if (i == 0) {
					temp.add(triangle.get(i).get(j)); 
				}else if (i-1>=0 && j==0) {
					temp.add(tempTriangle.get(i-1).get(j)+triangle.get(i).get(j));
				}else if (i-1>=0 && j==triangle.get(i).size()-1) {
					temp.add(tempTriangle.get(i-1).get(j-1)+triangle.get(i).get(j));
				}else {
					temp.add(Math.min(tempTriangle.get(i-1).get(j-1), tempTriangle.get(i-1).get(j))+triangle.get(i).get(j));
				}
			}
			tempTriangle.add(temp);
		}
        
//        for (int i = 0; i < tempTriangle.size(); i++) {
//			for (int j = 0; j < tempTriangle.get(i).size(); j++) {
//				System.out.print(tempTriangle.get(i).get(j)+"  ");
//			}
//			System.out.println();
//		}
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < tempTriangle.get(tempTriangle.size()-1).size(); i++) {
			if (tempTriangle.get(tempTriangle.size()-1).get(i) < result) {
				result = tempTriangle.get(tempTriangle.size()-1).get(i);
			}
		}
        return result;
    }
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Triangle t = new Triangle();
		List<List<Integer>> test = new ArrayList<List<Integer>>();
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(2);
		ArrayList<Integer> b = new ArrayList<Integer>();
		b.add(3);
		b.add(4);
		ArrayList<Integer> c = new ArrayList<Integer>();
		c.add(6);
		c.add(5);
		c.add(7);
		ArrayList<Integer> d = new ArrayList<Integer>();
		d.add(4);d.add(1);d.add(8);d.add(3);
		
		test.add(a);
		test.add(b);
		test.add(c);
		test.add(d);
		System.out.println(t.minimumTotal(test));
	}
}
