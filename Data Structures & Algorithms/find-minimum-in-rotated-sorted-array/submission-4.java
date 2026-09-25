class Solution {
    public int findMin(int[] nums) {
        int ls = 0, ld = nums.length - 1;

        while(ls < ld) {
            int mij = (ls + ld) / 2;

            if(nums[mij] < nums[ld]) ld = mij;
            else ls = mij + 1;
        }

        return nums[ls];
    }
}
