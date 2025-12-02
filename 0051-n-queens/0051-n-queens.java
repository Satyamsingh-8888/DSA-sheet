class Solution {
    
    public boolean checkDiagonal(int row, int col, int n, List<StringBuilder> board) {
        int r = row, c = col;
        while (r >= 0 && c >= 0) {
            if (board.get(r).charAt(c) == 'Q') return false;
            r--; c--;
        }
        r = row; c = col;
        while (r >= 0 && c < n) {
            if (board.get(r).charAt(c) == 'Q') return false;
            r--; c++;
        }
        return true;
    }

    public void solve(List<List<String>> ans, List<StringBuilder> board, boolean column[], int row, int n) {
        if (row == n) {
            List<String> temp = new ArrayList<>();
            for (StringBuilder sb : board)
                temp.add(sb.toString());
            ans.add(temp);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (!column[col] && checkDiagonal(row, col, n, board)) {
                column[col] = true;
                board.get(row).setCharAt(col, 'Q');
                solve(ans, board, column, row + 1, n);
                board.get(row).setCharAt(col, '.');
                column[col] = false;
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<StringBuilder> board = new ArrayList<>();
        boolean column[] = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) sb.append('.');
            board.add(sb);
        }

        solve(ans, board, column, 0, n);
        return ans;
    }
}
