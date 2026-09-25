class Solution {
public:
    bool BS(vector<vector<int>>& matrix, int ind, int target) {
        int ls = 0, ld = matrix[0].size() - 1;

        while(ls <= ld) {
            int mij = (ls + ld) / 2;

            if(target == matrix[ind][mij]) return true;

            if(target < matrix[ind][mij]) ld = mij - 1;
            else ls = mij + 1;
        }

        return false;
    }

    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int ls = 0, ld = matrix.size() - 1, m = matrix[0].size() - 1;

        while(ls <= ld) {
            int mij = (ls + ld) / 2;

            if(target >= matrix[mij][0] && target <= matrix[mij][m])
                return BS(matrix, mij, target);

            if(target < matrix[mij][0]) ld = mij - 1;
            else ls = mij + 1;
        }

        return false;
    }
};
