package leetCodeMedium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Poirot
 * 2015年6月15日
 */
public class TheSkylineProblem {
	public List<int[]> getSkyline(int[][] buildings) {
		List<int[]> res = new ArrayList<int[]>();
        if(buildings.length == 0) {
            return res;
        }

        //(endPoint, height)
        HashMap<Integer, Integer> endPoint = new HashMap<Integer, Integer>();

        // store endPoint, sort by height
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer n1, Integer n2) {
                return Integer.compare(endPoint.get(n2), endPoint.get(n1));
            }   
        });
        int currHeight = 0;
        int currEnd = Integer.MAX_VALUE;
        for(int i = 0; i <= buildings.length; i++) {
            int start = i == buildings.length ? Integer.MAX_VALUE : buildings[i][0];
            int end = i == buildings.length ? Integer.MAX_VALUE : buildings[i][1];
            int height = i == buildings.length ? 0 : buildings[i][2];

            // pre end
            while(currEnd < start) {
                while(!pq.isEmpty() && pq.peek() <= currEnd) {
                    pq.poll();
                }
                currHeight = pq.isEmpty() ? 0 : endPoint.get(pq.peek());
                res.add(new int[]{currEnd, currHeight});
                currEnd = pq.isEmpty() ? Integer.MAX_VALUE : pq.peek();
            }

            // this 
            if(height > currHeight) {
                currHeight = height;
                currEnd = end;
                res.add(new int[]{start, height});
            } else if(height == currHeight) {
                currEnd = end;
            }

            // update map and pq 
            if(endPoint.containsKey(end) && endPoint.get(end) < height) {
                endPoint.put(end, height);
            } else if(!endPoint.containsKey(end)) {
                endPoint.put(end, height);
                pq.offer(end);
            }
        }
        if(currHeight != 0) {
            res.add(new int[]{currEnd, 0});
        }
        return res;
    }
	public static void main(String[] args){
		
	}
}
