/**
 * 2015Äê6ÔÂ19ÈÕ
 * CH
 */
package leetCodeMedium;

/**
 * @author CH
 *
 */
public class BestTimetoBuyandSellStockII {
	public int maxProfit(int[] prices) {
        int max = 0;
        int begin = 0;
        for (int i = 1; i < prices.length; i++) {
        	if (i == prices.length -1) {
				max += prices[i] - prices[begin];
				begin = i;
			}
        	if( prices[i] < prices[i-1]) {
        		max += prices[i-1] - prices[begin];
				begin = i;
			}
		} 
        return max;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BestTimetoBuyandSellStockII t = new BestTimetoBuyandSellStockII();
		int[] test = {1,2};
		System.out.println(t.maxProfit(test));
	}

}
