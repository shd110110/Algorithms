package leetCodeHard;

public class BestTimetoBuyandSellStockIII {
	
	//most votes
	public int maxProfit(int[] prices) {
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;
        for(int price:prices){                              // Assume we only have 0 money at first
            release2 = Math.max(release2, hold2+price);     // The maximum if we've just sold 2nd stock so far.
            hold2    = Math.max(hold2,    release1-price);  // The maximum if we've just buy  2nd stock so far.
            release1 = Math.max(release1, hold1+price);     // The maximum if we've just sold 1nd stock so far.
            hold1    = Math.max(hold1,    -price);          // The maximum if we've just buy  1st stock so far. 
        }
        return release2; ///Since release1 is initiated as 0, so release2 will always higher than release1.
    }
    

	
	
	//By Poirot
//	public int maxProfit(int[] prices) {
//		int maxByTwoTransactions = maxProfitInSection(prices, 0,
//				prices.length - 1); 
//		for (int i = 1; i < prices.length; i++) { 
//			if (prices[i] >= prices[i - 1] ) {
//				 continue;
//			}
//			if (i < prices.length-1 && prices[i] > prices[i+1]) {
//				continue;
//			}
//			while (i < prices.length-1 && prices[i] == prices[i + 1])
//			{
//				i++;
//			}
////			System.out.println("test : " + i); // find i which i is the bottom
//			if (maxProfitInSection(prices, 0, i - 1)
//					+ maxProfitInSection(prices, i, prices.length - 1) > maxByTwoTransactions) {
//				maxByTwoTransactions = maxProfitInSection(prices, 0, i - 1)
//						+ maxProfitInSection(prices, i, prices.length - 1); 
//			}
//		}
//		return maxByTwoTransactions;
//	}
//
//	public int maxProfitInSection(int[] prices, int begin, int end) {
//		if (begin >= end) {
//			return 0;
//		} 
//		int tempMax = 0;
//		int max = 0;
//		int beginIndex = begin;
//		int maxIndex = begin; 
//		for (int i = begin; i <= end; i++) {
//			if (prices[i] > prices[maxIndex]) {
//				maxIndex = i;
//				tempMax = prices[i] - prices[beginIndex];
//			} else if (prices[i] < prices[beginIndex]) {
//				beginIndex = i;
//				maxIndex = i;
//				max = Math.max(tempMax, max);
//				tempMax = 0;
//			} 
//		}
//		max = Math.max(tempMax, max);
//		return max;
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BestTimetoBuyandSellStockIII t = new BestTimetoBuyandSellStockIII();
//		 int[] test = {6,1,3,2,4,7};
		int[] test = {2,1,2,1,0,2,5,4,6 };
		System.out.println(t.maxProfit(test)); 
	}

}
