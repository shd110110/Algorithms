package leetCodeMedium;

import java.util.HashMap; 

/**
 * @author Poirot 2015年6月19日
 */
public class CopyListwithRandomPointer {
	//other's idea 
//	public RandomListNode copyRandomList(RandomListNode head) {
//        if(head==null){
//            return null;
//        }
//        RandomListNode n = head;
//        while (n!=null){
//            RandomListNode n2 = new RandomListNode(n.label);
//            RandomListNode tmp = n.next;
//            n.next = n2;
//            n2.next = tmp;
//            n = tmp;
//        }
//
//        n=head;
//        while(n != null){
//            RandomListNode n2 = n.next;
//            if(n.random != null)
//                n2.random = n.random.next;
//            else
//                n2.random = null;
//            n = n.next.next;
//        }
//
//        //detach list
//        RandomListNode n2 = head.next;
//        n = head;
//        RandomListNode head2 = head.next;
//        while(n2 != null && n != null){
//            n.next = n.next.next;
//            if (n2.next == null){
//                break;
//            }
//            n2.next = n2.next.next;
//
//            n2 = n2.next;
//            n = n.next;
//        }
//        return head2;
//    }
	public RandomListNode copyRandomList(RandomListNode head) {
		HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
	    RandomListNode travel = head;
	    while(null != travel){
	        map.put(travel, new RandomListNode(travel.label));
	        travel = travel.next; 
	    }
	    travel = head;
	    while(null != travel){
	        map.get(travel).random = map.get(travel.random);
	        travel = travel.next;
	    }
	    travel = head;
	    while(null != travel){
	        map.get(travel).next = map.get(travel.next);
	        travel = travel.next;
	    }
	    return map.get(head);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
