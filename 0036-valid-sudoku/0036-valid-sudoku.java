class Solution {
    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            if (!isRowAndColValid(board, i)) {
                return false;
            }
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!isBoxValid(board, i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isRowAndColValid(char[][] board, int i) {
        Set<Character> rows = new HashSet<>();
        Set<Character> cols = new HashSet<>();

        // row check
        for (int m = 0; m < 9; m++) {
            if (board[i][m] != '.' && !rows.add(board[i][m])) {
                return false;
            }

            if (board[m][i] != '.' && !cols.add(board[m][i])) {
                return false;
            }

        }
        return true;

    }

    private boolean isBoxValid(char[][] board, int startRow, int startCol) {
        Set<Character> box = new HashSet<>();
        for (int m = 0; m < 3; m++) {
            for (int n = 0; n < 3; n++) {
                char val = board[startRow + m][startCol + n];
                if (val != '.' && !box.add(val)) {
                    return false;
                }
            }
        }
        return true;
    }
}