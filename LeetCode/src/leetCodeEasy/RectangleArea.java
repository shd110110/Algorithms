package leetCodeEasy;

/**
 * @author Poirot 2015年6月9日
 */
public class RectangleArea {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G,
			int H) {
		int areaA = (C - A) * (D - B);
		int areaB = (G - E) * (H - F);

		int left = Math.max(A, E);
		int right = Math.min(G, C);
		int bottom = Math.max(F, B);
		int top = Math.min(D, H);

		// If overlap
		int overlap = 0;
		if (right > left && top > bottom)
			overlap = (right - left) * (top - bottom);
		return areaA + areaB - overlap;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
