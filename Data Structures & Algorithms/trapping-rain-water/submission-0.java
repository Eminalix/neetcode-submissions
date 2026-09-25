class Solution {
    public int trap(int[] height) {
        int length, dif, prod, maxProd = 0;
        int ls = 0, i, j, ld = height.length - 1, max = 0, maxi = 0;

        while (ls < ld && height[ld] <= height[ld - 1]) --ld;
        while (ls < ld && height[ls] <= height[ls + 1]) ++ls;

        i = ls;

        while (i <= ld) {
            if (height[i] > max) {
                max = height[i];
                maxi = i;
            }

            ++i;
        }

        i = ls;

        while (ls < maxi) {
            dif = 0;

            ++i;

            while (i < maxi && height[i] < height[ls]) {
                dif += height[i];
                ++i;
            }

            prod = (i - ls - 1) * height[ls];
            maxProd += prod - dif;

            ls = i;
        }

        i = ld;

        while (ld > maxi) {
            dif = 0;

            i--;

            while (i >= maxi && height[i] < height[ld]) {
                dif += height[i];
                --i;
            }

            prod = (ld - i - 1) * height[ld];
            maxProd += prod - dif;

            ld = i;
        }

        return maxProd;
    }
}
