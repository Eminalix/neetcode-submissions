class Solution {
    public int maxProfit(int[] prices) {
        int a, p = 0;
        int i = 1;
        a = prices[0];

        while(i < prices.length) {
            if(prices[i] - a > p) {
                p = prices[i] - a;
            }
            else if(prices[i] < a) {
                a = prices[i];
            }

            ++i;
        }

        return p;
    }
}
