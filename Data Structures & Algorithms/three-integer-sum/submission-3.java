class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int i, j, k;
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> count = new HashMap<>();

        Arrays.sort(nums);

        for(i = 0; i < nums.length; ++i) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }

        for(i = 0; i < nums.length; ++i) {
            count.put(nums[i], count.get(nums[i]) - 1);

            if(i > 0 && nums[i] == nums[i - 1]) continue;

            for(j = i + 1; j < nums.length; ++j) {
                count.put(nums[j], count.getOrDefault(nums[j], 0) - 1);

                if(j > i + 1 && nums[j] == nums[j - 1]) continue;

                int target = (nums[i] + nums[j]) * (-1);

                if(count.getOrDefault(target, 0) > 0) {
                    res.add(List.of(nums[i], nums[j], target));
                }
            }

            for(j = i + 1; j < nums.length; ++j) {
                count.put(nums[j], count.getOrDefault(nums[j], 0) + 1);
            }
        }
        
        return res;
    }
}
