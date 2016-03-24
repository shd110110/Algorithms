package leetCodeMedium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
//150604
public class CourseScheduleII {
	public static int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] result = new int[numCourses];
		int a = 0;
		
        Set<Integer> zeroDegree = new HashSet<>();
		
        Map<Integer, Integer> degree = new HashMap<>();
        for (int row = 0; row < prerequisites.length; row++)
            degree.put(prerequisites[row][0], degree.get(prerequisites[row][0]) == null ? 1 :degree.get(prerequisites[row][0])+1);
        for (int i = 0; i < numCourses; i++)
            if (!degree.containsKey(i)) 
            	zeroDegree.add(i);
   
        if (zeroDegree.isEmpty()) 
        	return new int[0]; 
        
        while (!zeroDegree.isEmpty()) {
            Iterator<Integer> it = zeroDegree.iterator();
            int course = it.next();
            zeroDegree.remove(course);
            result[a++] = course;
            
            for (int row = 0; row < prerequisites.length; row++) {
                if (prerequisites[row][1] == course) {
                	degree.put(prerequisites[row][0], degree.get(prerequisites[row][0])-1);

                    if (degree.get(prerequisites[row][0]) == 0) 
                    	zeroDegree.add(prerequisites[row][0]);
                }
            }
        }
        for (int i = 0; i < degree.size(); i++)
            if (degree.containsKey(i) && degree.get(i) != 0) 
            	return new int[0];
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] test = {{0,1},{1,0}};//{{1,0},{2,0},{3,1},{3,2}};
		int[] r = findOrder(2, test);
		for (int i = 0; i < r.length; i++) {
			System.out.print(r[i] + " ");
		}
		
	}

}
