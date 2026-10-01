class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int x : nums) sum += x;
        if (Math.abs(target) > sum) return 0;
        int[][] dp = new int[nums.length + 1][2 * sum + 1];

        int mij = (2 * sum + 1) / 2;
        dp[0][mij] = 1;

        for(int j = 0; j < nums.length; ++j) {
            for(int i = 0; i < dp[0].length; ++i) {
                if(dp[j][i] != 0) {
                    dp[j + 1][i - nums[j]] += dp[j][i];
                    dp[j + 1][i + nums[j]] += dp[j][i];
                }
            }
        }

        return dp[dp.length - 1][mij + target];
    }
}