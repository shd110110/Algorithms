package leetCodeHard;
  
import java.util.HashMap;
import java.util.LinkedHashMap;  

/**
 * @author Poirot 2015年6月15日
 */
public class LRUCache {
//	private LinkedHashMap<Integer, Integer> map;
//	int capacity;
//
//	public LRUCache(int capacity) {
//		map = new LinkedHashMap<>(capacity);
//		this.capacity = capacity;
//	}
//
//	public int get(int key) {
//		if (map.containsKey(key)) {
//			int value = map.remove(key);
//			map.put(key, value);
//			return value;
//		} else {
//			return -1;
//		}
//	}
//
//	public void set(int key, int value) {
//		if (!map.containsKey(key) && map.size() == capacity) {
//			map.remove(map.keySet().iterator().next());
//		}
//		map.remove(key);
//		map.put(key, value);
//	}
	
	
	
	// 16ms beats 90.17%
	class DLinkedNode {
	    int key;
	    int value;
	    DLinkedNode pre;
	    DLinkedNode post;
	}

	/**
	 * Always add the new node right after head;
	 */
	private void addNode(DLinkedNode node){
	    node.pre = head;
	    node.post = head.post;

	    head.post.pre = node;
	    head.post = node;
	}

	/**
	 * Remove an existing node from the linked list.
	 */
	private void removeNode(DLinkedNode node){
	    DLinkedNode pre = node.pre;
	    DLinkedNode post = node.post;
	    pre.post = post;
	    post.pre = pre;
	}

	/**
	 * Move certain node in between to the head.
	 */
	private void moveToHead(DLinkedNode node){
	    this.removeNode(node);
	    this.addNode(node);
	}

	// pop the current tail. 
	private DLinkedNode popTail(){
	    DLinkedNode res = tail.pre;
	    this.removeNode(res);
	    return res;
	}

	private HashMap<Integer, DLinkedNode> 
	    cache = new HashMap<Integer, DLinkedNode>();
	private int count;
	private int capacity;
	private DLinkedNode head, tail;

	public LRUCache(int capacity) {
	    this.count = 0;
	    this.capacity = capacity;

	    head = new DLinkedNode();
	    head.pre = null;

	    tail = new DLinkedNode();
	    tail.post = null;

	    head.post = tail;
	    tail.pre = head;
	}

	public int get(int key) {

	    DLinkedNode node = cache.get(key);
	    if(node == null){
	        return -1; // should raise exception here.
	    }

	    // move the accessed node to the head;
	    this.moveToHead(node);

	    return node.value;
	}


	public void set(int key, int value) {
	    DLinkedNode node = cache.get(key);

	    if(node == null){

	        DLinkedNode newNode = new DLinkedNode();
	        newNode.key = key;
	        newNode.value = value;

	        this.cache.put(key, newNode);
	        this.addNode(newNode);

	        ++count;

	        if(count > capacity){
	            // pop the tail
	            DLinkedNode tail = this.popTail();
	            this.cache.remove(tail.key);
	            --count;   
	        }
	    }else{
	        // update the value.
	        node.value = value;
	        this.moveToHead(node);
	    }

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
