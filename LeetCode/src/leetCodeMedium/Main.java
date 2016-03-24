/**
 * 2016年3月18日
 * Poirot
 * 下午9:04:20
 * LeetCode
 */
package leetCodeMedium;

/**
 * @author Poirot
 *
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); 
		
		while(scan.hasNext()) {
			int count = scan.nextInt();
//			System.out.println(count);
			scan.nextLine();
			ArrayList<List<String>> result = new ArrayList<>();
			for(int i = 0; i < count; i++) {
				
				int n = scan.nextInt(); 
				scan.nextLine();
				
				HashSet<Integer>[] succeeds = new HashSet[n]; 
				HashSet<Integer>[] precedes = new HashSet[n]; 
				for (int m = 0; m < n; m++) {
					precedes[m] = new HashSet<>();
					succeeds[m] = new HashSet<>();
				}
				HashMap<Integer, String> numToName = new HashMap<> ();
				HashMap<String, Integer> nameToNum = new HashMap<> ();
				PriorityQueue<String> emptyDegree = new PriorityQueue<>();
				 
				for(int j = 0; j < n; j++) {
					String line = scan.nextLine();
					String[] strs = line.split(" ");
					String name = strs[0];
					numToName.put(j, name);
					nameToNum.put(name, j);
					int depends = Integer.valueOf(strs[1]);
					if (depends == 0) {
						emptyDegree.add(name);
					} else {
						for(int k = 2; k < strs.length; k++) {
							int toNode = Integer.valueOf(strs[k]);
							precedes[j].add(toNode);
							succeeds[toNode].add(j); 
						} 
					}
				}
//				System.out.println(emptyDegree);
				boolean hasCircle = false;
				ArrayList<String> oneResult = new ArrayList<>(); 	 
				for (int j = 0; j < n; j++) {
					if (emptyDegree.isEmpty()) {
						hasCircle = true;
						break;
					}
					String string = emptyDegree.remove();
					oneResult.add(string);
					int first = nameToNum.get(string); 
					for (int o : succeeds[first]) {
						precedes[o].remove(first);
						if (precedes[o].size() == 0) {
							emptyDegree.add(numToName.get(o));
						}
					}
				} 
				if (hasCircle) {
					oneResult = new ArrayList<>();
					oneResult.add("ERROR");
					result.add(oneResult);
				} else {
					result.add(oneResult);
				}
			}
			for (int i = 0; i < result.size(); i++) {
				List<String> list = result.get(i);
				for (int j = 0; j < list.size(); j++) {
					System.out.println(list.get(j));
				}
				System.out.println();
			}
		}
	}
}
