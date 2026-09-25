class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> map = new HashSet<>();
        int cnt = 0;

        for(int i = 0; i < nums.length; ++i) {
            if(!map.contains(nums[i])) map.add(nums[i]);
        }

        for(int i = 0; i < nums.length; ++i) {
            if(!map.contains(nums[i] - 1)) {
                cnt = 0;
                int term = nums[i];

                while(map.contains(term)) {
                    cnt++;
                    term++;
                }

                if(cnt > res) res = cnt;
            }
        }

        return Math.max(cnt, res);
    }
}
