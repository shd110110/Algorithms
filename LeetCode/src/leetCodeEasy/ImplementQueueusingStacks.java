/**
 * 2015Äê7ÔÂ7ÈÕ
 * CH
 */
package leetCodeEasy;

import java.util.Stack;

/**
 * @author CH
 *
 */
public class ImplementQueueusingStacks {

	class MyQueue { 
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
	    // Push element x to the back of queue.
	    public void push(int x) {
	        stack1.push(x);
	    }

	    // Removes the element from in front of queue.
	    public void pop() {
	        while (!stack1.isEmpty()){
	        	stack2.push(stack1.pop()); 
	        }
	        stack2.pop();
	        while (!stack2.isEmpty()){
	        	stack1.push(stack2.pop());
	        }
	    }

	    // Get the front element.
	    public int peek() {
	    	while (!stack1.isEmpty()){
	        	stack2.push(stack1.pop()); 
	        }
	    	int val = stack2.peek();
	    	while (!stack2.isEmpty()){
	        	stack1.push(stack2.pop());
	        }
	    	return val;
	    }

	    // Return whether the queue is empty.
	    public boolean empty() {
	        return stack1.isEmpty();
	    }
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
