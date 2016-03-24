package leetCodeMedium;

import java.util.Iterator;

/**
 * @author Poirot
 * 2015年9月30日
 */
public class PeekingIterator implements Iterator<Integer> {
	int current ;
	boolean hasnext;
	Iterator<Integer> iter;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
		this.iter = iterator;
	    if (iter.hasNext()) {
			hasnext = true;
			current = iter.next();
		}
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		return current;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    int res = current;
	    if (iter.hasNext()) {
			current = iter.next();
		} else {
			hasnext = false;
		}
	    return res;
	}

	@Override
	public boolean hasNext() {
	    return hasnext;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
