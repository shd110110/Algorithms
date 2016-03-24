/**
 * 2015Äê9ÔÂ9ÈÕ
 * Poirot
 */
package leetCodeEasy;

/**
 * @author Poirot
 *
 */
public class FirstBadVersion {
	public int firstBadVersion(int n) {
        int first = 1;
        int end = n;
        int medium = first / 2 + end / 2;
        if (first % 2 == 1 && end % 2 == 1) {
			medium += 1;
		}
        while (first < end) {
//        	System.out.println(first + "  " + end + "  " + medium); 
            if (isBadVersion(medium)) {
                end = medium;
            } else {
                first = medium + 1;
            }
            medium = first / 2 + end / 2;
            if (first % 2 == 1 && end % 2 == 1) {
    			medium += 1;
    		}
        }
        return end;
    } 
	
	boolean isBadVersion(int version) {
		return version >= 1702766719 ;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirstBadVersion t = new FirstBadVersion();
		System.out.println(Integer.MAX_VALUE);
		System.out.println(t.firstBadVersion(2126753390));
	}

}
