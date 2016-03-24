/**
 * 2015Äê7ÔÂ1ÈÕ
 * CH
 */
package leetCodeMedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap; 
import java.util.List;

/**
 * @author CH
 *
 */
public class Anagrams {
    public List<String> anagrams(String[] strs) {
        List<String> result = new ArrayList<String>();
        if (strs.length == 0) {
			return result;
		}
        HashMap<String, Integer> map = new HashMap<String, Integer>(); 
        for (int i = 0; i < strs.length; i++) {
			char[] charactors = strs[i].toCharArray();
			Arrays.sort(charactors);
			String a = new String(charactors);
			if (!map.containsKey(a)) {
				map.put(a, i);
			}else if (map.get(a) == -1) {
				result.add(strs[i]); 
			}else {
				result.add(strs[i]);
				result.add(strs[map.get(a)]);
				map.put(a, -1);
			} 
		}
        return result;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Anagrams t = new Anagrams();
		String[] strs = {"tea","and","ate","eat","den"};
		List<String> result = t.anagrams(strs);
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}

}
