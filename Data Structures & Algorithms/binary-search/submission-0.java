class Solution {
    public int search(int[] nums, int target) {
        int ls = 0;
        int ld = nums.length - 1;

        while(ls <= ld) {
            int mij = (ls + ld) / 2;

            if(target == nums[mij]) return mij;
            if(target < nums[mij]) ld = mij - 1;
            else ls = mij + 1;
        }

        return -1;
    }
}
