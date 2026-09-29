class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;

        for(int i = 1; i <= nums.length; ++i) {
            dp[i] = Math.max(dp[Math.max(0, i - 2)] + nums[i - 1], dp[Math.max(0, i - 1)]);
        }

        return Math.max(dp[dp.length - 1], dp[dp.length - 2]);
    }
}
