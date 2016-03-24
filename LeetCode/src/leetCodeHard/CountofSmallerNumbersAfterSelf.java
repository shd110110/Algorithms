/**
 * Dec 6, 2015
 * Poirot
 * 9:21:43 PM
 * LeetCode
 */
package leetCodeHard;
 
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List; 
 
 
 
/**
 * @author Poirot
 *
 */
public class CountofSmallerNumbersAfterSelf {
	public class RedBlackTreeNode {
		boolean color;
		int key;
		int size;
		RedBlackTreeNode left;
		RedBlackTreeNode right;
		RedBlackTreeNode parent;
		
		public RedBlackTreeNode(int key, int size) {
			// TODO Auto-generated constructor stub
			this.key = key;
			this.color = RedBlackTree.BLACK;
			this.size = size;
		}
	}
	public RedBlackTreeNode NIL = new RedBlackTreeNode(0,0);
	
	
	public class RedBlackTree {
		RedBlackTreeNode root;
		public static final boolean BLACK = true;
		public static final boolean RED = false;
		
		public RedBlackTree() {
			root = NIL;
		}

		public void leftRotate(RedBlackTreeNode x) { // 左旋
			RedBlackTreeNode y = x.right;
			x.right = y.left;
			if (y.left != NIL) {
				y.left.parent = x;
			}
			y.parent = x.parent;

			if (x.parent == NIL) {
				root = y;
			} else if (x == x.parent.left) {
				x.parent.left = y;
			} else {
				x.parent.right = y;
			}
			y.left = x;			
			x.parent = y;
			y.size = x.size;
			x.size = x.left.size + x.right.size + 1;
		}

		public void rightRotate(RedBlackTreeNode y) {// 右旋
			RedBlackTreeNode x = y.left;
			y.left = x.right;
			if (x.right != NIL) {
				x.right.parent = y;
			}
			x.parent = y.parent;
			if (y.parent == NIL) {
				root = x;
			} else if (y == y.parent.left) {
				y.parent.left = x;
			} else {
				y.parent.right = x;
			}
			y.parent = x;
			x.right = y;
			x.size = y.size;
			y.size = x.left.size + x.right.size + 1;
		}

		public void insert(RedBlackTreeNode z) { // 插入，插入后使用redBlackInsertFixup(z)来修改受影响的结点
			RedBlackTreeNode y = NIL;
			RedBlackTreeNode x = root;
			while (x != NIL) {
				x.size ++;  //维护子树规模
				y = x;
				if (z.key < x.key) {
					x = x.left;
				} else {
					x = x.right;
				}
			}
			z.parent = y;
			if (y == NIL) {
				root = z;
			} else if (z.key < y.key) {
				y.left = z;
			} else {
				y.right = z;
			}
			z.left = NIL;
			z.right = NIL;
			redBlackInsertFixup(z);
		}

		public void redBlackInsertFixup(RedBlackTreeNode z) { // 修改受影响的结点
			while (z.parent.color == RED) {
				if (z.parent == z.parent.parent.left) {
					RedBlackTreeNode y = z.parent.parent.right;
					if (y.color == RED) {
						z.parent.color = BLACK;
						y.color = BLACK;
						z.parent.parent.color = RED;
						z = z.parent.parent;
					} else if (z == z.parent.right) {
						z = z.parent;
						leftRotate(z);
					} else {
						z.parent.color = BLACK;
						z.parent.parent.color = RED;
						rightRotate(z.parent.parent);
					}
				} else {
					RedBlackTreeNode y = z.parent.parent.left;
					if (y.color == RED) {
						z.parent.color = BLACK;
						y.color = BLACK;
						z.parent.parent.color = RED;
						z = z.parent.parent;
					} else if (z == z.parent.left) {
						z = z.parent;
						rightRotate(z);
					} else {
						z.parent.color = BLACK;
						z.parent.parent.color = RED;
						leftRotate(z.parent.parent);
					}
				}
			}
			root.color = BLACK;
		}

		public RedBlackTreeNode find(int key) {
			if (root == NIL) {
				return null;
			}
			RedBlackTreeNode temp = root;
			while (temp != NIL) {
				if (key < temp.key) {
					temp = temp.left;
				} else if (key > temp.key) {
					temp = temp.right;
				} else {
					return temp;
				}
			}
			return null;
		}

		public void redBlackTransplant(RedBlackTreeNode u, RedBlackTreeNode v) {
			if (u.parent == NIL) {
				root = v;
			} else if (u == u.parent.left) {
				u.parent.left = v;
			} else {
				u.parent.right = v;
			}
			v.parent = u.parent;
		}

