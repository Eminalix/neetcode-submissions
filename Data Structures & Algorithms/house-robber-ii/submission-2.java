class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];

        int rob1 = 0, rob2 = 0;
        
        for(int i = 0; i < nums.length - 1; ++i) {
            int temp = Math.max(rob1, rob2 + nums[i]);
            rob2 = rob1;
            rob1 = temp;
        }

        int max = rob1;
        rob1 = 0;
        rob2 = 0;
        
        for(int i = 1; i < nums.length; ++i) {
            int temp = Math.max(rob1, rob2 + nums[i]);
            rob2 = rob1;
            rob1 = temp;
        }

        return Math.max(max, rob1);
    }
}
