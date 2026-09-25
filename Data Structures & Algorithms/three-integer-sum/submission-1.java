class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int i, j, k;
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        for(k = 0; k < nums.length - 2; ++k) {
            if(k > 0 && nums[k] == nums[k - 1]) continue;

            i = k + 1;
            j = nums.length - 1;

            while(i < j) {
                if(nums[i] + nums[j] + nums[k] == 0) {
                    res.add(new ArrayList<>(List.of(nums[i], nums[j], nums[k])));
                    while(i < j && nums[i] == nums[i + 1]) ++i;
                    while(i < j && nums[j] == nums[j - 1]) --j;

                    ++i;
                    --j;
                }
                else if(nums[i] + nums[j] + nums[k] > 0) --j;
                else ++i;
            }
        }

        return res;
    }
}
