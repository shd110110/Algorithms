package leetCodeMedium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Poirot 2015年6月13日
 */
public class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
};
