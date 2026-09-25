class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; ++i) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            }
            else {
                return true;
                //int cnt = map.get(nums[i]);
                //map.put(nums[i], cnt + 1);
            }
        }

        return false;
    }
}