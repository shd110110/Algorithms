package leetCodeMedium;
 
import java.util.HashMap;

/**
 * @author Poirot
 * 2015年6月13日
 */

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class CloneGraph {
	private HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) return null;
        if (map.containsKey(node.label)) {
            return map.get(node.label);
        }
        UndirectedGraphNode first = new UndirectedGraphNode(node.label);
        map.put(first.label, first);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            first.neighbors.add(cloneGraph(neighbor));
        }
        return first;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
