package leetCodeHard;

//import java.util.ArrayList;
//import java.util.HashSet; 


//150606
public class MaxPointsonaLine {
	//��һ�ַ���
//	public int maxPoints(Point[] points) {
//		if (points.length < 2) {
//			return points.length;
//		}
//		ArrayList<HashSet<Integer>> temp = new ArrayList<HashSet<Integer>>();
//		for (int i = 0; i < points.length; i++) {
//			temp.add(new HashSet<Integer>());
//		}
//		int max = 2;
//		for (int i = 0; i < points.length-1; i++) {
//			for (int j = i+1; j < points.length; j++) {
//				//�� i�͵�j
//				if (temp.get(i).contains(j)) {
//					continue;
//				}
//				 
//				int tempMax = 2;
//				Point a = points[i];
//				Point b = points[j];
//				if (a.x == b.x && a.y == b.y) {
//					for (int k = 0; k < points.length; k++) {
//						if (k == i || k == j) {
//							continue;
//						}else {
//							tempMax = 3;
//							break;
//						}
//					} 
//				}else {
//					for (int k = 0; k < points.length; k++) {
//						if (k == i || k == j) {
//							continue;
//						}
//						if (temp.get(i).contains(k) || temp.get(j).contains(j)) {
//							continue;
//						}
//						if (isInOneLine(a, b, points[k]) ) {
//							//System.out.println("hello  "+ k + "   "+i + "   "+j);
//							//System.out.println
//							temp.get(i).add(k);
//							temp.get(j).add(k);
//							tempMax++;
//						}
//					}
//				}
//				
//				if (tempMax > max) {
//					max = tempMax;
//				}
//			}
//		}
//		return max;
//	}
//	public boolean isInOneLine(Point a, Point b, Point c){
//		if (c.x == a.x && c.y == a.y) {
//			return true;
//		}
//		if(c.x == b.x && c.y == b.y){
//			return true;
//		}
//		if (a.x == b.x && b.x == c.x) {
//			return true;
//		}
//		if (a.x != b.x && b.x != c.x) { 
//			return (c.y - b.y)*(b.x - a.x) == (b.y - a.y)*(c.x - b.x);
//		}
//		return false;
//	}
	
	//�ڶ��ַ���
	public int maxPoints(Point[] points) {
		if (points.length < 2) {
			return points.length;
		}
		 
		int max = 2;
		for (int i = 0; i < points.length-1; i++) {
			for (int j = i+1; j < points.length; j++) {
				//�� i�͵�j 
				int tempMax = 2;
				Point a = points[i];
				Point b = points[j];
				if (a.x == b.x && a.y == b.y) {
					for (int k = 0; k < points.length; k++) {
						if (k == i || k == j) {
							continue;
						}else {
							tempMax = 3;
							break;
						}
					} 
				}else {
					for (int k = 0; k < points.length; k++) {
						if (k == i || k == j) {
							continue;
						} 
						if (isInOneLine(a, b, points[k]) ) {  
							tempMax++;
						}
					}
				}
				
				if (tempMax > max) {
					max = tempMax;
				}
			}
		}
		return max;
	}
	public boolean isInOneLine(Point a, Point b, Point c){
		if (c.x == a.x && c.y == a.y) {
			return true;
		}
		if(c.x == b.x && c.y == b.y){
			return true;
		}
		if (a.x == b.x && b.x == c.x) {
			return true;
		}
		if (a.x != b.x && b.x != c.x) { 
			return (c.y - b.y)*(b.x - a.x) == (b.y - a.y)*(c.x - b.x);
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point a = new Point(-42,-230);
		Point b = new Point(0,0);
		Point c = new Point(1,0);
		Point d = new Point(0,-70);
		Point e = new Point(0,-70);
		Point f = new Point(42,90);
		Point g = new Point(21,10);
		Point h = new Point(1,-1);
		Point i = new Point(84,250);
		Point[] test = {a,b,c,d,e,f,g,h,i};
		MaxPointsonaLine t = new MaxPointsonaLine();
		System.out.println(t.maxPoints(test));
	}

}
