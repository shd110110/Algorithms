package leetCodeMedium;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream; 
import java.io.IOException; 
import java.io.InputStreamReader;  
import java.util.TreeSet;
 

public class ContainsDuplicateIII150601 {
	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if(nums == null || nums.length <= 1)
            return false;
		if (k <= 0) {
			return false;
		} 
		int first = nums[0];
		int index = 0;
		TreeSet<Integer> temp = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
			if (temp.size() == k+1) {
				temp.remove(first);
				index++;
				first = nums[index];
			}
			if (!temp.add(nums[i]) && t >= 0) {
				return true;
			}
			if ((temp.higher(nums[i]) != null && Math.abs((long)temp.higher(nums[i]) - (long)nums[i]) <= t) || 
					(temp.lower(nums[i]) != null && Math.abs((long)temp.lower(nums[i]) - (long)nums[i]) <= t) ) {
				return true;
			}		
		}
		return false;
    }
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("F:\\test\\numbers.txt"); 
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String buff;
        StringBuilder stringBuilder = new StringBuilder();
        while((buff = br.readLine())!=null){

        	stringBuilder.append(buff);       
        }
        
        String s = stringBuilder.toString(); 
        br.close();
        String[] strings = s.split(",");
        int[] test = new int[strings.length];
        
        for (int i = 0; i < test.length; i++) {
			if (strings[i] != null) {
				test[i] = Integer.parseInt(strings[i]);
			}
		} 
		System.out.println(containsNearbyAlmostDuplicate(test, 10000, 0));
		
		int[] test1 = {-1,2147483647};

		System.out.println(containsNearbyAlmostDuplicate(test1, 1, 2147483647));
		
		TreeSet<Integer> temp = new TreeSet<>();
		temp.add(-1);
		temp.add(-1);
		if (temp.higher(-1) != null)
			System.out.println(temp.higher(-1));
	}

}