		public void redBlackDelete(RedBlackTreeNode z) {
			RedBlackTreeNode y = z;
			RedBlackTreeNode x;
			boolean yOriginalColor = y.color;
			if (z.left == NIL) {
				x = z.right;
				redBlackTransplant(z, z.right);
			} else if (z.right == NIL) {
				x = z.left;
				redBlackTransplant(z, z.left);
			} else {
				y = treeMinimum(z.right);
				yOriginalColor = y.color;
				x = y.right;
				if (y.parent == z) {
					x.parent = y;
				} else {
					redBlackTransplant(y, y.right);
					y.right = z.right;
					y.right.parent = y;
				}
				redBlackTransplant(z, y);
				y.left = z.left;
				y.left.parent = y;
				y.color = z.color;
			}

			if (yOriginalColor == BLACK) {
				redBlackDeleteFixup(x);
			}
		}

		public RedBlackTreeNode treeMinimum(RedBlackTreeNode node) {
			RedBlackTreeNode temp = node;
			while (temp.left != NIL) {
				temp = temp.left;
			}
			return temp;
		}

		public void redBlackDeleteFixup(RedBlackTreeNode x) {
			while (x != root && x.color == BLACK) {
				if (x == x.parent.left) {
					RedBlackTreeNode w = x.parent.right;
					if (w.color == RED) {
						w.color = BLACK;
						x.parent.color = RED;
						leftRotate(x.parent);
						w = x.parent.right;
					}
					if (w.left.color == BLACK && w.right.color == BLACK) {
						w.color = RED;
						x = x.parent;
					} else if (w.right.color == BLACK) {
						w.left.color = BLACK;
						w.color = RED;
						rightRotate(w);
						w = x.parent.right;
					} else {
						w.color = x.parent.color;
						x.parent.color = BLACK;
						leftRotate(x.parent);
						x = root;
					}
				} else {
					RedBlackTreeNode w = x.parent.left;
					if (w.color == RED) {
						w.color = BLACK;
						x.parent.color = RED;
						rightRotate(x.parent);
						w = x.parent.left;
					}
					if (w.right.color == BLACK && w.left.color == BLACK) {
						w.color = RED;
						x = x.parent;
					} else if (w.left.color == BLACK) {
						w.right.color = BLACK;
						w.color = RED;
						leftRotate(w);
						w = x.parent.left;
					} else {
						w.color = x.parent.color;
						x.parent.color = BLACK;
						rightRotate(x.parent);
						x = root;
					}
				}
			}
		}

		public RedBlackTreeNode osSelect(RedBlackTreeNode node, int i) {
			if (node.size < i) {
				return null;
			}
			int r = node.left.size + 1;
			if (i == r) {
				return node;
			} else if (i < r) {
				return osSelect(node.left, i);
			} else {
				return osSelect(node.right, i - r);
			}
		}
		
		public int osRank(RedBlackTreeNode node , RedBlackTreeNode x) { //查找x的秩，即x在中序遍历中的位置
			int r = 1;
			if (x.left != NIL) {
				r = x.left.size + 1;
			}
			
			RedBlackTreeNode y = x;
			while (y != root) {
				if (y == y.parent.right) {
					r = r + y.parent.left.size + 1;
				}
				y = y.parent;
			}        
			return r;
		}
		
		// 遍历
		public ArrayList<Integer> inorderTravel(RedBlackTreeNode root) {
			if (root == NIL) {
				return new ArrayList<>();
			}
			ArrayList<Integer> left = inorderTravel(root.left);
			left.add(root.key); 
			left.addAll(inorderTravel(root.right));
			return left;
		}
	}
	

	public List<Integer> countSmaller(int[] nums) {
		if (nums.length == 0) {
			return new ArrayList<>();
		}
		LinkedList<Integer> res = new LinkedList<>();
		RedBlackTree redBlackTree = new RedBlackTree();
		for (int i = nums.length - 1; i >= 0; i--) {
			redBlackTree.insert(new RedBlackTreeNode(nums[i], 1));
//			ArrayList<Integer> travel = redBlackTree.inorderTravel(redBlackTree.root);
//			for (int j = 0; j < travel.size(); j++) {
//				System.out.print(travel.get(j) + "  ");
//			}
//			System.out.println();
			int num = redBlackTree.osRank(redBlackTree.root, redBlackTree.find(nums[i]));
			res.addFirst(num - 1);
		}
		return res;
	}
	
	
	// Accumulation Solution 0(n^2)
//	private void add(int[] bit, int i, int val) {
//		for (; i < bit.length; i += 1)
//			bit[i] += val;
//	}
//
//	private int query(int[] bit, int i) {
//		return bit[i];
//	}
//
//	public List<Integer> countSmaller(int[] nums) {
//		int[] tmp = nums.clone();
//		Arrays.sort(tmp);
//		for (int i = 0; i < nums.length; i++) {
//			nums[i] = Arrays.binarySearch(tmp, nums[i]);
//		}
//		int[] bit = new int[nums.length];
//		Integer[] ans = new Integer[nums.length];
//		for (int i = nums.length - 1; i >= 0; i--) {
//			ans[i] = query(bit, nums[i]);
//			add(bit, nums[i] + 1, 1);
//		}
//		return Arrays.asList(ans);
//	}
	
	
	

