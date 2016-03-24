package leetCodeMedium;
//150606
public class SumRoottoLeafNumbers {
	private int sum = 0;
	public int sumNumbers(TreeNode root) {
        if (root == null) {
			return 0;
		} 
        sumNumber2(root, 0);
        return sum;
    }
	
	public void sumNumber2(TreeNode node, int tempSum){
		if (node.left == null && node.right == null) {
			sum += (tempSum*10 + node.val);
			return;
		}
		if (node.left != null) 
			sumNumber2(node.left, tempSum*10 + node.val);
		if (node.right != null) 
			sumNumber2(node.right, tempSum*10 + node.val);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(3);
		TreeNode node = new TreeNode(1);
		TreeNode node2 = new TreeNode(1);
		root.left = node;
		root.right = node2;
		SumRoottoLeafNumbers t = new SumRoottoLeafNumbers();
		System.out.println(t.sumNumbers(root));
	}

}
