class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0) return 0;
        int maxProfit = 0, n = prices.length, maxPrice = prices[n-1];
        
        for(int i=n-1; i>=0; i--){
            if(maxPrice-prices[i]>maxProfit)
                maxProfit = maxPrice - prices[i];
            maxPrice = Math.max(maxPrice, prices[i]);
        }
        return maxProfit;
    }
}