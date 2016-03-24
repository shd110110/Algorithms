package leetCodeHard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue; 
//150614
public class TheSkylineProblem {
//	class KeyPoint {
//        public int key;
//        public int height;
//        public KeyPoint next = null; 
//        public KeyPoint(int key, int height) {
//            this.key = key;
//            this.height = height;
//        } 
//    } 
//    public static int[] getKeyPoint(int key, int height) {
//        int[] kp = new int[2];
//        kp[0] = key;
//        kp[1] = height;
//        return kp;
//    } 
//    public List<int[]> getSkyline(int[][] buildings) {
//        KeyPoint head = new KeyPoint(-1,0);
//        KeyPoint prevKP = head;
//        for (int[] building:buildings) {
//            int l = building[0], r = building[1], h= building[2];
//            // insert left point
//            while (prevKP.next != null && prevKP.next.key <= l) 
//            	prevKP = prevKP.next;
//            int preHeight = prevKP.height; 
//            if (prevKP.key == l) { 
//            	prevKP.height = Math.max(prevKP.height, h);
//            } else if (prevKP.height < h) {
//            	//insert a node 
//                KeyPoint next = prevKP.next;
//                prevKP.next = new KeyPoint(l, h); 
//                prevKP = prevKP.next; 
////                System.out.println("hello world  "+prevKP.key + "  "+ prevKP.height);
//                prevKP.next = next;
//            }
//            // insert right point and update points in between
//            KeyPoint prev = prevKP, cur = prevKP.next;
//            while (cur != null && cur.key < r) {
//            	System.out.println("hello world  "+l); 
//                preHeight = cur.height;
//                cur.height = Math.max(cur.height, h);
//                if (cur.height == prev.height)
//                    prev.next = cur.next;
//                else
//                    prev = cur;
//                cur = cur.next;
//            }
//            if (prev.height != preHeight && prev.key != r && (cur == null || cur.key != r)) { 
////            	System.out.println("hello world  "+prevKP.key + "  "+ prevKP.height);
//                KeyPoint next = prev.next;
//                prev.next = new KeyPoint(r, preHeight); 
//                prev.next.next = next;
//            }
//        }
//        // convert to List<int[]>
//        List<int[]> list = new ArrayList<int[]>();
//        KeyPoint prev = head, cur = head.next;
//        while (cur != null) {
//            if (cur.height != prev.height)
//                list.add(getKeyPoint(cur.key, cur.height));
//            prev = cur;
//            cur = cur.next;
//        }
//        return list;
//    }
	
    //divide and conquer
//    public List<int[]> getSkyline(int[][] buildings) {
//        if (buildings.length == 0)
//            return new LinkedList<int[]>();
//        return recurSkyline(buildings, 0, buildings.length - 1);
//    }
//
//    private LinkedList<int[]> recurSkyline(int[][] buildings, int p, int q) {
//        if (p < q) {
//            int mid = p + (q - p) / 2;
//            return merge(recurSkyline(buildings, p, mid),
//                    recurSkyline(buildings, mid + 1, q));
//        } else {
//            LinkedList<int[]> rs = new LinkedList<int[]>();
//            rs.add(new int[] { buildings[p][0], buildings[p][2] });
//            rs.add(new int[] { buildings[p][1], 0 });
//            return rs;
//        }
//    }
//
//    private LinkedList<int[]> merge(LinkedList<int[]> l1, LinkedList<int[]> l2) {
//        LinkedList<int[]> rs = new LinkedList<int[]>();
//        int h1 = 0, h2 = 0;
//        while (l1.size() > 0 && l2.size() > 0) {
//            int x = 0, h = 0;
//            if (l1.getFirst()[0] < l2.getFirst()[0]) {
//                x = l1.getFirst()[0];
//                h1 = l1.getFirst()[1];
//                h = Math.max(h1, h2);
//                l1.removeFirst();
//            } else if (l1.getFirst()[0] > l2.getFirst()[0]) {
//                x = l2.getFirst()[0];
//                h2 = l2.getFirst()[1];
//                h = Math.max(h1, h2);
//                l2.removeFirst();
//            } else {
//                x = l1.getFirst()[0];
//                h1 = l1.getFirst()[1];
//                h2 = l2.getFirst()[1];
//                h = Math.max(h1, h2);
//                l1.removeFirst();
//                l2.removeFirst();
//            }
//            if (rs.size() == 0 || h != rs.getLast()[1]) {
//                rs.add(new int[] { x, h });
//            }
//        }
//        rs.addAll(l1);
//        rs.addAll(l2);
//        return rs;
//    }
    
	// MV Solution
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for(int[] b:buildings) {
            height.add(new int[]{b[0], -b[2]});
            height.add(new int[]{b[1], b[2]});
        }
        Collections.sort(height, (a, b) -> {
                if(a[0] != b[0]) 
                    return a[0] - b[0];
                return a[1] - b[1];
        });
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a)); // 最堆
        pq.offer(0);
        int prev = 0;
        for(int[] h:height) {
        	 
            if(h[1] < 0) {
                pq.offer(-h[1]); 
            } else {
                pq.remove(h[1]);
            }
            int cur = pq.peek();
            System.out.println(cur);
            if(prev != cur) {
                result.add(new int[]{h[0], cur});
                prev = cur;
            }
        }
        return result;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TheSkylineProblem t = new TheSkylineProblem();
		int[][] buildings = {{ 2 ,9, 10}, {3, 7, 15}};//,{ 5, 12, 12}, {15, 20, 10}, {19, 24 ,8}};
		List<int[]> result = t.getSkyline(buildings);
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i)[0] + "  " + result.get(i)[1]);
		}
	}

}
