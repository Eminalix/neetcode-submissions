class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> map = new HashSet<>();
        int cnt = 0;

        for(int i = 0; i < nums.length; ++i) {
            if(!map.contains(nums[i])) map.add(nums[i]);
        }

        for(int i : map) {
            if(!map.contains(i - 1)) {
                cnt = 1;
                while(map.contains(i + cnt)) {
                    cnt++;
                }

                if(cnt > res) res = cnt;
            }
        }

        return Math.max(cnt, res);
    }
}
