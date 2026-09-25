class Solution {
    public int maxArea(int[] heights) {
        int length, dif, prod, maxProd = 0;
        int i = 0, j = heights.length - 1;

        while(i < j) {
            length = j - i;
            dif = Math.min(heights[i], heights[j]);
            prod = length * dif;
            if(prod > maxProd) maxProd = prod;

            if(heights[i] < heights[j]) i++;
            else j--;
        }

        return maxProd;
    }
}
