package leetCodeHard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Poirot 2015年6月30日
 */
public class InsertInterval {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		if (intervals.size() == 0) {
			intervals.add(newInterval);
			return intervals;
		}
		int beginIndex = 0;
		while (beginIndex < intervals.size()
				&& newInterval.start > intervals.get(beginIndex).end) {
			beginIndex++;
		}
//		System.out.println(beginIndex);
		if (beginIndex == intervals.size()) {
			intervals.add(newInterval);
			return intervals;
		}
		if (newInterval.end < intervals.get(beginIndex).start) {
			intervals.add(beginIndex, newInterval);
		}

		int endIndex = beginIndex;
		while (endIndex < intervals.size() && newInterval.end >= intervals.get(endIndex).start) {
			endIndex++;
		}
//		System.out.println(endIndex);
		newInterval.start = Math.min(intervals.get(beginIndex).start, newInterval.start);
		newInterval.end = Math.max(intervals.get(endIndex-1).end, newInterval.end);
		for (int i = beginIndex; i < endIndex; i++) {
			intervals.remove(beginIndex);
		}
		intervals.add(beginIndex, newInterval); 
		return intervals;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InsertInterval t = new InsertInterval();
//		Interval a = new Interval(1,2);
//		Interval b = new Interval(3,5);
//		Interval c = new Interval(6,7);
//		Interval d = new Interval(8,10);
//		Interval e = new Interval(12,16);
		Interval f = new Interval(1,5);
		ArrayList<Interval> intervals = new ArrayList<>();
//		intervals.add(a);
//		intervals.add(b);
//		intervals.add(c);
//		intervals.add(d);
//		intervals.add(e);
		intervals.add(f);

		List<Interval> result = t.insert(intervals, new Interval(1,3));
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i).start + "   " + result.get(i).end);
		}
	}

}
