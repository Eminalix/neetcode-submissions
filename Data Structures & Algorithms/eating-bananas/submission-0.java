class Solution {
    public int numberOfHours(int[] piles, int b) {
        int cnt = 0;
        
        for(int i = 0; i < piles.length; ++i) {
            cnt += Math.ceil((double) piles[i] / b);
        }

        return cnt;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int max = 0, min = Integer.MAX_VALUE;

        for(int i = 0; i < piles.length; ++i) {
            if(piles[i] > max) max = piles[i];
        }

        int ls = 0, ld = max;

        while(ls <= ld) {
            int mij = (ls + ld) / 2;

            if(numberOfHours(piles, mij) <= h) {
                min = Math.min(min, mij);
                ld = mij - 1;
            }
            else ls = mij + 1;
            
        }

        return min;
    }
}
/*
    since piles <= h => the upper bound is the max number
    we need to find the first number within which 
    the bananas are eaten in <= h time
    log m comes from binary searching for the answer after knowing max
    and n from traversing the array to see if it works with the current number
    we also need an O(n) traversal to find max
*/