class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];

        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        
        for(int i = 1; i < dp.length - 1; ++i) {
            dp[i] = Math.max(dp[i - 1], dp[Math.max(0, i - 2)] + nums[i - 1]);
        }

        int max = dp[dp.length - 2];
        dp[0] = 0;
        dp[1] = 0;
        
        for(int i = 2; i < dp.length; ++i) {
            dp[i] = Math.max(dp[i - 1], dp[Math.max(0, i - 2)] + nums[i - 1]);
        }

        return Math.max(max, dp[dp.length - 1]);
    }
}
