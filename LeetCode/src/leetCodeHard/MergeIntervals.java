package leetCodeHard;
 
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap; 

/**
 * @author Poirot 2015年6月26日
 */
public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
		if (intervals.size() <= 1) {
			return intervals;
		}
		TreeMap<Integer, Interval> map = new TreeMap<>();
		for (int i = 0; i < intervals.size(); i++) {
			if (map.containsKey(intervals.get(i).start)) {
				if(intervals.get(i).end >map.get(intervals.get(i).start).end) 
					map.put(intervals.get(i).start, intervals.get(i));
			}else {
				map.put(intervals.get(i).start, intervals.get(i));
			}
		} 
		LinkedList<Interval> queue = new LinkedList<>();
		Iterator<Integer> itr = map.keySet().iterator();
		while (itr.hasNext()) {
			queue.add(map.get(itr.next()));
		}
		LinkedList<Interval> queue2 = new LinkedList<>();
		if (queue.size() <=1) {
			return queue;
		}
		Interval a = queue.pollFirst();
		
		while (queue.size() > 0) {
			Interval b = queue.pollFirst();
			if (a.end >= b.start) {
				a.end = Math.max(a.end, b.end);
			} else {
				queue2.add(a);
				a = b;
			}
			if (queue.size() == 0) {
				queue2.add(a);
			}
		}
		return queue2;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Interval a = new Interval(1, 4);
		Interval b = new Interval(1, 4);
		Interval c = new Interval(7, 9);
		LinkedList<Interval> intevals = new LinkedList<>();
		intevals.add(b);
		intevals.add(c);
		intevals.add(a);
		MergeIntervals t = new MergeIntervals();
		List<Interval> list = t.merge(intevals);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).start + "  " + list.get(i).end);
		}
	}

}
