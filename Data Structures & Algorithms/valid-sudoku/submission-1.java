class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> map1;
        Set<Character> map2;
        Set<Character> map3;

        for(int i = 0; i < 9; ++i) {
            map1 = new HashSet<>();
            map2 = new HashSet<>();
            map3 = new HashSet<>();

            for(int j = 0; j < 9; ++j) {
                if(map1.contains(board[i][j])
                && board[i][j] != '.') return false;

                if(map2.contains(board[j][i])
                && board[j][i] != '.') return false;

                if(map3.contains(board[(i / 3) * 3 + (j / 3)][(i % 3) * 3 + (j % 3)])
                && board[(i / 3) * 3 + (j / 3)][(i % 3) * 3 + (j % 3)] != '.') return false;

                map1.add(board[i][j]);
                map2.add(board[j][i]);
                map3.add(board[(i / 3) * 3 + (j / 3)][(i % 3) * 3 + (j % 3)]);
            }
        }

        return true;
    }
}
