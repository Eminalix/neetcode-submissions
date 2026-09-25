class Solution {
    private int[][] lookup;

    public int[][] buildSparseTable(int[] arr) {
        int n = arr.length;
        int maxK = (int) (Math.log(n) / Math.log(2)) + 1;

        lookup = new int[n][maxK];

        for(int i = 0; i < n; ++i) {
            lookup[i][0] = i;
        }

        // compute values for intervals of power of 2
        for(int j = 1; (1 << j) <= n; ++j) {
            // compute min value for intervals with size
            // 2 ^ j
            for(int i = 0; (i + (1 << j) - 1) < n; ++i) {
                if(arr[lookup[i][j - 1]] <=
                arr[lookup[i + (1 << (j - 1))][j - 1]]) {
                    lookup[i][j] = lookup[i][j - 1];
                }
                else {
                    lookup[i][j] = lookup[i + (1 << (j - 1))][j - 1];
                }
            }
        }

        return lookup;
    }

    public int query(int L, int R, int[][] lookup, int[] heights) {
        int j = (int)(Math.log(R - L + 1) / Math.log(2));

        int leftIdx = lookup[L][j];
        int rightIdx = lookup[R - (1 << j) + 1][j];

        if(heights[leftIdx] <= heights[rightIdx]) 
            return leftIdx;
        else return rightIdx;
    }

    public int DEI(int[] heights, int ls, int ld) {
        if(ls > ld) return 0;

        if(ls == ld) return heights[ls];

        int mini = query(ls, ld, lookup, heights);

        return Math.max(heights[mini] * (ld - ls + 1), 
        Math.max(DEI(heights, ls, mini - 1),
        DEI(heights, mini + 1, ld)));
    }
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;

        lookup = buildSparseTable(heights);

        return DEI(heights, 0, heights.length - 1);
    }
}
/*
    on the stack we need the index of the curr el
    pop from the stack whenever u encounter a height smaller
    than the top one
    whenever i pop something, the right boundary is the smaller element 
    that triggered the pop, and the left boundary is the top element
    on the stack after the pop, and then i can compare the local max
    area stored with the area cause whithin the left and right boundary
    rightBoundary - leftBoundary - 1
    for every element still on the stack when the main loop finishes, the right     
    boundary is uniformly arr.length

    OPTION 2
    DIVID ET IMPERA
    search for global minimum
    multiply it by rightB - leftB - 1
    do the same thing recursively for the left side
    and right side of the minimum
    compare with max
*/