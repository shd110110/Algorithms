package leetCodeMedium;

import java.util.LinkedList;

/**
 * @author Poirot 2015年6月11日
 */
public class ImplementStackusingQueues {

	LinkedList<Integer> deque = new LinkedList<>();
	public void push(int x) {
		deque.push(x);
	}

	// Removes the element on top of the stack.
	public void pop() {
		deque.removeFirst();
	}

	// Get the top element.
	public int top() {
		return deque.getFirst();
	}

	// Return whether the stack is empty.
	public boolean empty() {
		return deque.isEmpty();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
