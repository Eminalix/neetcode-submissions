class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1);

        for(int i = 0; i < nums.length; ++i) {
            // for each entry in the maps level check if its != 0
            // this is the map for the next level that will be reactualized after
            Map<Integer, Integer> dpMap = new HashMap<>();

            for(Map.Entry<Integer, Integer> entry : dp.entrySet()) {
                int total = entry.getKey();
                int count = entry.getValue();

                dpMap.put(total + nums[i], dpMap.getOrDefault(total + nums[i], 0) + count);
                dpMap.put(total - nums[i], dpMap.getOrDefault(total - nums[i], 0) + count);
            }

            dp = dpMap;
        }

        return dp.getOrDefault(target, 0);
    }
}