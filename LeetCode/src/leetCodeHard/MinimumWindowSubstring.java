package leetCodeHard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;  

/**
 * @author Poirot
 * 2015年6月27日
 */
public class MinimumWindowSubstring {
//    public String minWindow(String s, String t) {
//    	if (t == null || t.length() == 0) {
//			return t;
//		} 
//    	if (s.length() < t.length()) {
//			return "";
//		}
//    	HashMap<Character, Integer> tMap = new HashMap<>();
//    	for (int i = 0; i < t.length(); i++) {
//			if (tMap.containsKey(t.charAt(i))) {
//				int numbers = tMap.get(t.charAt(i))+1;
//				tMap.put(t.charAt(i), numbers);
//			}else {
//				tMap.put(t.charAt(i), 1);
//			}
//		}
////    	Iterator<Character> itr = tMap.keySet().iterator();
////    	while (itr.hasNext()){
////    		Character a = itr.next();
////    		System.out.println(a +" " +tMap.get(a));
////    	} 
//    	int begin = 0; 
//    	HashMap<Character,Integer> hashMap= new HashMap<>();
//    	int currentEnd=0;
//    	int length = 0;
//    	while (currentEnd < s.length()) {
//    		if (tMap.containsKey(s.charAt(currentEnd))){
//				if (hashMap.containsKey(s.charAt(currentEnd))) {
//					if ( hashMap.get(s.charAt(currentEnd)) < tMap.get(s.charAt(currentEnd)) ) {
//						length++;//如果某一项数量还不够，说明出现了一个
//					}
//					int numbers = hashMap.get(s.charAt(currentEnd))+1;
//					hashMap.put(s.charAt(currentEnd), numbers);
//				}else {
//					hashMap.put(s.charAt(currentEnd), 1);
//					length++; 
//				} 
//				if (length == t.length()) { 
//					break;
//				}
//			}
//    		currentEnd++;
//		}
//    	if (length != t.length()) {
//			return "";
//		} 
//    	int minLength = currentEnd - begin +1; 
//    	int numbers = 0;
//    	String currentString = s.substring(0, currentEnd+1); 
//    	if (currentEnd == s.length()-1) { 
//    		for (int j2 = begin; j2 <= currentEnd-t.length(); j2++) {  
//				if (!tMap.containsKey(s.charAt(j2))) { 
//					begin++; 
//				}else {
//					
//					if (hashMap.get(s.charAt(j2)) > tMap.get(s.charAt(j2))) {
////						System.out.println("chenhui " + s.charAt(j2)+ "  "+hashMap.get(s.charAt(j2)));
//						numbers = hashMap.get(s.charAt(j2)) - 1;
//						hashMap.put(s.charAt(j2), numbers);
//						begin++; 
//					} else { 
//						break;
//					} 
////					System.out.println(s.charAt(j2));
//				}
//			}
//			if (currentEnd - begin+1 < minLength) { 
//				minLength = currentEnd - begin+1;
//				currentString = s.substring(begin, currentEnd+1); 
//			}
//			return currentString;
//		}
//    	int end2 = currentEnd ; 
//    	
//    	if (tMap.containsKey(s.charAt(end2))) {
//    		for (int j2 = begin; j2 <= end2-t.length(); j2++) {  
//				if (!tMap.containsKey(s.charAt(j2))) { 
//					begin++; 
//				}else {
//					
//					if (hashMap.get(s.charAt(j2)) > tMap.get(s.charAt(j2))) {
////						System.out.println("chenhui " + s.charAt(j2)+ "  "+hashMap.get(s.charAt(j2)));
//						numbers = hashMap.get(s.charAt(j2)) - 1;
//						hashMap.put(s.charAt(j2), numbers);
//						begin++; 
//					} else { 
//						break;
//					} 
////					System.out.println(s.charAt(j2));
//				}
//			}
//			if (currentEnd - begin+1 < minLength) { 
//				minLength = currentEnd - begin+1;
//				currentString = s.substring(begin, currentEnd+1); 
//			}
//		}
//    	end2++;
////    	Iterator<Character> itr = hashMap.keySet().iterator();
////    	while (itr.hasNext()){
////    		Character a = itr.next();
////    		System.out.println(a +" " +tMap.get(a));
////    	} 
//    	while (end2 < s.length()) { 
////    		System.out.println(end2 + "  "+s.charAt(end2));
//    		if (!tMap.containsKey(s.charAt(end2))) {  
//			}else{  
////				System.out.println("begin  "+begin); 
////				System.out.println(currentString);
//				numbers = hashMap.get(s.charAt(end2)) + 1;
//				hashMap.put(s.charAt(end2), numbers); 
//				for (int j2 = begin; j2 <= end2-t.length(); j2++) {  
//					if (!tMap.containsKey(s.charAt(j2))) { 
//						begin++; 
//					}else {
//						
//						if (hashMap.get(s.charAt(j2)) > tMap.get(s.charAt(j2))) {
////							System.out.println("chenhui " + s.charAt(j2)+ "  "+hashMap.get(s.charAt(j2)));
//							numbers = hashMap.get(s.charAt(j2)) - 1;
//							hashMap.put(s.charAt(j2), numbers);
//							begin++; 
//						} else { 
//							break;
//						} 
////						System.out.println(s.charAt(j2));
//					}
//				}
////				System.out.println("begin  "+begin); 
//				if (end2-begin+1 < minLength) { 
//					minLength = end2-begin+1;
//					currentString = s.substring(begin, end2+1); 
//					if (minLength == t.length()) {
//						break;
//					}
//				}
//			} 
//			end2++;
//		}
//    	return currentString;
//    	
//    }
    
    
    
    public String minWindow(String s, String t) {
        if (t == null || t.length() == 0) {
            return t;
        }
        HashMap<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.containsKey(t.charAt(i)) ? tMap.get(t.charAt(i)) + 1 : 1);
        }
        int begin = 0;
        while (begin < s.length() && !tMap.containsKey(s.charAt(begin))) {
            begin++;
        }
        
        int end = begin;
        HashMap<Character, Integer> map = new HashMap<>();
        int resBegin = begin;
        int resEnd = end;
        int length = Integer.MAX_VALUE;
        int size = 0;
        while (end < s.length()) { 
            if (tMap.containsKey(s.charAt(end))) {
            	 
            	if (map.containsKey(s.charAt(end))) {
            		map.put(s.charAt(end), map.get(s.charAt(end)) + 1);
            	} else {
            		map.put(s.charAt(end), 1); 
            	} 
            	if (map.get(s.charAt(end)) <= tMap.get(s.charAt(end))) {
            		size++;
            	}
                if (s.charAt(end) == s.charAt(begin)) {
                    while (begin < end && (!map.containsKey(s.charAt(begin)) ||  map.get(s.charAt(begin)) > tMap.get(s.charAt(begin)))){ 
                        if (map.containsKey(s.charAt(begin)) && map.get(s.charAt(begin)) > tMap.get(s.charAt(begin))) {
                        	 map.put(s.charAt(begin), map.get(s.charAt(begin)) - 1);
                        }
                        begin++;
                    }
                } 
            }
            if (size == t.length()) {
                if (length > end - begin + 1) {
                    resBegin = begin;
                    resEnd = end;
                    length = end - begin + 1;
                }
            }
            end++;
        } 
        if (size != t.length()) {
            return "";
        }
      
        return s.substring(resBegin, resEnd + 1);
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("test");
		MinimumWindowSubstring t = new MinimumWindowSubstring();
		System.out.println(t.minWindow("acbbaca", "aba"));
		 
	}

}
