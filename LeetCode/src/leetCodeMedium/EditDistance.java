package leetCodeMedium;
 

/**
 * @author Poirot
 * 2015年6月23日
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
    	if (word1 == null && word2 == null) {
			return 0;
		}
        if (word1 == null && word2 !=null) {
			return word2.length();
        }
        if (word1 != null && word2 ==null) {
			return word1.length();
		}
        int minLength = Math.min(word1.length(), word2.length());
        int length = minLength;
        int index1 = -1;
        int index2 = -1;
        int tempResult = Integer.MAX_VALUE;
        while (length >0){
        	for (int i = 0; i + length <= word1.length(); i++) {
				if ((index2 = word2.indexOf(word1.substring(i, i+length))) != -1) {

					index1 = i;

					if (tempResult > (Math.max(index1, index2) + Math.max(word1.length()-index1 - length, word2.length() - index2 - length))) {
	        			tempResult = Math.max(index1, index2) + Math.max(word1.length()-index1 - length, word2.length() - index2 - length);
					}
				}
			}
        	if (index1 != -1) {
        		if (tempResult > Math.max(index1, index2) + Math.max(word1.length()-index1 - length, word2.length() - index2 - length)) {
        			tempResult = Math.max(index1, index2) + Math.max(word1.length()-index1 - length, word2.length() - index2 - length);
				}
        		
				break;
			}
        	length--;
        }
        
        if (index1 == -1) { 
			return Math.max(word1.length(), word2.length());
		}
        return tempResult;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EditDistance t = new EditDistance();
		System.out.println(t.minDistance("mart", "karma"));
	}

}
