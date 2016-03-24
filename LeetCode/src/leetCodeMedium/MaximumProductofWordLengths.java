/**
 * Dec 16, 2015
 * Poirot
 * 7:23:05 PM
 * LeetCode
 */
package leetCodeMedium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Poirot
 *
 */
public class MaximumProductofWordLengths {
	
	//first solution
    public int maxProduct(String[] words) {
        if (words.length <= 1) {
        	return 0;
        }
        @SuppressWarnings("unchecked")
		Set<Character>[] charactersSets = new HashSet[words.length];
        for (int i = 0; i < charactersSets.length; i++) {
			charactersSets[i] = new HashSet<>();
		}
        for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words[i].length(); j++) {
				charactersSets[i].add(words[i].charAt(j));
			}
		}
        
        int max = 0;
        for (int i = 0; i < words.length - 1; i++) {
			for (int j = i + 1; j < words.length; j++) {
				boolean mark = true;
				for (Character c : charactersSets[i]) {
					if (charactersSets[j].contains(c)) {
						mark = false;
						break;
					}
				}
				if (mark) {
					max = Math.max(max, words[i].length() * words[j].length());
				}
			}
		}
        return max;
    }
    
    // second solution
    public int maxProductSecond(String[] words) {
        if (words.length <= 1) {
        	return 0;
        }
        boolean[][] count = new boolean[words.length][128];
         
        for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words[i].length(); j++) {
				count[i][words[i].charAt(j)] = true;
			}
		}
        
        int max = 0;
        for (int i = 0; i < words.length - 1; i++) {
			for (int j = i + 1; j < words.length; j++) {
				boolean mark = true;
				for (int k = 97; k <= 122; k++) {
					if (count[i][k] && count[j][k]) {
						mark = false;
						break;
					}
				}
				if (mark) {
					max = Math.max(max, words[i].length() * words[j].length());
				}
			}
		}
        return max;
    }
    
    // third solution
    public int maxProductThird(String[] words) {
        if (words.length <= 1) {
        	return 0;
        }
        Arrays.sort(words, new Comparator<String>(){
            public int compare(String a, String b){
                return b.length() - a.length();
            }
        });
        
        boolean[][] count = new boolean[words.length][128];
         
        for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words[i].length(); j++) {
				count[i][words[i].charAt(j)] = true;
			}
		}
        
        int max = 0;
        for (int i = 0; i < words.length - 1; i++) {
			for (int j = i + 1; j < words.length; j++) {
				boolean mark = true;
				for (int k = 97; k <= 122; k++) {
					if (count[i][k] && count[j][k]) {
						mark = false;
						break;
					}
				}
				if (mark) {
					max = Math.max(max, words[i].length() * words[j].length());
					break;
				}
			}
		}
        return max;
    }
    
    
//    public int maxProduct(String[] words) {
//        int max = 0;
//
//        Arrays.sort(words, new Comparator<String>(){
//            public int compare(String a, String b){
//                return b.length() - a.length();
//            }
//        });
//
//        int[][] info = new int[words.length][2]; // {alphabet mask, length}
//        for(int i = 0; i < info.length; i++){
//            info[i][0] = getMask(words[i]);
//            info[i][1] = words[i].length();
//        }
//
//        for(int i = 0; i < info.length; i++){
//            for(int j = i + 1; j < info.length; j++){
//                if((info[i][0] & info[j][0]) == 0){
//                    max = Math.max(max, info[i][1] * info[j][1]);
//                    break; //prunning
//                }
//            }
//        }
//        return max;
//    }
//
//    private int getMask(String s){
//        int mask = 0;
//        for(char c: s.toCharArray()){
//            mask |= 1 << (c - 'a');
//        }
//        return mask;
//    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumProductofWordLengths t = new MaximumProductofWordLengths();
//		String[] words = {"abcw","baz","foo","bar","xtfn","abcdef"};
		String[] words = {"eae","ea","aaf","bda","fcf","dc","ac","ce","cefde","dabae"};
		System.out.println(t.maxProduct(words));
	}

}
