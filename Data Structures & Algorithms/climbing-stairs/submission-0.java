class Solution {
    public int climbStairs(int n) {
        int[] v = new int[n];

        for(int i = 0; i < n; ++i) {
            if(i == 0) v[i] = 1;
            else if(i == 1) v[i] = 2;
            else v[i] = v[i - 1] + v[i - 2];
        }

        return v[n - 1];
    }
}
