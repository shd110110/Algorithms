/**
 * 2015年11月19日
 * Poirot
 */
package leetCodeHard;

import java.util.ArrayList;

/**
 * @author Poirot
 *
 */
public class FindMedianfromDataStream {
	class MedianFinder {
		ArrayList<Integer> list = new ArrayList<>();
		
	    // Adds a number into the data structure.
	    public void addNum(int num) {
	        int index = findInsertIndex(list, num);
	        list.add(index, num);
	    }
	    
	    public int findInsertIndex(ArrayList<Integer> list, int num) {
	    	if (list.size() == 0) {
				return 0;
			}
	    	int begin = 0;
	    	int end = list.size()-1;
	    	while(begin < end - 1) {
	    		int medium = (begin + end) / 2;
	    		if (list.get(medium) > num) {
					end = medium;
				} else {
					begin = medium;
				}
	    		medium = (begin + end) / 2;
	    	}
	    	if (num > list.get(end)) {
				return end + 1;
	    	}
	    	if (num > list.get(begin)) {
				return begin + 1;
			} else {
				return begin;
			}
	    }

	    // Returns the median of current data stream
	    public double findMedian() {
	        if (list.size() % 2 == 1) {
				return list.get(list.size()/2);
			} else {
				return ((double)(list.get(list.size()/2) + list.get(list.size()/2-1)))/2;
			}
	    }
	};
	
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
