package leetCodeMedium;

/**
 * @author Poirot 2015年6月17日
 */
public class ReverseWordsinaString {
//	public static String reverseWords(String s) {
//		if (s == null) {
//			return null;
//		}
//		if (s.length() == 0) {
//			return "";
//		}
//		StringBuilder result = new StringBuilder();
//		int i = s.length() - 1;
//		while (i >= 0 && s.charAt(i) == ' ') {
//			i--;
//		}
//
//		while (i >= 0) {
//			while (i >= 0 && s.charAt(i) == ' ') {
//				i--;
//			}
//			if (i >= 0) {
//				int end = i + 1;
//				int begin = i;
//				while (begin >= 0 && s.charAt(begin) != ' ') {
//					begin--;
//				}
//				result.append(s.substring(begin + 1, end));
//				result.append(' ');
//				i = begin - 1;
//			} else {
//				break;
//			}
//
//		}
//		if (result.length() > 0) {
//			return result.toString().substring(0, result.length() - 1);
//		}
//		return "";
//	}

	// Second Round
	public static  String reverseWords(String s) {
		StringBuilder res = new StringBuilder();
		int end = s.length() - 1;
		while (end >= 0) {
			if (s.charAt(end) == ' ') {
				end--;
			} else {
				int begin = end;
				while (begin >= 0 && s.charAt(begin) != ' ') {
					begin--;
				}
				res.append(" ");
				res.append(s.substring(begin + 1, end + 1));
				end = begin - 1;
			}
		}
		return res.toString().trim();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseWords("  a  ").length());
	}

}
