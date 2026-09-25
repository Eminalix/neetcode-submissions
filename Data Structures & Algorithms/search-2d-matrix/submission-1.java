class Solution {
    public boolean BS(int[][] matrix, int ind, int target) {
        int ls = 0, ld = matrix[0].length - 1;

        while(ls <= ld) {
            int mij = (ls + ld) / 2;
            if(matrix[ind][mij] == target) return true;
            if(matrix[ind][mij] < target) ls = mij + 1;
            else ld = mij - 1;
        }

        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int ls = 0, ld = matrix.length - 1;
        int m = matrix[0].length - 1;

        while(ls <= ld) {
            int mij = (ls + ld)  / 2;
            if(matrix[mij][0] <= target && matrix[mij][m] >= target)
                return BS(matrix, mij, target);
            
            if(matrix[mij][0] < target) ls = mij + 1;
            else ld = mij - 1;
        }

        return false;
    }
}
