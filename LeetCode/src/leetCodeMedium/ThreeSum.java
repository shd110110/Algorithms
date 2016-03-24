/**
 * 2015年11月27日
 * Poirot
 */
package leetCodeMedium;
 
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Poirot
 *
 */
public class ThreeSum {

	// most votes
	public List<List<Integer>> threeSum(int[] num) {
		Arrays.sort(num);
		List<List<Integer>> res = new LinkedList<>();
		for (int i = 0; i < num.length - 2; i++) {
			if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
				int lo = i + 1, hi = num.length - 1, sum = 0 - num[i];
				while (lo < hi) {
					if (num[lo] + num[hi] == sum) {
						res.add(Arrays.asList(num[i], num[lo], num[hi]));
						while (lo < hi && num[lo] == num[lo + 1])
							lo++;
						while (lo < hi && num[hi] == num[hi - 1])
							hi--;
						lo++;
						hi--;
					} else if (num[lo] + num[hi] < sum) {
						lo++;
					} else {
						hi--;
					}
				}
			}
		}
		return res;
	}

	// public List<List<Integer>> threeSum(int[] num) {
	// List<List<Integer>> result = new ArrayList<>();
	// if (num.length < 3) {
	// return result;
	// }
	// Arrays.sort(num);
	// int key = 0, findResult = 0;
	// for (int i = 0; i < num.length - 2; i++) {
	// if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
	// for (int j = i + 1; j < num.length - 1; j++) {
	// if (j == i + 1 || (j > i + 1) && num[j] != num[j - 1]) {
	// key = num[i] + num[j];
	//
	// if (key > 0) {
	// break;
	// }
	// key = -key;
	// findResult = Arrays.binarySearch(num, j + 1, num.length, key);
	// if (findResult >= 0) {
	// ArrayList<Integer> temp = new ArrayList<>();
	// temp.add(num[i]);
	// temp.add(num[j]);
	// temp.add(num[findResult]);
	// result.add(temp);
	// }
	// }
	// }
	// }
	// }
	// return result;
	// }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreeSum t = new ThreeSum();
		int[] nums = {7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
		System.out.println(t.threeSum(nums));
	}

}
