/**
 * 2015��11��26��
 * Poirot
 */
package leetCodeMedium;
 
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author Poirot
 *
 */
public class MinimumHeightTrees {
	// idea: remove the leafs level by level
    // the results have at most two nodes
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        LinkedList<Integer> res = new LinkedList<>();
        if(n == 1) {
        	res.add(0);
        	return res;
        }
        Set<Integer>[] nodes = new HashSet[n];
        for (int i = 0; i < nodes.length; i++) {
			nodes[i] = new HashSet<>();
		}
        for (int i = 0; i < edges.length; i++) {
            nodes[edges[i][0]].add(edges[i][1]);
            nodes[edges[i][1]].add(edges[i][0]);
        }
        for (int i = 0; i < n; i++) {
            if(nodes[i].size() == 1) {
                res.add(i);
            }
        } 
        HashSet<Integer> visited = new HashSet<>();  
        while (visited.size() < n - 2) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                int leaf = res.removeFirst();
                visited.add(leaf);
                for (int key : nodes[leaf]) {
                    nodes[key].remove(leaf);
                    if (nodes[key].size() == 1) {
                        res.add(key);
                    }
                }
            }
        }
        return res;
    }		
	
//	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
//		List<Integer> res = new ArrayList<>();
//		if (n == 1) {
//			res.add(0);
//			return res;
//		}
//		@SuppressWarnings("unchecked")
//		HashSet<Integer>[] neighbors = new HashSet[n];
//		HashSet<Integer> visited = new HashSet<>();
//		ArrayList<Integer> leafs = new ArrayList<>(); //level travels, remove the leafs level by level
//		int[] degrees = new int[n];
//		for (int i = 0; i < edges.length; i++) {
//			int a = edges[i][0];
//			int b = edges[i][1];
//			if (neighbors[a] == null) {
//				neighbors[a] = new HashSet<>();
//			}
//			if (neighbors[b] == null) {
//				neighbors[b] = new HashSet<>();
//			}
//			neighbors[a].add(b);
//			neighbors[b].add(a);
//			degrees[a]++;
//			degrees[b]++;
//		}
//		for (int i = 0; i < degrees.length; i++) {
//			if (degrees[i] == 1) {
//				leafs.add(i);
//			}
//		}
//		
//		while ( visited.size() < n - 2) {
//			ArrayList<Integer> nextLevel = new ArrayList<>();
//			for (int i = 0; i < leafs.size(); i++) { 
//				int leaf = leafs.get(i);
//				visited.add(leaf);
//				HashSet<Integer> connectedToLeaf = neighbors[leaf];
//				for (int connect : connectedToLeaf) {
//					if (!visited.contains(connect)) {
//						degrees[connect]--;
//						if (degrees[connect] == 1) {
//							nextLevel.add(connect);
//						}
//					}
//				}
//			}
//			leafs = nextLevel;
//		}
//		return leafs;
//	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumHeightTrees t = new MinimumHeightTrees();
		int n = 6;
		int[][] edges = {{0, 3},{1, 3},{2, 3}, {4, 3}, {5, 4}};
		List<Integer> res = t.findMinHeightTrees(n, edges);
		for (int i = 0; i < res.size(); i++) {
			System.out.print(res.get(i) + " ");
		}
	}
}
