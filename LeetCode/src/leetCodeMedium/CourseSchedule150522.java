package leetCodeMedium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CourseSchedule150522 {
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		if (prerequisites.length == 0) {
			return true;
		}
		Map<Integer, Integer> tempMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < prerequisites.length; i++) {
			tempMap.put(prerequisites[i][0],prerequisites[i][1]);
		}
		int index = tempMap.get(0);
		Set<Integer> tempSet = new HashSet<Integer>();
		tempSet.add(index); 
		index = prerequisites[0][1];
		while(true) {
			if (!tempMap.containsKey(index)) {
				tempSet = new HashSet<Integer>();
				break;
			}else if(!tempSet.add(tempMap.get(index)))
				return false;
			index = tempMap.get(index);
		}
		return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] test = {{5,8},{3,5},{1,9},{4,5},{0,2},{1,9},{7,8},{4,9}};
		int[][] test2 = {{1,0},{2,6},{1,7},{6,4},{7,0},{0,5}};
		System.out.println(canFinish(10, test));
		System.out.println(canFinish(8, test2));
	}

}