	// mergeSort Solution By CH 0(nlog(n))
//	public class Point {
//		int index;
//		int value;
//
//		public Point(int index, int value) {
//			this.index = index;
//			this.value = value;
//		}
//	}

//	public List<Integer> countSmaller(int[] nums) {
//		if (nums.length == 0) {
//			return new ArrayList<>();
//		}
//		int[] res = new int[nums.length];
//		Point[] points = new Point[nums.length];
//		for (int i = 0; i < points.length; i++) {
//			points[i] = new Point(i, nums[i]);
//		}
//		sort(points, 0, nums.length - 1, res);
//		ArrayList<Integer> res2 = new ArrayList<>();
//		for (int i = 0; i < res.length; i++) {
//			res2.add(res[i]);
//		}
//		return res2;
//	}

//	public void sort(Point[] points, int begin, int end, int[] res) {
//		// System.out.println(begin + " " + end);
//		if (end == begin) {
//			return;
//		}
//		int half = (begin + end) / 2;
//
//		sort(points, begin, half, res);
//		sort(points, half + 1, end, res);
//		int i = half, j = end;
//		Point[] temp = new Point[end - begin + 1];
//		int index = temp.length - 1;
//		for (int k = end; k >= begin; k--) {
//			if (j <= half || i >= begin && points[i].value > points[j].value) {
//				if (j > half) {
//					res[points[i].index] += (j - half);
//				}
//				temp[index--] = points[i];
//				i--;
//			} else {
//				temp[index--] = points[j];
//				j--;
//			}
//		}
//
//		for (int k = 0; k < temp.length; k++) {
//			points[begin + k] = temp[k];
//		}
//
//	}

	
	
	// binary search Solution By CH 0(nlog(n))
	// public List<Integer> countSmaller(int[] nums) {
	//
	// LinkedList<Integer> res = new LinkedList<>();
	// if (nums.length == 0) {
	// return res;
	// }
	// ArrayList<Integer> sorted = new ArrayList<>();
	// // sorted.add(nums[nums.length - 1]);
	// // res.addFirst(0);
	// for (int i = nums.length - 1; i >= 0; i--) {
	// int index = find(sorted, nums[i]);
	// if (index >= sorted.size()) {
	// sorted.add(nums[i]);
	// } else {
	// sorted.add(index, nums[i]);
	// }
	// // System.out.println(sorted + " " + index);
	// res.addFirst(index);
	// }
	// return res;
	// }
	//
	// public int find(ArrayList<Integer> sortedList, int num) {
	// if (sortedList.size() == 0) {
	// return 0;
	// }
	// int begin = 0;
	// int end = sortedList.size() - 1;
	// int medium = (begin + end) / 2;
	// while (begin < end - 1) {
	// if (sortedList.get(medium) >= num) {
	// end = medium;
	// } else {
	// begin = medium;
	// }
	// medium = (begin + end) / 2;
	// }
	// if (sortedList.get(end) < num) {
	// return end + 1;
	// } else if (sortedList.get(begin) < num) {
	// return begin + 1;
	// } else {
	// return begin;
	// }
	// }
	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountofSmallerNumbersAfterSelf t = new CountofSmallerNumbersAfterSelf();
		// BufferedReader bufferedReader = new BufferedReader(new FileReader(
		// new File("C:\\Users\\Poirot\\Desktop\\test.txt")));

//		ArrayList<Integer> numList = new ArrayList<>();
//		Scanner scanner = new Scanner(new File("CountofSmallerNumbersAfterSelf.txt"));
//		while (scanner.hasNext()) {
//			String string = scanner.nextLine();
//			// System.out.println(string);
//			String[] strings = string.split(",");
//			System.out.println(strings.length);
//			for (int i = 0; i < strings.length; i++) {
//				numList.add(Integer.parseInt(strings[i]));
//			}
//		}
//		scanner.close();
//		int[] nums = new int[numList.size()];
//		for (int i = 0; i < nums.length; i++) {
//			nums[i] = numList.get(i);
//		}
//		int count = 0;
//		for (int i = 1; i < nums.length; i++) {
//			if (nums[i] < nums[0]) {
//				count++;
//			}
//		}
//		System.out.println(count); 
		
		int[] nums2 = { 5, 2, 6, 1 };
		System.out.println(t.countSmaller(nums2));
	}

}
