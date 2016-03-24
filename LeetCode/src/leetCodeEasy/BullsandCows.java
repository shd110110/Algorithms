/**
 * 2015��11��20��
 * Poirot
 */
package leetCodeEasy;
 
/**
 * @author Poirot
 *
 */
public class BullsandCows {
	
	//by Poirot3
//	public String getHint(String secret, String guess) {
//		if (secret == null || secret.length() == 0) {
//			return "0A0B";
//		}
//		int bulls = 0;
//		int cows = 0;
//		HashMap<Character, Integer> map = new HashMap<>(); 
//		for (int i = 0; i < secret.length(); i++) {
//			char c = secret.charAt(i);
//			if (c == guess.charAt(i)) {
//				bulls ++;
//			} else {
//				map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
//			}
//		}
//		
//		for (int i = 0; i < guess.length(); i++) { 
//			if (secret.charAt(i) != guess.charAt(i)) {
//				
//				if (map.containsKey(guess.charAt(i))) { 
//					
//					if (map.get(guess.charAt(i)) == 1) {
//						map.remove(guess.charAt(i));
//					} else {
//						map.put(guess.charAt(i), map.get(guess.charAt(i)) - 1);
//					}
//					cows++;
//				}
//			}
//		}
//		return String.valueOf(bulls) + "A" + String.valueOf(cows) + "B";
//	}

	
	public String getHint(String secret, String guess) {
	    int bulls = 0;
	    int cows = 0;
	    int[] numbers = new int[10];
	    for (int i = 0; i<secret.length(); i++) {
	        if (secret.charAt(i) == guess.charAt(i)) bulls++;
	        else {
	            if (numbers[secret.charAt(i)-'0']++ < 0) 
	            	cows++;
	            if (numbers[guess.charAt(i)-'0']-- > 0) 
	            	cows++;
	        }
	    }
	    return bulls + "A" + cows + "B";
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BullsandCows t = new BullsandCows();
		System.out.println(t.getHint("1122", "1222"));
		int a = 0;
		System.out.println(a++ > 0);
	}

}
