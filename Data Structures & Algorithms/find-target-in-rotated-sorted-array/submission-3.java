class Solution {
    public int BS(int[] nums, int ls, int ld, int target) {
        while(ls <= ld) {
            int mij = (ls + ld) / 2;

            if(nums[mij] == target) return mij;

            if(target < nums[mij]) ld = mij - 1;
            else ls = mij + 1;
        }

        return -1;
    }

    public int search(int[] nums, int target) {
        int ls = 0, ld = nums.length - 1;

        while(ls < ld) {
            int mij = (ls + ld) / 2;

            if(nums[mij] > nums[ld]) ls = mij + 1;
            else ld = mij;
        }

        if(target <= nums[nums.length - 1]) return BS(nums, ls, nums.length - 1, target);
        if(target >= nums[0]) return BS(nums, 0 , ls, target);
        return -1;
    }
}
/*
    is left side sorted?
        yes
            is target within it? shrink
            its not? its to the right
        no => right side is sorted
            is target within it? shrink
            its not? its to the left

    OR
    find minimum
    see if target lies in the left side
    or right side
    do BS on that portion
*/