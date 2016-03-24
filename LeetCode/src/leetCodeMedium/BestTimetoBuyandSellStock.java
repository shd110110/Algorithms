package leetCodeMedium;
//150619

public class BestTimetoBuyandSellStock {
	//First solution by CH 
//	public int maxProfit(int[] prices) {
//        return maxProfitInSection(prices, 0, prices.length-1);
//    }
//	public int maxProfitInSection(int[] prices, int begin, int end){
//		if (begin >= end) {
//			return 0;
//		}
//        int max = prices[begin];
//        int min = prices[begin];
//        int maxIndex = begin,minIndex = begin;
//        for (int i = begin; i <= end; i++) {
//			if (prices[i] > max) {
//				max = prices[i];
//				maxIndex = i;
//			}else if (prices[i] < min) {
//				min = prices[i];
//				minIndex = i;
//			}
//		}
//        if (maxIndex >= minIndex) { 
//			return max-min;
//		}
//        
//        return Math.max(Math.max(maxProfitInSection(prices, begin, maxIndex), maxProfitInSection(prices, maxIndex+1, minIndex-1)), 
//        		maxProfitInSection(prices, minIndex, end));
//	}
	
	//Second solution by CH 
	public int maxProfit(int[] prices) {
        if (prices.length < 2) {
			return 0;
		}
        int tempMax = 0;
        int max = 0;
        int beginIndex = 0;
        int maxIndex = 0;
        //int minThanBeginIndex = 0;
        for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[maxIndex]) {
				maxIndex = i;
				tempMax = prices[i] - prices[beginIndex];
			}else if (prices[i] < prices[beginIndex] ) {
				beginIndex = i;
				maxIndex = i;
				max = Math.max(tempMax, max);
				tempMax = 0;
			}
		}
        max = Math.max(tempMax, max);
        return max;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BestTimetoBuyandSellStock t = new BestTimetoBuyandSellStock();
		int[] test = {4,7,2,1};
		System.out.println(t.maxProfit(test));
	}

}
