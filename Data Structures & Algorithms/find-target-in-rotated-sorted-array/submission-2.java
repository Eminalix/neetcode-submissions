class Solution {
    public int search(int[] nums, int target) {
        int ls = 0, ld = nums.length - 1;

        while(ls <= ld) {
            int mij = (ls + ld) / 2;

            if(nums[mij] == target) return mij;

            // is left side sorted
            if(nums[ld] < nums[mij]) {
                if(target >= nums[ls] && target < nums[mij]) ld = mij - 1;
                else ls = mij + 1;
            }
            // else right side is sorted
            else {
                if(target <= nums[ld] && target > nums[mij]) ls = mij + 1;
                else ld = mij - 1;
            }
        }

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
*/