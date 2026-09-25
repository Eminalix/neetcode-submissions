class Solution {
    public int findMin(int[] nums) {
        int ls = 0, ld = nums.length - 1;
        int mij = 0;

        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.min(nums[0], nums[1]);

        while(ls <= ld) {
            mij = (ls + ld) / 2;

            if(ls == ld) return nums[mij];

            if(nums[mij] > nums[ld]) ls = mij + 1;
            else if(nums[mij] < nums[ls]) ld = mij;
            else return nums[ls];
        }

        return nums[mij];
    }
}
