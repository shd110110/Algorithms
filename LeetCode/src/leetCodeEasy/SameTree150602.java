package leetCodeEasy;

public class SameTree150602 {
	public boolean isSameTree(TreeNode p, TreeNode q) {
        if ((p == null && q != null) || (p != null && q == null)) {
			return false;
		}
        if (p == null && q == null) {
			return true;
		}
        if (q.val != p.val) {
			return false;
		}else {
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}
    }
}
