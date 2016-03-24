/**
 * 2015��11��24��
 * Poirot
 */
package leetCodeMedium;

/**
 * @author Poirot
 *
 */
public class BestTimetoBuyandSellStockwithCooldown {

	// by others
	// public int maxProfit(int[] prices) {
	// if (prices.length == 0 || prices.length == 1)
	// return 0;
	// int[] maxProfit = new int[prices.length];
	//
	// //initialise
	// maxProfit[0] = 0;
	// maxProfit[1] = Math.max(0, prices[1] - prices[0]);
	//
	// int value = Math.max(0 - prices[0], 0 - prices[1]);
	// for (int i = 2; i < prices.length; i++) {
	// int temp = prices[i] + value;
	// if (temp <= maxProfit[i - 1])
	// maxProfit[i] = maxProfit[i - 1];
	// else
	// maxProfit[i] = temp;
	//
	// if (maxProfit[i - 2] - prices[i] > value)
	// value = maxProfit[i - 2] - prices[i];
	// }
	// return maxProfit[prices.length - 1];
	// }

	public int maxProfit(int[] prices) {
		if (prices.length == 0 || prices.length == 1)
			return 0;
		int prepre = 0; //ǰ��Ϊֹ�������
		int pre = Math.max(0, prices[1] - prices[0]);//ǰ��Ϊֹ�������
		int buy = Math.max(0 - prices[0], 0 - prices[1]);// ѡ�����һ�첻�ǵڶ���Ĺ�Ʊ
		int current = 0; //����Ϊֹ������� ����Ҫ����
		for (int i = 2; i < prices.length; i++) {
			current = Math.max(pre, prices[i] + buy);
			buy = Math.max(buy, prepre - prices[i]);
			
			//����
			prepre = pre;
			pre = current;
		}
		return Math.max(pre, current);
	}
 
	 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Integer.MAX_VALUE);
		BestTimetoBuyandSellStockwithCooldown t = new BestTimetoBuyandSellStockwithCooldown();
		int[] prices = {1, 2, 3, 0, 2};
		System.out.println(t.maxProfit(prices));
	}

}
